package Graph.ProblemOnBFSAndDFS;

import java.util.*;

public class CycleDetectionInUndirectedGraphUsingBFS {
    public static class Solution {
        // Stores the graph as an adjacency list
        private static ArrayList<ArrayList<Integer>> adjacencyList;
        // Tracks which nodes have been visited
        private static boolean[] explored;

        // Represents a node and its parent during BFS traversal
        private static class NodeInfo {
            public int vertex;
            public int parentVertex;

            // Initializes node and parent values
            public NodeInfo(int vertex, int parentVertex) {
                this.vertex = vertex;
                this.parentVertex = parentVertex;
            }
        }

        public static String cycleDetection(int[][] edges, int n, int m) {
            // Handle cases with no edges or invalid input
            if (edges == null || m == 0) {
                return "Yes";
            }

            // Create adjacency list for 'n' vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Populate adjacency list with undirected edges
            for (int i = 0; i < m; i++) {
                // Convert to 0-based indexing
                int vertex1 = edges[i][0] - 1;
                int vertex2 = edges[i][1] - 1;

                // Add bidirectional edges
                adjacencyList.get(vertex1).add(vertex2);
                adjacencyList.get(vertex2).add(vertex1);
            }

            // Initialize array to track visited vertices
            explored = new boolean[n];

            // Check each unvisited vertex for cycles
            for (int i = 0; i < n; i++) {
                if (!explored[i]) {
                    // If a cycle is found, return "Yes"
                    if (findCycleBFS(i)) {
                        return "Yes";
                    }
                }
            }

            // No cycles detected
            return "No";
        }

        // Performs BFS to detect cycles starting from a given vertex
        private static boolean findCycleBFS(int startVertex) {
            // Mark the starting vertex as explored
            explored[startVertex] = true;

            // Create queue for BFS traversal
            Queue<NodeInfo> queue = new LinkedList<>();
            // Add starting vertex with no parent (-1)
            queue.offer(new NodeInfo(startVertex, -1));

            // Continue until queue is empty
            while (!queue.isEmpty()) {
                // Retrieve and remove the front node info
                NodeInfo current = queue.poll();
                int currentVertex = current.vertex;
                int parentVertex = current.parentVertex;

                // Explore all neighbors of the current vertex
                for (int i = 0; i < adjacencyList.get(currentVertex).size(); i++) {
                    int adjacentVertex = adjacencyList.get(currentVertex).get(i);

                    // If neighbor hasn't been explored, mark and enqueue it
                    if (!explored[adjacentVertex]) {
                        explored[adjacentVertex] = true;
                        queue.offer(new NodeInfo(adjacentVertex, currentVertex));
                    }
                    // If neighbor is explored and not the parent, a cycle exists
                    else if (parentVertex != adjacentVertex) {
                        return true;
                    }
                }
            }

            // No cycle found in this component
            return false;
        }
    }
    public static void main(String[] args) {

    }
}
