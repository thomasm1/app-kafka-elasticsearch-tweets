// STACKS
console.log("%c STACKS BEGIN: ", "color:white; background-color:green")

let letters = [];
let word = "rotator";
let reverse = "";

for (let i = 0; i < word.length; i++) {
  letters.push(word[i]);
}
console.log(letters);
for (let i = 0; i < word.length; i++) {
  reverse += letters.pop(word[i]);
}
console.log(reverse);
if (reverse === word) {
  console.log(word, "is palindrome");
}
///

var Stack = function() {
  this.count = 0;
  this.storage = {};
  //
  this.push = function(value) {
    this.storage[this.count] = value;
    this.count++;
  };
  this.pop = function() {
    if (this.count === 0) {
      return undefined;
    }
    this.count--;
    var result = this.storage[this.count];
    delete this.storage[this.count];
    return result;
  };
  this.size = function() {
    return this.count;
  };
  this.peek = function() {
    return this.storage[this.count - 1];
  };
};

var myStack = new Stack();
const implementStack = function(stack) {
  myStack.push(1);
  myStack.push(2);
  console.log("%c push(1),push(2)peek,pop,peek", "color:red");
  console.log(myStack.peek(), myStack.pop(), myStack.peek());
  myStack.push("item");
  console.log("%c ..push(item) peek,pop,peek", "color:blue");
  console.log(myStack.peek(), myStack.pop(), myStack.peek());
};

implementStack(myStack);
