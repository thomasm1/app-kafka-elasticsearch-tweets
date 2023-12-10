 
//Top Vars Above
// id:'2',
// did:'21-05-18',
// date:'May 18, 2021',
// author:'by Thomas Maestas, MA',
// cat3:'Musing Blockchain',
// title:'ETH v. BTC v. ADA, Part I: Ethereum\'s Law of Large Numbers',
// arrPosts = blogObject.posts
// arrCites= blogObject.cites

export const loggerMarch22 = (arrPosts) => {
   let blogObject = {}
 for (let i = 0;i<arrPosts.length;i++ ) {

    let  post =  arrPosts[i];
    let cite = arrCites[i]
 }
     
 }

var blogpost1 =  ` 
<p>Doubtless, New Chain Lifecycle is 5% utility, 5% hype and 90% Decentralized App developers' community -- the ingredient <i>par excellence</i> for lasting hype and adoption. Here we have the exponential growth of Ethereum interest, let alone price of token. On the contrary we have Cardano Network, powered by Proof-of-Stake ADA token, which has yet to evolve past TestNet phase, a point of paralysis for Cardano chain DAPP development. One last step before final main net launch, and finally, we can witness David face Goliath...</p>

<p class="quote"><i>This year, we are seeing the direct competitors clashing. Ethereum has made great strides to make it scalable and affordable, with the Berlin fork already finalized and London hard fork scheduled for July.
In the meantime, Cardano smart contracts should be entering the Cardano testnet by the end of this month.</i><sup>1</sup> 
</p>
<p>Better late than never, the Cardano blockchain ecosystem boasts superior, more efficient, sophisticated smart contracting:</p>
<p class="quote">Cardano (ADA) is a highly anticipated direct competitor to Ethereum, promising more scalability and smart contracts with the Alonzo upgrade.</p>
<p>There are two obstinate problems:<i>Ethereum's monopolistic and universal DAPP evolution and ADA's stunted community development.</i></p>
<p>First, All customized business applications, whether off-chain or on-, have built architectures depending on private/consortium blockchains that periodically sync with Ethereum mainnet. </p><p>Secondly, whether or not Cardono does launch main net, the multi-year delay in even <i>launching</i>chain mainnet --for all its bells and whistles -- has stunted new development and developer solidarity. Despite the author's praise for ADA, he concedes the infinitesimally small likelihood that Cardano developers will ever approach Ethereum network --</p> 
<p class="quote">Lastly, despite getting up to 7th rank, Cardano (ADA) is not likely to catch up with Ethereum’s much larger dev pool and network effect.<sup>1</sup></p>
<p>And so, beyond Ethereum 2's Proof-of-Stake transition on the near horizon, ethereum enjoys a burgeoning ecosystem of layer-2 sidechains, facilitated by the likes of those as Polygon (Matic) solutions. Even so, next to Polkadot ecosystem, only Cardano stands as a viable challenge, how ever miniscule it may be...</p>
<p class="quote">
*Ethereum holds (by far) the largest pool of developers, according to Electric Capital. As a number of open source dev ops tools are available to make remote work easier through collaboration, managing developers remains a serious cog in DeFi development. Yet Ethereum and its developer community have thus far been dominant in this sense.<br /><br />
*In the last three years, Ethereum has widened its developer pool by 215%. Such a network effect would be exceedingly difficult to overcome.</i><sup>2</sup> 
</p></p>
`
var blogcite1 = 
` 
<p class="footnotes">1. <a href="https://finance.yahoo.com/news/cardano-prepares-launch-alonzo-testnet-130000976.html?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAAKH0bKJvZsFbQBykBexupKV-HvvhwSDQjmlBmyM4Q69AaNPYvc4Tk8LSJIyBqekdp0PAPL7kz0hTgJFEwOB3jchU4gzkApL6bQay9JZ2z16ddSW5RsCYEp049RRj-L_zFhrhze_83BrLCQjxz_-oOvLEbc8l3X_T4KdO8-eQf6cz"   target="_blank">cardano-prepares-launch-alonzo-testnet</a>
</p>   
<p class="footnotes">2. <a href="https://www.benzinga.com/node/21184597"   target="_blank">Is the Bitcoin-Ethereum 'Flippening' a Likely Scenario?</a>
</p>
`; 
   
  let url =  [
     
 
     { 
      id:'2',
      did:'21-05-18',
      date:'May 18, 2021',
      author:'by Thomas Maestas, MA',
      cat3:'Musing Blockchain',
      title:'ETH v. BTC v. ADA, Part I: Ethereum\'s Law of Large Numbers',
      post:blogpost2,
     blogcite:blogcite2
     },
    { 
    id:'1',
    did:'21-05-17',
    date:'May 17, 2021',
    author:'by Thomas Maestas, MA',
    cat3:'Web Dev Affairs',
    title:'ETH v. BTC v. ADA, Part I: Varying levels of DAPP Community-Building ',
    post:blogpost1,
   blogcite:blogcite1
   }
   ] ;

   for (i=0;i<url.length;i++){ 
    let cat = ` 
    <div id="${url[i].did}" class="blogDiv"> 
    <hr />  
    <a href="#top"><button>Top</button></a>  
    <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>  
    <h5 id="cat3" class="  subdailytech">${url[i].cat3}</h5> 
    <p id="author" class="  author">${url[i].author}</p>   
    <h6  id="date" class="  chapternumber">${url[i].date}</h6>    
    <h6  id="title"   class="dailytitle chapternumber">${url[i].title}</h6>
    <div id="post">${url[i].post}
    </div>
    <div id="blogcite">${url[i].blogcite}
    </div>` ;
document.getElementById("paragraph-may21").innerHTML += cat; 
} 
 
