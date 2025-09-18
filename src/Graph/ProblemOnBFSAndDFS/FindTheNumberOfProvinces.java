package Graph.ProblemOnBFSAndDFS;

public class FindTheNumberOfProvinces {
    public static class Solution {
        // Tracks visited cities during DFS (static to be shared across methods)
        private static boolean[] visited;

        // Finds the number of provinces (connected components) in a graph represented by an adjacency matrix
        public static int findNumOfProvinces(int[][] roads, int n) {
            // Handle edge case: return 0 if roads matrix is null or number of cities is 0
            if (roads == null || n == 0) {
                return 0;
            }

            // Initialize visited array to track explored cities
            visited = new boolean[n];
            // Initialize counter for number of provinces
            int provinces = 0;

            // Iterate through all cities to find unvisited ones
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    // Increment province count for each new component
                    provinces++;
                    // Perform DFS to mark all cities in the current province as visited
                    dfs(i, roads);
                }
            }

            // Return the total number of provinces
            return provinces;
        }

        // Performs DFS to explore all cities in a connected component
        private static void dfs(int node, int[][] roads) {
            // Mark current city as visited
            visited[node] = true;

            // Explore all cities connected to the current city
            for (int i = 0; i < roads[node].length; i++) {
                // If city i is unvisited and there is a road between node and i
                if (!visited[i] && roads[node][i] == 1) {
                    dfs(i, roads); // Recursively explore connected city
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
