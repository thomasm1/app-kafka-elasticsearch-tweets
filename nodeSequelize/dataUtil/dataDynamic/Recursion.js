 
     let count = 0;

 export default function getSubsequence(word) { 
    if (word == '') { return ''; }
    const first = word.charAt(0);
    const rest = getSubsequence(word.substring(1));
    let result = '';
 
    rest.split(',').forEach( subseq => {
          count++;
        result += ','+ first + subseq; 
        result += ','+ subseq 
    });

    return result.substring(1);
}
 
let resultt = getSubsequence('hello');
console.log (count, resultt);


