package ds.tree;

//Given a binary tree, a target Node2 in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target Node2. No parent pointers are available.
//
//BinaryTree
//
//    Consider the tree shown in diagram
//
//    Input: target = pointer to Node2 with data 8.
//    root = pointer to Node2 with data 20.
//    k = 2.
//    Output : 10 14 22
//
//    If target is 14 and k is 3, then output
//    should be “4 20”

// for diagram https://www.geeksforgeeks.org/print-nodes-distance-k-given-Node2-binary-tree/


//Java program to print all nodes at a distance k from given Node2



//There are two types of nodes to be considered.
//1) Nodes in the subtree rooted with target node. For example if the target node is 8 and k is 2, then such nodes are 10 and 14.
//2) Other nodes, may be an ancestor of target, or a node in some other subtree. For target node 8 and k is 2, the node 22 comes in this category.
//
//Finding the first type of nodes is easy to implement. 
//Just traverse subtrees rooted with the target node and decrement k in recursive call. 
//When the k becomes 0, print the node currently being traversed (See this for more details). 
//Here we call the function as printkdistanceNodeDown().
//
//How to find nodes of second type? For the output nodes not lying in the subtree with the target node as the root, we must go through all ancestors. For every ancestor, 
//		we find its distance from target node, let the distance be d, now we go to other subtree 
//		(if target was found in left subtree, then we go to right subtree and vice versa) of the ancestor 
//		and find all nodes at k-d distance from the ancestor.

//A binary tree Node2
class Node2 
{
 int data;
 Node2 left, right;

 Node2(int item) 
 {
     data = item;
     left = right = null;
 }
}

public class PrintAllNodesatKdistance 
{
 Node2 root;
 /* Recursive function to print all the nodes at distance k in
    tree (or subtree) rooted with given root. */

 void printkdistanceNodeDown(Node2 Node2, int k) 
 {
     // Base Case
     if (Node2 == null || k < 0)
         return;

     // If we reach a k distant Node2, print it
     if (k == 0) 
     {
         System.out.print(Node2.data);
         System.out.println("");
         return;
     }

     // Recur for left and right subtrees
     printkdistanceNodeDown(Node2.left, k - 1);
     printkdistanceNodeDown(Node2.right, k - 1);
 }

 // Prints all nodes at distance k from a given target Node2.
 // The k distant nodes may be upward or downward.This function
 // Returns distance of root from target Node2, it returns -1
 // if target Node2 is not present in tree rooted with root.
 int printkdistanceNode(Node2 Node2, Node2 target, int k) 
 {
     // Base Case 1: If tree is empty, return -1
     if (Node2 == null)
         return -1;

     // If target is same as root.  Use the downward function
     // to print all nodes at distance k in subtree rooted with
     // target or root
     if (Node2 == target) 
     {
         printkdistanceNodeDown(Node2, k);
         return 0;
     }

     // Recur for left subtree
     int dl = printkdistanceNode(Node2.left, target, k);

     // Check if target Node2 was found in left subtree
     if (dl != -1) 
     {
           
         // If root is at distance k from target, print root
         // Note that dl is Distance of root's left child from 
         // target
         if (dl + 1 == k) 
         {
             System.out.print(Node2.data);
             System.out.println("");
         }
           
         // Else go to right subtree and print all k-dl-2 distant nodes
         // Note that the right child is 2 edges away from left child
         else
             printkdistanceNodeDown(Node2.right, k - (dl + 2));

         // Add 1 to the distance and return value for parent calls
         return 1 + dl;
     }

     // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
     // Note that we reach here only when Node2 was not found in left 
     // subtree
     int dr = printkdistanceNode(Node2.right, target, k);
     if (dr != -1) 
     {
         if (dr + 1 == k) 
         {
             System.out.print(Node2.data);
             System.out.println("");
         } 
         else
             printkdistanceNodeDown(Node2.left, k - (dr + 2));
         return 1 + dr;
     }

     // If target was neither present in left nor in right subtree
     return -1;
 }

 // Driver program to test the above functions
 public static void main(String args[]) 
 {
	 PrintAllNodesatKdistance tree = new PrintAllNodesatKdistance();

     /* Let us construct the tree shown in above diagram */
     tree.root = new Node2(20);
     tree.root.left = new Node2(8);
     tree.root.right = new Node2(22);
     tree.root.left.left = new Node2(4);
     tree.root.left.right = new Node2(12);
     tree.root.left.right.left = new Node2(10);
     tree.root.left.right.right = new Node2(14);
     Node2 target = tree.root.left.right;
     tree.printkdistanceNode(tree.root, target, 2);
 }
}

//This code has been contributed by Mayank Jaiswal