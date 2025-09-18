package Graph.ProblemOnBFSAndDFS;
import java.util.* ;

public class RottenOranges {
    public static class Solution {
        // Arrays to represent the four possible directions (up, right, down, left)
        private final static int[] rowsDirection = { -1, 0, 1, 0 };
        private final static int[] colsDirection = { 0, 1, 0, -1 };
        // Dimensions of the grid
        private static int rowSize;
        private static int colSize;

        // Class to store row and column coordinates of a cell
        private static class Pair {
            public int row; // Row coordinate
            public int col; // Column coordinate

            // Constructor to initialize coordinates
            public Pair(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        // Calculates minimum time to rot all oranges in the grid
        public int orangesRotting(int[][] grid) {
            // Handle edge case: return 0 if grid is null or empty
            if (grid == null || grid.length == 0) {
                return 0;
            }
            // Set grid dimensions
            rowSize = grid.length;
            colSize = grid[0].length;

            // Initialize variables
            int minTime = 0; // Tracks minimum time to rot all oranges
            Queue<Pair> queue = new LinkedList<>(); // Queue for BFS starting from rotten oranges

            // Add all initially rotten oranges (value 2) to the queue
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new Pair(i, j));
                    }
                }
            }

            // Perform BFS to rot adjacent fresh oranges
            while (!queue.isEmpty()) {
                int size = queue.size(); // Number of rotten oranges in current level
                boolean hasRotten = false; // Tracks if any new oranges were rotten in this iteration
                while (size-- > 0) {
                    // Get current rotten orange's coordinates
                    Pair current = queue.poll();
                    int rowIdx = current.row;
                    int colIdx = current.col;

                    // Explore all four neighboring cells
                    for (int idx = 0; idx < 4; idx++) {
                        int newRow = rowIdx + rowsDirection[idx];
                        int newCol = colIdx + colsDirection[idx];

                        // Check if neighbor is within bounds and is a fresh orange (value 1)
                        if (isSafe(newRow, newCol) && grid[newRow][newCol] == 1) {
                            queue.offer(new Pair(newRow, newCol)); // Add to queue for next level
                            grid[newRow][newCol] = 2; // Mark as rotten
                            hasRotten = true; // Indicate a new orange was rotten
                        }
                    }
                }

                // Increment time only if new oranges were rotten in this iteration
                if (hasRotten) {
                    minTime++;
                }
            }

            // Check for any remaining fresh oranges
            for (int[] row : grid) {
                for (int cell : row) {
                    if (cell == 1) {
                        return -1; // Return -1 if any fresh oranges remain
                    }
                }
            }

            // Return the minimum time required to rot all oranges
            return minTime;
        }

        // Checks if a cell is within grid bounds
        private static boolean isSafe(int row, int col) {
            return (row >= 0 && row < rowSize) && (col >= 0 && col < colSize);
        }
    }

    public static void main(String[] args) {

    }
}