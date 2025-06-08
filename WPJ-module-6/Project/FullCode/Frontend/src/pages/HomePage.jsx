import React from 'react';
import { Button, Container } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
  const navigate = useNavigate();

  // Simple auth check: if token exists in localStorage
  const isLoggedIn = Boolean(localStorage.getItem('token'));

  return (
    <div style={styles.pageContainer}>
      {/* Dark overlay */}
      <div style={styles.overlay} />

      <Container style={styles.contentContainer}>
        <header style={styles.header}>
          {!isLoggedIn ? (
            <>
              <h1 className="display-3 fw-bold mb-3">
                Welcome to <span style={styles.brandName}>BlogApp</span>
              </h1>
              <p className="lead mb-4">
                Your new space to create, share, and discover amazing stories.
              </p>
              <p className="mb-5" style={{ maxWidth: '600px', margin: '0 auto 3rem' }}>
                Whether you're a seasoned writer, a casual blogger, or just have a story to tell, BlogApp provides you with the tools to bring your ideas to life. Join our community and start your journey today!
              </p>
              <div className="d-flex justify-content-center gap-3">
                <Button
                  variant="primary"
                  size="lg"
                  onClick={() => navigate('/login')}
                >
                  Login
                </Button>
                <Button
                  variant="success"
                  size="lg"
                  onClick={() => navigate('/signup')}
                >
                  Sign Up
                </Button>
              </div>
            </>
          ) : (
            <>
              <h1 className="display-4 fw-bold mb-3">
                Welcome Back, <span style={styles.brandName}>Storyteller!</span>
              </h1>
              <p className="lead mb-4">
                Ready to inspire the world with your next story?
              </p>
              <Button
                variant="light"
                size="lg"
                onClick={() => navigate('/dashboard')}
              >
                Go to Dashboard
              </Button>
            </>
          )}
        </header>
      </Container>

      {/* Footer */}
      <footer style={styles.footer}>
        &copy; {new Date().getFullYear()} BlogApp &mdash; Crafted with ✨ for storytellers
      </footer>
    </div>
  );
};

// Styles object for better organization
const styles = {
  pageContainer: {
    backgroundImage:
      "url('https://images.unsplash.com/photo-1522199710521-72d69614c702?auto=format&fit=crop&w=1470&q=80')",
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    minHeight: '100vh',
    display: 'flex',
    flexDirection: 'column',
    position: 'relative',
    color: '#fff',
    textAlign: 'center',
  },
  overlay: {
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: 'rgba(0, 0, 0, 0.6)', // Increased overlay darkness for better text readability
    zIndex: 1,
  },
  contentContainer: {
    zIndex: 2,
    flex: 1,
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center', // This will center the content vertically
    alignItems: 'center', // This will center the content horizontally
    padding: '20px',
  },
  header: {
    width: '100%',
  },
  brandName: {
    color: '#00d4ff',
  },
  footer: {
    zIndex: 2,
    padding: '20px',
    color: '#ccc',
    fontSize: '0.9rem',
    width: '100%',
  },
};

export default HomePage;