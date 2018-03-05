package ds.tree;
import ds.tree.Node;


public class AVLBalance {
    public static void main(String[] args) {
    	Node root = insert(null, 10);
    	insert(root, 15);
    	insert(root, 25);
//    	insert(root, 100);
//    	insert(root, 100);
//    	insert(root, 100);
//    	insert(root, 100);
    	
		
	}
	static Node insert(Node root, int key) {
		if (root == null) {
			Node node = new Node(key,0);
			return node;
		}
		if (key <= root.key)
			root.lChild = insert(root.lChild, key);
		else
			root.rChild = insert(root.rChild, key);

		// root.ht = getHeight(root);
		int bf = getHeight(root.lChild) - getHeight(root.rChild);
		if (bf < -1) {
			if (getHeight(root.rChild.rChild) >= getHeight(root.rChild.lChild)) {
				root = lRotate(root);
			} else {
				// rChild rotation root.rChild
				root.rChild = rRotate(root.rChild);

				// lChild rotation
				root = lRotate(root);
			}
		} else if (bf > 1) {
			if (getHeight(root.lChild.lChild) >= getHeight(root.lChild.rChild)) {
				root = rRotate(root);
			} else {
				// lChild rotation root.lChild
				root.lChild = lRotate(root.lChild);
				// rChild rotation
				root = rRotate(root);
			}
		} else {
			root.ht = getHeight(root);//In first two cases we are doing this during rotation
		}

		return root;
	}

	static int getHeight(Node root) {
		if (root == null)
			return -1;
		int lChild = getHeight(root.lChild);
		int rChild = getHeight(root.rChild);
		return Math.max(lChild, rChild) + 1;
	}

	static Node lRotate(Node root) {
		Node newNode = root.rChild;
		root.rChild = root.rChild.lChild;
		newNode.lChild = root;
		root.ht = getHeight(root);
		newNode.ht = getHeight(newNode);
		return newNode;
	}

	static Node rRotate(Node root) {
		Node newNode = root.lChild;
		root.lChild = root.lChild.rChild;
		newNode.rChild = root;
		root.ht = getHeight(root);
		newNode.ht = getHeight(newNode);
		return newNode;
	}
}
