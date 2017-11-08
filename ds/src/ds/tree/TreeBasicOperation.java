package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BSTOperations bsTree = new BSTOperations();/* INSERTION */
//bsTree.insertNode(100, 1);
//bsTree.insertNode(50, 1);
//bsTree.insertNode(150, 1);
//bsTree.insertNode(25, 1);
//bsTree.insertNode(75, 1);
//bsTree.insertNode(10, 1);
//bsTree.insertNode(35, 1);
//bsTree.insertNode(65, 1);
//bsTree.insertNode(85, 1);
//bsTree.insertNode(80, 1);
//bsTree.insertNode(78, 1);
//bsTree.insertNode(120, 1);
//bsTree.insertNode(180, 1);

public class TreeBasicOperation {
	public static Node LCA(Node root, Node a, Node b) {
		   if (root == null) {
		       return null;
		   }

		   // If the root is one of a or b, then it is the LCA
		   if (root == a || root == b) {
		       return root;
		   }

		   Node left = LCA(root.lChild, a, b);
		   Node right = LCA(root.rChild, a, b);

		   // If both nodes lie in left or right then their LCA is in left or right,
		   // Otherwise root is their LCA
		   if (left != null && right != null) {
		      return root;
		   }

		   return (left != null) ? left : right; //if both are null it will return null
		}
	
	static boolean findLCA(Node node, int n1, int n2) {
		if (node == null)
			return false;
		if (node.key == n1 || node.key == n2)// if current node match with any
												// of the inputs return true to
												// it's caller so that it can be
												// marked as found in later
												// compuatiation in calling
												// function.
			return true;
		boolean left = findLCA(node.lChild, n1, n2);// scan left side
		boolean right = findLCA(node.rChild, n1, n2);// scan right side
		if (left && right) {
			System.out.println(node.key);
			return false;// once match can be return true or false or we can
							// remove this line
		}

		return left || right; // if any one is found we must return true

	}

	// height: longest path between root and leaf. height:no of edges between
	// height(leafNode) --> 0 // depth(root) --> 0
	// root and leaf
	// heigh(node): Max[height(leftchild),height(rightChild)] + 1(for node);

	static int height(Node root) {
		if (root == null)
			return -1;//f there is one node it's height will evaluate to 0
		int left = height(root.lChild);
		int right = height(root.rChild);
		return Math.max(left, right) + 1;
	}

	// inOrder of BST will result in to ascending ordered output
	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.lChild);
		System.out.println("Key: " + root.key + ", Height: " + height(root) + " |");
		inOrder(root.rChild);
	}

	static int width = Integer.MIN_VALUE;

	// find Diameter or width of given tree
	// The diameter of a tree (sometimes called the width) is the number of
	// nodes on the longest path between two leaves in the tree.
	static int findDiameter(Node root, int count) {
		if (root == null)
			return 0;
		int lheight = height(root.lChild);
		int rheight = height(root.rChild);
		int diameter = lheight + rheight + 1 + 2;// this condition is written by
													// taking only base case and
													// apparently it applies for
													// all cases: lheight--> -1,
													// rheight--> -1; -1-1+1+2 =
													// 1(diameter);
		if (diameter > width)
			width = diameter;
		findDiameter(root.lChild, 0);
		findDiameter(root.rChild, 0);
		return width;

	}

	// levelOrder - BFS in tree
	// can be used to find depth of binary tree. depth = no of levels; depth of
	// a node is defined as the edges/distance from node to root
	static void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node pop = q.poll();
			if (pop == null) {
				q.add(null);
				continue;
			} else {
				System.out.print(pop.key + " |");
				if (pop.lChild != null)
					q.add(pop.lChild);
				if (pop.rChild != null)
					q.add(pop.rChild);
			}
			if (q.size() == 1 && q.peek() == null)
				break;
		}

	}

	static List<Node> getPath(Node root, Node s, Node d) {
		LinkedList<Node> list1 = new LinkedList<Node>();
		LinkedList<Node> list2 = new LinkedList<Node>();
		getPath(list1, root, s);
//		for(Node node : list1){
//			System.out.print(node.key + "|");}
		System.out.println();
		temp = false;
		getPath(list2, root, d);

//		for(Node node : list2)
//			System.out.print(node.key + "|");
		int index = 0;
		Node prev = null;
		while(index < list1.size() && index < list2.size() && list1.get(index) == list2.get(index)){
			prev = list1.get(index);
			index++;
		}
		LinkedList<Node> output = new LinkedList<Node>();
		for(int i=list1.size()-1; i >=index; i--){
			output.add(list1.get(i));
		}
		output.add(prev);
        for(int i=index; i <list2.size(); i++){
        	output.add(list2.get(i));
		}
		return output;
	}
