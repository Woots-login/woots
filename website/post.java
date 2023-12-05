// Import necessary modules and set up your Express app
const express = require('express');
const bodyParser = require('body-parser');

const app = express();

// Middleware to parse JSON body
app.use(bodyParser.json());

// POST route to handle form data
app.post('/processFormData', (req, res) => {
  // Retrieve data from the request body
  const { email, password } = req.body;

  // Perform necessary operations with the received data (e.g., database operations)
  // For demonstration purposes, log the received data
  console.log('Received email:', email);
  console.log('Received password:', password);

  // Send a response (you can customize this based on your requirements)
  res.status(200).json({ message: 'Form data received successfully.' });
});

// Start the server
const PORT = 3000; // Replace with your desired port number
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
