package Graph.ExtraQuestions;
import java.net.Inet4Address;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/shortest-path-in-an-unweighted-graph_981297?interviewProblemRedirection=true&practice_topic%5B%5D=Graph&sort_entity=company_count&sort_order=DESC
public class ShortestPathInAnUnweightedGraph {

    public static class Solution {
        // Adjacency list to store the undirected graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;

        public static LinkedList<Integer> shortestPath(int[][] edges, int V, int n, int src, int target) {
            // Handle edge cases: null or empty edge list
            if (edges == null || n == 0) {
                return new LinkedList<>();
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(edges, V, n);

            // Initialize array to store parent vertices for path reconstruction
            int[] parent = new int[V + 1];
            // Set all parents to -1 (no parent assigned)
            Arrays.fill(parent, -1);

            // Initialize array to track visited vertices
            boolean[] visited = new boolean[V + 1];
            // Mark source vertex as visited
            visited[src] = true;

            // Initialize queue for BFS
            Queue<Integer> queue = new LinkedList<>();
            // Add source vertex to queue
            queue.offer(src);

            // Perform BFS to find shortest path
            while (!queue.isEmpty()) {
                // Remove current vertex from queue
                int currentVertex = queue.poll();

                // If target is reached, stop BFS
                if (currentVertex == target) {
                    break;
                }

                // Explore all neighbors of the current vertex
                for (int idx = 0; idx < adjacencyList.get(currentVertex).size(); idx++) {
                    int neighbor = adjacencyList.get(currentVertex).get(idx);
                    // If neighbor is unvisited, mark it, set parent, and enqueue
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        parent[neighbor] = currentVertex;
                        queue.offer(neighbor);
                    }
                }
            }

            // Initialize list to store the shortest path
            LinkedList<Integer> path = new LinkedList<>();

            // If target was not reached, return empty path
            if (!visited[target]) {
                return path;
            }

            // Reconstruct path from target to source using parent array
            int currentVertex = target;
            while (currentVertex != -1) {
                path.add(currentVertex);
                currentVertex = parent[currentVertex];
            }

            // Reverse path to get source-to-target order
            Collections.reverse(path);

            // Return the shortest path
            return path;
        }

        // Builds the adjacency list for an undirected graph
        private static void buildAdjacencyList(int[][] edges, int V, int n) {
            // Initialize adjacency list for V+1 vertices (0 to V)
            adjacencyList = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add undirected edges to the adjacency list
            for (int[] edge : edges) {
                int fromVertex = edge[0];
                int toVertex = edge[1];
                // Add bidirectional edges
                adjacencyList.get(fromVertex).add(toVertex);
                adjacencyList.get(toVertex).add(fromVertex);
            }
        }
    }
    public static void main(String[] args) {

    }
}
