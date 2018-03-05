package ds.tree;

//          Average	   Worst case --> skewed tree)
//Space	    Θ(n)	    O(n)
//Search	Θ(log n)	Θ(log n)
//Insert	Θ(log n)	Θ(log n)
//Delete	Θ(log n)	Θ(log n)
public class cAVLtree {

	Node root = null;

	static class Node {
		int key;
		Node lchild;
		Node rchild;
		int height = 1;
		int size = 1;

		Node(int key) {
			this.key = key;
		}

		public int getSize(Node current) {
			return size;
		}

		public void setSize(Node current) {
			if (current == null)
				return;
			int left = current.lchild != null ? current.lchild.size : 0;
			int right = current.rchild != null ? current.rchild.size : 0;
			this.size = left + right + 1; // +1 is for the current node
		}
	}

	// iterative way of inserting element in binary tree
	public void insert(int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = root;
		boolean isLeft = false;
		while (current != null) {
			parent = current;
			if (key <= current.key) {
				isLeft = true;
				current = current.lchild;
			} else {
				isLeft = false;
				current = current.rchild;
			}
		}
		if (isLeft)
			parent.lchild = newNode;
		else
			parent.rchild = newNode;

	}
	// recursive way of inserting element in binary tree

	public Node recinsert(Node current, int key) {
		if (current == null) {
			Node node = new Node(key);
			// node.setSize(node);
			return node;
		}
		if (key <= current.key)
			current.lchild = recinsert(current.lchild, key);
		else
			current.rchild = recinsert(current.rchild, key);

		int balanceFactor = calculateBalance(current); // left-right
		if (balanceFactor < -1) { // left of right(current.right)-->left(current, tree \)
			if (getHeight(current.rchild.rchild) >= getHeight(current.rchild.lchild))
				current = leftRotation(current);
			else {
				current.rchild = rightRotation(current.rchild);
				current = leftRotation(current);
			}
		} else if (balanceFactor > 1) {
			if (getHeight(current.lchild.lchild) >= getHeight(current.lchild.rchild))
				current = rightRotation(current);
			else {
				current.lchild = leftRotation(current.lchild);
				current = rightRotation(current);
			}
		} else {
			setHeight(current); // for -1<=balancefactorParent<=1 height; newly
			current.setSize(current); // added node will always
			// be a leaf node with height 0[Default].
		}
		return current;
	}

	public Node leftRotation(Node root) {
		Node newRoot = root.rchild;
		root.rchild = root.rchild.lchild;
		newRoot.lchild = root;
		setHeight(root);
		root.setSize(root);
		setHeight(newRoot);
		newRoot.setSize(newRoot);

		return newRoot;
	}

	public Node rightRotation(Node root) {
		Node newRoot = root.lchild;
		root.lchild = root.lchild.rchild;
		newRoot.rchild = root;
		setHeight(root);
		root.setSize(root);
		setHeight(newRoot);
		newRoot.setSize(newRoot);

		return newRoot;
	}

	private int calculateBalance(Node current) {
		int lh = current.lchild != null ? current.lchild.height : 0;
		int rh = current.rchild != null ? current.rchild.height : 0;
		return lh - rh;// left - right
	}

	public void setHeight(Node current) {
		current.height = Math.max(current.lchild != null ? current.lchild.height : 0,
				current.rchild != null ? current.rchild.height : 0) + 1;
	}

	public int getHeight(Node current) {
		if (current == null)
			return 0;
		return current.height;
	}

	// inorder traversal
	public void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.lchild);
		System.out.println(root.key);
		inOrder(root.rchild);
	}

	// AVL application
	private void getMedian(Node root) {
		if (root == null)
			return;
		int lSize = root.lchild != null ? root.lchild.size : 0;
		int rSize = root.rchild != null ? root.rchild.size : 0;
		int medInd = (lSize + rSize + 1) / 2;
		if (lSize > rSize)
			inOrder(root.lchild, lSize - (medInd - (rSize + 1)));
		else
			inOrder(root.rchild, medInd - (lSize + 1));

	}

	boolean b = true;
	int cou = 0;

	private void inOrder(Node root, int count) {
		if (root == null)
			return;
		inOrder(root.lchild, count);
		cou++;
		if (b) {
			if (cou == count) {
				b = false;
				System.out.println("\n\nMedian: " + root.key);
				return;
			}
		}
		// System.out.println(root.key);
		inOrder(root.rchild, count);
	}

	// get value only... Remember we are not removing the successor.
	private int getSuccessor(Node current) {
		Node successor = null;
		while (current != null) {
			successor = current;
			current = current.lchild;
		}
		return successor.key;
	}

	private int getPredecor(Node current) {
		Node predessor = null;
		while (current != null) {
			predessor = current;
			current = current.rchild;
		}
		return predessor.key;
	}

	public static void main(String[] args) {
		cAVLtree avlRef = new cAVLtree();
		Node root = new Node(5);
		root = avlRef.recinsert(root, 10);
		// avlRef.recinsert(root, 25);
		root = avlRef.recinsert(root, 15);
		root = avlRef.recinsert(root, 25);
		root = avlRef.recinsert(root, 90);
		root = avlRef.recinsert(root, 80);
		root = avlRef.recinsert(root, 70);

		root = avlRef.recinsert(root, 100);
		root = avlRef.recinsert(root, 110);
		root = avlRef.recinsert(root, 120);
		root = avlRef.recinsert(root, 130);
		Node currentRoot = avlRef.recinsert(root, 140);

		// avlRef.insert(50);
		// avlRef.insert(25);
		// avlRef.insert(15);
		// avlRef.insert(5);
		// avlRef.insert(90);
		// avlRef.insert(80);
		// avlRef.insert(70);
		// avlRef.insert(5);

		// avlRef.inOrder(currentRoot);
		avlRef.getMedian(currentRoot);

	}

}
