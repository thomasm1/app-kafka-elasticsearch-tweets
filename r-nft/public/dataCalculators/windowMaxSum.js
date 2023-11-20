/* O(n) */
function maxSubarraySum(arr, num) {
	let maxSum = 0;
	let tempSum = 0;
	if (arr.length < num) return null;
	for (let i= 0; i< num; i++) { // get up to first subWindow
		maxSum += arr[i];
	}
	tempSum = maxSum;
	for (let i = num; i < arr.length; i++) {
		tempSum = tempSum - arr[i-num] + arr[i]; // moving window
		maxSum = Math.max(maSum, tempSum);
	}
	
}


/* O(n^2) */
function maxSubarraySumNaive(arr, num) {
  if ( num > arr.length){
    return null;
  }
  var max = -Infinity;
  for (let i = 0; i < arr.length - num + 1; i ++){
    temp = 0;
    for (let j = 0; j < num; j++){
      temp += arr[i + j];
    }
    if (temp > max) {
      max = temp;
    }
  }
  return max;
}

var t1 = performance.now();
maxSubarraySumNaive([2,6,9,2,1,8,5,6,3],3)
var t2 = performance.now();
console.log(`NaiveTime: ${(t2 - t1) / 1000} seconds.`); 

var t1 = performance.now();
maxSubarraySum([2,6,9,2,1,8,5,6,3],3)
var t2 = performance.now();
console.log(`FastTime: ${(t2 - t1) / 1000} seconds.`); 
