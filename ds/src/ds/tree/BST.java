package ds.tree;

public class BST {

	/**
	 * @author Anmol.m
	 */
	public static void main(String[] args) {
		BSTOperations bsTree = new BSTOperations();

		Node root = bsTree.insertNode(50, 6); /* INSERTION */
		bsTree.insertNode(25, 4);
		bsTree.insertNode(30, 4);
		bsTree.insertNode(15, 7);
		bsTree.insertNode(55, 2);
		bsTree.insertNode(70, 7);
		bsTree.insertNode(95, 2);
		// root.rChild.lChild.key = 20;
		System.out.println(bsTree.checkBST(root));
		
	    treeToDLinkList(root);
	    display();

		// bsTree.findDepth(root); /* DEPTH */
		// System.out.println("Depth: " + bsTree.depth);
		// System.out.println("******");
		//
		// bsTree.inOrder(root); /* TRAVERSING */
		// System.out.println("******");
		// bsTree.printLeafNodes(root);
		//
		// System.out.println("******");
		// bsTree.deleteNode(delNode1); /* DELETION:- having no childs */
		// bsTree.inOrder(root);
		//
		// System.out.println("******");
		// bsTree.printLeafNodes(root);
		//
		// System.out.println("******");
		// bsTree.deleteNode(delNode2); /* DELETION:- having both the childs */
		// bsTree.inOrder(root);
		//
		// System.out.println("******");
		// bsTree.printLeafNodes(root);
	}

	static Node prev = null;
	static Link start = null;

	static void treeToDLinkList(Node root) {
		if (root == null)
			return;
		treeToDLinkList(root.lChild);
		convert(root.key);
		treeToDLinkList(root.rChild);

	}

	static private void convert(int key) {
		Link newLink = new Link(key);
		if (start == null) {
			start = newLink;
			return;
		}
		newLink.next = start;
		start.pre = newLink;
		start = newLink;
	}

	static void display() {
		Link current = start;
		while (current != null) {
			System.out.println(current.key);
			current = current.next;
		}

	}

	public static class Link {
		public int key;
		public Link next;
		public Link pre;

		public Link(int key) {
			this.key = key;
		}

		public void display() {
			System.out.println(key);
		}
	}

}
