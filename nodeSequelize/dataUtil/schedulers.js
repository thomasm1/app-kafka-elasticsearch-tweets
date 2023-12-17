"strict";

// Greedy Scheduler
// TIMES:
const intervals = [[10,13],[9,12],[11,12],[15,17]]; 
var  optimalSchedule = greedySchedulers(intervals);

 function greedySchedulers(intervalArray) {

    optimalSchedule = [];

    intervalArray.sort((intervalStart, intervalEnd) => {
        return  intervalStart[1] - intervalEnd[1] ;
    }) 
    
    var  lastFinishTime = Number.MIN_SAFE_INTEGER;

    intervalArray.forEach((int) => {
        const start  = int[0];
        if(start > lastFinishTime){
            const end = int[1];
            optimalSchedule.push(int);
            lastFinishTime = end;
        }
    });
    return optimalSchedule;
}

console.log(optimalSchedule)
