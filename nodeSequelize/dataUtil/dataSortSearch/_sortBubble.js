// SORTING

// Best asymptotic run-time complexity:
//        O(n):  Heap, Insertion  
// average case best:
//        O(nlogn):   Merge Sort, Quick Sort, Heap Sort. 
// The worst case best:
//        O(nlogn):   Merge Sort and Heap Sort.
  

// BUBBLE SORT (UNOPTIMIZED) 
// function bubbleSort(arr) {
//     for (var i = arr.length; i > 0; i--) {
//         for (var j = 0; j < i - 1; j++) {
//             console.log(arr, arr[j], arr[j + 1]);
//             if (arr[j] > arr[j + 1]) {
//                 var temp = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = temp;
//             }
//         }
//     }
//     return arr;
// } 
// ES2015  
export function  bubbleSort(arr) {
    const swap = (arr, idx1, idx2) => {
        [arr[idx1], arr[idx2]] = [arr[idx2], arr[idx1]];
    };

    for (let i = arr.length; i > 0; i--) {
        for (let j = 0; j < i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
    return arr;
}
console.log("%c SORTING: ", "color:black; background-color:yellow;border:solid 1px black");
 

let arrayUnsorted  = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17]
console.log('Unsorted: '+ arrayUnsorted)
let newBubbleSort = new bubbleSort(arrayUnsorted) 
console.log('Bubble Sort: '+ newBubbleSort);



// BUBBLE SORT (OPTIMIZED) with noSwaps
export function  bubbleSortOptimize(arr){
  var noSwaps;
  for(var i = arr.length; i > 0; i--){
    noSwaps = true;
    for(var j = 0; j < i - 1; j++){
      if(arr[j] > arr[j+1]){
        var temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
        noSwaps = false;         
      }
    }
    if(noSwaps) break;
  }
  return arr;
} 
let arrayUnsorted2  = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17]
console.log('Unsorted: '+ arrayUnsorted2)
let newBubbleSortOptimized = new bubbleSortOptimize(arrayUnsorted2) 
console.log('Bubble Sort (Optimized): '+ newBubbleSortOptimized);
