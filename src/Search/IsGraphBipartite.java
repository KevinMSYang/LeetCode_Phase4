//Question:785
//There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
//
//There are no self-edges (graph[u] does not contain u).
//There are no parallel edges (graph[u] does not contain duplicate values).
//If v is in graph[u], then u is in graph[v] (the graph is undirected).
//The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
//A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
//
//Return true if and only if it is bipartite.
//
// 
//
//Example 1:
//
//
//Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//Output: false
//Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
//Example 2:
//
//
//Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//Output: true
//Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

package Search;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	final int GREEN = 1;
	final int RED = 2;
	final int UN_VISITED = 0;
	
	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] seen = new int[n];
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			if (seen[i] != UN_VISITED) continue;
			
			q.add(i);
			seen[i] = GREEN;
			
			while (!q.isEmpty()) {
				Integer node = q.poll();
				int[] connectNode = graph[node];
				int curColor = seen[node];
				int targetColor = curColor == RED? GREEN : RED;
				
				for (int v : connectNode) {
					if (seen[v] == curColor) return false;
					if (seen[v] == UN_VISITED) {
						q.add(v);
						seen[v] = targetColor;
					}
				}
			}
		}
		return true;
	}
}
