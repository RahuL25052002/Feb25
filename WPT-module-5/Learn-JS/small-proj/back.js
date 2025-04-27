// server.js
const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(bodyParser.json());

// Connect to MySQL
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'cdac',          // replace with your MySQL password if set
  database: 'loginDB'    // make sure this DB exists
});

db.connect(err => {
  if (err) {
    console.error('MySQL connection failed: ', err.stack);
    return;
  }
  console.log('Connected to MySQL database');
});

// Endpoint to store user data
app.post('/login', (req, res) => {
  const { username, password } = req.body;

  if (!username || !password) {
    return res.status(400).send('Username and password required');
  }

  const sql = 'INSERT INTO users (username, password) VALUES (?, ?)';
  db.query(sql, [username, password], (err, result) => {
    if (err) {
      console.error('Error inserting data:', err);
      return res.status(500).send('Database error');
    }
    res.send('User saved!');
  });
});

app.listen(3000, () => {
  console.log('Server running on http://localhost:3000');
});
