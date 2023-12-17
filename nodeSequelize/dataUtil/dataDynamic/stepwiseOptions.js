export default class StepWiseOptions {

  constructor(steps, stepSize) {
         // if  N is undefined then '4'
    this.nSteps = steps || 4; 
        //  // i.e., can go 1 or 2 or 3  ... K ways  -> '3' if KstepSize undefined
    this.kStepSize = stepSize || 3;
         //Global Array  for singleton
    this.arrayGlobal = new Array(this.nSteps + 1).fill(-1); 
  }

  //Recursive  BAD!!  --> n2 !!
  waysBadRecursive(n, k) {
    if (n < 0)  return 0; 
    if (n == 0)  return 1;  

    let result = 0;
    for (let j = 1; j <= k; j++) {
      result += this.waysBadRecursive(n - j, k);
    }
    return result;
  }

  //Dynamic   w memo
  waysMemoRecursive(n, k, arr) {
    var arr = new Array(n + 1);
    if (n < 0)     return 0;
    if (n == 0) {
      arr[n] = 1;   // memo this 
                 return 1;
    }   
    if (arr[n] !== -1)   return arr[n]; // base case 

    arr[n] = 0; 
    for (let i = 1; i <= k; i++) {
      arr[n] = arr[n] + this.waysMemoRecursive(n - i, k,  arr);
    }
    return arr[n];
  }

  /////////////
  // bottom up     ==>>>>>> Iterative
  waysIterBottomUp(n, k) {
    var arr = new Array(n + 1);
    arr[0] = 1;

    for (let i = 1; i <= n; i++) {
      arr[i] = 0;

      for (let j = 1; j <= k; j++) {
        if (i - j >= 0) arr[i] = arr[i] + arr[i - j];
      }
    }
    return arr[n];
  }
}
let s = new StepWiseOptions();
console.log(s.waysBadRecursive(10, 3));

console.log(s.waysMemoRecursive(10,3));

console.log(s.waysIterBottomUp(10,3));