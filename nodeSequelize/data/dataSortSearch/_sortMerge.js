// Merge Sort Variations
// functions:
// export function mergeSort(arr)
//export function merge(arr1, arr2) {

export function merge(arr1, arr2) {
  let results = [];
  let i = 0;
  let j = 0;
  while (i < arr1.length && j < arr2.length) {
    if (arr2[j] > arr1[i]) {
      results.push(arr1[i]);
      i++;
    } else {
      // ======== includes > & equality
      results.push(arr2[j]);
      j++;
    }
  }

  //     Any remainders from one or the other
  while (i < arr1.length) {
    results.push(arr1[i]);
    i++;
  }
  while (j < arr2.length) {
    results.push(arr2[j]);
    j++;
  }

  return results;
}
//console for node.js; not included in export
// console.log("merge: ",merge([1,10,50],[2,14,99,100]));

export function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }
  let half = Math.floor(arr.length / 2);
  let left = mergeSort(arr.slice(0, half));
  let right = mergeSort(arr.slice(half));
  console.log(merge(left, right));
  return merge(left, right);
}
console.log("mergeSort: ", mergeSort([10, 1, 24, 9, 76, 73, 72]));

//////////////////////////////////////////////////////////////////////////////
// const list = [11, 6, 3, 9, 14, 66, 21];

// export function mergeSortAlt(list, left, right) {
//   if (left < right) {
//     const midhalf = Math.floor(list.length / 2);

//     mergeSortAlt(list, left, midhalf);
//     mergeSortAlt(list, left + 1, right);

//     merge(list, left, midhalf, right);
//   }
// }

// export function mergeAlt(list, lefthalf, midhalf, righthalf) {
//   const n1 = midhalf - left + 1;
//   const n2 = right - midhalf;

//   const array1 = [];
//   const array2 = [];

//   for (let i = 0; i < n2; i++) {
//     array1[i] = list[left + i];
//   }
//   for (let i = 0; i < n2; i++) {
//     array2[i] = list[midhalf + 1 + i];
//   }

//   let i = 0,
//     j = 0,
//     k = left;

//   while (i < n1 && j < n2) {
//     if (array1[i] < rightArray[j]) {
//       list[k] = left[i];
//       i++;
//     } else {
//       list[k] = right[j];
//       j++;
//     }
//     k++;
//   }

//   while (i < n1) {
//     if (array1[i] < rightArray[j]) {
//       list[k] = left[i];
//       i++;
//     } else {
//       list[k] = right[j];
//       j++;
//     }
//     k++;
//   }
// }
