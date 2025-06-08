import React, { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';
import { ListGroup, Button, Spinner, Alert } from 'react-bootstrap';

const CategoryList = ({ reload }) => {
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  const loadCategories = async () => {
    setLoading(true);
    setError('');
    try {
      //http://localhost:8080/category/
      const res = await axios.get('/category/');
      setCategories(res.data);
    } catch (err) {
      console.error('Error fetching categories:', err);
      setError('Could not load categories.');
    } finally {
      setLoading(false);
    }
  };

  const deleteCategory = async (id) => {
    try {
      await axios.delete(`/category/${id}`);
      loadCategories();
    } catch (err) {
      console.error('Failed to delete category:', err);
      setError('Failed to delete category.');
    }
  };

  useEffect(() => {
    loadCategories();
  }, [reload]);

  if (loading) return <Spinner animation="border" />;

  return (
    <div>
      {error && <Alert variant="danger">{error}</Alert>}
      <ListGroup>
        {categories.map(cat => (
          <ListGroup.Item
            key={cat.category_id}
            className="d-flex justify-content-between align-items-center"
          >
            <div>
              <strong>{cat.title}</strong> — {cat.description}
            </div>
            <Button variant="danger" size="sm" onClick={() => deleteCategory(cat.category_id)}>
              Delete
            </Button>
          </ListGroup.Item>
        ))}
      </ListGroup>
    </div>
  );
};

export default CategoryList;
