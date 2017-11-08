package ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.graph.DAG.Vertex;
//On a graph of n vertices and m edges, using a serial computation, the algorithm above takes Θ(n + m) time.
public class TopologicalSort {

	public void Sort(DAG graph) {
		System.out.println("\n\n TOPOLOGICAL SORT IN PROGRESSS");
		List<Vertex<Integer>> list = graph.getVertexList();//get list of all vertices in the graph
		Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();//create a q
		for (Vertex<Integer> v : list) {
			if (v.inDegree == 0)
				q.add(v);// add vertices with indegree '0' to the q
		}
		while (q.size() != 0) {
			Vertex<Integer> v = q.poll();
			System.out.print(v.key + ", ");
			List<Vertex> adjList = v.getAdjList();
			for (Vertex adjVertex : adjList) { 
				adjVertex.inDegree = adjVertex.inDegree - 1;
				if (adjVertex.inDegree == 0)// after removal of every elment
											// from q atleast one node will have
											// 0 indegree in DAG - True for DAG
					q.add(adjVertex);
			}
		}
	}
}
		
