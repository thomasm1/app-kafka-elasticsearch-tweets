const express = require('express');
const bodyParser = require('body-parser');
const axios = require('axios');

const app = express();
app.use(bodyParser.json());


const commentsByPostId = {}; 
const PORT = 4003; 
const PORT_EVENT_BUS = 4005;


app.post(`/events`, async (req, res) => {
  const { type, data } = req.body;

  if (type === `CommentCreated`) {
    const status = data.content.includes(`orange`) ? `rejected` : `approved`;

    await axios.post(`http://localhost:${PORT_EVENT_BUS}/events`, {
      type: `CommentModerated`,
      data: {
        id: data.id,
        postId: data.postId,
        status,
        content: data.content
      }
    });
  }

  res.send({});
});


app.listen(PORT, () => {
  console.log(`⚡️[server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[moderation]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);
});
 