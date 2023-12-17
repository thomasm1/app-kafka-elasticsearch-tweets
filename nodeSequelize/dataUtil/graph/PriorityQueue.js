



export class PriorityQueue {
    constructor(vals,arr,obj1,obj2,obj3) {
        
    this.obj1 = obj1 || {val:'a', priority:1}
    this.obj2 =  obj2 || {val:'b', priority:3}
    this.obj3 = obj3 || {val:'c',priority:6}

    this.arr = arr || [this.obj1, this.obj2, this.obj3]

    this.vals = vals || this.arr
    }
    enqueue (val, priority) {
        this.vals.push({val, priority});
        this.sort();
    }
    dequeue(val) {
        return this.vals.shift();
    }
    sort(a,b) {
        this.vals.sort((a,b) => a.priority - b.priority);
    }
}

const priorityQueue = new PriorityQueue()
 console.log(priorityQueue)
priorityQueue.enqueue('f',10)
console.log(priorityQueue)
// console.log(p)
console.log(priorityQueue.vals[3].val)