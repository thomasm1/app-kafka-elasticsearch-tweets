"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var sha256 = require("sha256");
var currentNodeUrl = process.argv[3];
var uuid_1 = require("uuid");
var Blockchain = /** @class */ (function () {
    function Blockchain() {
        this.chain = [];
        this.pendingTransactions = [];
        this.currentNodeUrl = currentNodeUrl;
        this.networkNodes = [];
        this.createNewBlock(100, '0', '0');
    }
    Blockchain.prototype.createNewBlock = function (nonce, previousBlockHash, hash) {
        var newBlock = {
            index: this.chain.length + 1,
            timestamp: Date.now(),
            transactions: this.pendingTransactions,
            nonce: nonce,
            hash: hash,
            previousBlockHash: previousBlockHash
        };
        this.pendingTransactions = [];
        this.chain.push(newBlock);
        return newBlock;
    };
    Blockchain.prototype.getLastBlock = function () {
        return this.chain[this.chain.length - 1];
    };
    Blockchain.prototype.createNewTransaction = function (amount, sender, recipient) {
        var newTransaction = {
            amount: amount,
            sender: sender,
            recipient: recipient,
            transactionId: (0, uuid_1.v1)()
        };
        return newTransaction;
    };
    Blockchain.prototype.addTransactionToPendingTransactions = function (transactionObj) {
        this.pendingTransactions.push(transactionObj);
        return this.getLastBlock().index + 1;
    };
    Blockchain.prototype.hashBlock = function (previousBlockHash, currentBlockData, nonce) {
        var dataAsString = previousBlockHash + nonce.toString() + JSON.stringify(currentBlockData);
        var hash = sha256(dataAsString);
        return hash;
    };
    Blockchain.prototype.proofOfWork = function (previousBlockHash, currentBlockData) {
        var nonce = 0;
        var hash = this.hashBlock(previousBlockHash, currentBlockData, nonce);
        while (hash.substring(0, 4) !== '0000') {
            nonce++;
            hash = this.hashBlock(previousBlockHash, currentBlockData, nonce);
        }
        return nonce;
    };
    Blockchain.prototype.chainIsValid = function (blockchain) {
        var validChain = true;
        for (var i = 1; i < blockchain.length; i++) {
            var currentBlock = blockchain[i];
            var prevBlock = blockchain[i - 1];
            var blockHash = this.hashBlock(prevBlock.hash, { transactions: currentBlock.transactions, index: currentBlock.index }, currentBlock.nonce);
            if (blockHash.substring(0, 4) !== '0000')
                validChain = false;
            if (currentBlock.previousBlockHash !== prevBlock.hash)
                validChain = false;
        }
        var genesisBlock = blockchain[0];
        var correctNonce = genesisBlock.nonce === 100;
        var correctPreviousBlockHash = genesisBlock.previousBlockHash === '0';
        var correctHash = genesisBlock.hash === '0';
        var correctTransactions = genesisBlock.transactions.length === 0;
        if (!correctNonce || !correctPreviousBlockHash || !correctHash || !correctTransactions)
            validChain = false;
        return validChain;
    };
    Blockchain.prototype.getBlock = function (blockHash) {
        var correctBlock = null;
        this.chain.forEach(function (block) {
            if (block.hash === blockHash)
                correctBlock = block;
        });
        return correctBlock;
    };
    Blockchain.prototype.getTransaction = function (transactionId) {
        var correctTransaction = null;
        var correctBlock = null;
        this.chain.forEach(function (block) {
            block.transactions.forEach(function (transaction) {
                if (transaction.transactionId === transactionId) {
                    correctTransaction = transaction;
                    correctBlock = block;
                }
            });
        });
        return {
            transaction: correctTransaction,
            block: correctBlock
        };
    };
    Blockchain.prototype.getAddressData = function (address) {
        var addressTransactions = [];
        this.chain.forEach(function (block) {
            block.transactions.forEach(function (transaction) {
                if (transaction.sender === address || transaction.recipient === address) {
                    addressTransactions.push(transaction);
                }
            });
        });
        var balance = 0;
        addressTransactions.forEach(function (transaction) {
            if (transaction.recipient === address)
                balance += transaction.amount;
            else if (transaction.sender === address)
                balance -= transaction.amount;
        });
        return {
            addressTransactions: addressTransactions,
            addressBalance: balance
        };
    };
    return Blockchain;
}());
exports.default = Blockchain;
