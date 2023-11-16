

import {Request, Response} from 'express'; 
import {CHAINS } from "../data/db-data";


 
export function getAllChains(req: Request, res: Response) {
 

         res.status(200).json({data:Object.values(CHAINS)});
 

}
export function getChainById(req: Request, res: Response) {

    const chainId = req.params["id"];
    const chains: any = Object.values(CHAINS);
    const chain = chains.find((chain: { id: number; }) => chain.id == +chainId); 

        res.status(200).json(chain);
 

} 