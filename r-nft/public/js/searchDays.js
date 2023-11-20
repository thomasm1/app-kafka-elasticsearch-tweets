// console.log("%c Search Daily Bitcoin Profits: ", "color:blue; background:aliceblue; border:solid 1px blue")
////////////////////////////////////////////////////
// Binary Search
function binarySearch(array, val) {
    let found = null;
    let min = 0;
    let max = array.length;
    let middle = (max + min) / 2;
    for (let i = 0; i < array.length; i++) {
        if (array[i] < val) {
            max = middle;
        } else if (array[i] > val) {
            min = middle;
        } else if (array[i] === val) {
            found = val;
            console.log(`found it, profit ${found} is at index ${i} in array size: ${array.length}`);
            return found;
        } else {
            return console.log("not found!");
        }
    }
}


// Fetch Data
// Sort largest profit to smallest profit (negative)
let dailyProfit = [];
let dailyIntProfit = [];
let dailyProfitFull = [];
async function fetchSortedBitcoin2019() {

    const bitcoinPromise = await fetch(
        // "Coinbase_LTCUSD_2019.json"
        "https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json"
    );

    const bitcoin2019 = await bitcoinPromise.json();
    // console.log("Raw downloaded data ", bitcoin2019);
    for (let i = 0; i < bitcoin2019.length; i++) {
        dailyProfit[i] = bitcoin2019[i].Close - bitcoin2019[i].Open; // Day's gain/loss  
        dailyIntProfit[i] = Math.floor(dailyProfit[i]);
        dailyProfitFull.push(dailyIntProfit[i])
    }
    dailySorted = dailyProfitFull.sort((a, b) => a - b);
    dailyLargest = dailySorted.reverse();
    console.log("%c Calculations: Search Daily Bitcoin Profits: ", "color:yellow; background:black; border:solid 1px orange");
    console.log("Integer Profits sorted", dailyLargest)
    return dailyLargest
}
// fetchSortedBitcoin2019();

////////////////////////////////////////////////
// Async to make ordered array, and search it
const awaitSearch = async function() {
    // const update = await makeOrderedArr(orderedArray, 1000, 10);
    const update = await fetchSortedBitcoin2019();

    binarySearch(update, 145);
};
awaitSearch();

////////////////////////////////////////////////