package util;

public class Tree {

	private TreeNode root;
	
	public void insert(int value) {
		
		// One time only on first Load of Tree
		if(root == null) {
			root = new TreeNode(value);
		} else {
			
			// TreeNode method will place value into node
			root.insert(value);
		}
	}
	 
	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		return null;
	}
	
}
