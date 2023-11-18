"use strict";
exports.__esModule = true;
var express = require("express");
var db_data_1 = require("db-data");
var cors = require("cors");
var app = express();
app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});
app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
var get_users_route_1 = require("./routes/get-users.route");
// import { postLogin  } from './routes/get-users.route';
function postLogin(req, res) {
    var data = req.body;
    var email = data.email;
    var password = data.password;
    var user = null;
    var users = Object.values(db_data_1.USERS);
    for (var _i = 0, users_1 = users; _i < users_1.length; _i++) {
        var u = users_1[_i];
        if (u.email == email && u.password == password) {
            user = u;
        }
    }
    res.status(200).json(user);
}
var PORT = 9000;
app.route('/api/users').get(get_users_route_1.getUsers);
app.route('/api/users/email/:email').get(get_users_route_1.getUserById);
app.route('/api/login').get(postLogin);
