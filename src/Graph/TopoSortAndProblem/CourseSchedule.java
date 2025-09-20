package Graph.TopoSortAndProblem;
import java.lang.reflect.Array;
import java.util.* ;
public class CourseSchedule {
    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;

        public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
            // Initialize result list for topological order
            ArrayList<Integer> topoOrder = new ArrayList<>();

            // Handle edge case: no vertices
            if (n == 0) {
                return topoOrder;
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(prerequisites, n);

            // Find the topological sort order
            ArrayList<Integer> topoOrderResult = findTopologicalSort(n);

            // Return topological order if all courses can be completed, else empty list
            return topoOrderResult.size() == n ? topoOrderResult : new ArrayList<>();
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(int[][] prerequisites, int V) {
            // Initialize adjacency list for V vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges (from -> to, where to depends on from)
            for (int[] edge : prerequisites) {
                int toVertex = edge[0] - 1; // Adjust for 0-based indexing
                int fromVertex = edge[1] - 1; // Adjust for 0-based indexing
                // Add single-directional edge
                adjacencyList.get(fromVertex).add(toVertex);
            }
        }

        // Performs topological sort to order courses
        private static ArrayList<Integer> findTopologicalSort(int V) {
            // Initialize in-degree array for all vertices
            int[] inDegree = new int[V];

            // Calculate in-degree for each vertex
            calculateInDegree(inDegree);

            // Initialize queue for vertices with no incoming edges
            Queue<Integer> queue = new LinkedList<>();
            // Add vertices with in-degree 0 to the queue
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
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

            // Return the topological order
            return topoOrder;
        }

        // Calculates in-degree for each vertex
        private static void calculateInDegree(int[] inDegree) {
            // Iterate through adjacency list to count incoming edges
            for (int i = 0; i < adjacencyList.size(); i++) {
                for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                    int neighbor = adjacencyList.get(i).get(j);
                    // Increment in-degree for each neighbor
                    inDegree[neighbor]++;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
