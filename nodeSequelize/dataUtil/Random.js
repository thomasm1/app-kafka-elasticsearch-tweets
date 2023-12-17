// import crypto from 'jscrypt' or something
 

export function Random () {
this.limit = limit || 3
}

Random.prototype.generateRandom = function(limit) {
  return Math.floor(Math.Random() * limit)
}
Random.prototype.getRandomUints = function(){
  const array = new Uint32Array(10);
  Window.crypto.getRandomValues(array);
 
  var randText = document.getElementById("myRandText");
  randText.innerHTML = "The random numbers are: "
  for (var i = 0; i < array.length; i++) {
    randText.innerHTML += array[i] + " ";
  }
}