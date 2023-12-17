 
// NON-BINARY SEARCH TREE  prototype
console.log("%c B-TREE SEARCH:", "color:white; background-color:black");
class Node {
    constructor(data, left, right, center) {  
        this.data = data || null;
        this.left = left || null;
        this.right = right || null;

        this.center = center || null;      // For Non-Binary Trees, etc.
        this.remainders = new Array();
    }
}

export default  function NBST() {  /// NEED WORK ON THIS  
        this.root = null; 
    
}

NBST.prototype.add = function(data) {
        const node = this.root;
        if (node === null) {
            this.root = new Node(data);
            return;
        } else {

            const searchTree = function(node) {
                if (data < node.data) {
                    if (node.left === null) {
                        node.left = new Node(data);
                        return;
                    } else if (node.left !== null) {
                        return searchTree(node.left);
                    }
                } else if (data > node.data) {
                    if (node.right === null) {
                        node.right = new Node(data);
                        return;
                    } else if (node.right !== null) {
                        return searchTree(node.right);
                    }
                } else {
                    return null;
                }
            };
            return searchTree(node);
        }
    }

    NBST.prototype.findMin = function() {
        let current = this.root;
        while (current.left !== null) {
            current = current.left;
        }
        return current.data;
    }
    NBST.prototype.findMax = function() {
        let current = this.root;
        while (current.right !== null) {
            current = current.right;
        }
        return current.data;
    }
    NBST.prototype.find = function(data) {
        let current = this.root;
        while (current.data !== data) {
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current === null) {
                return null;
            }
        }
        return current;
    }
    NBST.prototype.isPresent = function(data) {
        let current = this.root;
        while (current) {
            if (data === current.data) {
                return true;
            }
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
    NBST.prototype.remove  = function (data) {
        const removeNode = function(node, data) {
            if (node == null) {
                return null;
            }
            if (data == node.data) {
                // node has no children 
                if (node.left == null && node.right == null) {
                    return null;
                }
                // node has no left child 
                if (node.left == null) {
                    return node.right;
                }
                // node has no right child 
                if (node.right == null) {
                    return node.left;
                }
                // node has two children 
                var tempNode = node.right;
                while (tempNode.left !== null) {
                    tempNode = tempNode.left;
                }
                node.data = tempNode.data;
                node.right = removeNode(node.right, tempNode.data);
                return node;
            } else if (data < node.data) {
                node.left = removeNode(node.left, data);
                return node;
            } else {
                node.right = removeNode(node.right, data);
                return node;
            }
        }
        this.root = removeNode(this.root, data);
    }
    NBST.prototype.isBalanced = function() {
        return (this.findMinHeight() >= this.findMaxHeight() - 1)
    }
    NBST.prototype.findMinHeight = function (node = this.root) {
        if (node == null) {
            return -1;
        };
        let left = this.findMinHeight(node.left);
        let right = this.findMinHeight(node.right);
        if (left < right) {
            return left + 1;
        } else {
            return right + 1;
        };
    }
    NBST.prototype.findMaxHeight  = function (node = this.root) {
        if (node == null) {
            return -1;
        };
        let left = this.findMaxHeight(node.left);
        let right = this.findMaxHeight(node.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        };
    }
    NBST.prototype.inOrder = function () {
        if (this.root == null) {
            return null;
        } else {
            var result = new Array();

            function traverseInOrder(node) {
                node.left && traverseInOrder(node.left);
                result.push(node.data);
                node.right && traverseInOrder(node.right);
            }
            traverseInOrder(this.root);
            return result;
        };
    }
    NBST.prototype.preOrder = function() {
        if (this.root == null) {
            return null;
        } else {
            var result = new Array();

            function traversePreOrder(node) {
                result.push(node.data);
                node.left && traversePreOrder(node.left);
                node.right && traversePreOrder(node.right);
            };
            traversePreOrder(this.root);
            return result;
        };
    }
    NBST.prototype.postOrder = function () {
        if (this.root == null) {
            return null;
        } else {
            var result = new Array();

            function traversePostOrder(node) {
                node.left && traversePostOrder(node.left);
                node.right && traversePostOrder(node.right);
                result.push(node.data);
            };
            traversePostOrder(this.root);
            return result;
        }
    }

    NBST.prototype.levelOrder = function() {
        let result = [];
        let Q = [];
        if (this.root != null) {
            Q.push(this.root);
            while (Q.length > 0) {
                let node = Q.shift();
                result.push(node.data);
                if (node.left != null) {
                    Q.push(node.left);
                };
                if (node.right != null) {
                    Q.push(node.right);
                };
            };
            return result;
        } else {
            return null;
        };
    };
 
const nbst = new NBST();

nbst.add(9);
nbst.add(4);
nbst.add(17);
nbst.add(3);
nbst.add(6);
nbst.add(22);
nbst.add(5);
nbst.add(7);
nbst.add(20);

console.log(nbst.findMinHeight());
console.log(nbst.findMaxHeight());
console.log(nbst.isBalanced());
nbst.add(10);
console.log(nbst.findMinHeight());
console.log(nbst.findMaxHeight());
console.log(nbst.isBalanced());
console.log('inOrder: ' + nbst.inOrder());
console.log('preOrder: ' + nbst.preOrder());
console.log('postOrder: ' + nbst.postOrder()); 
console.log('levelOrder: ' + nbst.levelOrder());

 