package ds.tree;

public class BST {

	/**
	 * @author Anmol.m
	 */
	public static void main(String[] args) {
		BSTOperations bsTree = new BSTOperations();

		Node root = bsTree.insertNode(50, 6); /* INSERTION */
		bsTree.insertNode(25, 4);
		Node delNode2 = bsTree.insertNode(75, 3);
		bsTree.insertNode(15, 7);
		Node delNode1 = bsTree.insertNode(20, 8);
		bsTree.insertNode(55, 2);
		bsTree.insertNode(70, 7);
		bsTree.insertNode(95, 2);
		root.rChild.lChild.key= 20;
		System.out.println(bsTree.checkBST(root));

//		bsTree.findDepth(root); /* DEPTH */
//		System.out.println("Depth: " + bsTree.depth);
//		System.out.println("******");
//
//		bsTree.inOrder(root); /* TRAVERSING */
//		System.out.println("******");
//		bsTree.printLeafNodes(root);
//
//		System.out.println("******");
//		bsTree.deleteNode(delNode1); /* DELETION:- having no childs */
//		bsTree.inOrder(root);
//		
//		System.out.println("******");
//		bsTree.printLeafNodes(root);
//		
//		System.out.println("******");
//		bsTree.deleteNode(delNode2); /* DELETION:- having both the childs */
//		bsTree.inOrder(root);
//		
//		System.out.println("******");
//		bsTree.printLeafNodes(root);
	}

}
