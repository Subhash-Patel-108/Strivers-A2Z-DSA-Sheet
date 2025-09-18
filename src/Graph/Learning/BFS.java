package Graph.Learning;
import java.util.* ;
public class BFS {
    public static class Solution {
        // Performs Breadth-First Search (BFS) traversal on a graph starting from vertex 0
        public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
            // Initialize result list to store BFS traversal order
            List<Integer> traversal = new ArrayList<>();
            // Handle edge case: return empty list if adjacency list is null or empty
            if (adj == null || adj.size() == 0) {
                return traversal;
            }

            // Initialize queue for BFS and visited array to track explored nodes
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];

            // Start BFS from vertex 0
            queue.offer(0);
            visited[0] = true;

            // Process nodes in the queue
            while (!queue.isEmpty()) {
                // Dequeue the current node and add it to the result
                int currentNode = queue.poll();
                traversal.add(currentNode);

                // Explore all neighbors of the current node
                for (int i = 0; i < adj.get(currentNode).size(); i++) {
                    int neighbor = adj.get(currentNode).get(i);
                    // If neighbor is unvisited, mark it visited and enqueue it
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            // Return the BFS traversal order
            return traversal;
        }
    }


    public static void main(String[] args) {

    }
}
