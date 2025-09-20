package Graph.TopoSortAndProblem;
import java.util.*;

public class DirectedGraphCycleBFS {
    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;

        public boolean isCyclic(int V, int[][] edges) {
            // Handle edge cases: null or empty edge list
            if (edges == null || edges.length == 0) {
                return false;
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Initialize in-degree array for all vertices
            int[] inDegree = new int[V];
            // Calculate in-degree for each vertex
            for (int i = 0; i < adjacencyList.size(); i++) {
                for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                    int neighbor = adjacencyList.get(i).get(j);
                    inDegree[neighbor]++;
                }
            }

            // Initialize queue for vertices with in-degree 0
            Queue<Integer> queue = new LinkedList<>();
            // Add vertices with no incoming edges to the queue
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // Count vertices processed in topological sort
            int processedCount = 0;

            // Process queue to simulate topological sort
            while (!queue.isEmpty()) {
                // Remove a vertex from the queue
                int currentVertex = queue.poll();
                // Increment count of processed vertices
                processedCount++;

                // Process all neighbors of the current vertex
                for (int i = 0; i < adjacencyList.get(currentVertex).size(); i++) {
                    int neighbor = adjacencyList.get(currentVertex).get(i);
                    // Decrease in-degree of neighbor
                    inDegree[neighbor]--;

                    // If neighbor's in-degree becomes 0, add to queue
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            // Cycle exists if not all vertices were processed
            return processedCount != V;
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(int[][] edges, int v) {
            // Initialize adjacency list for v vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges to the adjacency list
            for (int i = 0; i < edges.length; i++) {
                int fromVertex = edges[i][0];
                int toVertex = edges[i][1];
                // Add single-directional edge
                adjacencyList.get(fromVertex).add(toVertex);
            }
        }
    }
    public static void main(String[] args) {

    }
}
