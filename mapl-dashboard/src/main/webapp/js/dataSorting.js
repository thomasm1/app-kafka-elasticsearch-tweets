// SORTING
console.log("%c SORTING: ", "color:black; background-color:yellow;border:solid 1px black");

// Best asymptotic run-time complexity:
//        O(n):  Heap, Insertion  
// average case best:
//        O(nlogn):   Merge Sort, Quick Sort, Heap Sort. 
// The worst case best:
//        O(nlogn):   Merge Sort and Heap Sort.
 

// SELECTION -- O(n^2)
// pretty lousy performance, but ... can be good at checking if everything is already sorted. 
// -- also good to use when memory space is limited. 
/* current item moves through the array and decides if the it’s smaller than the current minimum. If it is, the current item gets the new marker as the new current minimum.... right until the end of the array and the marked smallest item will get swapped with the value on the left-hand side. This value becomes partitioned.  and again ... */
function selectionSort(arr) {
    const swap = (arr, idx1, idx2) =>
        ([arr[idx1], arr[idx2]] = [arr[idx2], arr[idx1]]);

    for (let i = 0; i < arr.length; i++) {
        let currentMin = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[currentMin] > arr[j]) {
                currentMin = j;
            }
        }
        if (i !== currentMin) swap(arr, i, currentMin);
    }

    return arr;
}
// ALTERNATE SELECTION SORT
function selectionSort2(arr){
let arrSize = arr.length;
    let currentMin;
for (i=0; i < arrSize; i++){
//set minimum to this position
        currentMin = i;
//check the rest of the array to see if anything is smaller
        for (j=i+1; j < arrSize; j++){
            if (arr[j] < arr[currentMin]){
                currentMin = j;
            }
        }
//if the minimum isn't in the position, swap it
        if (i != currentMin){
               var temp = yourArray[i];
                yourArray[i] = yourArray[currentMin];
                yourArray[currentMin] = temp;
        }
    }
return arr;
}


let arraySelectionSort = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17]
console.log('Unsorted: '+ arraySelectionSort);

newSelectionSort = selectionSort(arraySelectionSort);
console.log('Selection Sort: '+ newSelectionSort);
newSelectionSort2 = selectionSort2(arraySelectionSort);
console.log('Selection Sort 2: '+ newSelectionSort2);
 

// INSERTION
function insertionSort(arr){
	var currentVal;
    for(var i = 1; i < arr.length; i++){
        currentVal = arr[i];
        for(var j = i - 1; j >= 0 && arr[j] > currentVal; j--) {
            arr[j+1] = arr[j]
        }
        arr[j+1] = currentVal;
    }
    return arr;
}

let arrayInsertionSort = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17]
console.log('Unsorted: '+ arrayInsertionSort)
newInsertionSort = insertionSort(arrayInsertionSort) 
console.log('Insertion Sort: '+ newInsertionSort);


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
function bubbleSort(arr) {
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
 
let arrayUnsorted  = [0, 2, 34, 22, 2, 1, 9, 76, 4, 10, 19, 17]
console.log('Unsorted: '+ arrayUnsorted)
newBubbleSort = bubbleSort(arrayUnsorted) 
console.log('Bubble Sort: '+ newBubbleSort);



// BUBBLE SORT (OPTIMIZED) with noSwaps
function bubbleSortOptimize(arr){
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
newBubbleSort = bubbleSortOptimize(arrayUnsorted2) 
console.log('Bubble Sort (Optimized): '+ newBubbleSort);
