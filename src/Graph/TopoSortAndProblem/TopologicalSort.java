package Graph.TopoSortAndProblem;
import java.util.* ;
public class TopologicalSort {

    public static class Solution {
        // Adjacency list to store the directed graph
        private static ArrayList<ArrayList<Integer>> adjacencyList;
        // Tracks vertices visited in the entire DFS traversal
        private static boolean[] visited;
        // Tracks vertices in the current DFS path
        private static boolean[] inCurrentPath;
        // Indicates whether a cycle is detected
        private static boolean hasCycle;

        public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
            // Initialize result list for topological order
            ArrayList<Integer> topoOrder = new ArrayList<>();

            // Handle edge cases: null edges or no vertices
            if (edges == null || v == 0) {
                return topoOrder;
            }

            // Create the adjacency list for the graph
            buildAdjacencyList(edges, v, e);

            // Initialize arrays to track visited vertices and current path
            visited = new boolean[v];
            inCurrentPath = new boolean[v];
            // Initialize cycle detection flag
            hasCycle = false;

            // Initialize stack to store topological order
            Stack<Integer> stack = new Stack<>();

            // Perform DFS for each unvisited vertex
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    // If a cycle is found, return empty list
                    if (performDFS(i, stack)) {
                        return new ArrayList<>();
                    }
                }
            }

            // Populate result list from stack
            while (!stack.isEmpty()) {
                topoOrder.add(stack.pop());
            }

            // Return the topological order
            return topoOrder;
        }

        // Builds the adjacency list for a directed graph
        private static void buildAdjacencyList(ArrayList<ArrayList<Integer>> edges, int v, int totalEdges) {
            // Initialize adjacency list for v vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges to the adjacency list
            for (int i = 0; i < totalEdges; i++) {
                int fromVertex = edges.get(i).get(0);
                int toVertex = edges.get(i).get(1);
                // Add single-directional edge
                adjacencyList.get(fromVertex).add(toVertex);
            }
        }

        // Performs DFS to detect cycles and build topological order
        private static boolean performDFS(int currentVertex, Stack<Integer> stack) {
            // Mark the current vertex as visited and part of the current path
            visited[currentVertex] = true;
            inCurrentPath[currentVertex] = true;

            // Explore all neighbors of the current vertex
            for (int neighbor : adjacencyList.get(currentVertex)) {
                // If neighbor is unvisited, continue DFS
                if (!visited[neighbor]) {
                    if (performDFS(neighbor, stack)) {
                        return true; // Cycle detected
                    }
                }
                // If neighbor is in the current path, a cycle is detected
                else if (inCurrentPath[neighbor]) {
                    return true;
                }
            }

            // Remove the current vertex from the current path
            inCurrentPath[currentVertex] = false;
            // Add vertex to stack for topological order
            stack.push(currentVertex);
            // No cycle found in this path
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
