const arrayDelay = [
  {
    "Date": "2019-07-04",
    "Symbol": "BTCUSD",
    "Open": 11976.42,
    "High": 12064.26,
    "Low": 11820,
    "Close": 11909.55,
    "Volume BTC": 1237.57,
    "Volume USD": 14790355.69
  },
  {
    "Date": "2019-07-04",
    "Symbol": "ETHUSD",
    "Open": 301.79,
    "High": 304,
    "Low": 300.39,
    "Close": 301.5,
    "Volume ETH": 3825.69,
    "Volume USD": 1154988.12
  }
];
function afterTheDelay() {
  setTimeout(() => {
    let outputPromise = "";
    arrayDelay.forEach((arrayDelay, index) => {
      outputPromise += `<li>Date: ${arrayDelay.Date} Symbol:  ${arrayDelay.Symbol} Close: ${arrayDelay.Close}</li>`;
    });
    document.getElementById("promises").innerHTML = "<strong>Local Ether + Bitcoin:</strong><br />" + outputPromise;
  }, 2000);
}
//   /* "Vanilla" Promise Syntax */
// doSomething()
// .then(result => doSomethingElse(result))
// .then(newResult => doThirdThing(newResult))
// .then(finalResult => {
//   console.log(finalResult);
// })
// .catch(failureCallback);
 

function addPromise(price) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      arrayDelay.push(price);
      // const error = true;
      const error = false;  
    if (!error) {
      resolve();
    } else {
      

      reject(console.log("%c Promise Errorrr occured", "color:orange; border:solid 1px orange") );
    } 
    }, 2000);
  });
}
// Promise
addPromise({
  "Date": "2020-01-01",
  "Symbol": "coinPROMISEAdded",
  "Open": 13000.00,
  "High": 14000,
  "Low": 12000.00,
  "Close": 1350.00
})
  .then(afterTheDelay)
  .catch(err => console.log(err));

// Promise.all
const promise1 = Promise.resolve("Price 1");
const promise2 = 10;
const promise3 = new Promise((resolve, reject) =>
  setTimeout(resolve, 2000, "Timeout-2000ms")
);
const promise4 = fetch(
  "https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json"
).then(res => res.json());

Promise.all([promise1, promise2, promise3, promise4]).then(values =>
  console.log(values)
);
Promise.all([promise1, promise2, promise3, promise4]).then(
  values =>
    (document.getElementById("promiseAll").innerHTML =
      "<strong>API PromiseAll:</strong><br /> https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json<br />  Date: " + values[3][1].Date + ' Symbol:' + values[3][1].Symbol + ' Close: ' + values[3][1].Close)
);

// ASYNC - AWAIT
// (async () => {
//   try {
//     const result = await doSomething();
//     const newResult = await doSomethingElse(result);
//     const finalResult = await doThirdThing(newResult);
//     console.log(finalResult); 
//   } catch(err) {
//     console.log(err);
//   }
// })();  

async function initAsync() {
  await addPromise({
    "Date": "2020-01-02",
    "Symbol": "coinASYNCAdded",
    "Open": 13000.00,
    "High": 14000,
    "Low": 12000.00,
    "Close": 1350.00
  });
  afterTheDelay();
}
initAsync(); 
