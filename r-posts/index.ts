import * as express from 'express';
import { Application,  Request, Response } from 'express';
import { POSTS } from "./db-data";
import { randomBytes } from 'crypto';
// const { randomBytes } = require("crypto");
import axios  from 'axios';
import * as cors from 'cors'; 
 

const app: Application = express();
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false })); 

const posts = {};
const PORT = 4000; 
const PORT_EVENT_BUS = 4005;

app.get(`/posts`, (req: Request, res: Response) => {
  res.send(posts);
});

app.post(`/posts/create`, async (req: Request, res: Response) => {
  const id = randomBytes(4).toString(`hex`);
  const { title } = req.body;

  posts[id] = {
    id, title
  };

  await axios.post(`http://localhost:${PORT_EVENT_BUS}/events`, {
    type: "PostCreated",
    data: {
      id, title
    },
  });

  res.status(201).send(posts[id]);
});

app.post(`/events`,(req: Request, res: Response) => {
  console.log(`Received Event`, req.body.type);

  res.send({});
});

app.listen(PORT, () => {

  console.log(`⚡️[server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[event-bus]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);

});
