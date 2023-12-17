const Sequelize = require('sequelize');
const db = require('../config/database.js');

const Crypto = db.define('crypto', {
  name: {
    type: Sequelize.STRING
  },
  token: {
    type: Sequelize.STRING
  },
  description: {
    type: Sequelize.STRING
  },
  symbol: {
    type: Sequelize.STRING
  },
  contact_email: {
    type: Sequelize.STRING
  }
});

Crypto.sync().then(() => {
  console.log('Crypto table created');
});
module.exports = Crypto;