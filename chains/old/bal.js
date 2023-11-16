// require('dotenv').config(); 
const express = require("express")
const cors = require('cors')
// const bodyParser = require('body-parser')
const Moralis = require("moralis").default 
const { EvmChain } = require("@moralisweb3/evm-utils")

const app = express()
app.use(cors())
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
const PORT = 8887 

const API_KEY =  process.env.MORALIS_API_KEY;
let chain = process.env.DEFAULT_CHAIN || 'eth'

const addressDEFAULT =  process.env.DEFAULT_ADDRESS;
const chainETH = EvmChain.ETHEREUM
const chainROPSTEIN = EvmChain.ROPSTEIN
const chainRINKEBY = EvmChain.RINKEBY
const chainPOLYGON = EvmChain.POLYGON
const chainMUMBAI = EvmChain.MUMBAI
const chainBSC = EvmChain.BSC
const chainBSC_TEST = EvmChain.BSC_TESTNET
const chainAVA = EvmChain.AVALANCHE



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
    address = req.query.address || addressDEFAULT;
    chain = req.query.chain || chainETH;
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
    switch (req.body.chain.toLowerCase()) {
        case "eth":
            chain = chainETH; break;
        case "ropstein":
            chain = chainROPSTEIN; break;
        case "rinkeby":
            chain = chainRINKEBY; break;
        case "polygon":
            chain = chainPOLYGON; break;
        case "mumbai":
            chain = chainMUMBAI; break;
        case "bsc":
            chain = chainBSC; break;
        case "bsctest":
            chain = chainBSC_TEST; break;        
        case "ava":
            chain = chainAVA; break;   
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
    try {p
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
    