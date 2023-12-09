const express = require("express");
const bodyParser = require("body-parser");
const axios = require("axios");

const app = express();
app.use(bodyParser.json());
 
const PORT_POSTS = 4000;
const PORT_COMMENTS = 4001;
const PORT_QUERY = 4002;
const PORT_MODERATION = 4003;

const PORT_BLOCKCHAIN = 9009;
const PORT_USERS = 9000;

const PORT = 4005;
const events = [];

app.post(`/events`, (req, res) => {
  const event = req.body;
  events.push(event);

  axios.post(`http://posts-clusterip-srv:${PORT_POSTS}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://comments-srv:${PORT_COMMENTS}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://query-srv:${PORT_QUERY}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://moderation-srv:${PORT_MODERATION}/events`, event).catch((err) => {
    console.log(err.message);
  });

  axios.post(`http://blockchain-srv:${PORT_BLOCKCHAIN}/events`, event).catch((err) => {
    console.log(err.message);
  });
  axios.post(`http://users-srv:${PORT_USERS}/events`, event).catch((err) => {
    console.log(err.message);
  });
  res.send({ status: "OK" });
});


app.get("/events", (req,res) => {
  res.send(events);
})

app.listen(PORT, () => {
  console.log(`⚡️[Event-Bus]: Server is running at https://localhost:${PORT}`); 
});
 