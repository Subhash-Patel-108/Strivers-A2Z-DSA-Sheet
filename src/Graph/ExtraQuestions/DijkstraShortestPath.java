package Graph.ExtraQuestions;
import java.util.* ;

//problem Link : https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469?interviewProblemRedirection=true&practice_topic%5B%5D=Graph&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class DijkstraShortestPath {

    public static class Solution {
        // Adjacency list representing the undirected weighted graph
        private static ArrayList<ArrayList<Edge>> adjList;

        // Stores a neighbor and the edge weight for adjacency representation
        private static class Edge {
            public int node;
            public int weight;

            // Creates an edge to the specified node with the given weight
            public Edge(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        // Runs Dijkstra's algorithm and returns shortest distances from source
        public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edgeList, int vertexCount, int edgeCount, int source) {
            // Return empty result for null or empty input
            if(edgeList == null || edgeList.isEmpty()) {
                return new ArrayList<>();
            }

            // Build adjacency list from the raw edges
            buildAdjList(edgeList, vertexCount);

            // Distance array: distance.get(i) represents shortest path to node i
            ArrayList<Integer> distance = new ArrayList<>();
            for(int i = 0; i < vertexCount; i++) {
                distance.add(Integer.MAX_VALUE);
            }

            // Min-heap to track next best node to process by current shortest distance
            PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
            minHeap.offer(new Edge(source, 0));
            distance.set(source, 0);

            // Dijkstra's algorithm main loop
            while(!minHeap.isEmpty()) {
                Edge current = minHeap.poll();
                int currentNode = current.node;
                int currentDist = current.weight;

                // Prune shorter paths already found for this node
                if(currentDist > distance.get(currentNode)) continue;

                // Traverse neighbors and update paths if improvement found
                for(Edge neighbor : adjList.get(currentNode)) {
                    int nextNode = neighbor.node;
                    int edgeCost = neighbor.weight;
                    int newDist = distance.get(currentNode) + edgeCost;

                    if(newDist < distance.get(nextNode)) {
                        distance.set(nextNode, newDist);
                        minHeap.offer(new Edge(nextNode, newDist));
                    }
                }
            }

            // Per requirements, do not update unreachable nodes to -1
            return distance;
        }

        // Builds adjacency list from input edge list
        private static void buildAdjList(ArrayList<ArrayList<Integer>> edges, int vertexCount) {
            adjList = new ArrayList<>();
            for(int i = 0; i < vertexCount; i++) {
                adjList.add(new ArrayList<>());
            }

            // Add both directions for each edge to model undirected graph
            for(ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                adjList.get(u).add(new Edge(v, weight));
                adjList.get(v).add(new Edge(u, weight));
            }
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
