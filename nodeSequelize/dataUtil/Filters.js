
// class rFilters   methods: 

import { geoClipAntimeridian } from "d3-geo";
import {randomNumberBetween} from "./dynamic.js"
// export class NumFilters {
//   //   fibonacci(num); fibonacciMemo(num) fizBuzz(num);  
// class ArrayFilters methods:
//  hashMapper(array, target)

// class ObjectFilters methods:
//
 
export class NumFilters {
    constructor(){
        console.log("Iteration SundryFilters init"); 
    }


    factorial(num) {
        if (num < 2) return 1;
        
        return this.factorial(num-1 * n);
    }

    fibonacci(num) { 
            if (num <=0) {return 0};
            if (num ==1) {return 1};
            return this.fibonacci(num-2)+this.fibonacci(num-1);
 
    }
    fibonacciMemo(num, memo ={}){
        if (num in memo) {return memo[num]}
        if (num <=0) {return 0};
        if (num ==1) {return 1};

        memo[num] = this.fibonacciMemo(num-1,memo)+ this.fibonacciMemo(num-2,memo);
        return memo[num]
    }
    // fibonacciIteration(num) { 
    // }


    fizzBuzz(num) { 
 
        for (let i=1;i<=num;i++){

            if ((i % 3)===0) {console.log("fizz")};
            if ((i % 5)===0) {console.log("buzz");}
            console.log(i);
        }
    }

    findPrimes(num){
        let primes = [];
        for (let i=0;i<=num;i++){
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;
        for (let i = 2;i<=Math.sqrt(num);i++){
            for (let j = 2;i*j<=num;j++){
                primes[i*j] = false;                
            }
        }
        let resultArr = []; 
        for (let i=0;i<primes.length;i++){
            if (primes[i]===true){  resultArr.push(i)         }
        }
        return resultArr;
    }

    caeserCipher(str, num) {
        num = num % 26; 
        const strLowerCase = str.toLowerCase();
        const alphabet = 'abcdefghijklmnopqrstuvwxyz'.split('');
        let newStringResult = '';
        for (let i = 0; i<strLowerCase.length;i++){
            let currentLetter = strLowerCase[i]
            if(currentLetter === ' ') {
                strLowerCase += currentLetter;
                continue;
            }
        let currentIndex = alphabet.indexOf(currentLetter) // i === 0, A
        let newIndex = currentIndex + num;
        if(newIndex > 25) newIndex = 26-newIndex;
        if(newIndex<0) 26+newIndex;
        if (str[i]===str[i].toUpperCase()) {
            newStringResult += alphabet[newIndex].toUpperCase();
        } else {
            newStringResult += alphabet[newIndex];
        }
    }
    return newStringResult; 
    }


}
 
const numFilters = new NumFilters();
const testInt = 40      //
console.log("findPrimes: "+ numFilters.findPrimes(testInt));
// console.log(numFilters.fibonacci(testInt ));
console.log("fibonacciMemo: "+numFilters.fibonacciMemo(testInt )); 
// console.log(numFilters.iterFibonacci(testInt ));
numFilters.fizzBuzz(testInt);

console.log("caeserCipher", numFilters.caeserCipher('Thomas', 1));

////// ////// ////// ////// ////// ////// ////// ////// ////// ////// ////// ////// 
// class ArrayFilters methods:

export class ArrayFilters {
    
    constructor(){
        console.log("ArrayFilters init"); 
    }

    getSample(arr) {
        return array[randomNumberBetween(0, arr.length -1)]
    }

    pluck(array, key) {
        return array.map(element => element[key])
    }
    
    groupBy(array, key) {
        return array.reduce((group, element) => {
        const keyValue = element[key]
        return { ...group, [keyValue]: [...(group[keyValue] ?? []), element] }
        }, {})
    }
    
    inPlaceReverse(arr) {
            for (let i =0;i<arr.length/2;i++) {
                let temp = arr[i];
                arr[i] = arr[arr.length-1-i]; //swap first & last
                arr[arr.length - 1 - i] = temp;
            }
            return arr;
        } 
        
    hashArrayMapper(intArray, targetSum){
    let pairs =[];
    let hashArrayTable = [];

    for(let i = 0; i<intArray.length; i++){
        let current = intArray[i];
        let targetPart = targetSum - current;   // Calculations to get to target here
        
        if (hashArrayTable.indexOf(targetPart) !== -1){  // if not empty
            pairs.push([current, targetPart]);
        }
        hashArrayTable.push(current);
    }
    return pairs;
}

