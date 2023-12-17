export default class BinarySearchGroot {
  
     // Refactored Binary Version
binarySearch(arr, elem) {
    var start = 0;
    var end = arr.length - 1;
    var middle = Math.floor((start + end) / 2);
    while (arr[middle] !== elem && start <= end) {
        if (elem < arr[middle]) end = middle - 1;
        else start = middle + 1;
        middle = Math.floor((start + end) / 2);
    }
    return arr[middle] === elem ? middle : -1;
}
// data === integer
binarySearchNode(data) {
    let lilgroot = new BST;
    lilgroot.add(data);

}  

// Long Binary version 
  binaryLongSearch(arr, elem) {
    var start = 0;
    var end = arr.length - 1;
    var middle = Math.floor((start + end) / 2);
    while(arr[middle] !== elem && start <= end) {
        if(elem < arr[middle]){
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        middle = Math.floor((start + end) / 2);
    }
    if(arr[middle] === elem){
        return middle;
    }
    return -1;
} 

// Linear Search  
linearSearch(arr, val){
    for(var i = 0; i < arr.length; i++){
        if(arr[i] === val) return i;
    }
    return -1;
}

demoLinear() {
    let arr = [34,51,1,2,3,45,56,687];
    let targ = 100;
    let result = linearSearch(arr, targ);
    console.log(`targ ${targ}, array ${arr} ... result!`);
}
 
}
