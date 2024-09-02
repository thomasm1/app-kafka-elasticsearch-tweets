(vertiBars = function(id = "dataQueues") {
// d3 STACKS
//console.log("%c D3 STACKS BEGIN: ", "color:white; background-color:green");

document.getElementById(id).innerHTML = ` 
 
<div class="appQueue">
</div>  
`;
// let letters = [];
// let word = "rotator";
// let reverse = "";

// for (let i = 0; i < word.length; i++) {
//   letters.push(word[i]);
// }
// console.log(letters);
// for (let i = 0; i < word.length; i++) {
//   reverse += letters.pop(word[i]);
// }
// console.log(reverse);
// if (reverse === word) {
//   console.log(word, "is palindrome");
// }

// ///
// var Stack = function() {
//   this.count = 0;
//   this.storage = {};
//   //
//   this.push = function(value) {
//     this.storage[this.count] = value;
//     this.count++;
//   };
//   this.pop = function() {
//     if (this.count === 0) {
//       return undefined;
//     }
//     this.count--;
//     var result = this.storage[this.count];
//     delete this.storage[this.count];
//     return result;
//   };
//   this.size = function() {
//     return this.count;
//   };
//   this.peek = function() {
//     return this.storage[this.count - 1];
//   };
// };

// TODO replace demo with observables subscription <====
let ETH = 20.53,
  BTC = 25.44; //,  e = 15, i = 20, u = 30
let XRP = 70.65,
  LTC = 75.76,
  b = 45.92,
c= 46.07,
d=56.68,
e=22.82,
f=41.71,
g=223.53,
h=324.66,
i=23.34,
j=27.26,
k=22.44,
l=44.55,
m=233.11,
n=211.56,
o=111.33,
p=234.22;
let data = [ETH, BTC, XRP, LTC,ETH, BTC,XRP,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p];

function render(data) {
  var bars = d3
    .select(".appQueue")
    .selectAll("div.h-bar")
    .data(data); //UPDATE data

  bars // ENTER data
    .enter()
    .append("div")
    .attr("class", "h-bar")
    .merge(bars) //Enter + Update data
    .style("width", function(d) {
      return d * 3 + "px";
    })
    .text(function(d) {
      return '$ '+ d;
    });

  bars
    .exit() // Exit
    .remove();
}

setInterval(function() {
  //data = data.length === 0 ? [r, o, t, a, t, o, r] : data;
  //   // for (let i = 0; i < data.length; i++) {
  //   data.push(Math.round(Math.random() * 100));
  //   // }
  data.unshift((50+ Math.random() * 100).toFixed(2));
  data.pop();
  render(data);
}, 1500);

render(data);

// render(data);
// var myStack = new Stack();
// const implementStack = function(stack) {
//   myStack.push(1);
//   myStack.push(2);
//   console.log("%c push(1),push(2)peek,pop,peek", "color:red");
//   console.log(myStack.peek(), myStack.pop(), myStack.peek());
//   myStack.push("item");
//   console.log("%c ..push(item) peek,pop,peek", "color:blue");
//   console.log(myStack.peek(), myStack.pop(), myStack.peek());
// };

// implementStack(myStack);

})();