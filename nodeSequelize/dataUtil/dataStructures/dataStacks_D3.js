// d3 STACKS
//console.log("%c D3 STACKS BEGIN: ", "color:white; background-color:green");

document.getElementById("appStacks").innerHTML = ` 
 
<div class="appStack">
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
let a = 10,
  o = 25; //,  e = 15, i = 20, u = 30
let r = 70,
  t = 75;

let data = [r, o, t, a, t, o, r];

function render(data) {
  var bars = d3
    .select(".appStack")
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
      return d;
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
  data.unshift(Math.round(Math.random() * 100));
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
