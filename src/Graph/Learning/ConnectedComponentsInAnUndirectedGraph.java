package Graph.Learning;
import java.util.* ;
public class ConnectedComponentsInAnUndirectedGraph {
    public static class Solution {
        // Finds all connected components in an undirected graph using DFS
        private static boolean[] visited; // Tracks visited nodes during DFS
        public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
            // Initialize result list to store all connected components
            ArrayList<ArrayList<Integer>> components = new ArrayList<>();

            // Handle edge case: return empty list if edges array is null or empty
            if (edges == null || edges.length == 0) {
                return components;
            }

            // Initialize adjacency list for the graph
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>()); // Add empty list for each vertex
            }

            // Build adjacency list from edges (undirected graph)
            for (int[] edge : edges) {
                int u = edge[0]; // First vertex of the edge
                int v = edge[1]; // Second vertex of the edge
                adjList.get(u).add(v); // Add v to u's adjacency list
                adjList.get(v).add(u); // Add u to v's adjacency list (undirected)
            }

            // Initialize visited array to track explored nodes
            visited = new boolean[V];

            // Iterate through all vertices to find connected components
            for (int i = 0; i < adjList.size(); i++) {
                if (!visited[i]) {
                    // Start DFS for unvisited vertex to find a new component
                    ArrayList<Integer> component = new ArrayList<>();
                    dfs(i, adjList, component);
                    components.add(component); // Add the found component to result
                }
            }

            // Return the list of all connected components
            return components;
        }

        // Performs DFS to explore a connected component
        private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> component) {
            // Mark current node as visited
            visited[node] = true;
            // Add current node to the component
            component.add(node);

            // Explore all unvisited neighbors of the current node
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, adjList, component); // Recursively explore neighbor
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
