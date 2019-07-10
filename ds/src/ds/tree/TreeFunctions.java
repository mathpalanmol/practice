package ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	int diameter(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1 is the
		 * diameter of root 4) Basically we are getting max out of root,leftsubtree and
		 * right subtree diameters.
		 */

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

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

	// find path root to leaf and equal to given sum | OR condition
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
		// OR condition. else we can call both left and right seperatly.
		// ultimately we need to return OR of both left and right recursive call

		return sumInRoot2LeafPath(root.left, path, index, sum) || sumInRoot2LeafPath(root.right, path, index, sum);
	}

	// LCA
	public static Node lca(Node root, Node node1, Node node2) {
		if (null == root) { // this is logical if both nodes are null it means root is lca.
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

		if (root1.data == root2.data) {// first check the root. left-->right and right-->left should be same.
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
	// del child first then root... postorder
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
		// to avoid duplicate entry of root we are dividing it to left and right sub
		// tree.
		System.out.println("Left sub tree");
		printleftSide(root.left); // exclude leaf nodes
		System.out.println("leaf nodes");
		printleafNodes(root.left);
		printleafNodes(root.right);
		System.out.println("Right side");
		printrightSide(root.right); // exclude leaf nodes

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
		if (!(root.left == null && root.right == null)) // to avoid printing leaf nodes.
			System.out.println(root.data);
		if (root.left != null) {
			printleftSide(root.left);
		} else if (root.right != null) {
			printleftSide(root.right);
		}

	}

	private void printrightSide(Node root) {
		if (root == null)
			return;
		if (!(root.left == null && root.right == null))
			System.out.println(root.data);
		if (root.right != null) {
			printrightSide(root.right);
		} else if (root.left != null) {
			printrightSide(root.left);
		}

	}

	// With given count n how many possible BST can be generated.
	// This problem can be solved using Dynamic Programming.
	// n
	// t(n) = E t(i-1)t(n-i) --> n is total no of nodes t(0)==t(1)==1
	// i=1
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

	public static int getHeight(Node root) {
		if (root == null)
			return 0;
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
	}

	public static boolean isBalancedNaive(Node root) {
		if (root == null)
			return true;
		int heightdifference = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightdifference) > 1) {
			return false;
		} else {
			return isBalancedNaive(root.left) && isBalancedNaive(root.right);
		}
	}

	public static void main(String[] args) {
		TreeFunctions tree = new TreeFunctions();
		Node root = tree.createTree();
		// tree.boundaryTraverse(root);
		tree.serialDeserialTree(root);
	}

	private void serialDeserialTree(Node root) {
		// Serialize
		List<Integer> inOrder = inOrder(root);
		List<Integer> preOrder = preOrder(root);

		Integer[] inOrderAry = (Integer[]) inOrder.toArray();
		Object[] preOrderAry = preOrder.toArray();
		// Deserialize
		deserialize(inOrder, preOrder, 0, preOrderAry.length - 1, 0);

	}

	Node root1 = null;
// not tested.
	private Node deserialize(List<Integer> inOrder, List<Integer> preOrder, int l, int h, int index) {
		if (l > h)
			return null;
		int indx = getIndex(preOrder, index++);
		Node newNode = new Node(preOrder.get(indx));
		newNode.left = deserialize(inOrder, preOrder, l, indx-1, index);
		newNode.right = deserialize(inOrder, preOrder, indx+1, h, index);
		return newNode;
	}

	private int getIndex(List<Integer> preOrder, int val) {
		return preOrder.indexOf(val);
	}
	// Program to store in order traversal

	static List<Integer> inOrderList = new ArrayList<Integer>();

	List<Integer> inOrder(Node root) {
		if (root == null)
			return null;
		inOrder(root.left);
		inOrderList.add(root.data);
		inOrder(root.right);
		return inOrderList;
	}

	// Program to store pre order traversal - root, left, right
	static List<Integer> preOrderList = new ArrayList<Integer>();

	List<Integer> preOrder(Node root) {
		if (root == null)
			return null;
		preOrderList.add(root.data);
		preOrder(root.left);
		preOrder(root.right);
		return preOrderList;
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
