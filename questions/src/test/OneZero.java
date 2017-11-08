package test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OneZero {
	static Node rt = null;

	public static void main(String[] args) {
		BigInteger capacity = new BigInteger("1000000000000000000000");
		Node root = new Node(new BigInteger("1"));
		createTree(root, capacity);
		Scanner scan = new Scanner(System.in);
		int opCount = scan.nextInt();
		for (int index = 0; index < opCount; index++) {
			BigInteger input = scan.nextBigInteger();
			BigInteger bfs = bfs(input);
			if(bfs == null){
			while(true){
				rt = null;
				System.gc();
				root = new Node(capacity);
				capacity = root.key.multiply(new BigInteger("10000"));
				createTree(root, capacity);
				bfs = bfs(input);
				if(bfs != null)
					break;
			}
			}
			System.out.println(bfs(input));
		}

	}

	private static void createTree(Node root, BigInteger capacity) {
		
		rt = root;
	
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while (root.key.multiply(new BigInteger("10")).compareTo(capacity)<0) {
			root = q.poll();
			Node left = new Node(root.key.multiply(new BigInteger("10")));
			Node right = new Node(root.key.multiply(new BigInteger("10")).add(new BigInteger("1")));
			q.add(left);
			q.add(right);
			root.lChild = left;
			root.rChild = right;
		}
		

	}

	static private BigInteger bfs(BigInteger input) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(rt);
		BigInteger result = null;
		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current.key.mod(input).longValue() == 0) {
				result = current.key;
				return result;
			}
			if (current.lChild == null && current.rChild == null) {
//				System.out.println("Root: " + current.key);
				break;
			}
//			System.out.println("Root: " + current.key + " Left: " + current.lChild.key + " Right: " + current.rChild.key);
			if (current.lChild != null)
				q.add(current.lChild);
			if (current.rChild != null)
				q.add(current.rChild);
		}
		q.clear();
		return result;
	}

	static class Node {
		BigInteger key;
		Node lChild;
		Node rChild;

		Node(BigInteger key) {
			this.key = key;
		}
	}

}
