const wt = [10, 40, 20, 30]
const val = [600, 400, 1000, 1200]
const capacity = 50 
 
export  class FractionalKnap {
    constructor(wt, val, ind) {
        this.wt = wt; 
        this.val = val;
        this.ind = ind;
        this.cost= val/wt;
  
        // console.log("max profit", getMaxValue(wt[0], val, capacity));
    }

   print() {
    console.log("max profit", getMaxValue(wt, val, capacity));
   }
}


  export default function getMaxValue(wt, val, capacity) {
    let items = []; 
    for(let i = 0; i<val.length; i++){
        let item = new FractionalKnap(wt[i], val[i], i)
        items.push(item);
        console.log(items)
    }
    //sort
    items.sort((item1, item2) => {
        return item2.cost - item1.cost;
    })

    let totalVal = 0;
    //adding items  
    for(let index=0; index<items.length; index++){
        const curWt = items[index].wt;
        const curVal = items[index].val;

        if(capacity - curWt >=0){
            capacity = capacity -curWt;  // new weight
            totalVal +=curVal;   // new value
        } else {
            // calculating last possible item ... 
            let fraction = capacity/curWt;
            totalVal += curVal*fraction;
            break;
        }
    }
    return  console.log(totalVal);
}
console.log("max profit", getMaxValue(wt, val, capacity));
 