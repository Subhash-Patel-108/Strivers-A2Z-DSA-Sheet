package Graph.ShortestPathAlgorithmAndProblem;
import java.util.* ;
public class ShortestPathInUndirectedGraph {
    public static class Solution {
        public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
            // Handle edge case: if adjacency list is null or empty, return empty array
            if (adj == null || adj.isEmpty()) {
                return new int[] {};
            }

            int n = adj.size(); // total number of vertices in the graph
            int[] distance = new int[n]; // stores shortest distance from source to each vertex
            Arrays.fill(distance, -1);   // initialize all distances as -1 (unreachable)
            distance[src] = 0;           // distance to source is 0

            boolean[] visited = new boolean[n]; // keeps track of visited nodes
            visited[src] = true;                // mark source as visited

            Queue<Integer> queue = new LinkedList<>(); // BFS queue
            queue.offer(src); // start BFS from source

            // Perform BFS
            while (!queue.isEmpty()) {
                int node = queue.poll();        // get current node
                int currDistance = distance[node]; // current node's distance from source

                // Explore all neighbors of the current node
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int neighbor = adj.get(node).get(i);

                    // If neighbor not visited, update distance and enqueue it
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        distance[neighbor] = currDistance + 1;
                        queue.offer(neighbor);
                    }
                }
            }

            // Return array containing shortest path distances from src
            return distance;
        }
    }


    public static void main(String[] args) {

    }
}
