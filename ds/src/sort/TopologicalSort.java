package sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.graph.DAG;
//A topological sort or topological ordering of a directed graph is a linear ordering of its vertices
//such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering. 
//A topological ordering is possible if and only if the graph has no directed cycles,
//The canonical application of topological sorting is in scheduling a sequence of jobs or tasks based on their dependencies. 
//The jobs are represented by vertices, and there is an edge from x to y if job x must be completed before job y can be started 
public class TopologicalSort {

	public void Sort(DAG graph) {
		System.out.println("\n\n TOPOLOGICAL SORT IN PROGRESSS");
		List<DAG.Vertex<Integer>> list = graph.getVertexList();
		Queue<DAG.Vertex<Integer>> q = new LinkedList<DAG.Vertex<Integer>>();
		for (DAG.Vertex<Integer> v : list) {
			if (v.inDegree == 0)
				q.add(v);
		}
		while (q.size() != 0) {
			DAG.Vertex<Integer> v = q.poll();
			System.out.print(v.key + ", ");
			List<DAG.Vertex> adjList = v.getAdjList();
			for (DAG.Vertex adjVertex : adjList) {
				adjVertex.inDegree = adjVertex.inDegree - 1;
				if (adjVertex.inDegree == 0)// after removal of every element
											// from q atleast one node will have
											// 0 indegree in DAG
					q.add(adjVertex);
			}
		}
	}

}
