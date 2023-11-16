
import { Request, Response } from 'express';
import { USERS } from "../db-data";


export function postLogin(req: Request, res: Response) {


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

export function getUsers(req: Request, res: Response) {
  // res.status(200).json({ data: Object.values(USERS) });
  res.status(200).json( Object.values(USERS) );
}

export function getUserById(req: Request, res: Response) {
  // To prevent the ID "0" we'll simply subtract by one. This way we can query for id = 2 which will serve us 1, etc. 
  //   const idx = req.params.id - 1;

  //   if (!user[idx]) {
  //     return res.status(404).json({ error: "user not found" });
  //   }
  //   return res.json(user[idx]);

  const email = req.params["email"];
  const users: any = Object.values(USERS);// users;
  const user = users.find((user: { email: string; }) => user.email == email);

  res.status(200).json(user);

}  