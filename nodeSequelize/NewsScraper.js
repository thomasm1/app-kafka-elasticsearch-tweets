 
import axios from "axios";
import CheerioApi from "cheerio";

///////////////// Web Scraping VARS
// GLOBAL VARS     Crypto News
const newsObj = {};
// later make a singleton for these
newsObj.tempArticles = newsObj.tempArticles || [];
// collect from UI initial keyword to search
newsObj.tempKey = "Ethereum";
newsObj.tempKeyArray = ["Ethereum", "NFT", "Web3"];

// collect from UI initial websites to scrape
newsObj.tempSites = newsObj.tempSites || [
  // Go to these websites and scrape
  //for keyword
  {
    name: "cointelegraph",
    address: "https://cointelegraph.com/",
    baseUrl: "https://cointelegraph.com",
  },
  {
    name: "coindesk",
    address: "https://www.coindesk.com/tech/",
    baseUrl: "https://www.coindesk.com",
  },
]; 
newsObj.targetArticles = newsObj.targetArticles || [];

/// Methods for class
 

/**
 * 
 * [  description]
 * @param  {[type]} arg1 [description]
 * @param  {[type]} arg2 [description]
 * @return {[type]}      [description]
 */
var someFunction = function (arg1, arg2) {
	// 
};

 export function getAllArticles() {
  newsObj.tempSites.forEach((news) => {
    axios.get(news.address).then((response) => {
      const html = response.data;
      const $ = CheerioApi.load(html);

      $(`a:contains(${newsObj.tempKeyArray[0]})`, html).each(function () {
        const title = $(this).text();
        const url = $(this).find("a").attr("href");

        newsObj.tempArticles.push({
          title,
          url: news.baseUrl,
          source: news.name,
        });
      });
    });
  });
  return newsObj;
}

export function getTargetArticles(newsId) {
    const localVars = this.getFinVars("coinsList");

    newsId = newsId || "cointelegraph";
  const newsAddress = newsObj.tempSites.filter((news) => news.name == newsId)[0]
    .address;
  const newsBase = newsObj.tempSites.filter((news) => news.name == newsId)[0]
    .baseUrl;

  axios
    .get(newsAddress)
    .then((response) => {
      const html = response.data;
      const $ = CheerioApi.load(html);

      $('a:contains("Ethereum")', html).each(function () {
        const title = $(this).text();
        const url = $(this).attr("href");

        newsObj.targetArticles.push({
          title,
          url: newsBase + url,
          source: newsId,
        });
      });

      console.log("just got target", newsObj.targetArticles);
    })
    .catch((err) => console.log(err));

  return newsObj;
}
