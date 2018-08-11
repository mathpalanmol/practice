package ds.tree;


//Java program to print Node1s at k distance from root

//Given a root of a tree, and an integer k. Print all the Node1s which are at k distance from root.
//
//For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
//
//            1
//          /   \
//        2      3
//      /  \    /
//    4     5  8 


//traverse subtrees rooted with the target Node1 and decrement k in recursive call. 
//When the k becomes 0, print the Node1 currently being traversed 

class Node1 
{
 int data;
 Node1 left, right;

 Node1(int item) 
 {
     data = item;
     left = right = null;
 }
}

public class PrintKdistanceNodeDown 
{
 Node1 root;

 void printKDistant(Node1 Node1, int k) 
 {
     if (Node1 == null)
         return;
     if (k == 0) 
     {
         System.out.print(Node1.data + " ");
         return;
     } 
     else
     {
         printKDistant(Node1.left, k - 1);
         printKDistant(Node1.right, k - 1);
     }
 }
  
 /* Driver program to test above functions */
 public static void main(String args[]) {
	 PrintKdistanceNodeDown tree = new PrintKdistanceNodeDown();
      
     /* Constructed binary tree is
             1
           /   \
          2     3
         /  \   /
        4    5 8 
     */
     tree.root = new Node1(1);
     tree.root.left = new Node1(2);
     tree.root.right = new Node1(3);
     tree.root.left.left = new Node1(4);
     tree.root.left.right = new Node1(5);
     tree.root.right.left = new Node1(8);

     tree.printKDistant(tree.root, 2);
 }
}

//This code has been contributed by Mayank Jaiswal