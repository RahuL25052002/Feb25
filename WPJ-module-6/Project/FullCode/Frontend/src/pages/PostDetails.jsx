// src/pages/PostDetails.jsx
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from '../api/axiosConfig';
import { Container, Card } from 'react-bootstrap';

const PostDetails = () => {
  const { postId } = useParams();
  const [post, setPost] = useState(null);

  useEffect(() => {
    axios.get(`/post/${postId}`).then(res => setPost(res.data));
  }, [postId]);

  return (
    <Container className="mt-4">
      {post ? (
        <Card>
          <Card.Body>
            <Card.Title>{post.name}</Card.Title>
            <Card.Text>{post.content}</Card.Text>
            {post.file && <Card.Img src={`http://localhost:8080/post/images/${post.file}`} />}
          </Card.Body>
        </Card>
      ) : (
        <p>Loading post...</p>
      )}
    </Container>
  );
};

export default PostDetails;