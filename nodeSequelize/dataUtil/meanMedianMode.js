import fs from 'fs'; 

process.stdin.resume()
process.stdin.setEncoding('utf-8')

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
})

process.stdin.on('end', function() {
    inputString = inputString.split('\n')
    main();
})

function readLine() {
    return inputString[currentLine++];
}

function runningMedian(a) {
let newArr = newArr.push(a)
console.log(newArr)
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const aCount = parseInt(readLine().trim(), 10);
    let a = [];
    for (let i= 0; i <aCount; i++) {
        const aItem = parseInt(readLine().trim(), 10);
        a.push(aItem);
    }
    const result = runningMedian(a);
    ws.write(result.join('\n') + '\n');
    ws.end
} 