package Graph.ProblemOnBFSAndDFS;
import java.util.* ;
public class NumberOfIslands {

    public static class Solution {
        // Directional offsets for 4-directional movement (right, down, left, up)
        private final static int[] rowOffsets = {0, 1, 0, -1};
        // Directional offsets for columns (right, down, left, up)
        private final static int[] colOffsets = {1, 0, -1, 0};
        // Number of rows in the grid
        private static int numRows;
        // Number of columns in the grid
        private static int numCols;

        // Class to store row and column coordinates
        private static class Coordinate {
            public int row;
            public int col;

            // Constructor to initialize coordinates
            public Coordinate(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public int numIslands(char[][] grid) {
            // Handle edge cases: null grid or empty rows
            if (grid == null || grid.length == 0) {
                return 0;
            }

            // Initialize count of islands
            int islandCount = 0;
            // Set grid dimensions
            numRows = grid.length;
            numCols = grid[0].length;

            // Iterate through each cell in the grid
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    // If a land cell ('1') is found, explore the island
                    if (grid[row][col] == '1') {
                        exploreIsland(grid, row, col);
                        islandCount++; // Increment island count
                    }
                }
            }

            // Return total number of islands
            return islandCount;
        }

        // Explores and marks all connected land cells ('1') as visited ('0') using BFS
        private static void exploreIsland(char[][] grid, int row, int col) {
            // Initialize queue for BFS
            Queue<Coordinate> queue = new LinkedList<>();
            // Add starting cell to queue
            queue.offer(new Coordinate(row, col));
            // Mark starting cell as visited
            grid[row][col] = '0';

            // Process all connected land cells
            while (!queue.isEmpty()) {
                // Get the next coordinate from the queue
                Coordinate current = queue.poll();
                int currentRow = current.row;
                int currentCol = current.col;

                // Check all four directions
                for (int i = 0; i < 4; i++) {
                    // Calculate new coordinates
                    int nextRow = currentRow + rowOffsets[i];
                    int nextCol = currentCol + colOffsets[i];

                    // If the new position is valid and contains land ('1'), mark and add to queue
                    if (isValidPosition(nextRow, nextCol) && grid[nextRow][nextCol] == '1') {
                        queue.offer(new Coordinate(nextRow, nextCol));
                        grid[nextRow][nextCol] = '0'; // Mark as visited
                    }
                }
            }
        }

        // Check if the given coordinates are within grid bounds
        private static boolean isValidPosition(int row, int col) {
            return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
        }
    }
    public static void main(String[] args) {

    }
}
