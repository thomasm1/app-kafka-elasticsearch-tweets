import * as express from 'express';
import { Application,  Request, Response } from 'express';
import { BLOCKCHAIN } from "./db-data";
import {randomBytes} from 'crypto';  
import axios  from 'axios';
import cors from 'cors'; 
 

const app: Application = express();
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
// app.use(cors({ origin: true }));
app.use(express.json());
app.use(express.urlencoded({ extended: false })); 

let blockchain =   {};
const PORT = 9009; 
const PORT_EVENT_BUS = 4005;


// #1 //
const getBlockchain = (req: Request, res: Response) => {
  res.status(200).json(Object.values(blockchain) );
  res.send(blockchain);
};


 // #2 //
 const getBlockById = (req: Request, res: Response) => {

  const blockId = req.params["id"];
  const blockchain: BLOCKCHAIN = Object.values(BLOCKCHAIN);
  const block = blockchain.find((block: { id: string; }) => block.id == blockId);

  res.status(200).json(block);
}  


// #3 //
 const BlockMinted = async (req: Request, res: Response) => {
  const id = randomBytes(4).toString(`hex`);
  const { title } = req.body;

  blockchain[id] = {
    id, title
  };

  await axios.post(`http://localhost:${PORT_EVENT_BUS}/events`, {
    type: "BlockMinted",
    data: {
      id, title
    },
  });

  res.status(201).send(blockchain[id]);
};


app.route('/blockchain').get(getBlockchain);  // #1 //
app.route(`/blockchain/:id`).get(getBlockById); // #2 // 
app.route(`/transaction`).post(BlockMinted); // #3 //


// #5
app.post(`/events`,(req: Request, res: Response) => {
  console.log(`Received Event`, req.body.type);

  res.send({});
});

app.listen(PORT, () => {
  console.log(`⚡️[*blockchain* server]: Server is running at https://localhost:${PORT}`);
  console.log(`⚡️[event-bus]: Event Bus target: https://localhost:${PORT_EVENT_BUS}`);
});
