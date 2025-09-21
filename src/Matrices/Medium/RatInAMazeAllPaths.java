package Matrices.Medium;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/rat-in-a-maze-all-paths_758966?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class RatInAMazeAllPaths {
    public static class Solution {
        // Direction vectors for 4 possible moves: down, right, up, left
        private static final int[] ROW_DIRECTIONS = {1, 0, -1, 0};
        private static final int[] COL_DIRECTIONS = {0, 1, 0, -1};

        /**
         * Main method to find all possible paths for rat to reach destination
         * Uses backtracking algorithm to explore all valid paths
         */
        public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
            // Result list to store all valid paths
            ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

            // Handle edge cases
            if (maze == null || n == 0 || maze[0][0] == 0 || maze[n-1][n-1] == 0) {
                return allPaths; // Return empty list if no path possible
            }

            // Create a path matrix to track current path being explored
            int[][] currentPath = new int[n][n];

            // Start backtracking from top-left corner (0,0)
            findAllPaths(maze, 0, 0, n, currentPath, allPaths);

            return allPaths;
        }

        /**
         * Recursive backtracking method to find all paths from current position to destination
         */
        private static void findAllPaths(int[][] maze, int currentRow, int currentCol, int mazeSize,
                                         int[][] pathMatrix, ArrayList<ArrayList<Integer>> allValidPaths) {

            // Base case: reached destination (bottom-right corner)
            if (currentRow == mazeSize - 1 && currentCol == mazeSize - 1) {
                // Mark destination cell as part of current path
                pathMatrix[currentRow][currentCol] = 1;

                // Convert 2D path matrix to 1D list and add to results
                ArrayList<Integer> solutionPath = convertPathToList(pathMatrix, mazeSize);
                allValidPaths.add(solutionPath);

                // Backtrack: unmark the destination cell for other path explorations
                pathMatrix[currentRow][currentCol] = 0;
                return;
            }

            // Mark current cell as part of the path being explored
            pathMatrix[currentRow][currentCol] = 1;

            // Try all 4 possible directions: down, right, up, left
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = currentRow + ROW_DIRECTIONS[direction];
                int nextCol = currentCol + COL_DIRECTIONS[direction];

                // Check if next position is valid and can be visited
                if (isValidMove(nextRow, nextCol, mazeSize) && pathMatrix[nextRow][nextCol] == 0 && maze[nextRow][nextCol] == 1) {
                    // Recursively explore path from next position
                    findAllPaths(maze, nextRow, nextCol, mazeSize, pathMatrix, allValidPaths);
                }
            }

            // Backtrack: unmark current cell to allow other paths to use it
            pathMatrix[currentRow][currentCol] = 0;
        }

        /**
         * Helper method to check if a move to given position is valid
         */
        private static boolean isValidMove(int row, int col, int size ) {
            // Check if position is within maze boundaries
            return (row >= 0 && row < size && col >= 0 && col < size);
        }

        /**
         * Convert 2D path matrix to 1D ArrayList as required by output format
         * Reads matrix from left to right, top to bottom
         */
        private static ArrayList<Integer> convertPathToList(int[][] pathMatrix, int size) {
            ArrayList<Integer> pathList = new ArrayList<>();

            // Read matrix row by row, column by column
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    pathList.add(pathMatrix[row][col]);
                }
            }

            return pathList;
        }
    }
    public static void main(String[] args) {

    }
}
