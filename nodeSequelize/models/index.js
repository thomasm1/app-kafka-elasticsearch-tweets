
const fs = require('fs');
const path = require('path');
const { Sequelize } = require('sequelize')
const basename = path.basename(__filename); 
const env = process.env.NODE_ENV || 'development';


const config = require(__dirname + '/../config/config.json')[env];
console.log(config)

// SEQUELZE
const sequelize = new Sequelize('database', 'username', 'password', {
    host: 'localhost',
    dialect: 'postgres',/* one of 'mysql' | 'mariadb' | 'postgres' | 'mssql' */
  });




  
  const Blog = require(`${__dirname}/models/blog`)(sequelize)

  Blog.findAll().then((blogs) => {
    console.log(blogs)
    sequelize.close()
  })

  const User = require(`${__dirname}/models/user`)(sequelize)

  User.findAll().then((users) => {
    console.log(users)
    sequelize.close()
  })
 


