import React, { useState } from 'react';
import axios from '../api/axiosConfig';
import { Form, Button, Alert, Spinner } from 'react-bootstrap';

const CategoryForm = ({ onSuccess }) => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');
    try {
      await axios.post('/category/', { title, description });
      setTitle('');
      setDescription('');
      onSuccess();
    } catch (err) {
      console.error(err);
      setError('Failed to add category. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <Form onSubmit={handleSubmit} className="mb-3">
      {error && <Alert variant="danger">{error}</Alert>}
      <Form.Group className="mb-2">
        <Form.Label>Title</Form.Label>
        <Form.Control
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          disabled={loading}
          required
        />
      </Form.Group>
      <Form.Group className="mb-2">
        <Form.Label>Description</Form.Label>
        <Form.Control
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          disabled={loading}
          required
        />
      </Form.Group>
      <Button type="submit" disabled={loading} variant="primary">
        {loading ? (
          <>
            <Spinner
              as="span"
              animation="border"
              size="sm"
              role="status"
              aria-hidden="true"
            />{' '}
            Adding...
          </>
        ) : (
          'Add Category'
        )}
      </Button>
    </Form>
  );
};

export default CategoryForm;
