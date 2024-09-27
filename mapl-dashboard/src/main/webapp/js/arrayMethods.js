console.log("%c BITCOIN CALCS BEGIN: ", "color:white; background-color:black") 
// document.getElementById("app").innerHTML = ` 
// <div class="appTitle">
// </div>   
// `;
const btc2019 = [
  {
    Date: "2019-07-04",
    Symbol: "BTCUSD",
    Open: 11976.42,
    High: 12064.26,
    Low: 11820,
    Close: 11909.55,
    "Volume BTC": 1237.57,
    "Volume USD": 14790355.69
  },
  {
    Date: "2019-07-03",
    Symbol: "BTCUSD",
    Open: 10829.18,
    High: 12014.6,
    Low: 10829.18,
    Close: 11976.42,
    "Volume BTC": 36836.85,
    "Volume USD": 419076229.34
  },
  {
    Date: "2019-07-02",
    Symbol: "BTCUSD",
    Open: 10577.63,
    High: 10925,
    Low: 9651,
    Close: 10829.18,
    "Volume BTC": 41476.42,
    "Volume USD": 424791613.92
  },
  {
    Date: "2019-07-01",
    Symbol: "BTCUSD",
    Open: 10761.26,
    High: 11210.52,
    Low: 9953,
    Close: 10577.63,
    "Volume BTC": 37633.9,
    "Volume USD": 396857365.17
  }
];
 
const ethBtc = [
  {
    Date: "2019-07-04",
    Symbol: "BTCUSD",
    Open: 11976.42,
    High: 12064.26,
    Low: 11820,
    Close: 11909.55,
    "Volume BTC": 1237.57,
    "Volume USD": 14790355.69
  },
  {
    Date: "2019-07-03",
    Symbol: "BTCUSD",
    Open: 10829.18,
    High: 12014.6,
    Low: 10829.18,
    Close: 11976.42,
    "Volume BTC": 36836.85,
    "Volume USD": 419076229.34
  },
  {
    Date: "2019-07-02",
    Symbol: "BTCUSD",
    Open: 10577.63,
    High: 10925,
    Low: 9651,
    Close: 10829.18,
    "Volume BTC": 41476.42,
    "Volume USD": 424791613.92
  },
  {
    Date: "2019-07-01",
    Symbol: "BTCUSD",
    Open: 10761.26,
    High: 11210.52,
    Low: 9953,
    Close: 10577.63,
    "Volume BTC": 37633.9,
    "Volume USD": 396857365.17
  },
  {
    Date: "2019-07-04",
    Symbol: "ETHUSD",
    Open: 301.79,
    High: 304,
    Low: 300.39,
    Close: 301.5,
    "Volume ETH": 3825.69,
    "Volume USD": 1154988.12
  },
  {
    Date: "2019-07-03",
    Symbol: "ETHUSD",
    Open: 291.25,
    High: 303.83,
    Low: 289.61,
    Close: 301.79,
    "Volume ETH": 105691.96,
    "Volume USD": 31264397.55
  },
  {
    Date: "2019-07-02",
    Symbol: "ETHUSD",
    Open: 293.7,
    High: 296.24,
    Low: 270.42,
    Close: 291.25,
    "Volume ETH": 218010.42,
    "Volume USD": 61564550.93
  },
  {
    Date: "2019-07-01",
    Symbol: "ETHUSD",
    Open: 290.07,
    High: 301.32,
    Low: 278.65,
    Close: 293.7,
    "Volume ETH": 184436.14,
    "Volume USD": 53230192.12
  }
];
console.log("%c Object mapping: ", "color:orange; border:solid 1px orange")
//0-A.)
console.time("timer_Obj-A.");
for (const key in btc2019[0]) {
  console.log("btc2019[0][key]: ", btc2019[0][key]);
}
console.timeEnd("timer_Obj-A.");
//0-B.)
console.time("timer_Obj-B.");
for (const b of Object.values(btc2019[0])) {
  console.log("Object.values: ", b);
}
console.timeEnd("timer_Obj-B.");
//0-C.)
console.time("timer_Obj-C.");
const bObject = new Map(
  Object.entries({
    Date: "2019-07-02",
    Symbol: "BTCUSD",
    Open: 10577.63,
    High: 10925,
    Low: 9651,
    Close: 10829.18,
    "Volume BTC": 41476.42,
    "Volume USD": 424791613.92
  })
);
for (const b of bObject.values()) {
  console.log("Object.entries", b);
}
console.timeEnd("timer_Obj-C.");
//1.)
console.time("timer_i");
for (let i = 0; i < btc2019.length; i++) {
  console.log(btc2019[i].Symbol, btc2019[i].Date, btc2019[i].High);
}
console.timeEnd("timer_i");
//2.
console.time("timer_forOf");
for (const btc of btc2019) {
  console.log(btc.Symbol, btc.Date, btc.High);
}
console.timeEnd("timer_forOf");
//3. forEach
console.time("timer_forEach");

