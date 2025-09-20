package Graph.TopoSortAndProblem;

import java.util.*;

public class PrerequisiteTask {

    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;

        public static boolean prerequisiteTask(int[][] dependency, int n, int m) {
            // Handle edge cases: null dependencies or no edges
            if (dependency == null || m == 0) {
                return true;
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(dependency, n);

            // Find the number of tasks in topological sort
            int completedTasks = findTopoSort(n);

            // Return true if all tasks can be completed (no cycle)
            return completedTasks == n;
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(int[][] dependency, int V) {
            // Initialize adjacency list for V vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges (from -> to, where to depends on from)
            for (int[] edge : dependency) {
                int toVertex = edge[0] - 1; // Adjust for 0-based indexing
                int fromVertex = edge[1] - 1; // Adjust for 0-based indexing
                // Add single-directional edge
                adjacencyList.get(fromVertex).add(toVertex);
            }
        }

        // Performs topological sort using Kahn's algorithm and counts completed tasks
        private static int findTopoSort(int V) {
            // Steps of Kahn's Algorithm:
            // 1. Compute in-degree for each vertex (number of incoming edges).
            // 2. Add all vertices with in-degree 0 to a queue.
            // 3. While queue is not empty:
            //    a. Remove a vertex and increment count.
            //    b. Decrease in-degree of all its neighbors by 1.
            //    c. Add neighbors with in-degree 0 to the queue.
            // 4. Return count of processed vertices (if count < V, a cycle exists).

            // Initialize in-degree array for all vertices
            int[] inDegree = new int[V];

            // Calculate in-degree for each vertex
            calculateInDegree(inDegree);

            // Initialize queue for vertices with in-degree 0
            Queue<Integer> queue = new LinkedList<>();
            // Add vertices with no incoming edges to the queue
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // Count processed vertices
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

            // Return number of processed vertices
            return processedCount;
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