    meanMedianMode(arr){
        return {
            mean: this.getMean(arr),
            median:this.getMedian(arr),
            mode: this.getMode(arr)
        }
    }

    getMean(arr) {
        let sum = 0;
        arr.forEach(num => {
            sum += num;
        });
        let mean = sum/arr.length;
        return mean;
    }

    getMedian(arr) {
        arr.sort(function(a,b){ return a-b}); // Sort ascending
        let median;
        if (arr.length %2 !==0) { median =  Math.floor(arr.length/2)} // odds: round down middle elem
        else { 
            let firstMid = arr[(arr.length/2)-1]
            let secondMid = arr[(arr.length/2)]
            median = (firstMid+secondMid)/2;
        }
        return median
    }

    // Median without ordering
            getMedianOfMedians(arr, k, low, high) {
                const medianIndex = this.getApproxMedIndex(arr, low, high);
                const length = medianIndex - low + 1
                if(length == k) {
                    return arr [medianIndex];
                }
                if (length > k){
                    //left
                    return this.getMedianOfMedians (arr, k, low, medianIndex-1);
                } else {
                    //right
                    return this.getMedianOfMedians(arr, k-length, medianIndex +1, high)
                } 
            } 
            getApproxMedIndex(arr,low, high) {
                const pivot = this.partitionAndGet(arr,low, high);

                // right index for this pivot : Quick Sort 
                while(low < high) {
                    while(arr[low] < pivot)
                    low++;
                while(arr[high] > pivot)
                    high--;
                if(arr[low] == arr[high])
                    low++;
                else if(low < high) {
                    //swap
                    let temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
                }
            } 
            partitionAndGet(arr, low, high) { 
                // median of medians
                if(high - low + 1 <= 9) {
                    arr.sort((a,b) => a-b);
                    return arr[Math.ceil(arr.length/2)];
                }
                // chunking
                let temp = null;
                const mediansArray = [];
                let index = 0;

                while (high >= low) {
                    temp = []
                    const len = Math.min(5, high -low +1);

                    for (let i = 0; i < len && low <=high;i++){
                        temp[i] = arr[low];
                        low++;
                    }

                    temp.sort((a,b) => a-b);
                    mediansArray[index] = temp [Math.ceil(temp.length/2)];
                }
                // Median of medians
                return this.partitionAndGet(mediansArray, 0, mediansArray.length-1);
            }

    getMode(arr) {
        let modeObject = {};
        arr.forEach(num => {
            if(!modeObject[num]) {   modeObject[num] = 0; }
            modeObject[num]++;
        });
        let maxFrequency = 0;
        let modes = []
        for (let num in modeObject) {
            if(modeObject[num] > maxFrequency) {
                modes = [num];
                maxFrequency = modeObject[num];
            } else if (modeObject[num] === maxFrequency) {modes.push(num)}// if 2 modes
        }
        if (modes.length === Object.keys(modeObject).length) { modes = []; }
        return modes
    }
    maxProfit(arr) {
        let maxProfit = 0;
        let buyPrice = 0;
        let sellPrice = 0;
        let changeBuyPrice = true;

    for (let i = 0;i<arr.length;i++){
        if (changeBuyPrice) {      buyPrice = arr[i];   }
        sellPrice = arr[i+1];
        
        if(sellPrice < buyPrice) { 
            changeBuyPrice=true;
        } else {
            let tempProfit = sellPrice - buyPrice;
            if (tempProfit > maxProfit) { maxProfit = tempProfit; }
            changeBuyPrice = false;
            }
        }
        return maxProfit;
      }



    } 

let arrayFilters = new ArrayFilters(); 
   let orderedArray = [1,2,3,4,5]
   let nearlyOrderedArray = [1,2,3,4,5,4,6,1]
 let unorderedArray = [10, 18, 4, 5, 9, 6, 16, 12]
console.log(arrayFilters.inPlaceReverse(orderedArray))  

console.log(arrayFilters.hashArrayMapper([1,5,3,2,2],7));

console.log(arrayFilters.meanMedianMode(nearlyOrderedArray)) //mean 3.25, median 3.5, mode['1','4']
 let other = [9,10,23,10,23,9]
 console.log(arrayFilters.meanMedianMode(other)) // mean 14/median-10/mode:[]
console.log(arrayFilters.maxProfit(unorderedArray));
                                     
console.log(arrayFilters.getMedianOfMedians(unorderedArray, Math.ceil(unorderedArray.length/2) +1, 0, unorderedArray.length-1))


// class ObjectFilters methods:
//