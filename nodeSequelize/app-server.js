// import "dotenv/config"; // only CRYPTO_API_KEY here

import cors from 'cors';
import { getAllArticles, getTargetArticles } from "./NewsScraper.js";
import {FinClass} from "./FinClass.js"
import {BlogClass} from "./BlogClass.js" 
import express from "express";
 
(function() {
  
const app = express();
const PORT = process.env.PORT || 3001;

let newsObj = {};   

// app.use(cors({
//   origin: '*' 
// }));
const corsOptions = {
  origin: '*',
  optionsSuccessStatus: 200  
}
/// // Imported from app-proxy's UI inputs

////////////////////////////////////////////////
///////////// NEWS API ///////////////////////// 

// DataScraper to return json data on NEWS topics:
app.get("/cryptonews", (req, res) => {
  console.log("/cryptonews");
  newsObj = getAllArticles();

  // delete log when making unit tests
  console.log("/cryptonews using newsObj.tempArticles: ", newsObj.tempArticles);
  res.json(newsObj.tempArticles);
});
// Default is news
app.get("/", (req, res) => { 
  newsObj = getAllArticles();
  res.json(newsObj.tempArticles);
});

// TODO  ->  place calculations into app-proxy
app.get(`/cryptonews/:newsId`, (req, res) => {
  const newsId = req.params.newsId;

  // Pass in user's param (calculated by getTargetArticles)
  newsObj = getTargetArticles(newsId);
  // delete log after making unit tests
  console.log(" newsObj.targetArticles: ", newsObj.targetArticles);
  res.json(newsObj.targetArticles);
});

//////////////////////////////////////p/////////
///// FIN API //////////////////////////////////

const finClass = new FinClass(); // one singleton per session

// Data to return crypto resources     // META DATA BY NATION
app.get("/countries", (req, res) => {
  const finMeta = finClass.getMetaData("countries");
  console.log("RUNNING /countries finMeta: ", finMeta);

  res.json(finMeta);
});

app.get("/coins", (req, res) => {
  // COINS DATA
  const finCoins = finClass.getCoinsData();
  console.log(finCoins);
  // res.json(coins[0].screen_data[2].crypto_data)
  res.json(finCoins);
});

// Calendar
app.get("/calendar", (req, res) => {
  // CALENDAR/TIME
  const cal = finClass.getCalData();
  // let cal = response.data.screen_data.icoData.data
  // let cal = response.data.screen_data.icoData.categories
  res.json(cal);
}); 


//////////////////////////////////////p/////////
///// BLOG API //////////////////////////////////

  const blogClass = new BlogClass(); // one singleton per session 
  var blogPosts;
  var blogCat;

app.get("/blog", cors(corsOptions), (req, res) => {  
   blogPosts = blogPosts? blogPosts: blogClass.getBlogData();
  console.log(blogPosts); 
  res.json(blogPosts); 
});
 

app.get("/blog-categories", cors(corsOptions), (req, res) => {  
  blogCat = blogCat? blogCat: blogClass.getBlogCat();
 console.log(blogCat); 
 res.json(blogCat); 
});

/////////////////   Static index path / // will put REACT build There; 
app.use(express.static("public"));

app.listen(PORT, () => {
  setTimeout(() => {
    console.log(` ... serving on Port ${PORT}`);
  }, 2500);
});

})()