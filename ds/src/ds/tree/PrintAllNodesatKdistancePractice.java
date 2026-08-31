package ds.tree;

public class PrintAllNodesatKdistancePractice {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int printNodeKDistance(Node root, Node target, int k) {
		if (root == null)
			return -1;
		if (root == target) {
			printNodedown(target, k);
			return 0;
		}
		int dl = printNodeKDistance(root.left, target, k);
		if (dl != -1) {
			if (dl + 1 == k) {
				System.out.println(root.data);
			} else {
				printNodedown(root.right, k - (dl + 2));
			}
			return dl + 1;
		}
		int dr = printNodeKDistance(root.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.println(root.data);
				return -1;
			} else {
				printNodedown(root.left, k - (dl + 2));
			}
			return dr + 1;
		}
      return -1;
	}

	private static void printNodedown(Node target, int k) {
		if(target == null)
			return;
		if(k == 0) {
			System.out.println(k);
			return;
				}
		printNodedown(target.left, k - 1);
		printNodedown(target.right, k - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
