package ds.tree;

import java.util.Arrays;
// BASIC operations
// Traversals - DFS AND BFS
// Height
// Diameter
// Lca
// Path
// Symmetrical



public class TreeFunctions {
	
	Node root;

	public static int heightOfTree(Node root) {
		if (null == root)
			return 0;
		int hLeftSub = heightOfTree(root.left);
		int hRightSub = heightOfTree(root.right);
		return Math.max(hLeftSub, hRightSub) + 1;
	}

	// root to leaf
	private static int nPath;

	public static void root2LeafPath(Node root, int[] path) {
		nPath = 0;
		processPath(root, path, 0);
	}

	private static void processPath(Node root, int[] path, int index) {
		if (null == root) {
			return;
		}
		path[index++] = root.data;
		if (root.left == null && root.right == null) {
			print(path, index);
			return;
		}
		processPath(root.left, path, index);
		processPath(root.right, path, index);
		// return;
	}

	private static void print(int[] path, int index) {
		System.out.printf("Root to Leaf path %d : ", ++nPath);
		System.out.println(Arrays.toString(Arrays.copyOf(path, index)));
		return;
	}
	// root to leaf end

	// Program – Root to leaf path, sum equals to given number

	private static int[] arr;

	public static void sumInRoot2LeafPath(Node root, int[] path, int sum) {
		boolean sumExist = sumInRoot2LeafPath(root, path, 0, sum);
		if (sumExist) {
			System.out.println("Sum exists in Path: " + Arrays.toString(arr));
		} else {
			System.out.println("Sum does not exist in any Path");
		}
	}

	private static boolean sumInRoot2LeafPath(Node root, int[] path, int index, int sum) {
		if (null == root) {
			return false;
		}
		path[index++] = root.data;
		sum = sum - root.data;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				arr = Arrays.copyOf(path, index);
				return true;
			}
			return false;
		}
		return sumInRoot2LeafPath(root.left, path, index, sum) || sumInRoot2LeafPath(root.right, path, index, sum);
	}

	// LCA
	public static Node lca(Node root, Node node1, Node node2) {
		if (null == root) {
			return root;
		}
		if (root == node1 || root == node2) {
			return root;
		}
		Node left = lca(root.left, node1, node2);
		Node right = lca(root.right, node1, node2);

		if (left != null && right != null) {
			return root;
		}
		if (left != null)
			return left;
		else
			return right;
	}
	// symmetrical // Mirror image of itself

	boolean checkSymetrical(Node root) {
		return checkSymetrical(root, root);
	}

	private boolean checkSymetrical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.data == root2.data) {
			return checkSymetrical(root1.left, root2.right) && checkSymetrical(root1.right, root2.left);
		}

		return false;
	}

	// Isomorphic
	// Two trees are called isomorphic if one of them can be obtained from other by
	// a series of flips, i.e. by swapping left and right children of a number of
	// nodes.
	boolean isIsomorphic(Node n1, Node n2) {
		// Both roots are NULL, trees isomorphic by definition
		if (n1 == null && n2 == null)
			return true;

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been
		// "Flipped".
		// Both of these subtrees have to be isomorphic.
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}

	// delete tree
	public static Node deleteTree(Node root) {
		if (null == root) {
			return null;
		}
		root.left = deleteTree(root.left);
		root.right = deleteTree(root.right);
		root = null;
		return root;
	}

	// boundary traverse

	void boundaryTraverse(Node root) {
		if (root == null)
			return;
		System.out.println(root.data);
		// to avoid duplicate entry of root we are dividing it to left and right sub tree.
		System.out.println("Left sub tree");
		printleftSide(root.left); // exclude leaf nodes
		System.out.println("leaf nodes");
		printleafNodes(root.left);
		printleafNodes(root.right);
		System.out.println("Right side");
		printrightSide(root.right); // exclude leaf nodes

	}

	private void printrightSide(Node root) {
		if (root == null)
			return;
		if(!(root.left == null && root.right == null))
		System.out.println(root.data);
		if (root.right != null) {
			printrightSide(root.right);
		} else if (root.left != null) {
			printrightSide(root.left);
		}

	}

	private void printleafNodes(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printleafNodes(root.left);
		printleafNodes(root.right);
	}

	private void printleftSide(Node root) {
		if (root == null)
			return;
		if(!(root.left == null && root.right == null))
		System.out.println(root.data);
		if (root.left != null) {
			printleftSide(root.left);
		} else if (root.right != null) {
			printleftSide(root.right);
		}

	}
	
	
	// With given count n how many possible BST can be generated.
	// This problem can be solved using Dynamic Programming. 
//	         n
	//t(n) = E     t(i-1)t(n-i)   --> n is total no of nodes t(0)==t(1)==1
//	         i=1
	int countTreesRec(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= numKeys; root++) {
				left = countTreesRec(root - 1); // left
				right = countTreesRec(numKeys - root); // right
				sum += left * right;
			}
			return (sum);
		}
	}
	
	
	public static void main(String[] args) {
		TreeFunctions tree = new TreeFunctions();
		Node root = tree.createTree();
		tree.boundaryTraverse(root);
	}
	
	private Node createTree() {
		this.root = new Node(100);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n30 = new Node(30);
		Node n31 = new Node(31);
		Node n40 = new Node(40);
		Node n41 = new Node(41);
		Node n50 = new Node(50);
		Node n51 = new Node(51);
		Node n60 = new Node(60);
		Node n61 = new Node(61);
		Node n62 = new Node(62);

		root.left = n10;
		root.right = n11;

		n10.left = n30;
		n10.right = n40;

		n11.right = n31;
		n11.left = n41;

		n30.left = n50;
		n31.right = n51;

		n40.right = n60;
		n60.left = n61;
		n60.right = n62;

		return root;
	}
	class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int num) {
			this.data = num;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}
	}
}
