package Graph.ExtraQuestions;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/check-graph-is-bipartite-or-not_920551?interviewProblemRedirection=true&practice_topic%5B%5D=Graph&sort_entity=company_count&sort_order=DESC
public class CheckBipartiteGraph {

    public static class Solution {

        private static ArrayList<ArrayList<Integer>> adjList;

        // Function to check if a graph is bipartite using BFS
        public static boolean isGraphBipartite(ArrayList<ArrayList<Integer>> edges) {
            // Edge case: empty graph is trivially bipartite
            if (edges == null || edges.isEmpty()) {
                return true;
            }

            // Build adjacency list from the given edge matrix
            buildAdjList(edges);

            int V = edges.size();
            int[] colors = new int[V]; // 0 = not colored, 1 & 2 are two colors
            colors[0] = 1; // Start coloring first node with color 1

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0); // Begin BFS from node 0

            while (!queue.isEmpty()) {
                int node = queue.poll();
                int currentColor = colors[node];
                int neighborColor = (currentColor == 2) ? 1 : 2; // alternate color for neighbors

                for (int neighborIndex = 0; neighborIndex < adjList.get(node).size(); neighborIndex++) {
                    int neighbor = adjList.get(node).get(neighborIndex);

                    // If neighbor has same color as current node, graph is not bipartite
                    if (colors[neighbor] == currentColor) {
                        return false;
                    }

                    // If neighbor is not colored, assign opposite color and add to queue
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = neighborColor;
                        queue.offer(neighbor);
                    }
                }
            }

            // If no conflicts found, graph is bipartite
            return true;
        }

        // Builds adjacency list from adjacency matrix edges (0/1 matrix)
        private static void buildAdjList(ArrayList<ArrayList<Integer>> edges) {
            adjList = new ArrayList<>();
            int V = edges.size();

            // Initialize adjacency list for each vertex
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }

            // Convert matrix to adjacency list (undirected graph)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (edges.get(i).get(j) == 1) {
                        adjList.get(i).add(j);
                        adjList.get(j).add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
