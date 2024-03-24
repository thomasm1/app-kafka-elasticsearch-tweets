const { DATA_BLOCKCHAIN }  = require('./db-blockchain')
const Blockchain = require('.Blockchain');
const bitcoin = new Blockchain();




 

console.log('VALID: ', bitcoin.chainIsValid(DATA_BLOCKCHAIN.chain));









