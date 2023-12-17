import fs, { read } from 'fs';

export default function reader(filePath)   {
    
 fs.readFile(filePath, (err, data) => {
    if(err) throw err; 
    console.log(data.toString());  
    return data.toString();
  }) 
}
 
let filePath = '../data/csv/Coinbase_BTCUSD_2019.csv';
reader(filePath);