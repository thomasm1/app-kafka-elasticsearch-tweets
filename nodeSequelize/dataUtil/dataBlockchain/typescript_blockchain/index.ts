import * as crypto from 'crypto';

class Transaction {
    constructor(
        public amount: number,
        public payer: string, // public key
        public payee: string, //    "
        ) {}

        toString() {
            return JSON.stringify(this);
        }
}

class Block { // CONTAINER for multiple transactions

    public nonce = Math.round(Math.random() * 99999999)
    constructor(
        public prevHash: string,
        public transaction: Transaction,
        public ts = Date.now()
    ) {}

    get hash() {
        const str = JSON.stringify(this);
        const hash = crypto.createHash('SHA256');//Secure Hash Alg, 256 bits - 1-way encrypt only
        hash.update(str).end();
        return hash.digest('hex');

    }
}

class Chain {
    public static instance = new Chain(); //singleton instance
    chain: Block[];

    constructor() {
        this.chain = [new Block(null, new Transaction(100, 'genesis', 'satoshi'))]; // GENESIS BLOCK
    }

    get lastBlock() {
        return this.chain[this.chain.length -1];
    }

    mine(nonce:number) {
        let solution = 1;
        console.log('⛏️⛏️⛏️ mining yo ⛏️⛏️⛏️')

        while(true) {
            const hash = crypto.createHash('MD5');// Message-Digest Algorithm: Similar to SHA-256, but only 128 bits - faster to compute
            hash.update((nonce + solution).toString()).end();
            
            const attempt = hash.digest('hex');
            if(attempt.substr(0,4) === '0000'){
                console.log(`Solved: ${solution}`);
                return solution;
            }
            solution += 1;
        }
    }

    addBlock(transaction: Transaction, senderPublicKey: string, signature: Buffer) {

        const verifier = crypto.createVerify('SHA256');
        verifier.update(transaction.toString());
        const isValid = verifier.verify(senderPublicKey, signature);

        if(isValid) {
        const newBlock = new Block(this.lastBlock.hash, transaction);
        
        this.mine(newBlock.nonce); // Proof of Work
        this.chain.push(newBlock); // Sending money secured by Wallet
        }
    };
}

class Wallet {
    public publicKey: string;
    public privateKey: string;

    constructor() {
        const keypair = crypto.generateKeyPairSync('rsa', {//Rivest-Shamir-Adleman, 2-way: 
            //public-Encrypt; private-Decrypt
            //SIGNING: signature-of-hash--private==>verify-hash--public
            modulusLength:2048,
            publicKeyEncoding: {type: 'spki', format:'pem' },
            privateKeyEncoding: {type: 'pkcs8', format:'pem' },
        }); 
        this.privateKey= keypair.privateKey;
        this.publicKey= keypair.publicKey;
    }

    sendMoney(amount:number, payeePublicKey: string) {
        const transaction = new Transaction(amount, this.publicKey, payeePublicKey);
        const sign = crypto.createSign('SHA256');
        sign.update(transaction.toString()).end();

        const signature = sign.sign(this.privateKey);
        Chain.instance.addBlock(transaction, this.publicKey, signature);
    }

}

// USE CASES: 
const satoshi = new Wallet();
const thomas = new Wallet();
const sarah = new Wallet();

satoshi.sendMoney(50, thomas.publicKey);
thomas.sendMoney(23, sarah.publicKey);
sarah.sendMoney(5, satoshi.publicKey);

console.log(Chain.instance);