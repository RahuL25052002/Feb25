import React from 'react';
import CategoryForm from '../components/CategoryForm';
import CategoryList from '../components/CategoryList';
import { Card } from 'react-bootstrap';

const Categories = () => {
  return (
    <div
      style={{
        backgroundImage:
          "url('https://images.unsplash.com/photo-1556761175-b413da4baf72?auto=format&fit=crop&w=1470&q=80')",
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '100vh',
        padding: '40px 20px',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        position: 'relative',
      }}
    >
      {/* Overlay */}
      <div
        style={{
          position: 'absolute',
          inset: 0,
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          zIndex: 0,
        }}
      ></div>

      <Card
        style={{
          maxWidth: '800px',
          width: '100%',
          padding: '30px',
          borderRadius: '20px',
          backgroundColor: 'rgba(255, 255, 255, 0.95)',
          boxShadow: '0 8px 25px rgba(0, 0, 0, 0.2)',
          zIndex: 1,
        }}
      >
        <h2 className="text-center mb-4" style={{ color: '#333' }}>Manage Categories</h2>

        <CategoryForm onSuccess={() => window.location.reload()} />

        <hr className="my-4" />

        <CategoryList />
      </Card>

      <footer
        style={{
          marginTop: '30px',
          color: '#eee',
          fontSize: '0.85rem',
          zIndex: 1,
        }}
      >
        &copy; {new Date().getFullYear()} BlogApp — Organize your content with clarity 🗂️
      </footer>
    </div>
  );
};

export default Categories;
