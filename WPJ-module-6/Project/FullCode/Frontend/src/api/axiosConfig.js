// src/api/axiosConfig.js
import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // assuming your backend is on port 8080
  headers: {
    'Content-Type': 'application/json',
  },
  withCredentials: true, // this is important if backend uses session
});

export default axiosInstance;
