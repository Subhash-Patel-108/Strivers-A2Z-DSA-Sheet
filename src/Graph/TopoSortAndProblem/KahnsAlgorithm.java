package Graph.TopoSortAndProblem;
import java.util.* ;
public class KahnsAlgorithm {

    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> graph;

        public static ArrayList<Integer> topoSort(int V, int[][] edges) {
            // Steps of Kahn's Algorithm:
            // 1. Compute in-degree for each vertex (number of incoming edges).
            // 2. Add all vertices with in-degree 0 to a queue.
            // 3. While queue is not empty:
            //    a. Remove a vertex and add it to the result list.
            //    b. Decrease in-degree of all its neighbors by 1.
            //    c. Add neighbors with in-degree 0 to the queue.
            // 4. If result list size is less than V, a cycle exists (not checked here).
            // 5. Return the topological order.

            // Handle edge cases: null or empty edge list
            if (edges == null || edges.length == 0) {
                return new ArrayList<>();
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Initialize in-degree array for all vertices
            int[] inDegree = new int[V];
            // Calculate in-degree for each vertex
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.get(i).size(); j++) {
                    int neighbor = graph.get(i).get(j);
                    inDegree[neighbor]++;
                }
            }

            // Initialize queue for vertices with in-degree 0
            Queue<Integer> queue = new LinkedList<>();
            // Add vertices with no incoming edges to the queue
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // Initialize result list for topological order
            ArrayList<Integer> topoOrder = new ArrayList<>();

            // Process queue to build topological order
            while (!queue.isEmpty()) {
                // Remove a vertex from the queue and add to result
                int currentVertex = queue.poll();
                topoOrder.add(currentVertex);

                // Process all neighbors of the current vertex
                for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                    int neighbor = graph.get(currentVertex).get(i);
                    // Decrease in-degree of neighbor
                    inDegree[neighbor]--;

                    // If neighbor's in-degree becomes 0, add to queue
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }

            // Return the topological order
            return topoOrder;
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(int[][] edges, int v) {
            // Initialize adjacency list for v vertices
            graph = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }

            // Add directed edges to the adjacency list
            for (int i = 0; i < edges.length; i++) {
                int fromVertex = edges[i][0];
                int toVertex = edges[i][1];
                // Add single-directional edge
                graph.get(fromVertex).add(toVertex);
            }
        }
    }
    public static void main(String[] args) {

    }
}
