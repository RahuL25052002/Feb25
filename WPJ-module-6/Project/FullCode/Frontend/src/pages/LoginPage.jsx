import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Card } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import axios from '../api/axiosConfig';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
const handleLogin = async (e) => {
  e.preventDefault();

  try {
    const response = await axios.post('/user/login', { email, password });

    // ✅ Store user details (e.g., id, name, email) in localStorage
    localStorage.setItem('user', JSON.stringify(response.data));
    localStorage.setItem('isLoggedIn', 'true');

    alert(response.data.message || 'Login successful');
    navigate('/dashboard');
  } catch (error) {
    alert('Login failed: Invalid credentials');
    console.error(error);
  }
};



  return (
    <div
      style={{
        backgroundImage:
          "url('https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=1470&q=80')",
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        padding: '20px',
        position: 'relative',
        color: '#fff',
      }}
    >
      {/* Overlay */}
      <div
        style={{
          position: 'absolute',
          top: 0,
          bottom: 0,
          left: 0,
          right: 0,
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          zIndex: 0,
        }}
      />

      <Container style={{ zIndex: 1 }}>
        <Row className="justify-content-center">
          <Col md={6}>
            <Card
              style={{
                borderRadius: '20px',
                backgroundColor: 'rgba(255, 255, 255, 0.95)',
                boxShadow: '0 8px 25px rgba(0, 0, 0, 0.2)',
              }}
            >
              <Card.Body>
                <h3 className="text-center mb-4" style={{ color: '#333' }}>
                  Login to Your Blog
                </h3>
                <Form onSubmit={handleLogin}>
                  <Form.Group className="mb-3">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control
                      type="email"
                      placeholder="Enter your email"
                      value={email}
                      onChange={(e) => setEmail(e.target.value)}
                      required
                    />
                  </Form.Group>

                  <Form.Group className="mb-4">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                      type="password"
                      placeholder="Enter your password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      required
                    />
                  </Form.Group>

                  <Button variant="primary" type="submit" className="w-100">
                    Login
                  </Button>
                </Form>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>

      {/* Footer */}
      <footer
        style={{
          zIndex: 1,
          marginTop: '30px',
          color: '#eee',
          fontSize: '0.85rem',
          textAlign: 'center',
        }}
      >
        &copy; {new Date().getFullYear()} MyBlog | Crafted with 💙
      </footer>
    </div>
  );
};

export default LoginPage;
