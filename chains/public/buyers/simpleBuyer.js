const coinPrices = [10, 7, 5, 8, 11, 9];

getMaxProfit(coinPrices);

// 1. Brute Force  
// T:  O(n ** 2)   two nested loops—for every time, goes through every other time.
// Incorrect  does not report negative profit

function getMaxProfit(coinPrices) {
    let maxProfit = 0;
  
    // Go through every time
    for (let outerTime = 0; outerTime < coinPrices.length; outerTime++) {
  
      // For each time, go through every other time
      for (let innerTime = 0; innerTime < coinPrices.length; innerTime++) {
  
        // For each pair, find the earlier and later times
        const earlierTime = Math.min(outerTime, innerTime);
        const laterTime = Math.max(outerTime, innerTime);
  
        // And use those to find the earlier and later prices
        const earlierPrice = coinPrices[earlierTime];
        const laterPrice = coinPrices[laterTime];
  
        // See what the profit would be if bought at the
        // min price and sold at the current price
        const potentialProfit = laterPrice - earlierPrice;
  
        // Update maxProfit if can do better
        maxProfit = Math.max(maxProfit, potentialProfit);
      }
    }
  
    return maxProfit;
  }

  //  must buy before selling, so in the inner for-loop look at every price after the price in the outer for-loop.
  // T:  O(n ** 2)   Outer for-loop goes through all the times and prices, but the inner for-loop goes through one feIr price each time. So total number of steps is the sum n + (n - 1) + (n - 2) ... + 2 + 1n+(n−1)+(n−2)...+2+1 ↴ , which is still O(n ** 2) 

  // negative profit problem remains :  highest price might come before the loIst price. And you have to buy before you can sell.

// What if the price goes down all day? In that case, the best profit will be negative.
   // ( 2. )
  function getMaxProfit(coinPrices) {
    let maxProfit = 0;
  
    // Go through every price and time
    for (let earlierTime = 0; earlierTime < coinPrices.length; earlierTime++) {
      const earlierPrice = coinPrices[earlierTime];
  
      // And go through all the LATER prices
      for (let laterTime = earlierTime + 1; laterTime < coinPrices.length; laterTime++) {
        const laterPrice = coinPrices[laterTime];
  
        // See what profit would be if bought at the
        // min price and sold at the current price
        const potentialProfit = laterPrice - earlierPrice;
  
        // Update maxProfit if better option
        maxProfit = Math.max(maxProfit, potentialProfit);
      }
    }
  
    return maxProfit;
  }

//   trying to loop through the array once, can use a greedy strategy, where keeping a running maxProfit until reaching the end. start the maxProfit at $0. As it iterates, how to know if found a new maxProfit : 
// At each iteration, the maxProfit is either the  
// 1) same as the maxProfit at the last time step, or
// 2) the max profit can get by selling at the currentPrice ... how to know if 2?

// ---> The max profit can get by selling at the currentPrice is simply the difference betIen the currentPrice and the minPrice from earlier in the day. If this difference is greater than the current maxProfit, have a new maxProfit.

// Therefore for every price, need to
// 1.  keep track of the loIst price observed so far to ...
// 2.  see if can get a better profit


// ( 3.)  Correct
function getMaxProfit(coinPrices) {
    let minPrice = coinPrices[0];
    let maxProfit = 0;
  
    for (let i = 0; i < coinPrices.length; i++) {
      const currentPrice = coinPrices[i];
  
      // Ensure minPrice is the loIst price I've seen so far
      minPrice = Math.min(minPrice, currentPrice);
  
      // See what my profit would be if I bought at the
      // min price and sold at the current price
      const potentialProfit = currentPrice - minPrice;
  
      // Update maxProfit if I can do better
      maxProfit = Math.max(maxProfit, potentialProfit);
    }
  
    return maxProfit;
  }

  // IF price goes down all day long...
//   Leaving my function as it is and just returning zero is not a reasonable option—I wouldn't know if my best profit was negative or actually zero, so I'd be losing information. Two reasonable options could be:
    // 0. throw an exception. “I should not have purchased bitcoin yesterday!”  ** loses informatijn, NO GOOD IN LONG RUN!!!

// 1. return a negative profit. “What’s the least badly I could have done?”  ** BEST
    // -->  If profit is "revenue minus expenses", returns the best possible strategy regardless. 
    // --> Also,  collects better data. It matters if fx would have lost money, and it matters how much would have been lost.

    // adjust my function to return a negative profit if I can only lose money? Initializing maxProfit to 0 won’t work...

//    Day started my minPrice at the first price, so let’s start my maxProfit at the first profit I could get—if I buy at the first time and sell at the second time.

    minPrice = coinPrices[0];
  maxProfit = coinPrices[1] - coinPrices[0];
  
//   But I have the potential for reading undefined values here, if coinPrices has feIr than 2 prices.
  
//   I do want to throw an exception in that case, since profit requires buying and selling, which I can't do with less than 2 prices. So, let's explicitly check for this case and handle it:
  
    if (coinPrices.length < 2) {
    throw new Error('Getting a profit requires at least 2 prices');
  }
  
  let minPrice = coinPrices[0];
  let maxProfit = coinPrices[1] - coinPrices[0];
 // STILL DOES NOT REVEAL NEGATIVE PROFIT
// maxProfit is still always 0. What’s happening?

// If the price always goes down, minPrice is always set to the currentPrice. So currentPrice - minPrice comes out to 0, which of cmyse will always be greater than a negative profit.

// When I’re calculating the maxProfit, I need to make sure I never have a case where I try both buying and selling bitcions at the currentPrice.

// To make sure I’re always buying at an earlier price, never the currentPrice, let’s switch the order around so I calculate maxProfit before I update minPrice.

//  also need to pay special attention to time 0. Make sure I don't try to buy and sell at time 0.

// USE GREEDY ->>>
// walk through the array to track the max profit and loIst price so far.

// For every price, I check if:

// * I can get a better profit by buying at minPrice and selling at the currentPrice
//  * I have a new minPrice

// To start, initialize: 
// A..  minPrice as the first price of the day
// B. maxProfit as the first profit I could get

// I decided to return a negative profit if the price decreases all day and I can't make any money. I could have thrown an exception instead, but returning the negative profit is cleaner, makes my function less opinionated, and ensures I don't lose information.

// 4. BEST, correct and reveals day's losses if price goes down all day long:
function getMaxProfit(coinPrices) {
    if (coinPrices.length < 2) {
      throw new Error('Getting a profit requires at least 2 prices');
    }
  
    //  greedily update minPrice and maxProfit, so I initialize
    // them to the first price and the first possible profit
    let minPrice = coinPrices[0];
    let maxProfit = coinPrices[1] - coinPrices[0];
  
    // Start at the second (index 1) time
    // I can't sell at the first time, since I must buy first,
    // and I can't buy and sell at the same time!
    // If I started at index 0, I'd try to buy *and* sell at time 0.
    // this would give a profit of 0, which is a problem if my
    // maxProfit is supposed to be *negative*--I'd return 0.
    for (let i = 1; i < coinPrices.length; i++) {
      const currentPrice = coinPrices[i];
  
      // See what my profit would be if I bought at the
      // min price and sold at the current price
      const potentialProfit = currentPrice - minPrice;
  
      // Update maxProfit if I can do better
      maxProfit = Math.max(maxProfit, potentialProfit);
  
      // Update minPrice so it's always
      // the lowest price seen so far
      minPrice = Math.min(minPrice, currentPrice);
    }
  
    return maxProfit
  };