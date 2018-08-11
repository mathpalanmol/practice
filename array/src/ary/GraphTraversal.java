package ary;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

	static List<Vertex> vList = new ArrayList<Vertex>();

	static void setEdge(Vertex v1, Vertex v2) {
		v1.getAdjList().add(v2); // undirected
		v2.getAdjList().add(v1); // undirected
	}

	// level by level
	public void traverseBFS(Vertex start) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(start);// add first element
		start.visited = true;
		System.out.println("BFS:");
		while (!q.isEmpty()) {
			Vertex vertex = q.poll();
			System.out.print(vertex.key + " ");
			for (Vertex adj : vertex.getAdjList()) {
				if (adj.visited)
					continue;
				adj.visited = true;
				q.offer(adj);
			}
		}
		for (Vertex v : vList)
			v.visited = false;// reset after traverse
	}

	public void traverseDFS(Vertex start) {
		if (start.visited == false) {
			start.visited = true;
			System.out.println(start.key);
			for (Vertex vertex : start.adjList) {
				traverseDFS(vertex);
			}
		}
	}

	public void path(Vertex source, Vertex target) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		Queue<Vertex> path = new LinkedList<Vertex>();
		q.offer(source);
		source.visited = true;
		while (!q.isEmpty()) {
			Vertex vertex = q.poll();
			path.add(vertex);
			for (Vertex v : vertex.getAdjList()) {
				if (v == target) {
					System.out.println("\nPrinting Distance and path:");

					print(path, target);// 0r v
					v.visited = false;// so that target can be searched further.
										// target can have more than one
										// inbounds.
					v.distance = vertex.distance + 1;
					System.out.println("Distance: " + v.distance);
					System.out.println("***************************");
					continue;
				}
				if (v.visited)
					continue;
				v.visited = true;
				v.distance = vertex.distance + 1;
				q.offer(v);

			}
		}
	}

	private void print(Queue<Vertex> path, Vertex target) {
		for (Vertex vertex : path)
			System.out.print(vertex.key + " ");
		System.out.print(target.key);
		System.out.println();
	}

	public static void main(String[] args) {
		GraphTraversal traversal = new GraphTraversal();
		Vertex v1 = new Vertex(1);
		vList.add(v1);
		Vertex v2 = new Vertex(2);
		vList.add(v2);
		Vertex v3 = new Vertex(3);
		vList.add(v3);
		Vertex v4 = new Vertex(4);
		vList.add(v4);
		Vertex v5 = new Vertex(5);
		vList.add(v5);
		Vertex v6 = new Vertex(6);
		vList.add(v6);
		Vertex v7 = new Vertex(7);
		vList.add(v7);
		Vertex v8 = new Vertex(8);
		vList.add(v8);
		setEdge(v1, v2);
		setEdge(v1, v3);
		setEdge(v1, v8);
		setEdge(v2, v4);
		setEdge(v2, v5);
		setEdge(v3, v4);
		setEdge(v3, v7);
		setEdge(v4, v5);
		setEdge(v4, v7);
		setEdge(v4, v6);
		setEdge(v6, v8);
		setEdge(v7, v8);
		// traversal.traverseBFS(v1);
		// traversal.path(v1, v8);
		traversal.traverseDFS(v1);
	}

}

class Vertex {
	int key;
	boolean visited;
	List<Vertex> adjList = new ArrayList<Vertex>();
	int distance;

	Vertex(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public List<Vertex> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<Vertex> adjList) {
		this.adjList = adjList;
	}

}
