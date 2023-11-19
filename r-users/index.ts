import * as express from 'express';
import { Application,  Request, Response } from 'express';
const { randomBytes } = require("crypto");
// const bodyParser = require("body-parser");
import { USERS } from "./db-data";
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
  
const users = {};
const PORT = 9000; 
const PORT_EVENT_BUS = 4005;

 
const userRegister = async (req: Request, res: Response) => {
  const id = randomBytes(4).toString(`hex`);
  const { email, password } = req.body;
  users[id] = {
    id 
  };

  await axios.post(`http://localhost:${PORT_EVENT_BUS}/events`, {
    type: "UserCreated",
    data: {
      id,
      email,
      password
    },
  });

  res.status(201).send(users[id]);
};

const userLogin = (req: Request, res: Response) => {
  const data = req.body;
  let email = data.email;
  let password = data.password;
  let user = null;
  let users: any = Object.values(USERS)
  for (let u of users) {
    if (u.email == email && u.password == password) {
      user = u
    }
  }
  res.status(200).json(user)
}

const   getUsers = (req: Request, res: Response) => {
  // res.status(200).json({ data: Object.values(USERS) });
  res.status(200).json( Object.values(USERS) );
}

const getUserById = (req: Request, res: Response) => {

  const email = req.params["email"];
  const users: any = Object.values(USERS); 
  const user = users.find((user: { email: string; }) => user.email == email);

  res.status(200).json(user);

}  

app.route('/users').post(userRegister);
 
app.route('/users').get(getUsers); 
app.route('/users/email/:email').get(getUserById);
app.route('/login').get(userLogin);

app.post(`/events`, (req, res) => {
  console.log(`Received Event`, req.body.type);

  res.send({});
});

app.listen(PORT, () => {
  console.log(`⚡️[server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[event-bus]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);
});
 