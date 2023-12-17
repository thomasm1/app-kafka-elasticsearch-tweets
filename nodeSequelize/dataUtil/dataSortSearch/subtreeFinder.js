// Find subtree nodes in a tree
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

//     1
//   2   3
//  4 5 6 7
let root1 = new Node(1);
root1.left = new Node(2);
root1.right = new Node(3);
root1.left.left = new Node(4);
root1.left.right = new Node(5);
root1.right.left = new Node(6); 
root1.right.right = new Node(7);

 
// subtree
//  4
// 5 6 
let root2 = new Node(4);
root2.left = new Node(5);
root2.right = new Node(6);

console.log(checkSubtree(root1, root2));

function inOrder(node, list) {
    if (node == null) { return }
    //left
    inOrder(node.left, list);
    //node
    inOrder(node.data);
    //right
    inOrder(node.right, list);
} 

function preOrder(node, list) {
    if (node == null) { return }
    //node                              -> NODE FIRST
    preOrder(node.data);
    //left
    preOrder(node.left, list);
    //right
    preOrder(node.right, list);
} 

function checkSubtree(tree, subtree) {
    if(subtree ==null) {
        return true;
    }
    if(tree == null) {
        return false;
    }

    // inOrder
    let first = [];
    let second = [];
    inOrder(tree, first);
    inOrder(subtree, second ); 

    if(!listToString(first).includes(listToString(second)))
        return false;                        // if false, need pre-order!!
    
    // preOrder
    first = [];
    second = [];
    preOrder(tree, first);
    preOrder(subtree, second ); 

    if(!listToString(first).includes(listToString(second)))
        return false;                        // if false, need pre-order!!

    return true;
    } 
 

function listToString(list){
    return list.toString().replace(/,/g,'');
}