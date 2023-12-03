import * as express from 'express';
import { Application,  Request, Response } from 'express'; 
import { USERS } from "./db-data";
import {randomBytes} from 'crypto'; 
import axios  from 'axios';
import cors from 'cors'; 
 

const app: Application = express();
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
// app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false })); 
  
const users = USERS; // {};
const PORT = 9002; 
const PORT_EVENT_BUS = 4005;

// #1
const   getUsers = (req: Request, res: Response) => {
  // res.status(200).json({ data: Object.values(users) });
  res.status(200).json( Object.values(users) );
}

 // #2
const getUserById = (req: Request, res: Response) => {

  const email = req.params["email"];
  const users: any = Object.values(USERS);// users;                   //////// REMOVE THIS LINE
  const user = users.find((user: { email: string; }) => user.email == email);

  res.status(200).json(user);

}  
// #3
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

// #4
const userLogin = (req: Request, res: Response) => {
  const data = req.body;
  const users: any = Object.values(USERS);// users;
  let email = data.email;
  let password = data.password;
  let user = null;
 
  for (let u of users) {
    if (u.email == email && u.password == password) {
      user = u
    }
  }
  res.status(200).json(user)
}

app.route('/users').get(getUsers); // #1
app.route('/users/email/:email').get(getUserById);  // #2
app.route('/users').post(userRegister); // #3
app.route('/login').get(userLogin);



app.post(`/events`, (req, res) => {
  console.log(`Received Event`, req.body.type); 
  res.send({});
});

app.listen(PORT, () => {
  console.log(`⚡️[*users* server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[event-bus]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);
});
 