static boolean temp = false;
	private static boolean getPath(LinkedList<Node> list, Node root, Node dest) {
		if (root == null)
			return false;
		if (root == dest) {
			list.add(root);
			temp = true;
			return true;
		} else {
			if(!temp){
			list.add(root);
			boolean left = getPath(list, root.lChild, dest);
			
			boolean right = getPath(list, root.rChild, dest);
			
			if(!temp){
			if (left == true || right == true)
				return true;
			else
				list.removeLast();
			}
		}}
		return false;
	}
	
	static void printPathsRecurdest(int path[], Node node, int pathLen, Node dest) 
    {
        if (node == null)
            return ;
  
        /* append this node to the path array */
        path[pathLen] = node.key;
        pathLen++;
  
        /* it's a leaf, so print the path that lead to here  */
        if (node.key == dest.key){
            printArray(path, pathLen);
            }
        else
        {
            /* otherwise try both subtrees */
        	printPathsRecurdest(path, node.lChild, pathLen, dest);
        	printPathsRecurdest(path, node.rChild, pathLen, dest);
        }
        
    }
	
	//multiple path's
	static void printPathsRecur(Node node, int path[], int pathLen) 
    {
        if (node == null)
            return;
  
        /* append this node to the path array */
        path[pathLen] = node.key;
        pathLen++;
  
        /* it's a leaf, so print the path that led to here  */
        if (node.lChild == null && node.rChild == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printPathsRecur(node.lChild, path, pathLen);
            printPathsRecur(node.rChild, path, pathLen);
        }
    }
  
    /* Utility function that prints out an array on a line. */
    static void printArray(int ints[], int len) 
    {
        int i;
        for (i = 0; i < len; i++) 
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

	public static void main(String[] args) {
		BSTOperations bsTree = new BSTOperations();/* INSERTION */
		Node src = bsTree.insertNode(100, 1); // value part is useless
		bsTree.insertNode(50, 1);
		bsTree.insertNode(150, 1);
		bsTree.insertNode(25, 1);
		bsTree.insertNode(75, 1);
		bsTree.insertNode(10, 1);
		bsTree.insertNode(35, 1);
		bsTree.insertNode(65, 1);
		bsTree.insertNode(85, 1);
		bsTree.insertNode(80, 1);
		bsTree.insertNode(78, 1);
		bsTree.insertNode(120, 1);
		Node dest = bsTree.insertNode(180, 1);
		bsTree.insertNode(76, 1);
		bsTree.insertNode(77, 1);
		// findLCA(bsTree.root, 10, 35);
		// System.out.println(height(bsTree.root));
		// System.out.println("Printing Inorder: ");
		// inOrder(bsTree.root);
		// System.out.println(findDiameter(bsTree.root, 0));
		// levelOrder(bsTree.root);
		LinkedList<Node> list1 = new LinkedList<Node>();
		System.out.println("Printing path: Source: " + src.key + " Destination: " + dest.key);
		for(Node node : getPath(bsTree.root, src, dest))
			System.out.print(node.key + "|");
		System.out.println();
		
		printPathsRecurdest(new int[50], bsTree.root, 0, dest);

	}

}

// Node findLCA(Node node, int n1, int n2) {
// // Base case
// if (node == null)
// return null;
//
// // If either n1 or n2 matches with root's key, report
// // the presence by returning root (Note that if a key is
// // ancestor of other, then the ancestor key becomes LCA
// if (node.key == n1 || node.key == n2)
// return node;
//
// // Look for keys in left and right subtrees
// Node left_lca = findLCA(node.lChild, n1, n2);
// Node right_lca = findLCA(node.rChild, n1, n2);
//
// // If both of the above calls return Non-NULL, then one key
// // is present in once subtree and other is present in other,
// // So this node is the LCA
// if (left_lca != null && right_lca != null)
// return node;
//
// // Otherwise check if left subtree or right subtree is LCA
// return (left_lca != null) ? left_lca : right_lca;
// }