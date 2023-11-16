// HEAPS Min 1=>1+  
console.log("%c MinHEAP Bi-Tree: ", "color:white; background-color:brown");

// Left child: 1*2
// Right chile: 1*2 + 1
// Parent: i/2
let MinHeap = function() {
  let heap = [null];
  this.insert = function(num) {
    heap.push(num);
    if (heap.length > 2) {
      let idx = heap.length - 1;
      while (heap[idx] < heap[Math.floor(idx / 2)]) {
        if (idx >= 1) {
          [heap[Math.floor(idx / 2)], heap[idx]] = [
            heap[idx],
            heap[Math.floor(idx / 2)]
          ];
          if (Math.floor(idx / 2) > 1) {
            idx = Math.floor(idx / 2);
          } else {
            break;
          }
        }
      }
    }
  }; // END INSERT
  this.remove = function() {
    let smallest = heap[1];
    if (heap.length > 2) {
      heap[1] = heap[heap.length - 1];
      heap.splice(heap.length - 1);
      if (heap.length == 3) {
        if (heap[1] > heap[2]) {
          [heap[1], heap[2]] = [heap[2], heap[1]];
        }
        return smallest;
      }
      let i = 1;
      let left = 2 * i;
      let right = 2 * i + 1;
      while (heap[i] >= heap[left] || heap[i] > heap[right]) {
        if (heap[left] < heap[right]) {
          [heap[i], heap[left]] = [heap[left], heap[i]];
          i = 2 * i;
        } else {
          [heap[i], heap[right]] = [heap[right], heap[i]];
          i = 2 * i + 1;
        }
        left = 2 * i;
        right = 2 * i + 1;
        if (heap[left] == undefined || heap[right] == undefined) {
          break;
        }
      }
    } else if (heap.length == 2) {
      heap.splice(1, 1);
    } else {
      return null;
    }
    return smallest;
  }; // end REMOVE
  
  this.sort = function() {
    let result = new Array();
    while (heap.length > 1) {
      result.push(this.remove());
    }
    return result;
  };

  this.printHeight = function() {
      return heap.length;
  }

  this.print = function() {
      return heap;
  }
};
let newMinHeap = new MinHeap();
console.log(newMinHeap.print());
newMinHeap.insert(3);
newMinHeap.insert(5);
console.log(newMinHeap.print());
newMinHeap.insert(1);
newMinHeap.insert(7);
console.log(newMinHeap.printHeight());
newMinHeap.remove(7);
console.log(newMinHeap.printHeight());
console.log(newMinHeap.print());
// HEAPS maxHeap 1+ => 1
console.log("%c MaxHEAP Bi-Tree: ", "color:white; background-color:brown");

let MaxHeap = function() {

	let heap = [null];

	this.print = () => heap;

	this.insert = function(num) {
		heap.push(num);
		if (heap.length > 2) {
			let idx = heap.length - 1;
			while (heap[idx] > heap[Math.floor(idx/2)]) {
				if (idx >= 1) {
					[heap[Math.floor(idx/2)], heap[idx]] = [heap[idx], heap[Math.floor(idx/2)]];
					if (Math.floor(idx/2) > 1) {
						idx = Math.floor(idx/2);
					} else {
						break;
					};
				};
			};
		};
	};

	this.remove = function() {
		let smallest = heap[1];
		if (heap.length > 2) {
			heap[1] = heap[heap.length - 1];
			heap.splice(heap.length - 1);
			if (heap.length === 3) {
				if (heap[1] < heap[2]) {
					[heap[1], heap[2]] = [heap[2], heap[1]];
				};
				return smallest;
			};
			let i = 1;
			let left = 2 * i;
			let right = 2 * i + 1;
			while (heap[i] <= heap[left] || heap[i] <= heap[right]) {
				if (heap[left] > heap[right]) {
					[heap[i], heap[left]] = [heap[left], heap[i]];
					i = 2 * i
				} else {
					[heap[i], heap[right]] = [heap[right], heap[i]];
					i = 2 * i + 1;
				};
				left = 2 * i;
				right = 2 * i + 1;
				if (heap[left] === undefined || heap[right] === undefined) {
					break;
				};
			};
		} else if (heap.length === 2) {
			heap.splice(1, 1);
		} else {
			return null;
		};
		return smallest;
	};

    this.printHeight = function() {
        return heap.length;
    }
  
    this.print = function() {
        return heap;
    }
};

let newMaxHeap = new MaxHeap();
console.log(newMaxHeap.print());
newMaxHeap.insert(3);
newMaxHeap.insert(5);
console.log(newMaxHeap.print());
newMaxHeap.insert(1);
newMaxHeap.insert(7);
console.log(newMaxHeap.printHeight());
newMaxHeap.remove(7);
console.log(newMaxHeap.printHeight());
console.log(newMaxHeap.print());