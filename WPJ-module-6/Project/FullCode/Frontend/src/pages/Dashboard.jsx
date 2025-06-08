import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import PostForm from '../components/PostForm';
import CategoryForm from '../components/CategoryForm';
import PostList from '../components/PostList';
import axios from '../api/axiosConfig';

const Dashboard = () => {
  const navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem('user'));
  const userId = user?.id || null;

  const [activeCategoryId, setActiveCategoryId] = useState(null);
  const [showCategoryForm, setShowCategoryForm] = useState(false);
  const [categories, setCategories] = useState([]);
  const [reload, setReload] = useState(false);

  useEffect(() => {
    if (!userId) {
      navigate('/login');
    }
  }, [userId, navigate]);

  const handleReload = () => setReload(prev => !prev);

  const loadCategories = async () => {
    try {
      const res = await axios.get('/category/');
      setCategories(res.data);
    } catch (err) {
      console.error('Error loading categories:', err);
    }
  };

  useEffect(() => {
    loadCategories();
  }, [reload]);

  const handleShowPostForm = (categoryId) => {
    setActiveCategoryId(categoryId);
  };

  const handleBack = () => {
    setActiveCategoryId(null);
    setShowCategoryForm(false);
    handleReload();
  };

  return (
    <div
      style={{
        backgroundImage:
          "url('https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&w=1470&q=80')",
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        padding: '30px',
        position: 'relative',
        color: '#333',
      }}
    >
      <div
        style={{
          position: 'absolute',
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          zIndex: 0,
        }}
      />
      <Container fluid style={{ position: 'relative', zIndex: 1 }}>
        <h2 className="text-center mb-5" style={{ color: '#00d4ff', fontWeight: '700' }}>
          Dashboard
        </h2>

        {!activeCategoryId && !showCategoryForm && (
          <Row className="justify-content-center mb-4">
            <Col xs="auto">
              <Button variant="success" size="lg" onClick={() => setShowCategoryForm(true)}>
                Create Category
              </Button>
            </Col>
          </Row>
        )}

        {showCategoryForm && (
          <Card className="custom-card mx-auto" style={{ maxWidth: 600 }}>
            <Card.Body>
              <h4 className="mb-3">Create Category</h4>
              <CategoryForm onSuccess={handleBack} />
              <Button variant="secondary" onClick={handleBack} className="mt-3">
                Back
              </Button>
            </Card.Body>
          </Card>
        )}

        {activeCategoryId && (
          <Card className="custom-card mx-auto" style={{ maxWidth: 600 }}>
            <Card.Body>
              <h4 className="mb-3">
                Create Post for Category:{' '}
                {categories.find(c => c.category_id === activeCategoryId)?.title}
              </h4>
              <PostForm
                userId={userId}
                categoryId={activeCategoryId}
                onSuccess={handleBack}
              />
              <Button variant="secondary" onClick={handleBack} className="mt-3">
                Back
              </Button>
            </Card.Body>
          </Card>
        )}

        {!activeCategoryId && !showCategoryForm && (
          <Row>
            <Col md={6}>
              <Card className="custom-card mb-4" style={{ maxHeight: '60vh', overflowY: 'auto' }}>
                <Card.Body>
                  <h4>All Categories</h4>
                  {categories.map(cat => (
                    <Card key={cat.category_id} className="mb-3 p-3 shadow-sm">
                      <h5>{cat.title}</h5>
                      <p>{cat.description}</p>
                      <Button variant="primary" onClick={() => handleShowPostForm(cat.category_id)}>
                        Create Post
                      </Button>
                    </Card>
                  ))}
                </Card.Body>
              </Card>
            </Col>

            <Col md={6}>
              <Card className="custom-card mb-4" style={{ maxHeight: '60vh', overflowY: 'auto' }}>
                <Card.Body>
                  <h4>Recent Posts</h4>
                  <PostList reload={reload} />
                </Card.Body>
              </Card>
            </Col>
          </Row>
        )}

        <footer style={{ marginTop: '40px', color: '#eee', fontSize: '0.9rem', textAlign: 'center' }}>
          &copy; {new Date().getFullYear()} BlogApp — Stylish and smart ✨
        </footer>
      </Container>

      <style>{`
        .custom-card {
          background: rgba(255, 255, 255, 0.95);
          border: none;
          border-radius: 20px;
          box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
          color: #333;
        }
        .btn-primary, .btn-success {
          border: none;
          border-radius: 30px;
          padding: 10px 22px;
          font-weight: 600;
          background-image: linear-gradient(135deg, #00d4ff, #007cf0);
          color: #fff !important;
          transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        .btn-primary:hover, .btn-success:hover {
          transform: scale(1.05);
          box-shadow: 0 6px 15px rgba(0, 212, 255, 0.4);
        }
        .form-control {
          border-radius: 12px;
        }
      `}</style>
    </div>
  );
};

export default Dashboard;
