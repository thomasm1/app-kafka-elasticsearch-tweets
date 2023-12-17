import DataTrie from "../../dataStructures/dataTrie";
import {hashMethods} from "../../dataStructures/dataHashTablesProto";


// Tags & Searchbox
const trieTag = new DataTrie(); 

// 
// Text & Quotations Mapper
export default class QuotationsClosure { 
 
constructor(options){
    
const quoteHash = new hashMethods(options);  
this.options = options || {};

//add
this.key = options.key || '';
this.val = options.val || '';
//query
this.query = options.query || '';

quoteHash.add('title', `Bitcoin Buyer Console`);
quoteHash.add('tocTitle', `Guiding Inspiration for Bitcoin Buyer:`);
quoteHash.add('toc',`“Typically, momentum trading is effective in markets that 1) do not have valuation models, 2) have large amounts of volatility, and 3) have frequent mispricings. Momentum investing is not typically used in US stocks, bonds, or options – as they have clear valuation models (e.g. discounted cash flow analysis for stocks and black Scholes for options). However, for commodities and assets like crypto – momentum trading can be an effective strategy that allows protection from losses in downtrends and capture subside on the uptrends. Based on historical data, this may be an extremely effective strategy – until a valuation model has been figured out.” <sup>1</sup><br />
<br /> 
[using a strategy to]
"... create deep reinforcement learning agents that learn to make money trading Bitcoin. <br />
... to experiment with state-of-the-art deep reinforcement learning technologies to see if we can create profitable Bitcoin trading bots. It seems to be the status quo to quickly shut down any attempts to create reinforcement learning algorithms, as it is “the wrong way to go about building a trading algorithm”. However, recent advances in the field have shown that RL agents are often capable of learning much more than supervised learning agents within the same problem domain." <sup>2</sup><br />
<br />

1. https://www.coindesk.com/set-protocol-launches-momentum-trading-strategy<br /><br />
2: https://towardsdatascience.com/creating-bitcoin-trading-bots-that-dont-lose-money-2e7165fb0b29<br /><br />

data from: 07-04-2019<br />
source -https://www.cryptodatadownload.com/data/northamerican/`);

// Constant Time for other values added
quoteHash.add(this.key, this.val);

}   // end constructor

  getTitle() {
         return quoteHash.lookup(title);
}
 getTocTitle(){
    return quoteHash.lookup(tocTitle); 
}
  getToc(){
    return quoteHash.lookup(toc); 
} 

getOtherQuery(query) { 
    this.query = query;
    return quoteHash.lookup(this.query);
} 
}