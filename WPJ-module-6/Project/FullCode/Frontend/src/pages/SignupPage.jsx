import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Card } from 'react-bootstrap';
import axios from '../api/axiosConfig';

const SignupPage = () => {
  const [form, setForm] = useState({ name: '', email: '', password: '', about: '' });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSignup = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/user/', form);
      alert(response.data.message);
    } catch (error) {
      console.error('Registration failed:', error);
      alert('Registration failed!');
    }
  };

  return (
    <div
      style={{
        backgroundImage:
          "url('https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1470&q=80')",
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
          <Col md={7}>
            <Card
              style={{
                borderRadius: '20px',
                backgroundColor: 'rgba(255, 255, 255, 0.95)',
                boxShadow: '0 8px 25px rgba(0, 0, 0, 0.2)',
                padding: '30px',
              }}
            >
              <h3 className="text-center mb-4" style={{ color: '#333' }}>
                Create an Account
              </h3>

              <Form onSubmit={handleSignup}>
                <Form.Group className="mb-3">
                  <Form.Label>Name</Form.Label>
                  <Form.Control
                    name="name"
                    value={form.name}
                    onChange={handleChange}
                    placeholder="Enter your name"
                    className="rounded-pill"
                    required
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    name="email"
                    value={form.email}
                    onChange={handleChange}
                    placeholder="Enter your email"
                    className="rounded-pill"
                    required
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    type="password"
                    name="password"
                    value={form.password}
                    onChange={handleChange}
                    placeholder="Create a password"
                    className="rounded-pill"
                    required
                  />
                </Form.Group>

                <Form.Group className="mb-4">
                  <Form.Label>About</Form.Label>
                  <Form.Control
                    as="textarea"
                    rows={3}
                    name="about"
                    value={form.about}
                    onChange={handleChange}
                    placeholder="Tell us about yourself"
                    className="rounded-3"
                  />
                </Form.Group>

                <Button
                  type="submit"
                  variant="success"
                  className="w-100 rounded-pill fw-bold custom-btn"
                >
                  Register
                </Button>
              </Form>
            </Card>
          </Col>
        </Row>
      </Container>

      <footer
        style={{
          marginTop: '30px',
          color: '#eee',
          fontSize: '0.85rem',
          zIndex: 1,
          textAlign: 'center',
        }}
      >
        &copy; {new Date().getFullYear()} BlogApp — Empowering your words ✨
      </footer>

      <style>{`
        .custom-btn {
          transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .custom-btn:hover {
          background-color: #198754;
          transform: scale(1.03);
        }
      `}</style>
    </div>
  );
};

export default SignupPage;
