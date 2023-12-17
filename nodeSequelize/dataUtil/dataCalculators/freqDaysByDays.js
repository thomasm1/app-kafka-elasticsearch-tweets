// Bitcoin day-over-day count:
// 'you make your own luck' -- freq days by day

function sameBitLuck(arr1, arr2) {
    let freqCount1obj = {}
    let freqCount2obj = {}
    for (let ival of arr) {
        freqCount1obj[ival] = (freqCount1[ival] || 0)  +  1
    }
    for (let ival of arr) {
        freqCount2obj[ival] = (freqCount2obj[ival] || 0)  +  1
    }
    for(let key in freqCount1obj) {
        if(!(key**2 in freqCount2)){
            return false
        }
        if(freqCount2[key**2] !== freqCount1[key]) {
            return false
        }
    }
    return true
}
sameBitLuck([1,2,2,3], [9,3,2,1])
