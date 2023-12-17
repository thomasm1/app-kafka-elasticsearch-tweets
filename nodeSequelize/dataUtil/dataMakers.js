
export default function arrayMaker(len) {
    var data = Array.apply(null, {length:len} ).map(Function.call, Math.random) 
    return data;
}
// when called direclty~
console.log(arrayMaker(5));
