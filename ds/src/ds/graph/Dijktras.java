package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Graph contains vertex and edges
//TODO WEIGHTED GRAPH
//TODO Dijiktras Algrorithm
//1, pick any vetex 
//2. take it's edge and put it in priority q (min heap sorted by weight)
//3. pop the elments one by one and update every vertex temp weight. if less weight is found(tempedge.from.weight + edge_weight < current_weight)
//4. stop when queue is empty
public class Dijktras {
	Map<Integer, Vertex> vertexs = new HashMap<Integer, Vertex>();
	// Map<Integer, Edge> edges = new HashMap<Integer, Edge>();

	class Vertex {
		int key;
		int tempweight;
		boolean isVisited;
		// int weight;
		List<Edge> edges = new ArrayList<Edge>();

		Vertex(int key) {
			this.key = key;
		}

		public List<Edge> getList() {
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
		Vertex vertex = new Vertex(key);
		vertexs.put(key, vertex);
	}

	public Vertex getVertex(int key) {
		return vertexs.get(key);
	}

	public void setEdge(int to, int from, int weight) {
		Vertex v1 = getVertex(to);
		Vertex v2 = getVertex(from);
		Edge e1 = new Edge(v1, v2, weight);
		Edge e2 = new Edge(v2, v1, weight);
		v1.getList().add(e1);
		v2.getList().add(e2);
	}
  //anmol.m
	int shortestDistance(int to, int from) {
		// Maintain an array of vertex to add/update vertices. Update tempweight if vertex exist in the list.
		List<Vertex> vertexList = new ArrayList<Vertex>();
		Vertex start = getVertex(to);
		Vertex end = getVertex(from);
		while (start != null) {
			start.isVisited = true;
			System.out.println("Start: " + start.key);
			System.out.println("End " + end.key);
			if (start.key == end.key)
				return start.tempweight;
			List<Edge> edges = start.getList();
			if (edges.size() > 0) {
				for (Edge edge : edges) {
					
						Vertex v1 = edge.from;
						if (v1.isVisited == false) { // create a seperate arraylist to check if the node is visited or not. 
							if (vertexList.contains(v1)) {//if visited we need to check if the weight of start(temp) and edge is less than visting node. if yes update it's tempweight value.
								if ((start.tempweight + edge.weight) < v1.tempweight)
									v1.tempweight = start.tempweight + edge.weight;
							} else {
								v1.tempweight = start.tempweight + edge.weight;
								vertexList.add(v1);
							}
						}
					
				}

				start = getSource(vertexList);

			}
		}
		return -1;
	}

	// public void setEdge(int key1, int key2) {
	// Vertex a = nodes.get(key1);
	// Vertex b = nodes.get(key2);
	// a.getList().add(b);
	// b.getList().add(a);
	// }

	// public void print1(){
	// for(Vertex vertex: nodes.values()){
	// System.out.print("\nNode: " + vertex.key+ "(" + vertex + ")");
	// System.out.println("\nAdjacent List: ");
	// for(Vertex adjs : vertex.getList()){
	// System.out.print(" " + adjs.key + "(" + adjs + ")");
	// }
	// }
	// }

	private Vertex getSource(List<Vertex> vertexList) {
		Vertex source = null;
		int count = Integer.MAX_VALUE;
		if (vertexList.size() > 0) {
			for (Vertex vertex : vertexList) {
				if ((!vertex.isVisited) && vertex.tempweight < count) {
					count = vertex.tempweight;
					source = vertex;
				}
			}
		}

		return source;
	}

	// public void print() {
	// for (Vertex vertex : nodes.values()) {
	// System.out.print("\nNode: " + vertex.key + "(" + vertex + ")");
	// System.out.println("\nAdjacent List: ");
	// for (Vertex adjs : vertex.getList()) {
	// System.out.print(" " + adjs.key + "(" + adjs + ")");
	// }
	// }
	// }

	public static void main(String[] args) {
		Dijktras graph = new Dijktras();
		graph.setVertex(1);
		graph.setVertex(2);
		graph.setVertex(3);
		graph.setVertex(4);
		graph.setVertex(5);
		graph.setEdge(1, 2, 2);
		graph.setEdge(1, 3, 3);
		graph.setEdge(2, 4, 3);
		graph.setEdge(3, 4, 1);
//		graph.setEdge(4, 5, 4);
//		graph.setEdge(2, 5, 3);

		int distance = graph.shortestDistance(1, 4);
		System.out.println(distance);

	}

}
