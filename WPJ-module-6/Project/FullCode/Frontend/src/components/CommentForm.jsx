// src/components/CommentForm.jsx
import React, { useState } from 'react';
import axios from '../api/axiosConfig';
import { Form, Button } from 'react-bootstrap';

const CommentForm = ({ postId, onCommentAdded }) => {
  const [content, setContent] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const storedUser = localStorage.getItem('user');
    if (!storedUser) {
      alert('Please login to comment.');
      return;
    }

    const user = JSON.parse(storedUser);

    try {
      await axios.post(`/comment/${postId}/by/${user.id}`, { content });
      setContent('');
      onCommentAdded();
    } catch (err) {
      console.error('Failed to post comment', err);
    }
  };


  return (
    <Form onSubmit={handleSubmit} className="mb-3">
      <Form.Group>
        <Form.Label>Comment</Form.Label>
        <Form.Control value={content} onChange={(e) => setContent(e.target.value)} />
      </Form.Group>
      <Button type="submit" className="mt-2">Add Comment</Button>
    </Form>
  );
};

export default CommentForm;



