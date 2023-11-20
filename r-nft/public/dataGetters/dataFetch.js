// (fetch - promise)
// fetch('http://example.com/movies.json')
//   .then(function(response) {
//     return response.json();
//   })
//   .then(function(myJson) {
//     console.log(JSON.stringify(myJson));
//   });

// (async () => {
//   const response = await fetch('https://jsonplaceholder.typicode.com/users');  
//   const data = await response.json();
//   console.log(JSON.stringify(json));
// })() 

// ASYNC - AWAIT - FETCH
async function fetchAsync() {

    const resBtc = await fetch(
        "https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json"
    );
    const resEth = await fetch(
        "https://tmm-nov.s3.amazonaws.com/data/coins/Coinbase_ETHUSD_2019.json"
    );

    const dataEth = await resEth.json();
    document.getElementById("fetchAsyncEther").innerHTML =
        "<strong>API ETH Fetched:</strong><br />https://tmm-nov.s3.amazonaws.com/data/coins/Coinbase_ETHUSD_2019.json<br /><br />Date:  " + dataEth[5].Date + ' Symbol:  ' + dataEth[5].Symbol + ' Close:  ' + dataEth[5].Close;
    // console.log("async fetched ..", dataEth); 
    // console.log("async fetched stringify ..", JSON.stringify(dataEth)); 

    const dataBtc = await resBtc.json();
    document.getElementById("fetchAsyncBtc").innerHTML =
        "<strong>API BTC Fetched:</strong><br />https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json<br /><br />Date:  " + dataBtc[0].Date + ' Symbol:  ' + dataBtc[0].Symbol + ' Close:  ' + dataBtc[0].Close;
    // console.log("async fetched ..", dataBtc); 

}
fetchAsync();