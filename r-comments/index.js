const express = require("express");
const bodyParser = require("body-parser");
const { randomBytes } = require("crypto");
const cors = require("cors");
const axios = require("axios");

const app = express();
app.use(bodyParser.json());
app.use(cors());

const commentsByPostId = {}; 
const PORT = 4001; 
const PORT_EVENT_BUS = 4005;

app.get(`/posts/:id/comments`, (req, res) => {
  res.send(commentsByPostId[req.params.id] || []);
});

app.post(`/posts/:id/comments`, async (req, res) => {
  const commentId = randomBytes(4).toString(`hex`);
  const { content } = req.body;

  const comments = commentsByPostId[req.params.id] || [];

  comments.push({ id: commentId, content });

  commentsByPostId[req.params.id] = comments;

  await axios.post(`http://localhost:${PORT_EVENT_BUS}/events`, {
    type: `CommentCreated`,
    data: {
      id: commentId,
      content,
      postId: req.params.id,
    },
  });

  res.status(201).send(comments);
});

app.post(`/events`, (req, res) => {
  console.log(`Event Received`, req.body.type);

  res.send({});
});
 

app.listen(PORT, () => {
  console.log(`⚡️[server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[comments]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);
});