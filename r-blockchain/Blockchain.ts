
import * as sha256 from 'sha256';
const currentNodeUrl: string = process.argv[3];
//"nodemon --watch dev -e js dev/networkNode.js 9001 http://localhost:9001"
import { v1 as uuidv1 } from 'uuid';

interface Transaction {
    amount: number;
    sender: string;
    recipient: string;
    transactionId: string;
}

interface Block {
    index: number;
    timestamp: number;
    transactions: Transaction[];
    nonce: number;
    hash: string;
    previousBlockHash: string;
}
 class Blockchain {
    private chain: Block[];
    private pendingTransactions: Transaction[];
    private currentNodeUrl: string;
    private networkNodes: string[];

    constructor() {
        this.chain = [];
        this.pendingTransactions = [];
        this.currentNodeUrl = currentNodeUrl;
        this.networkNodes = [];
        this.createNewBlock(100, '0', '0');
    }

    createNewBlock(nonce: number, previousBlockHash: string, hash: string): Block {
        const newBlock: Block = {
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
    }

    getLastBlock(): Block {
        return this.chain[this.chain.length - 1];
    }

    createNewTransaction(amount: number, sender: string, recipient: string): Transaction {
        const newTransaction: Transaction = {
            amount: amount,
            sender: sender,
            recipient: recipient,
            transactionId: uuidv1()
        };

        return newTransaction;
    }

    addTransactionToPendingTransactions(transactionObj: Transaction): number {
        this.pendingTransactions.push(transactionObj);
        return this.getLastBlock().index + 1;
    }

    hashBlock(previousBlockHash: string, currentBlockData: any, nonce: number): string {
        const dataAsString: string = previousBlockHash + nonce.toString() + JSON.stringify(currentBlockData);
        const hash: string = sha256(dataAsString);
        return hash;
    }

    proofOfWork(previousBlockHash: string, currentBlockData: any): number {
        let nonce: number = 0;
        let hash: string = this.hashBlock(previousBlockHash, currentBlockData, nonce);
        while (hash.substring(0, 4) !== '0000') {
            nonce++;
            hash = this.hashBlock(previousBlockHash, currentBlockData, nonce);
        }

        return nonce;
    }

    chainIsValid(blockchain: Block[]): boolean {
        let validChain: boolean = true;

        for (let i = 1; i < blockchain.length; i++) {
            const currentBlock: Block = blockchain[i];
            const prevBlock: Block = blockchain[i - 1];
            const blockHash: string = this.hashBlock(prevBlock.hash, { transactions: currentBlock.transactions, index: currentBlock.index }, currentBlock.nonce);
            if (blockHash.substring(0, 4) !== '0000') validChain = false;
            if (currentBlock.previousBlockHash !== prevBlock.hash) validChain = false;
        }

        const genesisBlock: Block = blockchain[0];
        const correctNonce: boolean = genesisBlock.nonce === 100;
        const correctPreviousBlockHash: boolean = genesisBlock.previousBlockHash === '0';
        const correctHash: boolean = genesisBlock.hash === '0';
        const correctTransactions: boolean = genesisBlock.transactions.length === 0;

        if (!correctNonce || !correctPreviousBlockHash || !correctHash || !correctTransactions) validChain = false;

        return validChain;
    }

    getBlock(blockHash: string): Block | null {
        let correctBlock: Block | null = null;
        this.chain.forEach(block => {
            if (block.hash === blockHash) correctBlock = block;
        });
        return correctBlock;
    }

    getTransaction(transactionId: string): { transaction: Transaction | null; block: Block | null } {
        let correctTransaction: Transaction | null = null;
        let correctBlock: Block | null = null;

        this.chain.forEach(block => {
            block.transactions.forEach(transaction => {
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
    }

    getAddressData(address: string): { addressTransactions: Transaction[]; addressBalance: number } {
        const addressTransactions: Transaction[] = [];
        this.chain.forEach(block => {
            block.transactions.forEach(transaction => {
                if (transaction.sender === address || transaction.recipient === address) {
                    addressTransactions.push(transaction);
                }
            });
        });

        let balance: number = 0;
        addressTransactions.forEach(transaction => {
            if (transaction.recipient === address) balance += transaction.amount;
            else if (transaction.sender === address) balance -= transaction.amount;
        });

        return {
            addressTransactions: addressTransactions,
            addressBalance: balance
        };
    }
}

export default Blockchain;