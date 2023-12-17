const Sequelize = require('sequelize');
const dotenv = require('dotenv');
 
dotenv.config();

// module.exports =  new Sequelize(process.env.DATABASE_URL, {
module.exports =  new Sequelize("cryptomaven","postgres", "5432", {
  host: 'localhost',
  dialect: 'postgres',  

  // host: 'commuterlink.cmcadlepsyx9.us-east-1.rds.amazonaws.com',
  // dialect: 'postgres',  
  // host: 'thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com'
  // dialect: 'oracle',   
  operatorsAliases: false, 
  pool: {
    max: 5,
    min: 0,
    acquire: 30000,
    idle: 10000
  },
});