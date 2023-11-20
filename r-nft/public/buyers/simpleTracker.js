/* VERSION ONE */
function CoinTracker(arr) { 
  
  var max_profit = -1;
  var buy_price = 0;
  var sell_price = 0;
  
  var change_buy_index = true;   //  iterating the buying price until a cheap coin price is found
   
  for (var i = 0; i < arr.length-1; i++) {  // loop through list of coin prices once
   
    sell_price = arr[i+1];   // selling price the next element in list
     
    if (change_buy_index) { buy_price = arr[i]; }    // if no suitable cheap buying price, set buying price equal to the current element 

    if (sell_price < buy_price) {    // if the selling price is less than the buying price  cannot make a profit so  ontinue to the   next element in the list which will be the new buying price
      change_buy_index = true; 
      continue;
    }
    
   
    else {  // if the selling price is greater than the buying price check to see if these two indices give us a better  profit then current one
      var temp_profit = sell_price - buy_price;
      if (temp_profit > max_profit) { max_profit = temp_profit; }
      change_buy_index = false;
    }
    
  }
  
  return max_profit;
         
}

CoinTracker([44, 30, 24, 32, 35, 30, 40, 38, 15]);  

/* VERSION TWO */
// takes every value a turns it into the profit one would make if he bought the coins that day and sold them on the most expensive day left.
function maxProfit(array) {
	
  var profitArray = array.map(function(currentValue, index) {
    return array.slice(index, array.length)
          .sort(function(a, b){return b-a})[0] - currentValue		
  })
  
  return profitArray.sort(function(a, b){return b-a})[0];

}
 
console.log(maxProfit([45, 24, 35, 31, 40, 38, 11]));

/* version 3 */ 
// shortest: 
function CoinPicker(arr) {
	let trueMax = 0;
	arr.reduce(function(prev, item){
		let max = Math.max(item - prev, 0);
		
		max > trueMax ? trueMax = max : null;
		
		if (max === 0) {
			return item;
		} else {
			return prev;
		}
	});
	
	if (trueMax === 0) {
		return -1;
	}
	return trueMax;
}