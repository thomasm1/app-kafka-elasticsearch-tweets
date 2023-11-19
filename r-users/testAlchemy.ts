
import Moralis from "moralis"
import { Network, Alchemy } from 'alchemy-sdk';

import * as express from 'express';

import { Application } from "express";
import * as path from 'path';
import * as cors from 'cors';
import * as chains from './data/db-constants'; 

import { getRequiredEnvVar, setDefaultEnvVar } from "./util/envHelpers";
import {
  addAlchemyContextToRequest,
  validateAlchemySignature,
  AlchemyWebhookEvent,
} from "./util/webhooksUtil";


const app: Application = express();
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

const { EvmChain } = require("@moralisweb3/evm-utils")


///////// TEST DATA METHODS
import { getAllChains, getChainById } from "./routes/get-chains.route";
import {  searchAddresses } from "./routes/search-addresses.route";
// searchAddressesByCategory 
import { saveChain } from './routes/save-chain.route';
import { postLogin,  getUsers, getUserById, } from './routes/get-users.route';
// import  {getOpenai} from './routes/openai.route';
import { getNft, postNft, postNfts, getNftData, postNftData } from './routes/get-nfts.route';

/////// LIVE DATA METHODS
import { getDataController } from './controllers/getDataController';
import { runInThisContext } from "vm";

/////////////// CONSTANTS
const PORT = 9000;
const ALCHEMY_AUTH_TOKEN = process.env["ALCHEMY_AUTH_TOKEN"];
const ALCHEMY_ETHEREUM = process.env["ALCHEMY_ETHEREUM"];
const ALCHEMY_POLYGON = process.env["ALCHEMY_POLYGON"];
const API_KEY = process.env["MORALIS_API_KEY"];
let chain = process.env["DEFAULT_CHAIN"] || 'ETHEREUM'
const addressDEFAULT = process.env["DEFAULT_ADDRESS"];
 


//// STATIC FILES
app.use(express.static(path.join(__dirname, 'public')));
/// ROUTING
app.route('/api/chains').get(getAllChains);
app.route('/api/chains/:id').get(getChainById);

app.route('/api/addresses').get(searchAddresses);
// app.route('/api/addresses:category').get(searchAddressesByCategory);  
app.route('/api/chains/:id').put(saveChain);
// app.route('/api/nft').get(getNft);  
app.route('/api/login').post(postLogin);
app.route('/api/users').get(getUsers);
app.route('/api/users/:id').get(getUserById);

app.route('/api/nft-test').get(getNft);
app.route('/api/nft-test').post(postNft);

app.route('/api/nfts-test').post(postNfts); 
/// open-ai stuff
app.use('/api/openai', require('./routes/openai.route'));
// app.route('/api/openai').post(getOpenai);



//// LIVE DATA ROUTES
app.get("/api/nft", async (req, res) => {

  try { 
    const address = req.query['address'] || addressDEFAULT;
    chain = req.query['chain'] || chains.chainETH;
    const data = await getDataController(address, chain)
    res.status(200)
    res.json(data)
  } catch (error) {
    console.log(error);
    res.status(500)
    res.json({ error: error.message })
  }
})

app.post("/api/nft", async (req, res) => {
  const address = req.body.address;

  if (!address || address.length !== 42) {
    res.status(400);
    res.json({ error: "Invalid address" });
  };
  if (!chain || chain.length < 3) {
    res.status(400);
    res.json({ error: "Invalid chain" });
  };
  
  switch (req.body.chain.toUpperCase()) {
    case "ETHEREUM":
      chain = chains.chainETH; break;
    case "ROPSTEIN":
      chain = chains.chainROPSTEIN; break;
    case "RINKEBY":
      chain = chains.chainRINKEBY; break;
    case "GOERLI":
      chain = chains.chainGOERLI; break;
    case "POLYGON":
      chain = chains.chainPOLYGON; break;
    case "MUMBAI":
      chain = chains.chainMUMBAI; break;
    case "BNB":
      chain = chains.chainBSC; break;
    case "BNB_TEST":
      chain = chains.chainBSC_TEST; break;
    case "AVALANCHE":
      chain = chains.chainAVA; break;
    case "FUJI":
      chain = chains.chainFUJI; break;
    case "FANTOM":
      chain = chains.chainFANTOM; break;
    case "ARBITRUM":
      chain = chains.chainARBITRUM; break;
    default:
      res.status(400);
      res.json({ error: "chain not supported" })
  }

  try {
    const data = await getDataController(address, chain);
    res.status(200)
    res.json(data)
  } catch (error) {
    console.log(error);
    res.status(500)
    res.json({ error: error.message })
  }
})
 
app.get("api/nft/eth/:address", async (req, res) => {
  const address = req.params.address;
  if (!address || address.length !== 42) {
    res.status(400);
    res.json({ error: "Invalid address" });
  };
  // multi-chain support later TODO
  const chain = chains.chainETH;
  try {
    const data = await getDataController(address, chain);
    res.status(200)
    res.json(data)
  } catch (error) {
    console.log(error);
    res.status(500)
    res.json({ error: error.message })
  }
})


//// WEBHOOKS
// polygon
async function runTest() {
  app.post(`https://polygon-mainnet.g.alchemy.com/v2/${process.env["ALCHEMY_POLYGON"]}`, async (req, res) => {
 
const settings = {
  apiKey: ALCHEMY_POLYGON, // Replace with your Alchemy API Key.
  network: Network.ETH_MAINNET, // Replace with your network.
};

const alchemy = new Alchemy(settings);

async function main() {
  const latestBlock = await alchemy.core.getBlockNumber();
  console.log("The latest block number is", latestBlock);
}
main()
})

}
// ETHEREUM
app.post(`https://eth-mainnet.g.alchemy.com/v2/${process.env["ALCHEMY_ETHEREUM"]}`, async (req, res) => {
 
const { Network, Alchemy } = require("alchemy-sdk");
 
const settings = {
  apiKey: ALCHEMY_ETHEREUM, // Replace with your Alchemy API Key.
  network: Network.ETH_MAINNET, // Replace with your network.
};

const alchemy = new Alchemy(settings);

async function main() {
  const latestBlock = await alchemy.core.getBlockNumber();
  console.log("The latest block number is", latestBlock);
}
}) 

async function alchemy(): Promise<void> { 

  // setDefaultEnvVar("PORT", "9000");
  // setDefaultEnvVar("HOST", "127.0.0.1");
  setDefaultEnvVar("SIGNING_KEY", `${process.env["ALCHEMY_AUTH_TOKEN"]}`);

  // const port = +getRequiredEnvVar("PORT");
  // const host = getRequiredEnvVar("HOST");
  const signingKey = getRequiredEnvVar(`SIGNING_KEY`);

  // Middleware needed to validate the alchemy signature
  app.use(
    express.json({
      verify: addAlchemyContextToRequest,
    })
  );
  app.use(validateAlchemySignature(signingKey));

  // Register handler for Alchemy Notify webhook events
  // TODO: update to your own webhook path
  app.post("/api/alchemy/ethereum", (req, res) => {
    const webhookEvent = req.body as AlchemyWebhookEvent;
    // Do stuff with with webhook event here!
    console.log(`Processing webhook event id: ${webhookEvent.id}`);
    // Be sure to respond with 200 when you successfully process the event
    res.send("Alchemy Notify is the best!");
  });
}


const startServer = async () => {
  await Moralis.start({
    apiKey: API_KEY,
  })
  app.listen(PORT, () => {
    console.log(`HTTP REST API Server listening at http://localhost:${PORT}/api/nft`)
  })
}
runTest();
alchemy();
startServer(); 