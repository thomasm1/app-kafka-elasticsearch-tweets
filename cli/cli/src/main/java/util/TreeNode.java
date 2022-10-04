package util;

import org.junit.After;

public class TreeNode {
	
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	 
	public TreeNode(int data) {
		this.data = data;
	}

	/**
	 * @returns Node with value for identifier.... integer primitive for the hashMapper tool.  
	 * 
	 *prints data
	 */

	public TreeNode get(int value) {
		if(value == data) {
			return this;
		}
		if (value < data) {
			if (leftChild != null) {
				return leftChild.get(value);
			}
		}
		else {
			if (rightChild !=null) {
				return rightChild.get(value);
			}
		}
//		After both recursive sides complete, .
		return null;
	}


	/**
	 * @returns nothing  
	 * 
	 * insert only
	 */	

	public void insert(int value) {
		if(value == data) {
			return;
		}
		if(value < data) {
			if(leftChild==null) {
				leftChild= new TreeNode(value);
			} else {
				leftChild.insert(value); // Recursive flow down to next node
			}
		} else {
			if (rightChild==null) {
				rightChild = new TreeNode(value);
			} else {
				rightChild.insert(value); // Recursive
			}
		}
	}
	
	

	/**
	 * @returns nothing
	 * 
	 *prints data
	 */
	
	// Depth-first Search to Lowest Level Left Child Node: min
	 public void traverseInOrder() {
		if (leftChild != null) {
			leftChild.traverseInOrder();
		} 
		// Recursive Left side hits base case furrthest left, then print
		System.out.println(data + ", ");
		
		// Finish out Right-Childs
		if (rightChild != null) {
			rightChild.traverseInOrder();
		}
		// No print right child until print of root: In-order
	}
	 
	 
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the leftChild
	 */
	public TreeNode getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public TreeNode getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode getValue() {
		// TODO Auto-generated method stub
		return null;
	}


}
