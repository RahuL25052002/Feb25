// src/components/SearchBar.jsx
import React, { useState } from 'react';
import axios from '../api/axiosConfig';
import { Form, Button } from 'react-bootstrap';

const SearchBar = ({ onResults }) => {
  const [keyword, setKeyword] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();
    const res = await axios.get(`/post/get/${keyword}`);
    onResults(res.data);
  };

  return (
    <Form onSubmit={handleSearch} className="mb-3 d-flex">
      <Form.Control
        placeholder="Search Posts"
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        className="me-2"
      />
      <Button type="submit">Search</Button>
    </Form>
  );
};

export default SearchBar;