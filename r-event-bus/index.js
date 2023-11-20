const express = require("express");
const bodyParser = require("body-parser");
const axios = require("axios");

const app = express();
app.use(bodyParser.json());
 
const PORT_POSTS = 4000;
const PORT_COMMENTS = 4001;
const PORT_QUERY = 4002;
const PORT_MODERATION = 4003;


const PORT = 4005;
app.post(`/events`, (req, res) => {
  const event = req.body;

  axios.post(`http://localhost:${PORT_POSTS}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://localhost:${PORT_COMMENTS}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://localhost:${PORT_QUERY}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://localhost:${PORT_MODERATION}/events`, event).catch((err) => {
    console.log(err.message);
  });
  res.send({ status: "OK" });
});



app.listen(PORT, () => {
  console.log(`⚡️[Event-Bus]: Server is running at https://localhost:${PORT}`); 
});
 