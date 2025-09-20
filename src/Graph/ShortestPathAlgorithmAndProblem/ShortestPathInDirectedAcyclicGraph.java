package Graph.ShortestPathAlgorithmAndProblem;
import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {

    public static class Solution {
        // Adjacency list to store the directed weighted graph
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

        public static int[] shortestPathInDAG(int V, int n, int[][] edges) {
            // Handle edge case: null or empty edge list
            if (edges == null || edges.length == 0) {
                return new int[] {};
            }

            // Build the adjacency list for the graph
            buildAdjacencyList(edges, V);

            // Initialize array to store shortest distances from source (vertex 0)
            int[] distances = new int[V];
            // Set all distances to infinity (unreachable)
            Arrays.fill(distances, Integer.MAX_VALUE);
            // Set distance to source vertex as 0
            distances[0] = 0;

            // Initialize priority queue to process vertices by smallest distance
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
            // Add source vertex with distance 0
            priorityQueue.offer(new Edge(0, 0));

            // Process queue to compute shortest paths
            while (!priorityQueue.isEmpty()) {
                // Remove vertex with smallest distance
                Edge currentEdge = priorityQueue.poll();
                int currentVertex = currentEdge.vertex;
                int currentDistance = currentEdge.weight;

                // Skip if a shorter path to currentVertex was already found
                if (currentDistance > distances[currentVertex]) {
                    continue;
                }

                // Explore all neighbors of the current vertex
                for (int idx = 0; idx < adjacencyList.get(currentVertex).size(); idx++) {
                    Edge neighborEdge = adjacencyList.get(currentVertex).get(idx);
                    int neighborVertex = neighborEdge.vertex;
                    int edgeWeight = neighborEdge.weight;

                    // Update distance if a shorter path is found
                    if (distances[currentVertex] + edgeWeight < distances[neighborVertex]) {
                        distances[neighborVertex] = distances[currentVertex] + edgeWeight;
                        priorityQueue.offer(new Edge(neighborVertex, distances[neighborVertex]));
                    }
                }
            }

            // Replace unreachable vertices (Integer.MAX_VALUE) with -1
            for (int i = 0; i < V; i++) {
                if (distances[i] == Integer.MAX_VALUE) {
                    distances[i] = -1;
                }
            }

            // Return array of shortest path distances from source
            return distances;
        }

        // Builds the adjacency list for a directed weighted graph
        private static void buildAdjacencyList(int[][] edges, int V) {
            // Initialize adjacency list for V vertices
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Add directed edges with weights to the adjacency list
            for (int i = 0; i < edges.length; i++) {
                int fromVertex = edges[i][0];
                int toVertex = edges[i][1];
                int weight = edges[i][2];
                // Add edge to adjacency list
                adjacencyList.get(fromVertex).add(new Edge(toVertex, weight));
            }
        }
    }
    public static void main(String[] args) {

    }
}
