package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Direct Acyclic graph = no cycle + directional
public class DAG {

	//map contains key as node key and values as list of adjacent nodes
	//to facilitate search of Vertex object using keys.
	private Map<Integer, Vertex<Integer>> vList = new HashMap<Integer, Vertex<Integer>>();

	public class Vertex<k> {
		public k key;
		public int inDegree = 0; // For DAG; 0: no incoming 
//		int outDegree = 0;// For DAG; 0: no outgoing  // in this example we are not updating outdegree.
		List<Vertex> adjList = new ArrayList<Vertex>();

		Vertex(k key) {
			this.key = key;
		}

		public List<Vertex> getAdjList() {
			return adjList;
		}

	}

	class Edge<v> {
		v to;
		v from;

		Edge(v to, v from) {
			this.to = to;
			this.from = from;
		}
	}

	public List<Vertex<Integer>> getVertexList() {
		List<Vertex<Integer>> list = new ArrayList<Vertex<Integer>>();
		for (Vertex<Integer> vertex : vList.values())
			list.add(vertex);
		return list;
	}

	public Vertex getvertex(int key) {
		return vList.get(key);
	}

	public Vertex addVertex(int key) {
		Vertex<Integer> newVertex = new Vertex<Integer>(key);
		vList.put(key, newVertex);
		return newVertex;
	}

	public void addEdges(int to, int from) {
		Vertex v1 = getvertex(to);
		Vertex v2 = getvertex(from);
		Edge<Vertex> newEdge = new Edge<Vertex>(v1, v2);
		v1.adjList.add(v2);
		v2.inDegree = v2.inDegree + 1; // v2 is adjacent to v1, i.e v1-->v2
		// v2.eList.add(v1); enable it for bi-directional graph
	}

	public int getInDegree(Vertex v) {
		return v.inDegree;
	}

	public int getOutDegree(Vertex v) {
		return v.adjList.size();
	}

	public static void main(String[] args) {
		DAG graph = new DAG();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		// graph.addVertex(7);
		graph.addEdges(1, 3);
		graph.addEdges(1, 4);
		graph.addEdges(3, 5);
		graph.addEdges(5, 4);
		graph.addEdges(2, 4);
		graph.addEdges(2, 6);
		graph.addEdges(6, 5);

		graph.print();
		TopologicalSort tpsort = new TopologicalSort();
		tpsort.Sort(graph);

	}

	private void print() {
		for (Vertex<Integer> vertex : vList.values()) {
			System.out.print(
					"Key: " + vertex.key + " Indegree: " + getInDegree(vertex) + " Outdegree: " + getOutDegree(vertex));
			int count = 0;
			for (Vertex v : vertex.adjList) {
				System.out.print("  Adjacent: (" + ++count + "):  " + v.key);
			}

			System.out.println();
		}

	}

}
