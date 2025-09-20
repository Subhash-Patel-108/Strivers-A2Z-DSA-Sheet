package Graph.ProblemOnBFSAndDFS;
import java.util.* ;
public class DetectCycleInADirectedGraph {
    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;
        // Tracks vertices visited in the entire DFS traversal
        private static boolean[] visited;
        // Tracks vertices in the current DFS path
        private static boolean[] inCurrentPath;
        // Indicates whether a cycle is detected
        private static boolean hasCycle;

        public boolean isCyclic(int V, int[][] edges) {
            // Handle edge cases: null or empty edge list
            if (edges == null || edges.length == 0) {
                return false;
            }

            // Create the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Initialize arrays to track visited vertices and current path
            visited = new boolean[V];
            inCurrentPath = new boolean[V];
            // Initialize cycle detection flag
            hasCycle = false;

            // Check each unvisited vertex for cycles using DFS
            for (int i = 0; i < V; i++) {
                if (!visited[i] && !hasCycle) {
                    // Start DFS from the current vertex
                    performDFS(i);
                }
            }

            // Return whether a cycle was found
            return hasCycle;
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(int[][] edges, int V) {
            // Initialize adjacency list for V vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges to the adjacency list
            for (int[] edge : edges) {
                int fromVertex = edge[0];
                int toVertex = edge[1];

                // Add single-directional edge
                adjacencyList.get(fromVertex).add(toVertex);
            }
        }

        // Performs DFS to detect cycles in the directed graph
        private static void performDFS(int currentVertex) {
            // Stop if a cycle is already found
            if (hasCycle) {
                return;
            }

            // Mark the current vertex as visited and part of the current path
            visited[currentVertex] = true;
            inCurrentPath[currentVertex] = true;

            // Explore all neighbors of the current vertex
            for (int i = 0; i < adjacencyList.get(currentVertex).size(); i++) {
                int neighbor = adjacencyList.get(currentVertex).get(i);

                // If neighbor is unvisited, continue DFS
                if (!visited[neighbor]) {
                    performDFS(neighbor);
                }
                // If neighbor is in the current path, a cycle is detected
                else if (inCurrentPath[neighbor]) {
                    hasCycle = true;
                    return;
                }
            }

            // Remove the current vertex from the current path upon backtracking
            inCurrentPath[currentVertex] = false;
        }
    }
    public static void main(String[] args) {

    }
}
