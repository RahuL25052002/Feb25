import React, { useEffect, useState } from 'react';
import axios from '../api/axiosConfig';
import PostForm from '../components/PostForm';
import PostList from '../components/PostList';
import { Card, Form, Spinner, Alert } from 'react-bootstrap';

const Posts = () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const userId = user?.id;

  const [categoryId, setCategoryId] = useState('');
  const [categories, setCategories] = useState([]);
  const [reload, setReload] = useState(false);
  const [loadingCategories, setLoadingCategories] = useState(true);
  const [error, setError] = useState('');

  const handleSuccess = () => {
    setReload(prev => !prev);
  };

  const loadCategories = async () => {
    try {
      const res = await axios.get('/category/');
      setCategories(res.data);
    } catch (err) {
      setError('Failed to load categories',err);
    } finally {
      setLoadingCategories(false);
    }
  };

  useEffect(() => {
    loadCategories();
  }, []);

  return (
    <div
      style={{
        backgroundImage:
          "url('https://images.unsplash.com/photo-1511203466129-824e631920d4?auto=format&fit=crop&w=1470&q=80')",
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        padding: '40px 20px',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        position: 'relative',
        color: '#333',
      }}
    >
      <div
        style={{
          position: 'absolute',
          inset: 0,
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          zIndex: 0,
        }}
      />

      <Card
        style={{
          maxWidth: '850px',
          width: '100%',
          padding: '30px',
          borderRadius: '20px',
          backgroundColor: 'rgba(255, 255, 255, 0.95)',
          boxShadow: '0 8px 25px rgba(0, 0, 0, 0.2)',
          zIndex: 1,
          color: '#333',
        }}
      >
        <h2 className="text-center mb-4" style={{ color: '#333', fontWeight: '700' }}>
          Create a Post
        </h2>

        {error && <Alert variant="danger">{error}</Alert>}

        {loadingCategories ? (
          <Spinner animation="border" />
        ) : (
          <>
            <Form.Group className="mb-3">
              <Form.Label>Select Category</Form.Label>
              <Form.Select
                value={categoryId}
                onChange={(e) => setCategoryId(e.target.value)}
                required
              >
                <option value="">-- Select a Category --</option>
                {categories.map(cat => (
                  <option key={cat.category_id} value={cat.category_id}>
                    {cat.title}
                  </option>
                ))}
              </Form.Select>
            </Form.Group>

            {categoryId ? (
              <PostForm userId={userId} categoryId={categoryId} onSuccess={handleSuccess} />
            ) : (
              <Alert variant="info">Please select a category to create a post.</Alert>
            )}
          </>
        )}

        <hr className="my-4" />

        <PostList reload={reload} onDeleteSuccess={handleSuccess} />
      </Card>

      <footer
        style={{
          marginTop: '30px',
          color: '#eee',
          fontSize: '0.85rem',
          zIndex: 1,
          textAlign: 'center',
          width: '100%',
          fontWeight: '500',
          letterSpacing: '0.05em',
        }}
      >
        &copy; {new Date().getFullYear()} BlogApp — Share your thoughts with the world ✍️
      </footer>
    </div>
  );
};

export default Posts;
