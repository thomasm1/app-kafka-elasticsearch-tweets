console.log("%c Binary Search: ", "color:black; background:aliceblue; border:solid 1px black")

////////////////////////////////////////////////////
// Binary Search
function binarySearch(array, val) {
    let found = null;
    let min = 0;
    let max = array.length;
    let middle = (max + min) / 2;
    for (let i = 0; i < array.length; i++) {
        if (array[i] < val) {
            max = middle;
        } else if (array[i] > val) {
            min = middle;
        } else if (array[i] === val) {
            found = val;
            console.log(`found it, ${found} is at index ${i} in array size: ${array.length}`);
            return found;
        } else {
            return console.log("not found!");
        }
    }
}
////////////////////////////////////////////////
// Make Unorderd Array, 
function makeUnorderedArr(arr, desiredLen) {
    arr = arr || [1, 2, 3]
    desiredLen = desiredLen || 100;
    const nwArray = arr;

    for (let i = 0; i < desiredLen; i++) {
        let randomDigit = Math.floor(desiredLen * Math.random());
        nwArray.push(randomDigit);
    }
    console.log(`Made random Array of  length: ${desiredLen}  ..starting with ${nwArray[0]}`)
    return nwArray;
}
////////////////////////////////////////////////
// Make Ordered Array
function makeOrderedArr(arr, desiredLen, start) {
    const nwArray = arr;
    for (let i = start; i <= desiredLen; i++) {
        nwArray.push(i);
    }
    console.log(`Made Ordered Array length: ${nwArray.length} ..starting with ${start}`)
    return nwArray;
}

////////////////////////////////////////////////
// Async to make ordered array, and search it
const asyncSearch = async function() {
    const orderedArray = [];
    const update = await makeOrderedArr(orderedArray, 1000, 10);
    console.log('Async Call makeOrderedArr() & binarySearch()')

    binarySearch(update, 777);
};
asyncSearch();

////////////////////////////////////////////////
// Manual provide array, and search it
const order = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22];
binarySearch(order, 18);

const unorderedArray = [];
//parameters = (arr, desiredLen)
makeUnorderedArr(unorderedArray, 1000);

const orderedArray = [];
//parameters = (arr, desiredLen, start)
makeOrderedArr(orderedArray, 1000, 1);