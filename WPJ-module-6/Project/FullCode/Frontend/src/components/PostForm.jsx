import React, { useState } from 'react';
import axios from '../api/axiosConfig';
import { Form, Button, Alert, Spinner } from 'react-bootstrap';

const PostForm = ({ categoryId, onSuccess }) => {
  const [name, setName] = useState('');
  const [content, setContent] = useState('');
  const [image, setImage] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  // ✅ Get logged-in userId from localStorage
  const user = JSON.parse(localStorage.getItem('user'));
  const userId = user?.id;

  const handlePost = async () => {
    const res = await axios.post(`/post/post/user/${userId}/category/${categoryId}`, {
      name,
      content,
    });
    return res.data.post_id;
  };

  const handleUpload = async (postId) => {
    if (!image) return;
    const formData = new FormData();
    formData.append('image', image);

    await axios.post(`/post/file/post/${postId}`, formData, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');
    try {
      const postId = await handlePost();
      await handleUpload(postId);
      setName('');
      setContent('');
      setImage(null);
      onSuccess();
    } catch (err) {
      console.error(err);
      setError('Failed to create post. Please try again.');
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
          value={name}
          onChange={(e) => setName(e.target.value)}
          disabled={loading}
          required
        />
      </Form.Group>
      <Form.Group className="mb-2">
        <Form.Label>Content</Form.Label>
        <Form.Control
          as="textarea"
          value={content}
          onChange={(e) => setContent(e.target.value)}
          disabled={loading}
          required
        />
      </Form.Group>
      <Form.Group className="mb-2">
        <Form.Label>Image</Form.Label>
        <Form.Control
          type="file"
          onChange={(e) => setImage(e.target.files[0])}
          disabled={loading}
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
            Creating...
          </>
        ) : (
          'Create Post'
        )}
      </Button>
    </Form>
  );
};

export default PostForm;
