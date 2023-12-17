// 2 hash functions
// 2 classes:
//  class HashSeparateChaining 
// class HashTableLinearProbing  
 

// separate chaining =>
// Can store more keys than size of array....
// Separate Chaining	Very Easy to implement
// Memory Inefficient – requires a secondary data structure to store collisions Long Chains will produce Linear search times
export class HashSeparateChaining {
  constructor(size) {
    this.size = size || 53; 
    this.keyMap = new Array(this.size);
  }

// O(1)
hashPrime(key) { 
    let total = 0;
    let PRIME = 31;
    for (let i = 0; i < Math.min(key.length, 100); i++) {  
      let char = key[i]; 
      let value = char.charCodeAt(0) - 96;
      total = (total + value + PRIME) % this.keyMap.length;
    }
    return total;
  }
  
// O(N)
hashSlow(key, arrayLen) {
  let total = 0;
  for (let char of key) {
    let value = char.charCodeAt(0) - 96;
    total = (total + value) % arrayLen;
  }
  return total;
}
 
}

// Open Addressing //  linear probing
/*
        This is because the memory addresses used for the single list are closer together, while separate chaining can have each data structure in different locations 
        far apart from each other. ... 
         linear probing leaves all values in one place in the single list
         
        Advantages:
        Open Addressing	Memory Efficient – stores elements in empty array spaces	
        Disadvantages: Creates Clusters with Linear and Quadratic Probing
        
        */
 
export class HashTableLinearProbing {
  constructor(mSize = 53) {
    this.count = 0; // Tracks actual item count in table
    // this.mSize = mSize; // current storage size of table
    this.maxLoadFactor = 0.667; // when table crosses 2/3rds capacity, size will either need to be increased or decreased
    this.increaseBy = 1.5; // x approaches infinity, amortized to O(N)
    this.table = new Array(mSize); // table holding keys & values
  }

  hash(key) {
    let a = 113; // random number between 1 and p - 1
    let b = 87; // random number between 1 and p - 1
    let PRIME = 10000019;
    let mSize = this.mSize; // hash table
    return ((a * key + b) % PRIME) % mSize; // return result of hash formula
  }

  add(key, value) {
    // Constant Time
    
    key = key.replace(/-/g, ""); // replace hyphens from key input
    let hash = this.hash(key); // create hash value out of key

    if (this.table[hash]) {
      // if position is already filled
      if (this.table[hash].key == key) {
        // if table position's key matches
        this.table[hash].value = value; // update value
      } else {
        let val = this.probe(hash);
        this.table[val] = { key, value }; // then place key and value in found empty position
        this.count++; // increment count of phone book after adding value
      }
    } else {
      // ff position empty
      this.table[hash] = { key, value }; // place key and value in found empty position
      this.count++; // increment count of phone book after adding value
    }
    if (this.count >= this.size * this.maxLoadFactor) {
      // if phone book is full
      this.increaseSize(); // call function to increase size of table
    }
  }

  probe(hash) {
    var a = 1; // 1 or where GCD of size and a is 1
    var i = 0; // counter to use for incrementing
    var val = (hash + a * i) % this.size; // get value with probe of 0
    while (this.table[val]) {
      // while table's position is filled
      i++; // increment i
      val = (hash + a * i) % this.size; // probe next position
    }
    return val; // return the result of the hash and probe function that results in an empty table position
  }
  increaseSize() {
    var temp = this.table; // set current table equal to temp variable
    this.size = this.size * this.increaseBy; // increase size of phone book
    this.table = new Array(this.size); // create new table with updated size
    for (i = 0; i < temp.length; i++) {
      // loop through current table
      if (temp[i]) {
        // if value in current table at position
        var key = temp[i].key; // get key at position
        var value = temp[i].value; // get value at position
        var hash = this.hash(key); // hash key value
        if (this.table[hash]) {
          // if position is already filled
          var val = this.probe(hash); // get new hash value returned from probe function
          this.table[val] = { key, value }; // then place key and value in found empty position
        } else {
          // if position empty
          this.table[hash] = { key, value }; // place key and value in found empty position
        }
      }
    }
  }
}
// Prototypal method more ru than pseudo-class b/c faster, except without encapsulation   // Saving Space, assigning props to the prototype
