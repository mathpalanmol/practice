package ds.tree;

// two random nodes in binary tree are swaped. find them and fix the tree.
public class BstNodeSwap {

	class Node<k> {
		k data;
		Node<k> left;
		Node<k> right;

		Node(k data) {
			this.data = data;
		}
	}

	// void correctBST( Node root )
	// {
	// // Initialize pointers needed
	// // for correctBSTUtil()
	// first = middle = last = prev = null;
	//
	// // Set the poiters to find out
	// // two nodes
	// correctBSTUtil( root );
	//
	// // Fix (or correct) the tree
	// if( first != null && last != null )
	// {
	// int temp = first.data;
	// first.data = last.data;
	// last.data = temp;
	// }
	// // Adjacent nodes swapped
	// else if( first != null && middle !=
	// null )
	// {
	// int temp = first.data;
	// first.data = middle.data;
	// middle.data = temp;
	// }
	//
	// // else nodes have not been swapped,
	// // passed tree is really BST.
	// }

	Node<Integer> root = null;

	public static void main(String[] args) {
		BstNodeSwap ref = new BstNodeSwap();
		ref.createTreev1();
		ref.inOrder(ref.root);
		ref.fixBst(ref.root);
		System.out.println();
		Node n1 = null;
		Node n2 = null;
		if (ref.n1 != null) {
			n1 = ref.n1;
			if (ref.n2 == null)
				n2 = ref.mid;
			System.out.println(ref.n1.data);
		}
		if (ref.n2 != null) {
			n2 = ref.n2;
			System.out.println(ref.n2.data);
		}
		swapData(n1, n2);
	}

	private static void swapData(Node<Integer> n12, Node<Integer> n22) {
		int temp = n12.data;
		n12.data = n22.data;
		n22.data = temp;

	}

	// do the inorder scan. while doing so keep track of previous element.
	// n1 and n2 are two misplaced nodes that has to be identified.
	// if scanned value is less than pre value
	// capture the previous : for first time and current scanned node for second
	// time. y?
	// 10, 25, 35, 30, 40, 50, 75, 100, 120,
	// 35
	// 30
	// 10, 25, 100, 35, 40, 50, 75, 30, 120,
	// 100
	// 30
	private void inOrder(Node<Integer> root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);
	}

	Node<Integer> n1 = null;
	Node<Integer> n2 = null;
	Node<Integer> mid = null;
	Node<Integer> pre = null;

	void fixBst(Node<Integer> root) {
		if (root == null)
			return;

		fixBst(root.left);
		if (pre != null && pre.data > root.data) {
			if (n1 == null) {
				n1 = pre;
				mid = root;
			} else
				n2 = root;
		}
		pre = root; // correct location to track previous
		fixBst(root.right);

	}

	void fix(Node<Integer> root) {
		if (root == null)
			return;
		fix(root.left);
		if (pre != null && pre.data > root.data) {
			if (n1 == null) {
				n1 = pre;
				mid = root;
			} else
				n2 = root;
		}
		fix(root.right);
	}

	// orignal tree;
	private void createTreev1() {
		if (root == null) {
			root = new Node<Integer>(50);
		}
		root.left = new Node<Integer>(25);
		root.right = new Node<Integer>(100);
		root.left.left = new Node<Integer>(10);
		root.left.right = new Node<Integer>(35);
		root.left.right.left = new Node<Integer>(30);
		root.left.right.right = new Node<Integer>(40);
		root.right.left = new Node<Integer>(75);
		root.right.right = new Node<Integer>(120);
	}

	// adjacent misplaced nodes 30,35
	private void createTreev2() {
		if (root == null) {
			root = new Node<Integer>(50);
		}
		root.left = new Node<Integer>(25);
		root.right = new Node<Integer>(100);
		root.left.left = new Node<Integer>(10);
		root.left.right = new Node<Integer>(30);
		root.left.right.left = new Node<Integer>(35);
		root.left.right.right = new Node<Integer>(40);
		root.right.left = new Node<Integer>(75);
		root.right.right = new Node<Integer>(120);
	}

	// adjacent misplaced nodes 100,30
	private void createTree() {
		if (root == null) {
			root = new Node<Integer>(50);
		}
		// swap 30 with 100
		root.left = new Node<Integer>(25);
		root.right = new Node<Integer>(30); // root.right = new Node<Integer>(100);
		root.left.left = new Node<Integer>(10);
		root.left.right = new Node<Integer>(35);
		root.left.right.left = new Node<Integer>(100);// oot.left.right.left = new Node<Integer>(30);
		root.left.right.right = new Node<Integer>(40);
		root.right.left = new Node<Integer>(75);
		root.right.right = new Node<Integer>(120);
	}

}
