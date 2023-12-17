import {NewsScraper, FinClass} from "../../app-proxy.js";
// im
export default  function  (num, multiplier){
    return num * multiplier;
}

export function listToString(list){
    return list.toString().replace(/,/g,'');
}

export function randomNumberBetween(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
  }
  
  export function sleep(duration) {
    return new Promise(resolve => {
      setTimeout(resolve, duration)
    })
  }
  
  export function memoize(cb) {
    const cache = new Map()
    return (...args) => {
      const key = JSON.stringify(args)
      if (cache.has(key)) return cache.get(key)
  
      const result = cb(...args)
      cache.set(key, result)
      return result
    }
  }

   
// quickData is private globablly available
let quickData;
export const newsScraper = new NewsScraper()
quickData = newsScraper.getAllArticles();
console.log(quickData);
console.log(quickData.tempArticles);

quickTData = newsScraper.getTargetArticles(1);
console.log(" quickTData.targetArticles: ", quickTData.targetArticles);
console.log(quickTData.targetArticles);
quickTData

export const dummyData = getCoinsData()
getCalData()
nations = {}


const finObj = new  FinClass(nations)
const input  = finObj.getFinVars(nations)
console.log(finobj)
console.log(input)




