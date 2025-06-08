import React from 'react';
import ReactDOM from 'react-dom/client'; // Or 'react-dom' for older React versions
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css'; // If you use Bootstrap CSS

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App /> {/* <== App component is the root */}
  </React.StrictMode>
);