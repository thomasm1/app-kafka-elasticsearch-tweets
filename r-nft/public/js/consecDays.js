
console.log("%c Calculations: 7-day Profits", "color:orange; background:black; border:solid 1px orange")
/* O(n) */
function bestBitcoinWeek(arr, num) {
    
    let maxSum = 0;
    let tempSum = 0;
    if (arr.length < num) return null;
    for (let i = 0; i < num; i++) { // get up to first subWindow
        maxSum += arr[i];
    }
    tempSum = maxSum;
    for (let i = num; i < arr.length; i++) {
        tempSum = tempSum - arr[i - num] + arr[i]; // moving window
        maxSum = Math.max(maxSum, tempSum);
    } 
    console.log("Best 7-day, total profit: " +  maxSum)

    maxSum /= 7; // average week's sum profit to a daily average
    console.log("Best 7-day, daily avg profit: " +  maxSum)

    return maxSum
}

// Best Bitcoin Week  
let dailyNet = [];
let dailyNetFull = [];
async function fetchBitcoin2019() {

    const bitcoinPromise = await fetch(
        // "Coinbase_LTCUSD_2019.json"
        "https://tmm-nov.s3.amazonaws.com/data/coins/BTCUSD_2019.json"
        );
    
    const bitcoin2019  = await bitcoinPromise.json();
    console.log("Raw downloaded data ", bitcoin2019);
    for (let i = 0; i < bitcoin2019.length; i++) {
        dailyNet[i] = bitcoin2019[i].Close - bitcoin2019[i].Open; // Day's gain/loss 
        dailyNetFull.push(dailyNet[i]) 

        dailyNet[i] = (dailyNet[i] <= 0) ? 0 : dailyNet[i]; // negative days kept in array, as "0"... 
        dailyNet.push(dailyNet[i])
    }
    console.log("Array treating neg days as 0", dailyNet)

    console.log("**Includes negative values")  
    bestBitcoinWeek(dailyNetFull, 7)
    console.log("**Treats neg days as 0: ");  
    bestBitcoinWeek(dailyNet, 7);  

    return dailyNetFull 
} 
fetchBitcoin2019();

//  console.log("[outside fx]-ready for calcs...days net gain/loss: ", dailyNet);
 
// async function asyncCalc(array) {

//     const arr = await array;
//     bestBitcoinWeek(arr, 7); 
// }
// asyncCalc(dailyNet);


// /* O(n) */
// function maxSubarraySum(arr, num) {
//     let maxSum = 0;
//     let tempSum = 0;
//     if (arr.length < num) return null;
//     for (let i = 0; i < num; i++) { // get up to first subWindow
//         maxSum += arr[i];
//     }
//     tempSum = maxSum;
//     for (let i = num; i < arr.length; i++) {
//         tempSum = tempSum - arr[i - num] + arr[i]; // moving window
//         maxSum = Math.max(maSum, tempSum);
//     }

// }


// /* O(n^2) */
// function maxSubarraySumNaive(arr, num) {
//     if (num > arr.length) {
//         return null;
//     }
//     var max = -Infinity;
//     for (let i = 0; i < arr.length - num + 1; i++) {
//         temp = 0;
//         for (let j = 0; j < num; j++) {
//             temp += arr[i + j];
//         }
//         if (temp > max) {
//             max = temp;
//         }
//     }
//     return max;
// }

// var t1 = performance.now();
// maxSubarraySumNaive([2, 6, 9, 2, 1, 8, 5, 6, 3], 3)
// var t2 = performance.now();
// console.log(`NaiveTime: ${(t2 - t1) / 1000} seconds.`);

// var t1 = performance.now();
// maxSubarraySum([2, 6, 9, 2, 1, 8, 5, 6, 3], 3)
// var t2 = performance.now();
// console.log(`FastTime: ${(t2 - t1) / 1000} seconds.`); 
