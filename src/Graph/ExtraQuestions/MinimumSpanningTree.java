package Graph.ExtraQuestions;
import java.sql.Array;
import java.util.* ;
public class MinimumSpanningTree {
    public static class Solution {
        // Adjacency list to store the undirected weighted graph
        private static ArrayList<ArrayList<Edge>> adjacencyList;

        // Class to store neighbor vertex and edge weight
        private static class Edge {
            public int vertex;
            public int weight;

            // Constructor to initialize vertex and weight
            public Edge(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        public static int spanningTree(int V, int[][] edges) {
            // Handle edge case: null or empty edge list
            if (edges == null || edges.length == 0) {
                return 0;
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Compute the minimum spanning tree cost
            int minCost = computeMinimumSpanningTreeCost(V);

            // Return the MST cost
            return minCost;
        }

        // Builds the adjacency list for an undirected weighted graph
        private static void buildAdjacencyList(int[][] edges, int numVertices) {
            // Initialize adjacency list for numVertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add undirected edges with weights to the adjacency list
            for (int i = 0; i < edges.length; i++) {
                int fromVertex = edges[i][0];
                int toVertex = edges[i][1];
                int weight = edges[i][2];
                // Add bidirectional edges
                adjacencyList.get(fromVertex).add(new Edge(toVertex, weight));
                adjacencyList.get(toVertex).add(new Edge(fromVertex, weight));
            }
        }

        // Computes the minimum spanning tree cost using Prim's algorithm
        private static int computeMinimumSpanningTreeCost(int numVertices) {
            // Initialize array to track visited vertices
            boolean[] visited = new boolean[numVertices];

            // Initialize min-heap to select minimum weight edges
            PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            // Add starting vertex (0) with weight 0
            minHeap.offer(new Edge(0, 0));

            // Initialize total cost
            int totalCost = 0;

            // Process heap to build MST
            while (!minHeap.isEmpty()) {
                // Get edge with minimum weight
                Edge currentEdge = minHeap.poll();
                int currentVertex = currentEdge.vertex;
                int edgeWeight = currentEdge.weight;

                // Skip if vertex is already visited
                if (visited[currentVertex]) {
                    continue;
                }

                // Mark vertex as visited and add weight to total cost
                visited[currentVertex] = true;
                totalCost += edgeWeight;

                // Add unvisited neighbors to heap
                for (int i = 0; i < adjacencyList.get(currentVertex).size(); i++) {
                    Edge neighborEdge = adjacencyList.get(currentVertex).get(i);
                    int neighborVertex = neighborEdge.vertex;
                    int neighborWeight = neighborEdge.weight;

                    // Add unvisited neighbor to heap
                    if (!visited[neighborVertex]) {
                        minHeap.offer(new Edge(neighborVertex, neighborWeight));
                    }
                }
            }

            // Return the total MST cost
            return totalCost;
        }
    }


    public static void main(String[] args) {

    }
}
