// SETS
console.log("%c SETS BEGN: ", "color:white; background-color:grey");
// ES6 Set methods:  .has, .values, .add,   .size,
function mySet() {
  // collection holding set
  var collection = [];
  // check for presence, return true or false
  this.has = function(element) {
    return collection.indexOf(element) !== -1;
  };
  //return all els in set
  this.values = function() {
    return collection;
  };
  //add el to a set
  this.add = function(element) {
    if (!this.has(element)) {
      collection.push(element);
      return true; // added
    }
    return false; // alread in set
  };
  //remove el from set
  this.remove = function(element) {
    if (this.has(element)) {
      var index = collection.indexOf(element);
      collection.splice(index, 1);
      return true; // removed
    }
    return false; // none to remve
  };
  this.size = function() {
    return collection.length; // col size
  };
  //  returns the union of two sets
  this.union = function(otherSet) {
    var unionSet = new Set();
    var firstSet = this.values();
    var secondSet = otherSet.values();
    firstSet.forEach(function(e) {
      unionSet.add(e);
    });
    secondSet.forEach(function(e) {
      unionSet.add(e);
    });
    return unionSet;
  };
  // returns intersection of 2 sets AS A NEW SET
  this.intersection = function(otherSet) {
    var intersectionSet = new mySet();
    var firstSet = this.values();
    firstSet.forEach(function(e) {
      if (otherSet.has(e)) {
        intersectionSet.add(e);
      }
    });
    return intersectionSet;
  };
  // returns DIFFERENCE of 2 sets as a new set
  this.difference = function(otherSet) {
    var differenceSet = new Set();
    var firstSet = this.values();
    firstSet.forEach(function(e) {
      if (!otherSet.has(e)) {
        differenceSet.add(e);
      }
    });
    return differenceSet;
  };
  // tests if set is a subset of a different set
  this.subset = function(otherSet) {
    var firstSet = this.values();
    return firstSet.every(function(value) {
      return otherSet.has(value);
    });
  };
}
var setA = new mySet();
var setB = new mySet();

setA.add("a");
setB.add("b");
setB.add("c");
setB.add("a");
setB.add("d");
console.log(setA.subset(setB));
console.log(setA.intersection(setB).values());
console.log(setB.difference(setA).values());

console.log(setB.values());
setB.remove("a");
console.log(setB.has("a"));
console.log(setB.add("d"));
