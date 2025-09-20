package Graph.ProblemOnBFSAndDFS;
import java.util.* ;

public class IsBipartiteUsingDFS {


    public static class Solution {
        // Adjacency list to store the graph
        private static ArrayList<ArrayList<Integer>> graph;
        // Array to track colors of vertices (0: uncolored, 1: color1, 2: color2)
        private static int[] vertexColors;

        public boolean isBipartite(int V, int[][] edges) {
            // Handle edge cases: null or empty edge list
            if (edges == null || edges.length == 0) {
                return true;
            }

            // Create the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Initialize color array for V vertices
            vertexColors = new int[V];

            // Check each uncolored vertex to ensure the graph is bipartite
            for (int i = 0; i < V; i++) {
                if (vertexColors[i] == 0) {
                    // If coloring fails for any component, graph is not bipartite
                    if (!colorGraphDFS(i, 1)) {
                        return false;
                    }
                }
            }

            // Graph is bipartite if all components are successfully colored
            return true;
        }

        // Builds the adjacency list for an undirected graph
        private static void buildAdjacencyList(int[][] edges, int V) {
            // Initialize adjacency list for V vertices
            graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // Add edges to create undirected graph
            for (int[] edge : edges) {
                int vertex1 = edge[0];
                int vertex2 = edge[1];

                // Add bidirectional edges
                graph.get(vertex1).add(vertex2);
                graph.get(vertex2).add(vertex1);
            }
        }

        // Colors the graph using DFS and checks if it is bipartite
        private static boolean colorGraphDFS(int currentVertex, int color) {
            // Assign the given color to the current vertex
            vertexColors[currentVertex] = color;
            // Determine the alternate color for neighbors (1 -> 2, 2 -> 1)
            int alternateColor = color == 1 ? 2 : 1;

            // Explore all neighbors of the current vertex
            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                int neighbor = graph.get(currentVertex).get(i);

                // If neighbor has the same color as current vertex, not bipartite
                if (vertexColors[neighbor] == color) {
                    return false;
                }

                // If neighbor is uncolored, recursively color it with the alternate color
                if (vertexColors[neighbor] == 0) {
                    if (!colorGraphDFS(neighbor, alternateColor)) {
                        return false;
                    }
                }
            }

            // Component is bipartite so far
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
