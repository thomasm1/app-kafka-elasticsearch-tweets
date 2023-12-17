// find node whose data has common ancesor, i.e. topmost conjoining nodes

import { Node } from '../dataStructures/DataBinaryTreeClass.js';
// assuming   binary tree
export function commonAncestor(int) {
    let integer = int;
    let root = new Node(8);
    root.left = new Node (7);
    root.left.left = new Node(4); 
    root.left.right = new Node(14);
    root.left.left.right = new Node(3); 
    
    root.right = new Node (18);  
    root.right.right = new Node(32);
    root.right.left = new Node(17);

    console.log(root.left.data); 


    // START  2-28
//     if (root == null) { return console.log("No Tree Here!")}
//     while (root != null) {
//         if (integer < root.data) {
//                 root = root.left
//         }
//         if (integer > root.data) {
//             root = root.right; 
//         }

//         console.log(root.data);

//     }
// console.log(root.data);
}
commonAncestor(7);
