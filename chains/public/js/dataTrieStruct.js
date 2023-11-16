// d3 TRIE - associative data structures
console.log("%c   TRIE BEGIN: ", "color:white; background-color:purple");

let NodeTrie = function() {
  this.keys = new Map();
  this.end = false;
  this.setEnd = function() {
    this.end = true;
  };
  this.isEnd = function() {
    return this.end;
  };
};

let Trie = function() {
  this.root = new NodeTrie();
  this.add = function(input, node = this.root) {
    if (input.length == 0) { // If no input,use this.root for node
      node.setEnd();
      return;
    } else if (!node.keys.has(input[0])) { // input.len > 0, there are more letters, but NOT YET AT END OF WORD
      node.keys.set(input[0], new NodeTrie());// so start input[0] as first letter. 
      return this.add(input.substr(1), node.keys.get(input[0])); // every letter after the first letter, pass in NODE JUST CREATED (node with letter 'B's)
    } else {
      return this.add(input.substr(1), node.keys.get(input[0])); // (for another word of same letter 'B') every letter after first letter, onto EXISTING NODE
    }
  };
  this.isWord = function(word) {// checking if whole word in.. (doesn't check every word, only 1st letter )
    let node = this.root;
    while (word.length > 1) {
      if (!node.keys.has(word[0])) {
        return false;
      } else {
        node = node.keys.get(word[0]);
        word = word.substr(1);
      }
    }
    return node.keys.has(word) && node.keys.get(word).isEnd() ? true : false;
  };
  this.print = function() { // helper fx:array of every word and searches 
    let words = new Array();
    let search = function(node = this.root, string) {
      if (node.keys.size != 0) {
        for (let letter of node.keys.keys()) {
          search(node.keys.get(letter), string.concat(letter));
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

let newTrie = new Trie();
newTrie.add("Tom");
newTrie.add("Thomas");
newTrie.add("Tomtom");
newTrie.add("Tom");
newTrie.add("ThomasMilton");
newTrie.add("ball");
newTrie.add("bat");
newTrie.add("sense");
newTrie.add("donut");
newTrie.add("doubleDown");
console.log(newTrie.isWord("Tom"));
console.log(newTrie.isWord("Thxyz"));
console.log(newTrie.isWord("TomXX"));
console.log(newTrie.isWord("ball"));
console.log(newTrie.print());