btc2019.forEach(function (btc) {
  console.log(btc.Symbol, btc.Date, btc.High);
});
console.timeEnd("timer_forEach");
  
 

//////// FILTER 
console.log("%c Filter, then addin conditional object/array (shortens new array): ", "color:orange; border:solid 1px orange");
const btc2019AddObj = btc2019.filter(btc => btc.Symbol === 'BTCUSD').map(btc => Object.assign({}, btc, { newSymbol: 'BTC' }));
console.log('btc2019 with new obj in array', btc2019AddObj);   /// SHORTENS ARRAY
console.log('btc2019 untouched ', btc2019);

const btc2019AddArr = btc2019.filter(btc => btc.Symbol === 'BTCUSD').map(btc => Object.assign({}, btc, { newSymbol: ['BTC','3d array'] }));
console.log('btc2019 with new obj in array', btc2019AddArr);    /// SHORTENS NEW ARRAY
console.log('btc2019 untouched ', btc2019);

console.log("%c Filtering out negative days: ", "color:orange; border:solid 1px orange")
// filter out negative days, calc
const avgPosOnly = btc2019
  .filter(btc => btc.Close - btc.Open >= 0)
  .map(btc => (btc.Close - btc.Open) / btc2019.length); ///calc each avg
console.log(avgPosOnly);
//
const canBuy = btc2019.filter(function (btc) {
  if (btc.Close <= 11000) {
    return true;
  }
});
console.log(canBuy);
print('FILTER' + canBuy);
//
const belowtenk = btc2019.filter((item) => { 
  return item.Close < 11000.0;
})
console.log(belowtenk);
print('FILTER' + `<br /><code>${JSON.stringify(belowtenk)}</code>`);


///////// MAP  
console.log("%c Array mapping: ", "color:orange; border:solid 1px orange")
// create object
const newBTC = new Map(
   Object.entries({ bitcoin: 'BTC',  ethereum: 'ETH', litecoin: 'LTC'})
);
for (const b of newBTC.values()) {
   console.log(b);
}
for (const b of newBTC.keys()) {
   console.log(b);
} 
 
// count ETH types in array
const ethBtc_mixed = ethBtc;
const eth_in_array = ethBtc_mixed.reduce((acc, cur) => {
     return acc + (cur.Symbol === 'ETHUSD' ? 1 : 0)
}, 0);
console.log(eth_in_array);

// take out, clean array (outlier anomalous data)
const ethBtc_mixed1 = ethBtc
const mislabled = ethBtc_mixed1.filter(e => e.Symbol === 'ETHUSD')
const ethBtc_correct = mislabled.map(e => e.Symbol = 'ETH')
console.log(mislabled) // cleaned full array
console.log(ethBtc_correct) // cleaned objects

// c vanilla sorting
const unsorted = ethBtc;
console.log("unsorted", unsorted) 
const sortedClose = unsorted.sort((a,b) => a.Close < b.Close); // ?
console.log("unsorted", unsorted) 
console.log("sortedClose", sortedClose) 
// sorted.splice(SortedClose.length/2) //  cut  array to length of median
// console.log(sorted)
 

//
    let canSell = [];
    for (let i = 0; i < btc2019.length; i++) {
      if (btc2019[i] >= btc2019[i - 1]) {
        canSell.push(btc2019[i]);
      }
    }
    console.log(canSell);

// map new arrays -> create array of btc volumes
const coinIntervals = ethBtc.map(
  coin => `${coin.Symbol} [O:${coin.Open}-C:${coin.Close}]`
);
console.log(coinIntervals);  print('MAP' + coinIntervals)
//
const coinSquareRoot = ethBtc.map(coin => Math.sqrt(coin.Close));
const coinSquare = ethBtc.map(coin => coin.Close * 2);
console.log(coinSquareRoot, coinSquare); print('MAP' + coinSquareRoot+' '+ coinSquare)
//
const coinSymbols = ethBtc.map(function (coin) {
  return coin.Symbol;
});
console.log(coinSymbols);  print('MAP' + coinSymbols)
//
print('MAP' + coinSymbols)
const btcName = btc2019.map((item) => {
  return `<br />${item.Symbol} : ${item.Close}`;
})
console.log(btcName); print('MAP' + btcName)


