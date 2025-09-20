package Graph.TopoSortAndProblem;
import java.util.* ;

public class EventualSafeStates {

    public static class Solution {
        // Adjacency list to store the reversed directed graph
        private static List<List<Integer>> reversedGraph;

        public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            // Handle edge cases: null or empty adjacency list
            if (adj == null || adj.isEmpty()) {
                return new ArrayList<>();
            }

            // Reverse the edges of the graph
            reverseEdges(adj, V);

            // Find safe nodes using topological sort on reversed graph
            List<Integer> safeNodes = topoSort(V);
            // Sort the result for ascending order
            Collections.sort(safeNodes);
            // Return the list of safe nodes
            return safeNodes;
        }

        // Reverses the edges of the original graph
        private static void reverseEdges(List<List<Integer>> adj, int V) {
            // Initialize adjacency list for reversed graph
            reversedGraph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                reversedGraph.add(new ArrayList<>());
            }

            // Add reversed edges (from vertex2 to vertex1)
            for (int i = 0; i < adj.size(); i++) {
                for (int j = 0; j < adj.get(i).size(); j++) {
                    int fromVertex = i;
                    int toVertex = adj.get(i).get(j);
                    // Add edge in reverse direction
                    reversedGraph.get(toVertex).add(fromVertex);
                }
            }
        }

        // Performs topological sort using Kahn's algorithm to find safe nodes
        private static List<Integer> topoSort(int V) {
            // Steps of Kahn's Algorithm:
            // 1. Compute in-degree for each vertex (number of incoming edges in reversed graph).
            // 2. Add all vertices with in-degree 0 to a queue.
            // 3. While queue is not empty:
            //    a. Remove a vertex and add it to the result list.
            //    b. Decrease in-degree of all its neighbors by 1.
            //    c. Add neighbors with in-degree 0 to the queue.
            // 4. The result list contains safe nodes (vertices not part of or leading to cycles).
            // 5. Return the result list.

            // Initialize result list for safe nodes
            List<Integer> safeNodes = new ArrayList<>();

            // Initialize in-degree array for all vertices
            int[] inDegree = new int[V];
            // Calculate in-degree for each vertex in reversed graph
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < reversedGraph.get(i).size(); j++) {
                    int neighbor = reversedGraph.get(i).get(j);
                    inDegree[neighbor]++;
                }
            }

            // Initialize queue for vertices with in-degree 0
            Queue<Integer> queue = new LinkedList<>();
            // Add vertices with no incoming edges to the queue
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // Process queue to build list of safe nodes
            while (!queue.isEmpty()) {
                // Remove a vertex from the queue and add to result
                int currentVertex = queue.poll();
                safeNodes.add(currentVertex);

                // Process all neighbors of the current vertex
                for (int i = 0; i < reversedGraph.get(currentVertex).size(); i++) {
                    int neighbor = reversedGraph.get(currentVertex).get(i);
                    // Decrease in-degree of neighbor
                    inDegree[neighbor]--;

                    // If neighbor's in-degree becomes 0, add to queue
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            // Return the list of safe nodes
            return safeNodes;
        }
    }

    public static void main(String[] args) {

    }
}
