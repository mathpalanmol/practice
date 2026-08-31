package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//          Average	 Worst case --> skewed tree)
//Space	    Θ(n)	    O(n)
//Search	Θ(log n)	O(n)
//Insert	Θ(log n)	O(n)
//Delete	Θ(log n)	O(n)
public class BSTOperations {
	Node root = null;
	int count = -1;
	int depth;

	public Node insertNode(int key, int value) {
		Node parent = root;
		Node current = root;
		boolean isLeft = false;
		Node newNode = new Node(key, value);
		if (root == null)
			root = newNode;
		else {
			while (true) {
				parent = current;
				if (key < current.key) {
					isLeft = true;
					current = current.lChild;
				} else {
					isLeft = false;
					current = current.rChild;
				}
				if (current == null)
					break;
			}
			if (isLeft)
				parent.lChild = newNode;
			else
				parent.rChild = newNode;
		}
		return newNode;
	}

	public Node findNode(int key) {
		Node current = root;
		while (current != null) {
			if (key == current.key)
				return current;
			if (key <= current.key)
				current = current.lChild;
			else
				current = current.rChild;
		}
		return null;
	}

	public void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.lChild);
		node.display();
		inOrder(node.rChild);
	}

	static boolean bst = true;
	static int max = Integer.MIN_VALUE;

	public List<Integer> validateBST(Node node, List<Integer> list) {
		if (node == null)
			return list;
		validateBST(node.lChild, list);
		list.add(node.key);
		validateBST(node.rChild, list);
		return list;
	}

	public boolean validateBst(List<Integer> list) {
		int pre = Integer.MIN_VALUE;
		boolean bst = true;
		for (int next : list) {
			if (next < pre) {
				bst = false;
				break;
			}
			pre = next;

		}
		return bst;
	}

	// TODO distance from root
	public void findDepth(Node node) {

		if (node == null)
			return;
		count++;
		findDepth(node.lChild);
		if (node.lChild == null && node.rChild == null) {
			if (count > depth)
				depth = count;
		}
		findDepth(node.rChild);
		count--;
	}

	public void printLeafNodes(Node node) {
		if (node == null)
			return;
		printLeafNodes(node.lChild);
		if (node.lChild == null && node.rChild == null)
			node.display();
		printLeafNodes(node.rChild);

	}
	// level order traversal

	public void levelOrder() {
		Node current = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(current);
		while (q.peek() != null) {
			Node del = q.poll();
			System.out.println(del);
			if (del.lChild != null)
				q.add(del.lChild);
			if (del.rChild != null)
				q.add(del.rChild);
		}
	}

	public void deleteNode(Node delNode) {
		Node parent = root;
		Node current = root;
		boolean isLeft = true;
		// use case not found: matching node doesn#t exist.
		while (current != delNode) {
			parent = current;
			if (delNode.key < current.key) {
				isLeft = true;
				current = current.lChild;
			} else {
				isLeft = false;
				current = current.rChild;
			}
		}
		/* If the delete node doesn't have any childs */
		if (current.lChild == null && current.rChild == null) {
			if (isLeft)
				parent.lChild = null;
			else
				parent.rChild = null;
		}
		/* If the delete node has one child - left child */
		if (current.lChild != null && current.rChild == null) {
			if (isLeft)
				parent.lChild = delNode.lChild;
			else
				parent.rChild = delNode.lChild;
		}
		/* If the delete node has one child - right child */
		if (current.rChild != null && current.lChild == null) {
			if (isLeft)
				parent.lChild = delNode.rChild;
			else
				parent.rChild = delNode.rChild;
		}
		/* If the node has both left and right childs */
		if (current.lChild != null && current.rChild != null) {
			Node successor = findSuccessor(delNode);
			if (isLeft)
				parent.lChild = successor;

			else
				parent.rChild = successor;
			successor.lChild = delNode.lChild;
		}

	}

	private Node findSuccessor(Node delNode) {
		Node parentSuccessor = delNode;
		Node successor = delNode.rChild;
		Node current = successor;
		while (current != null) {
			parentSuccessor = successor;
			successor = current;
			current = current.lChild;
		}
		if (successor != delNode.rChild) // right child,
		{
			parentSuccessor.lChild = successor.rChild;
			successor.rChild = delNode.rChild;
		}
		return successor;
	}

	boolean output = true;

	boolean checkBST(Node root) {
		if (root == null)
			return false;

		// boolean result = true;
		if (output) {
			if ((root.lChild != null && root.lChild.key > root.key)
					|| (root.rChild != null && root.rChild.key < root.key)) {
				// result = false;
				output = false;
				return false;
			}

			if ((root.rChild == null && root.lChild != null && root.lChild.key > root.key)) {
				// result = false;
				output = false;
				return false;
			}
			if (root.lChild == null && root.rChild != null && root.rChild.key < root.key) {
				// result = false;
				output = false;
				return false;
			}
			if (root.rChild == null && root.lChild == null) {
				// result = false;
				return true;
			}
			if ((root.lChild != null && root.lChild.key < root.key)
					&& (root.rChild != null && root.rChild.key > root.key)) {
				// result = true;
				return true;
				// output = false;
			}
			checkBST(root.lChild);
			checkBST(root.rChild);
		}

		return output;
	}

	void printPathsRecur(Node node, int path[], int pathLen) {
		if (node == null)
			return;

		/* append this node to the path array */
		path[pathLen] = node.key;
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (node.lChild == null && node.rChild == null)
			printArray(path, pathLen);
		else {
			/* otherwise try both subtrees */
			printPathsRecur(node.lChild, path, pathLen);
			printPathsRecur(node.rChild, path, pathLen);
		}
	}

	/* Utility function that prints out an array on a line. */
	void printArray(int ints[], int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

}
