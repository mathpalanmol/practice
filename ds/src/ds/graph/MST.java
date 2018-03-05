package ds.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//PRIMS ALGO : 
// Set of edges that contains all the vertex with minimum weight.
//Minimum Spanning Tree: Visit every node in a graph with minimum distance possible.
//The standard application is to a problem like phone network design. 
//You have a business with several offices; you want to lease phone lines to connect them up with each other; 
//and the phone company charges different amounts of money to connect different pairs of cities.

// Graph should be connected it can have cycles. edges should contain weights.


//Does the minimum spanning tree of a graph give the shortest distance between any 2 specified nodes?
//No. The Minimal spanning tree assures that the total weight of the tree is kept at its minimum.
//But it doesn't mean that the distance between any two nodes involved in the minimum-spanning tree is minimum
public class MST {

	Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();

	class Vertex<k> {
		k key;
		boolean isVisited;
		PriorityQueue<Edge> adjList = new PriorityQueue<Edge>(new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		Vertex(k key) {
			this.key = key;
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
		v1.adjList.add(edge);
//		v2.adjList.add(v1);
	}

	// Prism: Start with any node in a graph; 
	// Scan unvisited adjacent nodes with minimum weight.
	// let say b and c is neighbour of a. choose b or c based on minimum weight and mark a as visited.
	// let suppose edge weight from a to c was minimum. now to move ahead you need to check both a and c unvisited neighbour. mark c as visited.

	public void mst(int key) {
		Vertex start = map.get(key);
		// PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		//put start node in arraylist
		List<Vertex> vList = new ArrayList<Vertex>();
		vList.add(start);
		start.isVisited = true;
		System.out.print(start.key);
		while (vList.size() != map.size()) {
			Edge e = null;
			Vertex vtemp = null;
			int count = Integer.MAX_VALUE;
			for (Vertex v : vList) {
				Edge e1 = (Edge) v.adjList.peek();
				while(e1 != null && e1.from.isVisited != false){
					v.adjList.poll();
					e1 = (Edge) v.adjList.peek();
					if(e1 == null)
						break;
				}
				if (e1 != null && e1.weight < count && e1.from.isVisited == false) {
					vtemp = v;
					count = e1.weight;
					e = e1;
				}
			}

			if (e != null && e.from.isVisited == false) {
				vList.add(e.from);
				e.from.isVisited = true;
				System.out.print(e.from.key);
			}
			if(vtemp != null)
				vtemp.adjList.poll();
		}
	}
public static void main(String[] args) {
	MST obj = new MST();
	obj.setVertex(1);
	obj.setVertex(2);
	obj.setVertex(3);
	obj.setVertex(4);
	obj.setVertex(5);
	obj.setVertex(6);
	// obj.setVertex(7);
	obj.setEdge(1, 3, 1);
	obj.setEdge(1, 4, 1);
	obj.setEdge(3, 5, 1);
	obj.setEdge(5, 4, 1);
//	obj.setEdge(2, 4, 1);
	obj.setEdge(5, 6, 2);
	obj.setEdge(6, 2, 1);
	
	obj.mst(1);

	
}
}