let i;
for (i=0;i<url.length;i++){ 
  let catMod = `
  <div id="${url[i].did}_mod" class="blogDivMod"> 
  <hr />  
  <a href="#top-mod"><button>Top</button></a>   
  <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>  
  <h5 id="cat3" class="  subdailytech">${url[i].cat3}</h5>  
  <p id="author" class="  author">${url[i].author}</p>   
  <h6  id="date" class="  chapternumber">${url[i].date}</h6>    
  <h6  id="title"   class="dailytitle chapternumber">${url[i].title}</h6>
  <br />
  <div id="post">${url[i].post}</div>
  </div>
 <div id="blogcite">${url[i].blogcite}
 </div>`;
document.getElementById("paragraph-mod-may21").innerHTML += catMod;
}

}; 

const first =`We used to occasionally have black swan events,” says Richard Wilding, 
professor of supply chain strategy at Cranfield University in the UK, referring to rare and hard-to-predict 
occurrences that have major impacts. ​“The problem at the moment is we have a whole flock of black swans coming 
at us.” Wilding says managing a supply chain used to involve 80 percent dealing with predictability and 20 percent coping with surprises, numbers that have now flipped. And he says a growing number of companies are now using tools that provide greater visibility into the flow of goods, and which can sometimes predict potential choke points. “You effectively need to have continual monitoring,” he says. In an age when everything is connected, the global supply chain—a mess of transportation routes connecting 
commodities to manufacturers to buyers—has until recently remained alarmingly analog. That was manageable in the before-times,
 but the age of constant supply chain disruption is sending companies scrambling for more data."`

 const cite = ` <p class="footnotes">1. <a href="https://www.benzinga.com/node/21184597"   target="_blank">Is the Bitcoin-Ethereum 'Flippening' a Likely Scenario?</a>  </p>   `
const html = `<p class="firstparagraph">${first}</p>`   
let firstArr = [];
firstCite = [] 
firstArr.push(html)
firstCite.push(cite)
console.log('blogger-may21'); 
console.log(angular.toJson(url));

bloggerMay21();  



   