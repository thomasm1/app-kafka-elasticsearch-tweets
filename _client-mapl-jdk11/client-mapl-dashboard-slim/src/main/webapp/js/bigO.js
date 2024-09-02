
console.log("%c big O Performance Timers", "color:white; background:red; :solid 1px blue")

// AUXILIARY SPACE COMPLEXITY: memory allocateD to run alg (not including input space)
//  O(1) Constant   Primitive types (bool, num, undefined, null)
//  O(n) Linear   String types
//  O(n) Linear   Complex/Reference types (Array.length, Object.key.)

//  O(1) Space - number loop
function addingLoop(n) {
    let total = 0;
    for (let i = 1; i <= n; i++) {
      total += i;
    }
    return total;
  }
  
  // O(n) Space - array doubling
  function double(arr) {
    let newArr = [];
    for (let i = 0; i < arr.length; i++) {
      newArr.push(2 * arr[i]);
    }
    return newArr;
  }
  
  // TIME COMPLEXITY- runtime
  // O(1)       Constant=== (f(n = 1))
  // O(log n)   Almost like Constant Log4 or log100 === (f(Log(n))
  // O(n)       Linear=== (f(n) = n)
  // O(nlog n)
  // O(n^2)     Quadratic=== (f(n) = n2)
  
  //  O(1)
  function addUpFastTo(n) {
    return (n * (n + 1)) / 2;
  }
  var time1 = performance.now();
  addUpFastTo(100000000);
  var time2 = performance.now();
  console.log(`FastTime O(1): ${(time2 - time1) / 1000} seconds.`);
  
  ///  O(n)
  function addUpSlowTo(n) {
    let total = 0;
    for (let i = 1; i <= n; i++) {
      total += i;
    }
    return total;
  }
  var t1 = performance.now();
  addUpSlowTo(100000000);
  var t2 = performance.now();
  console.log(`SlowTime O(n): ${(t2 - t1) / 1000} seconds.`);
  
  /// Quad  O(n^2)
  var totali, totalj;
  function allPairsQuadraticTo(n) {
    for (var i = 0; i < n; i++) {
      totali += i;
      for (var j = 0; j < n; j++) {
        totalj += j;
      }
      return totalj;
    }
    return totali;
  }
  var tt11 = performance.now();
  allPairsQuadraticTo(1000);
  var tt22 = performance.now();
  console.log(`Quad O(n^2): ${((tt22 - tt11) / 1000).toPrecision(12)} seconds.`);
  
  //notQuad O(n)
  var totalii;
  function allPairsNotQuadraticTo(n) {
    for (var i = 0; i < n; i++) {
      totalii += i;
    }
    return totalii;
  }
  var tt1 = performance.now();
  allPairsNotQuadraticTo(1000);
  var tt2 = performance.now();
  console.log(`notQuad O(n): ${((tt2 - tt1) / 1000).toPrecision(12)} seconds.`);
  
  // LOGS:  Binary logarithm of a number is # of times you can divide by 2 before reaching <1.
  // log2(8) === 3  .... 8/2 = 4, 4/2 = 2, 2/2 = 1 === binary log is 3.
  // Log base2 of (value) equals exponent
  // Log base2 of 8 equals 3 .... 2(exp) = value
  // So, Log2 or Log4, or log100 === O(Log(n))
  //
  // searching algs often have logarithmic time complexity
  // sortings algs often involve logs
  // recursion often has logarithmic space complexity
  