/////////// FIND - returns first it finds ..  
const btcFind = btc2019.find((item) => {
  return item.Date === '2019-07-04'
})
console.log(btcFind); print('FIND: ' + btcFind)

/////////// INDEXOF - returns index or -1  ==> use some()
const btcIndexOf = btc2019.includes(btc2019[0]) 
console.log(btcIndexOf); print('INDEXOF: ' + btcIndexOf)

/////////// INCLUDES - returns Boolean  ==> use some()
const btcIncludes = btc2019.includes(btc2019[0]) 
console.log(btcIncludes); print('INCLUDES: ' + btcIncludes)

/////////// SOME/EVERY - returns Boolean 
var boolSome = btc2019.some(  
    btc => { return btc.Symbol === 'EHUSD' }); 
console.log(boolSome);  print('SOME: ' + boolSome)

const btcSomeTrue = btc2019.some((item) => {
  return item.Close < 11000   })
console.log(btcSomeTrue); print('SOME: ' + btcSomeTrue)

/////////// forEACH  - DOES NOT RETURN ANYTHING
const btcForEach = btc2019.forEach((item) => {
  print('forEACH: ' + `${item.Symbol} : ${item.Close}`);
  console.log(`${item.Symbol} : ${item.Close}`);
})

/////////// REDUCE((accumulation, item) =>{}, startIndex)
// let closeAvg = 0, closeSum = 0;
// for (let i = 0; i < btc2019.length; i++) {
//   closeSum += btc2019[i].Close;
//   closeAvg = closeSum/btc2019.length;
// } 

// Add reduce accumulation object/array  **does not shorten array
console.log("%c reduce acc, then add object/array (does NOT shorten new array):: ", "color:orange; border:solid 1px orange");
const newReducedObject = btc2019
    .reduce((acc, btc) => {
      return btc.Symbol === 'BTCUSD'
        ? acc.concat(Object.assign({}, btc, { newSymbol: 'BTC' }))
        : acc.concat(Object.assign({}, btc, { newSymbol: 'Not BTC' }));
    }, [])            // does not shorten array
console.log('conditional btc2019',newReducedObject);
console.log('not touched btc2019',btc2019); 

// close  sum => close AVG
const closeSum = btc2019.reduce((total, btc) => total + btc.Close, 0);
const closeAvg = closeSum / btc2019.length;
console.log("sum: " + closeSum, "avg: " + closeAvg);
// reduce daily intervals
const closeIntTot = btc2019.reduce(
  (total, btc) => total + (btc.Close - btc.Open),
  0
); //  !!! fix absolutes logic
const closeIAvg = closeIntTot / btc2019.length;
console.log("sum: " + closeIntTot, "avg: " + closeIAvg);

const btcTotalReduce = btc2019.reduce((currentTotal, item) => {
  return Math.floor((item.Close + currentTotal) / btc2019.length);
}, 0)
console.log(btcTotalReduce);
print('REDUCE: ' + btcTotalReduce)

//////////// SORT  
// const sortedBtc = btc2019.sort(function(a, b) {
//   if (a.Close > b.Close) {
//     return 1;
//   } else {
//     return -1;
//   }
// }); 
console.log("%c Sorting (JavaScript library): ", "color:orange; border:solid 1px orange")
const sortedBtc = btc2019.sort((a, b) => (a.Open > b.Open ? 1 : -1));
const sortedB = btc2019.sort((a, b) => a.Open - b.Open);
console.log(sortedBtc, sortedB);


///////////// FILTER/MAP/SORT/REDUCE CALCULATION
console.log("%c Calc Avg, Sum each pos avg, reduce to total: ", "color:orange; border:solid 1px orange")
const avgPosLong = btc2019
  .filter(btc => btc.Close - btc.Open >= 0)
  .map(btc => (btc.Close - btc.Open) / btc2019.length) ///calc each avg
  .sort((a, b) => a - b)
  .reduce((a, b) => a + b, 0); // sum each pos avg, reduce to total
const avgPos = avgPosLong / btc2019.length;
console.log(avgPosLong, avgPos);
 


function print(val) {
  let el = document.createElement('p');
  el.innerHTML = val;
  // document.getElementById('output').appendChild(el)
}





