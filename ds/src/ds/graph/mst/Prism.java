package ds.graph.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//PRIMS ALGO : 
// connected directed(uni or bi) graph with no cycle forms spanning tree
// MST is a subgraph of a graph with equal no of nodes both one less edge
// Set of edges that contains all the vertex with minimum weight.
//Minimum Spanning Tree: Visit every node in a graph with minimum distance possible.
//The standard application is to a problem like phone network design. 
//You have a business with several offices; you want to lease phone lines to connect them up with each other; 
//and the phone company charges different amounts of money to connect different pairs of cities.

// Graph should be connected it can have cycles. edges should contain weights.

//
//Prim’s algorithm is a greedy
//algorithm that finds a minimum spanning tree for a connected weighted undirected graph.

//Does the minimum spanning tree of a graph give the shortest distance between any 2 specified nodes?
//No. The Minimal spanning tree assures that the total weight of the tree is kept at its minimum.
//But it doesn't mean that the distance between any two nodes involved in the minimum-spanning tree is minimum
public class Prism {

	Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
	PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.weight - e2.weight;
		}
	});

	class Vertex<k> {
		k key;
		boolean isVisited; // it is considered as visited if all it's adjacents are visited.
		private List<Edge> edges = new ArrayList<Edge>();

		Vertex(k key) {
			this.key = key;
			map.put((int) key, this);
		}

		public boolean isVisited() {
			return isVisited;
		}

		public List<Edge> getAdjacents() {
			return edges;
		}

	}

	class Edge {
		Vertex to;
		Vertex from;
		int weight;

		Edge(Vertex to, Vertex from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
	}

	public void setVertex(int key) {
		Vertex<Integer> newVertex = new Vertex<Integer>(key);
		map.put(key, newVertex);
	}

	public void setEdge(int to, int from, int weight) {
		Vertex v1 = map.get(to);
		Vertex v2 = map.get(from);
		Edge edge = new Edge(v1, v2, weight);
		v1.getAdjacents().add(edge); // v1--> v2
		// v2.adjList.add(v1);
	}
	// standard steps
	// The steps for implementing Prim's algorithm are as follows:
	// Initialize the minimum spanning tree with a vertex chosen at random.
	// check the connecting vertices and choose the minimum and add it to the list.
	// Keep repeating step 2 until we get a minimum spanning tree
	// done

	// : Start with any node in a graph;
	// Scan unvisited adjacent nodes with minimum weight.
	// let say b and c is neighbour of a. choose b or c based on minimum weight and
	// mark visited to every chosen node.
	// let suppose edge weight from a to c was minimum. now to move ahead you need
	// to check both a and c unvisited neighbour. mark c as visited.


	public int process(Vertex vertex) {
		vertex.isVisited = true; // starting vertex mark it to true and put the adj edges in q.
		List<Edge> edges = vertex.getAdjacents();
		for (Edge edge : edges) {
			q.add(edge);
		}
		int sum = 0;
		while (q.size() != 0) { 
			Edge e = q.poll(); // it will always give the min weight edge among the visited vertex edges.
			sum += e.weight;
			Vertex v = e.from;
			v.isVisited = true;
			List<Edge> edges1 = v.getAdjacents();
			for (Edge edge : edges1) {
				if (!edge.from.isVisited)// discart visited vertices.
					q.add(edge);
			}

		}
		return sum;

	}

	public static void main(String[] args) {
		Prism obj = new Prism();
		obj.setVertex(1);
		obj.setVertex(2);
		obj.setVertex(3);
		obj.setVertex(4);
		obj.setVertex(5);
		obj.setVertex(6);
		// obj.setVertex(7);
		obj.setEdge(1, 3, 1); // to, from, weight
		obj.setEdge(1, 4, 1);
		obj.setEdge(3, 5, 1);
		obj.setEdge(5, 4, 1);
		// obj.setEdge(2, 4, 1);
		obj.setEdge(5, 6, 2);
		obj.setEdge(6, 2, 1);

		// obj.mst(1);
		int cost = obj.process(obj.map.get(1));
		System.out.println("cost: " + cost);

	}
	
	

}

/*private void mst(int i) {
	Vertex vertex = map.get(i);
	List<Vertex> list = new ArrayList<Vertex>();
	list.add(vertex);
	int minCost = 0;
	while (list.size() != 0) {
		Result result = getNextAdjacent(list);// return nu
		minCost += result.weight;
		if (result.v != null)
			list.add(result.v); // from: is the node we have choosen

	}
	System.out.println("Min cost: " + minCost);
}

public class Result implements Comparable {
	int weight;
	Vertex v;

	public Result(int weight, Vertex v) {
		super();
		this.weight = weight;
		this.v = v;
	}

	@Override
	public int compareTo(Object o) { // Increasing Order
		return ((Result) o).weight - weight;
	}

}

private Result getNextAdjacent(List<Vertex> list) {
	List<Result> outList = new ArrayList<Result>();
	for (Vertex v : list) {
		Edge edge = getMinEdge(v.getAdjacents());
		if (edge == null) {
			list.remove(v);
		}
		edge.from.isVisited = true;
		Result res = new Result(edge.weight, edge.from);
		outList.add(res);
	}
	Collections.sort(outList);
	if (outList.size() >= 1)
		return outList.get(0);
	else
		return null;
}

private Edge getMinEdge(List<Edge> adjacents) {
	Edge e = null;
	int min = Integer.MAX_VALUE;
	for (Edge edge : adjacents) {
		if (!edge.from.isVisited) {
			if (edge.weight < min) {
				min = edge.weight;
				e = edge;
			}
		}
	}
	return e;
}

private boolean isVisited(Vertex to) {
	List<Edge> adjacents = to.getAdjacents();

	for (Edge edge : adjacents) {
		Vertex v = edge.from;
		if (!v.isVisited) {
			return false;
		}
	}
	return true;
}

private HashSet getVertices() {
	HashSet<Vertex> vertices = new HashSet<Vertex>();
	for (Entry<Integer, Vertex> entry : map.entrySet()) {
		vertices.add(entry.getValue());
	}
	return vertices;
}*/




