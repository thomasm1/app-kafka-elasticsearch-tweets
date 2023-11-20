
// const jsdom = require("jsdom");
// const { JSDOM } = jsdom;
// const fetch = require('isomorphic-fetch')

// (async () => {
//     const response = await fetch('https://www.coindesk.com/price/bitcoin');
//     const text = await response.text();
//     console.log(text.match(/(?<=\<article>).*(?=\<\/article>)/));
//   })()
// (async () => {
//     const response = await fetch('https://www.coindesk.com/price/bitcoin');
//     const text = await response.text();
//     const dom = await new JSDOM(text);
//     console.log(dom.window.document.querySelector("article").textContent);
//   })()
 
async function scraper()   {
    const resText = await fetch('https://www.coindesk.com/price/bitcoin', {
        mode: 'no-cors'  
      });
    const text = await resText.text();
    const textOutput = text.match(/(?<=\<span class="currency-price>).*(?=\<\/span>)/);
    console.log("%c Data Scrapers", "border:solid 1px orange;color:brown;");
    console.log(textOutput);
    document.getElementById("scraperBtc").innerHTML =
      `<strong>API Scraper (regExp):</strong><br />${textOutput}`;
  };
// scraper();

async function scraper2()   { 
    const resDom = await fetch('https://www.cryptodatadownload.com/data/northamerican', {
        mode: 'no-cors'  
      });
    const textDom = await resDom.text();
    const dom = await new JSDOM(textDom);
    const domOutput = dom.window.document.querySelector("article").textContent; 
    console.log(domOutput);
    document.getElementById("scraperEth").innerHTML =
      `<strong>API Scraper (jsDom):</strong><br />${domOutput}`;
  };
// scraper2(); 