package service;
// ## Inventory Category A. 
// ## Hashing Table will use chaining (instead of Linear Probing to handle collisions

//Source code - Hashtables - Chaining

//## Inventory Category B. 
// ## The hashing table itself will not use traditional O(n) linked lists to traverse each chain. 
// ## Instead, this app uses BST's to obtain objects at O(log n) speed.
//Source code - Trees - Binary Search Trees (Insertion)
//Source code - Trees - Binary Search Trees (Traversal)
//Source code - Trees - Binary Search Trees (Get, Min, Max)

//## Inventory Category C.
// ## This app uses two customized sorting algorithms on inventory. 
//Source code - Sort Algorithms - Quick Sort (Implementation)
//Source code - Sort Algorithms - Counting Sort (Implementation)

//## Inventory Category D.
//Source code - Heaps - Heaps (Peek)
//Source code - Heaps - Priority Queues
//Source code - Heaps - Heapsort (Implementation)

public class ControllerService {
	private String invA = "// ## Hashing Table will use chaining (instead of Linear Probing to handle collisions\r\n";
	private static String invB= "//Source code - Trees - Binary Search Trees (Insertion)\r\n"
			+ "//Source code - Trees - Binary Search Trees (Traversal)\r\n"
			+ "//Source code - Trees - Binary Search Trees (Get, Min, Max);";
	
	private static String invC= "//Source code - Sort Algorithms - Quick Sort (Implementation)\r\n"
			+ "//Source code - Sort Algorithms - Counting Sort (Implementation)";
	
	private String invD = "//Source code - Heaps - Heaps (Peek)\r\n"
			+ "//Source code - Heaps - Priority Queues\r\n"
			+ "//Source code - Heaps - Heapsort (Implementation)";
	
	public ControllerService(String a, String b,String c, String d) {
		
	}
			public static char[] getAllStructs() {
	  // returns the current form of the primary data structure in use: the binary search tree for storing
		return invB.toCharArray();
	}

			public static char[] getAllAlgorithms() {
	 
		return invC.toCharArray();
	}
}
