package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

//Question link https://www.gohired.in/2018/02/23/diagonal-traversal-of-binary-tree/

public class TreeDiagonalTraversal {

	private void traverseDiagonal(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node nod = q.poll();
			System.out.print(nod.value + "-->");
			if (nod.lChild != null)
				q.add(nod.lChild);
			if (nod.rChild != null) {
				System.out.println(nod.rChild.value + "-->");
				if (nod.rChild.lChild != null)
					q.add(nod.lChild);
				if (nod.rChild != null) {
					System.out.println(nod.rChild.rChild.value + "-->");
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
