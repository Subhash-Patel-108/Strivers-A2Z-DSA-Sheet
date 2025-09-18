package Graph.Learning;
//import java.lang.reflect.Array;
import java.util.* ;
public class DFS {
    public static class Solution {
        // Represents the adjacency list of the graph (static to be shared across methods)
        private static ArrayList<ArrayList<Integer>> adjList;
        // Tracks visited nodes during DFS (static to be shared across methods)
        private static boolean[] visited;

        // Finds all connected components in an undirected graph using DFS
        public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
            // Initialize result list to store all connected components
            ArrayList<ArrayList<Integer>> components = new ArrayList<>();

            // Handle edge case: return empty list if edges is null or no vertices
            if (edges == null || v == 0) {
                return components;
            }

            // Initialize adjacency list for the graph
            adjList = new ArrayList<>();
            for (int idx = 0; idx < v; idx++) {
                adjList.add(new ArrayList<>()); // Add empty list for each vertex
            }

            // Build adjacency list from edges (undirected graph)
            for (int idx = 0; idx < e; idx++) {
                int u = edges.get(idx).get(0); // First vertex of the edge
                int w = edges.get(idx).get(1); // Second vertex of the edge
                adjList.get(u).add(w); // Add w to u's adjacency list
                adjList.get(w).add(u); // Add u to w's adjacency list (undirected)
            }

            // Initialize visited array to track explored nodes
            visited = new boolean[v];

            // Iterate through all vertices to find connected components
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    // Start DFS for unvisited vertex to find a new component
                    ArrayList<Integer> component = new ArrayList<>();
                    DFS(i, component);
                    components.add(component); // Add the found component to result
                }
            }

            // Return the list of all connected components
            return components;
        }

        // Performs DFS to explore a connected component
        private static void DFS(int node, ArrayList<Integer> component) {
            // Mark current node as visited
            visited[node] = true;
            // Add current node to the component
            component.add(node);

            // Explore all unvisited neighbors of the current node
            for (int idx = 0; idx < adjList.get(node).size(); idx++) {
                int neighbor = adjList.get(node).get(idx);
                if (!visited[neighbor]) {
                    DFS(neighbor, component); // Recursively explore neighbor
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
