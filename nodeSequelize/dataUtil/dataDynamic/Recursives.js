

export default class Recursives {
    targetSumInt = 10;
    numbers = [];
    memo = {}
    howSumMemo (targetSum, numbers, _memo = {} )   {
        if(targetSum===0) return [];
        if(targetSum < 0) return null;
    
        for (let num of numbers){
            const remainder = targetSum - num;
            const remainderResult = howSum(remainder, numbers, _memo);
            if(remainderResult  !== null) {
               memo[targetSum] = [...remainderResult, num];
               return memo[targetSum];
            }
        }
        return memo[targetSum]
        return null;
    }
    
    howSum (targetSum, numbers)   {
        if(targetSum===0) return [];
        if(targetSum < 0) return null;
    
        for (let num of numbers){
            const remainder = targetSum - num;
            const remainderResult = howSum(remainder, numbers);
            if(remainderResult  !== null) {
                return [...remainderResult, num];
            }
        }
        return null;
    }   
    
      towerOfHanoi (n, fromRod, toRod, auxRod){
          if (n==1){
              console.log("moving disk 1 from "+fromRod+"to the "toRod);
          } else{
        
            towerOfHanoi(n-1, fromRod, auxRod, toRod);
            console.log("moving the "+n+"th disk from " + fromRod +" to the " + toRod);
            towerOfHanoi(n-1, auxRod, toRod, fromRod);         
        }
    } 
}

 
let count = 0;

function getSubsequence(word) { 
if (word == '') { return ''; }
const first = word.charAt(0);
const rest = getSubsequence(word.substring(1));
let result = '';

rest.split(',').forEach( subseq => {
     count++;
   result += ','+ first + subseq; 
   result += ','+ subseq 
});

return result.substring(1);
} 
let resultt = getSubsequence('hello');
console.log (count, resultt);