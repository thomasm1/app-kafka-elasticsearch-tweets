/*
creating a binary tree of nodes. These can be stored in a regular array, the size of which depends on the number of symbols, 
{\displaystyle n}n. A node can be either a leaf node or an internal node. Initially, all nodes are 
leaf nodes, which contain the symbol itself, the weight (frequency of appearance) of the symbol and optionally, a link to a 
parent node which makes it easy to read the code (in reverse) starting from a leaf node. Internal nodes contain a weight,
 links to two child nodes and an optional link to a parent node. As a common convention, bit '0' represents
  following the left child and bit '1' represents following the right child. A finished tree has up to n leaf nodes and  n-1}n-1 internal nodes. 
 A Huffman tree that omits unused symbols produces the most optimal code lengths.
 */
 
// 1 2 3 4 5 5 6
// F E D C A B G

// A | 0 => 
// B | ~
// C | ~ 
// D | ~
// E | ~ 
// F | ~
// G | ~ 
export class HuffmanNode{
    constructor(freq, data, left, right){
        this.freq = freq
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

/// mapping object
const charBinaryMapping = {};
const str = "ABBCCCCGGGGGDEAAAEDBBBDFAGG"
const code = encode(str)
console.log("final coded string : "+ code);

function encode(str) {
    let mapping = {}
    for(let i = 0; i<str.length;i++){
        if ((!str.charAt(i) in mapping)){
            mapping[str.charAt(i)] = 1;
        } else{
            mapping[str.charAt(i)] = mapping [str.charAt(i)] + 1;
        }
    }
   const root =  generateTree(mapping);
    setBinaryCode(root, "");
    // generate the binary coded string : 
    console.log(charBinaryMapping);
let s = "";
    for (let i = 0; i < str.length; i++){
         s += charBinaryMapping[str.charAt(i)]  // <== keep concatenating until complete coded string!!
        }
        return s;
}
 function setBinaryCode(node,str){
     if(node != null) { 
         
        if(node.left == null && node.right == null){     
                                                                    // mapping charBinaryMapping { node.data : str}
        charBinaryMapping[node.data] = str;
        }
                 // generating binary, only left or right
         //left
         str += '0';
         setBinaryCode(node.left, str);
        str = str.slice(0, str.length - 1);
        //right
         str += '1';
         str = str.slice(0, str.length - 1);
    }
 }
 
 function generateTree(mapping){
    let keySet = Object.keys(mapping);
    const priorityQ = [];
    keySet.forEach(character => {
        let node = new HuffmanNode(mapping[character], character, null, null);
        priorityQ.push(node);
        priorityQ.sort((a,b) => {a.freq - b.freq});
    });
    while(priorityQ > 1 && typeof priorityQ !== 'undefined') {
        const first = priorityQ.shift();
        const second = priorityQ.shift();
        let mergeNode = new HuffmanNode((first.freq + second.freq), '_', first, second )
        
        root = mergeNode; 
        priorityQ.push(mergeNode);
        priorityQ.sort((a,b) >a.freq - b.freq);
    
    }
    return priorityQ.shift();

}
