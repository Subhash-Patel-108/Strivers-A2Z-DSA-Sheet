package Graph.ProblemOnBFSAndDFS;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphUsingDFS {
    public class Solution {
        // Tracks visited vertices during DFS
        private static boolean[] visited;
        // Stores the graph as an adjacency list
        private static ArrayList<ArrayList<Integer>> graph;
        // Indicates whether a cycle has been detected
        private static boolean cycleDetected;

        public boolean isCycle(int V, int[][] edges) {
            // Handle edge case: null or empty edge list
            if (edges == null || edges.length == 0) {
                return false;
            }

            // Initialize adjacency list for V vertices
            graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // Build undirected graph by adding edges
            for (int i = 0; i < edges.length; i++) {
                // Get vertices from edge (no adjustment needed as input is 0-based)
                int vertex1 = edges[i][0];
                int vertex2 = edges[i][1];

                // Add bidirectional edges to adjacency list
                graph.get(vertex1).add(vertex2);
                graph.get(vertex2).add(vertex1);
            }

            // Initialize visited array and cycle flag
            visited = new boolean[V];
            cycleDetected = false;

            // Check each unvisited vertex for cycles using DFS
            for (int vertex = 0; vertex < V; vertex++) {
                if (!visited[vertex] && !cycleDetected) {
                    // Start DFS from the current vertex with no parent (-1)
                    performDFS(vertex, -1);
                }
            }
            // Return whether a cycle was found
            return cycleDetected;
        }

        // Performs DFS to detect cycles in the graph
        private static void performDFS(int currentVertex, int parentVertex) {
            // Stop further exploration if a cycle is already found
            if (cycleDetected) {
                return;
            }

            // Mark the current vertex as visited
            visited[currentVertex] = true;

            // Explore all neighbors of the current vertex
            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                int neighbour = graph.get(currentVertex).get(i);

                // If the neighbour is visited and not the parent, a cycle is detected
                if (visited[neighbour] && parentVertex != neighbour) {
                    cycleDetected = true;
                    return;
                }

                // If neighbour is unvisited, continue DFS
                if (!visited[neighbour]) {
                    performDFS(neighbour, currentVertex);
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
