// server.js
const express = require('express');
const cors = require('cors');
const app = express();
const PORT = 3000;

app.use(cors()); // allows cross-origin requests
app.use(express.json()); // parses JSON in request body

// POST route to handle signup
app.post('/api/signup', (req, res) => {
  const { username, email, password } = req.body;

  // Here you can add logic to validate, hash password, store in DB, etc.
  console.log('Received data:', { username, email, password });

  res.json({ message: 'Signup successful!' });
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
