package ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

	static class Node {
		int key;
		LinkedList<Node> adjacents = new LinkedList<Node>();

		Node(int key) {
			this.key = key;
		}
	}

	public static void main(String[] args) {
		Graph graph1 = new Graph();
		Node start = graph1.create();
	    graph1.bfs(start);
	    System.out.println();
		graph1.dfs(start);
	}

	// return start node.... it can be any node... in our example it's node 1
	private Node create() {

		Node n1 = new Node(1);
		nodeLookUp.put(1, n1);
		Node n2 = new Node(2);
		nodeLookUp.put(2, n2);
		Node n3 = new Node(3);
		nodeLookUp.put(3, n3);
		Node n4 = new Node(4);
		nodeLookUp.put(4, n4);
		Node n5 = new Node(5);
		nodeLookUp.put(5, n5);
		Node n6 = new Node(6);
		nodeLookUp.put(6, n6);
		Node n7 = new Node(7);
		nodeLookUp.put(7, n7);
		Node n8 = new Node(8);
		nodeLookUp.put(8, n8);
		Node n9 = new Node(9);
		nodeLookUp.put(9, n8);
		// create 3X3 matrix. moves allowed: left, right, up and down
		setEdge(n1, n2);
		setEdge(n1, n4);
		setEdge(n2, n3);
		setEdge(n3, n6);
		setEdge(n2, n5);
		setEdge(n4, n1);
		setEdge(n4, n5);
		setEdge(n4, n7);
		setEdge(n5, n6);
		setEdge(n5, n8);
		setEdge(n5, n4);
		setEdge(n5, n2);
		setEdge(n7, n8);
		setEdge(n7, n4);
		setEdge(n6, n3);
		setEdge(n6, n5);
		setEdge(n6, n9);
		setEdge(n8, n9);
		setEdge(n8, n7);
		setEdge(n8, n5);

		return n1;

	}

	Node getNode(int key) {
		if (nodeLookUp.containsKey(key)) {
			return nodeLookUp.get(key);
		}
		return null;
	}

	void setEdge(Node source, Node dest) {
		source.adjacents.add(dest); // directed Graph // one way
	}

	public void bfs(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		q.add(start);
		while (!q.isEmpty()) {
			Node current = q.poll();
			if (visited.contains(current))
				continue;
			System.out.print(current.key + " --> ");
			visited.add(current);
			for (Node node : current.adjacents) {
				q.add(node);
			}
		}
	}

	HashSet<Node> set = new HashSet<Node>();

	public void dfs(Node start) {
		if (start == null)
			return;
		else {
			if (!set.contains(start)) {
				set.add(start);
				System.out.print(start.key + " --> ");
				for (Node node : start.adjacents) {
					dfs(node);
				}

			}
		}

	}

}
