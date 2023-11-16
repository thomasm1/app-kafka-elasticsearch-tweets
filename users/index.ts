import * as express from 'express';
import * as fs from 'fs';
import * as https from 'https';
import { USERS } from "db-data";
import { Application } from "express";
import * as path from 'path';
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
 
import {  getUsers, getUserById, } from './routes/get-users.route';
// import { postLogin  } from './routes/get-users.route';

function postLogin(req, res) { 

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
 
 
const PORT = 9000;
 
 
app.route('/api/users').get(getUsers); 
app.route('/api/users/email/:email').get(getUserById);

app.route('/api/login').get(postLogin);
 
  
 