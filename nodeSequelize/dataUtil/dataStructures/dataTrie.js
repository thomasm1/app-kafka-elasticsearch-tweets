// d3 TRIE - associative data structures
console.log("%c   TRIE BEGIN: ", "color:white; background-color:purple");

const trieDescription = `
Trie data structure
The word "Trie" is an excerpt from the word "retrieval". Trie is a sorted tree-based data-structure that stores the set of strings. It has the number of pointers equal to the number of characters of the alphabet in each node. It can search a word in the dictionary with the help of the word's prefix. For example, if we assume that all strings are formed from the letters 'a' to 'z' in the English alphabet, each trie node can have a maximum of 26 points.

Trie is also known as the digital tree or prefix tree. The position of a node in the Trie determines the key with which that node is connected.

Properties of the Trie for a set of the string:
The root node of the trie always represents the null node.
Each child of nodes is sorted alphabetically.
Each node can have a maximum of 26 children (A to Z).
Each node (except the root) can store one letter of the alphabet.
`

export function NodeTrie (key) {

  //iterative with links
  this.key = key || null;
  this.parent = null;
  // hash of children
  this.children = {};
  this.nodeEnd = false;

  // recursive
  this.keyMap = new Map();
  this.end = false;     //   this the leaf node 
  this.setEnd = function() {
    this.end = true;
  };
  this.isEnd = function() {
    return this.end;
  };

};

export default function DataTrie() {
  this.root = new NodeTrie(null);

// Iterative
  this.addIterative = function (input, node = this.root) {
    for(let i = 0;i<word.length;i++){
      if(!node.children[word[i]]){
        node.children[word[i]] = new DataTrie(word[i])  // iteratively hashing
        node.children[word[i]].parent = node;   // assign parent to child node
      }
      node = node.children[word[i]];
      if (i == word.length-1){
        node.nodeEnd = true;
      }
    }
  };

// Recursive
  this.add = function(input, node = this.root) {
    if (input.length == 0) { // If no input,use this.root for node
      node.setEnd();
      return;
    } else if (!node.keyMap.has(input[0])) { // input.len > 0, there are more letters, but NOT YET AT END OF WORD
      node.keyMap.set(input[0], new NodeTrie());// so start input[0] as first letter. 
      return this.add(input.substr(1), node.keyMap.get(input[0])); // every letter after the first letter, pass in NODE JUST CREATED (node with letter 'B's)
    } else {
      return this.add(input.substr(1), node.keyMap.get(input[0])); // (for another word of same letter 'B') every letter after first letter, onto EXISTING NODE
    }
  }; 
  
  this.isWord = function(word) {// checking if whole word in.. (doesn't check every word, only 1st letter )
    let node = this.root;
    while (word.length > 1) {
      if (!node.keyMap.has(word[0])) {
        return false;
      } else {
        node = node.keyMap.get(word[0]);
        word = word.substr(1);
      }
    }
    return node.keyMap.has(word) && node.keyMap.get(word).isEnd() ? true : false;
  };

  this.contains = function(word) { // check if contains a whole word
  let node = this.root;
    for(let i=0;i<word.length;i++){
      //check if char node exists in children
      if (node.children[word[i]]) {
        node = node.children[word[i]];
      } 
      // implied else clause  - doesn't exit, return false since not valid word
      return false;
    }
    return node.end;
}

  this.printIterative = function() { 
    let wordsPrimitive = [];    // Primitve Space Comp  --- TIme faster probably
    //  let wordsObject = new Array();   // Reference Space Comp  --- TIme
      let node = this.root;
      while(node!==null) {
        wordsPrimitive.unshift(node.key); // iteratively take away first char
        node = node.parent; // on up links to full word
      }
      return wordsPrimitive.join(''); 
    }  

  this.printRecursive = function() { // helper fx:array of every word and searches 
    let words = new Array();
   
    let search = function(node = this.root, string) {
      if (node.keyMap.size != 0) {
        for (let letter of node.keyMap.keys()) {

          search(node.keyMap.get(letter), string.concat(letter));
        }
        if (node.isEnd()) {
          words.push(string);
        }
      } else {
        string.length > 0 ? words.push(string) : undefined;
        return;
      }
    };
    search(this.root, new String());
    return words.length > 0 ? words : null;
  };
};
