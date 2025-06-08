import React, { useEffect, useState } from 'react';
import axiosInstance from '../api/axiosConfig';
import { Card, Col, Container, Row, Spinner, Alert, Button } from 'react-bootstrap';
import CommentList from './CommentList';

const PostList = ({ reload, onDeleteSuccess }) => {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  const fetchPosts = async () => {
    setLoading(true);
    setError('');
    try {
      const res = await axiosInstance.get('/post/all?pageNumber=0&pageSize=50');
      setPosts(res.data.content || []);
    } catch (err) {
      setError('Failed to load posts.',err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, [reload]); // refetch when reload changes

  const handleDelete = async (postId) => {
    if (!window.confirm('Are you sure you want to delete this post?')) return;
    try {
      await axiosInstance.delete(`/post/delete/${postId}`);
      if (onDeleteSuccess) onDeleteSuccess();
      else fetchPosts();
    } catch (err) {
      alert('Failed to delete post. Please try again.',err);
    }
  };

  return (
    <Container className="mt-4">
      <h4>Recent Posts</h4>
      {loading ? (
        <Spinner animation="border" />
      ) : error ? (
        <Alert variant="danger">{error}</Alert>
      ) : posts.length === 0 ? (
        <Alert variant="info">No posts found.</Alert>
      ) : (
        <Row>
          {posts.map((post) => (
            <Col md={6} key={post.post_id || post.postId}>
              <Card className="mb-4 shadow-sm">
                {post.file && (
                  <Card.Img
                    variant="top"
                    src={`http://localhost:8080/post/images/${post.file}`}
                    alt={post.name}
                  />
                )}
                <Card.Body>
                  <Card.Title>{post.name}</Card.Title>
                  <Card.Text>{post.content}</Card.Text>
                  <small className="text-muted">
                    Published on: {post.date || 'Unknown date'}
                  </small>
                  <div className="d-flex justify-content-between align-items-center mt-3">
                    <CommentList postId={post.post_id || post.postId} />
                    <Button
                      variant="danger"
                      size="sm"
                      onClick={() => handleDelete(post.post_id || post.postId)}
                    >
                      Delete
                    </Button>
                  </div>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      )}
    </Container>
  );
};

export default PostList;
