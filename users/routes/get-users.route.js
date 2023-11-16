"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.getUserById = exports.getUsers = exports.postLogin = void 0;
var db_data_1 = require("../data/db-data");
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
exports.postLogin = postLogin;
function getUsers(req, res) {
    // res.status(200).json({ data: Object.values(USERS) });
    res.status(200).json(Object.values(db_data_1.USERS));
}
exports.getUsers = getUsers;
function getUserById(req, res) {
    // To prevent the ID "0" we'll simply subtract by one. This way we can query for id = 2 which will serve us 1, etc. 
    //   const idx = req.params.id - 1;
    //   if (!user[idx]) {
    //     return res.status(404).json({ error: "user not found" });
    //   }
    //   return res.json(user[idx]);
    var email = req.params["email"];
    var users = Object.values(db_data_1.USERS); // users;
    var user = users.find(function (user) { return user.email == email; });
    res.status(200).json(user);
}
exports.getUserById = getUserById;
