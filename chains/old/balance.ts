
import * as express from 'express';
import {Application} from "express";
const app: Application = express(); 
import * as dotenv from 'dotenv'; 
import * as cors from 'cors';
dotenv.config(); 
import Moralis  from "moralis" 
const { EvmChain } = require("@moralisweb3/evm-utils")
 

app.use(cors()) 
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
const PORT = 8887 

const API_KEY =  process.env["MORALIS_API_KEY"];
let chain = process.env["DEFAULT_CHAIN"] || 'ETHEREUM'

const addressDEFAULT =  process.env["DEFAULT_ADDRESS"];
const chainETH = EvmChain.ETHEREUM
const chainROPSTEIN = EvmChain.ROPSTEIN
const chainRINKEBY = EvmChain.RINKEBY
const chainGOERLI = EvmChain.GOERLI
const chainPOLYGON = EvmChain.POLYGON
const chainMUMBAI = EvmChain.MUMBAI
const chainBSC = EvmChain.BSC
const chainBSC_TEST = EvmChain.BSC_TESTNET
const chainAVA = EvmChain.AVALANCHE
const chainFUJI = EvmChain.FUJI 
const chainFANTOM= EvmChain.FANTOM 
const chainARBITRUM = EvmChain.ARBITRUM 



async function getData(address, chain) {
    // GET NATIVE BAL
    const nativeBal = await Moralis.EvmApi.balance.getNativeBalance({
        address,
        chain
    })
    // Format native bal formated in ether via the .ether getter
    const native = nativeBal.result.balance.ether
    // GET TOKEN BAL
    const tokenBals = await Moralis.EvmApi.token.getWalletTokenBalances({
        address,
        chain
})
    // Format token bal formated to readable outpu with display() method
    const tokens = tokenBals.result.map((token) => token.display());
    // GET NFTs
    const nftBals = await Moralis.EvmApi.nft.getWalletNFTs({
        address,
        chain,
        limit:10,
    })
    // Format outpu to return name, amount and metadata
    const nfts = nftBals.result.map((nft) => ({
    name: nft.result.name,
    amount: nft.result.amount,
    metadata: nft.result.metadata,
    }))
    return { native, tokens, nfts }
}
//////////// ROUTING ////////////////////////////////////////////////////////////////////

app.get("/nft", async(req, res) => {

try {
    const address = req.query['address'] || addressDEFAULT;
    chain = req.query['chain'] || chainETH;
    const data = await getData(address, chain)    
    res.status(200)
    res.json(data)
} catch (error) {
    console.log(error);
    res.status(500)
    res.json({error: error.message })
}
})

app.post("/nft", async(req, res) => { 
    const address = req.body.address;

    if(!address || address.length !== 42) {
        res.status(400);
        res.json({error: "Invalid address" });
    }; 
    if(!chain || chain.length < 3) {
        res.status(400);
        res.json({error: "Invalid chain" });
    }; 
    switch (req.body.chain.toUpperCase()) {
        case "ETHEREUM":
            chain = chainETH; break;
        case "ROPSTEIN":
            chain = chainROPSTEIN; break;
        case "RINKEBY":
            chain = chainRINKEBY; break;
        case "GOERLI":
            chain = chainGOERLI; break;
        case "POLYGON":
            chain = chainPOLYGON; break;
        case "MUMBAI":
            chain = chainMUMBAI; break;
        case "BNB":
            chain = chainBSC; break;
        case "BNB_TEST":
            chain = chainBSC_TEST; break;        
        case "AVALANCHE":
            chain = chainAVA; break;     
        case "FUJI":
            chain = chainFUJI; break;     
        case "FANTOM":
            chain = chainFANTOM; break;     
        case "ARBITRUM":
            chain = chainARBITRUM; break;   
        default:
            res.status(400);
            res.json({error: "chain not supported" })                    
    }
        
    try {
        const data  = await getData(address, chain);
        res.status(200)
        res.json(data)
    } catch (error) {
        console.log(error);
        res.status(500)
        res.json({error: error.message })
    }
    })
app.post("/nft/eth", async(req, res) => { 
    const address = req.body.address;
    if(!address || address.length !== 42) {
        res.status(400);
        res.json({error: "Invalid address" });
    }; 
    // multi-chain support later TODO
    const chain = chainETH;
    try {
        const data  = await getData(address, chain);
        res.status(200)
        res.json(data)
    } catch (error) {
        console.log(error);
        res.status(500)
        res.json({error: error.message })
    }
    })
app.get("/nft/eth/:address", async(req, res) => { 
    const address = req.params.address;  
    if(!address || address.length !== 42) {
        res.status(400);
        res.json({error: "Invalid address" });
    }; 
    // multi-chain support later TODO
    const chain = chainETH;
    try {
        const data  = await getData(address, chain);
        res.status(200)
        res.json(data)
    } catch (error) {
        console.log(error);
        res.status(500)
        res.json({error: error.message })
    }
    })
const startServer = async() => {
    await Moralis.start({
        apiKey: API_KEY,
    })
    app.listen(PORT, () => {
        console.log(`Example app listening at http://localhost:${PORT}`)
    })
}
startServer();
    