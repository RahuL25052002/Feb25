import React, { useEffect, useState } from 'react';
import axiosInstance from '../api/axiosConfig';
import { ListGroup, Spinner, Alert, Form, Button, Row, Col } from 'react-bootstrap';

const CommentList = ({ postId }) => {
  const [comments, setComments] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [newComment, setNewComment] = useState('');
  const [userId, setUserId] = useState(null);

  // Fetch logged-in user ID from localStorage
  useEffect(() => {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const parsed = JSON.parse(storedUser);
      setUserId(parsed.id);
    }
  }, []);

  const fetchComments = async () => {
    if (!postId) return;

    try {
      const res = await axiosInstance.get(`/comment/post/${postId}/comments`);
      setComments(Array.isArray(res.data) ? res.data : []);
      setError('');
    } catch (err) {
      console.error('Error fetching comments:', err);
      setError('Failed to load comments.');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    if (postId) fetchComments();
  }, [postId]);

  const handleAddComment = async (e) => {
    e.preventDefault();
    if (!newComment.trim()) return;

    const storedUser = localStorage.getItem('user');
    if (!storedUser) {
      alert('Please login to comment.');
      return;
    }

    const user = JSON.parse(storedUser);

    try {
      await axiosInstance.post(`/comment/${postId}/by/${user.id}`, {
        content: newComment,
      });
      setNewComment('');
      fetchComments();
    } catch (err) {
      console.error('Error adding comment:', err);
      alert('Failed to add comment');
    }
  };

  const handleDeleteComment = async (commentId) => {
    const confirmDelete = window.confirm('Are you sure you want to delete this comment?');
    if (!confirmDelete) return;

    try {
      await axiosInstance.delete(`/comment/${commentId}`);
      fetchComments();
    } catch (err) {
      console.error('Failed to delete comment:', err);
      alert('Failed to delete comment');
    }
  };

  return (
    <div className="mt-3">
      <h6>Comments</h6>
      {loading ? (
        <Spinner animation="border" size="sm" />
      ) : error ? (
        <Alert variant="danger">{error}</Alert>
      ) : (
        <ListGroup>
          {comments.length === 0 ? (
            <ListGroup.Item>No comments yet.</ListGroup.Item>
          ) : (
            comments.map((comment) => (
              <ListGroup.Item key={comment.id}>
                <Row>
                  <Col>
                    <strong>{comment.userName || 'Anonymous'}</strong>: {comment.content}
                  </Col>
                  <Col xs="auto">
                    {/* ✅ Only show delete if comment belongs to logged-in user */}
                    {userId === comment.userId && (
                      <Button
                        variant="danger"
                        size="sm"
                        onClick={() => handleDeleteComment(comment.id)}
                      >
                        Delete
                      </Button>
                    )}
                  </Col>
                </Row>
              </ListGroup.Item>
            ))
          )}
        </ListGroup>
      )}

      <Form onSubmit={handleAddComment} className="mt-2">
        <Form.Control
          type="text"
          placeholder="Write a comment..."
          value={newComment}
          onChange={(e) => setNewComment(e.target.value)}
        />
        <Button type="submit" variant="primary" size="sm" className="mt-2">
          Add Comment
        </Button>
      </Form>
    </div>
  );
};

export default CommentList;
