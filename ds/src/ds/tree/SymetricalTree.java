package ds.tree;

import java.util.Arrays;
import java.util.Stack;

public class SymetricalTree {

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	TreeNode root;
	// root to leaf
	private static int nPath;
	static int pathLen;

	/*
	 * 0 1 1 3 4 4 3 5 5
	 * 
	 */
	private TreeNode createTree() {
		this.root = new TreeNode(100);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n30 = new TreeNode(30);
		TreeNode n31 = new TreeNode(31);
		TreeNode n40 = new TreeNode(40);
		TreeNode n41 = new TreeNode(41);
		TreeNode n50 = new TreeNode(50);
		TreeNode n51 = new TreeNode(51);
		TreeNode n60 = new TreeNode(60);
		TreeNode n61 = new TreeNode(61);
		TreeNode n62 = new TreeNode(62);

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

		// TreeNode output = lca(root, n41, n51);
		// System.out.println("lca: " + output.value);
		// int[] ary = new int[50];
		// processPath(n10, n50, ary, 0);
		//
		// System.out.println("Distance: " + distance(root, n50, n41));

		// binaryToLinkedList(root);
		// printLinkedList(start);

		return root;
	}

	// LCA
	public static TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2) {
		if (null == root) {
			return null;
		}
		if (root == node1 || root == node2) {
			return root;
		}
		TreeNode left = lca(root.left, node1, node2);
		TreeNode right = lca(root.right, node1, node2);

		if (left != null && right != null) {
			return root;
		}
		if (left != null)
			return left;
		else
			return right;
	}

	private int distance(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode lca = lca(root, node1, node2);
		processPath(lca, node1, new int[50], 0);
		int l1 = pathLen;
		processPath(lca, node2, new int[50], 0);
		int l2 = pathLen;

		return l1 + l2 - 1;
	}

	// path from root to a node
	private static void processPath(TreeNode root, TreeNode dest, int[] path, int index) {
		if (null == root) {
			return;
		}
		path[index++] = root.value;
		if (root == dest) {
			print(path, index);
			return;
		}
		processPath(root.left, dest, path, index);
		processPath(root.right, dest, path, index);
		// return;
	}

	private static void print(int[] path, int index) {
		System.out.printf("Root to Leaf path %d : ", ++nPath);
		pathLen = index;
		System.out.println(Arrays.toString(Arrays.copyOf(path, index)));
		return;
	}

	boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.value == root2.value) {
			return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
		}

		return false;
	}

	int findDiameter(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int left = getHeight(root.left);
			int right = getHeight(root.right);
			return getMax(left + right + 1, findDiameter(root.left), findDiameter(root.right));
		}

	}

	private int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;
	}

	TreeNode start;
	TreeNode current;

	void binaryToLinkedList(TreeNode root) {
		if (root == null)
			return;
		binaryToLinkedList(root.left);
		if (current == null) {
			start = root;
		} else {
			current.right = root;
			root.left = current;
		}
		current = root;
		binaryToLinkedList(root.right);
	}

	void printLinkedList(TreeNode current) {
		System.out.println("Printing linked list");
		while (current != null) {
			System.out.println(current.value);
			current = current.right;
		}
	}

	// Convert a given tree to a tree where every node contains sum of
    // values of nodes in left and right subtrees in the original tree
    int toSumTree(TreeNode node) 
    {
        // Base case
        if (node == null)
            return 0;
  
        // Store the old value
        int old_val = node.value;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        node.value = toSumTree(node.left) + toSumTree(node.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return node.value + old_val;
    }
	
	void printZigZagTraversal(TreeNode rootNode) {

		// if null then return
		if (rootNode == null) {
			return;
		}

		// declare two stacks
		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();

		// push the root
		currentLevel.push(rootNode);
		boolean leftToRight = true;

		// check if stack is empty
		while (!currentLevel.isEmpty()) {

			// pop out of stack
			TreeNode node = currentLevel.pop();

			// print the data in it
			System.out.print(node.value + " ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}

				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}

				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<TreeNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	public static void main(String[] args) {
		SymetricalTree tree = new SymetricalTree();

		/*
		 * 0 1 1 3 4 4 3 5 5
		 * 
		 */
		tree.createTree();

		// System.out.println("tree is symmetric: " + tree.isSymmetric(tree.root));
		// System.out.println("Diameter: " + tree.findDiameter(tree.root));
	}

}
