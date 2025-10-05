package DynamicProgramming.TwoAndThreeDDP;

import java.util.LinkedList;
import java.util.Queue;

//Problem Link:https://www.geeksforgeeks.org/problems/minimum-cost-path3833/1
public class MinimumCostPathWithFourDirections {

    public static class Solution {

        // Directional offsets for 4-directional movement (right, left, down, up)
        private final static int[] ROW_DIRECTIONS = {0, 0, 1, -1};
        private final static int[] COLUMN_DIRECTIONS = {1, -1, 0, 0};
        // Store total number of rows in the grid
        private static int totalRow;
        // Store total number of columns in the grid
        private static int totalColumn;
        // Class to store row and column indices
        private static class Pair {
            public int rowIdx;
            public int colIdx;

            // Constructor to initialize row and column indices
            public Pair(int rowIdx, int colIdx) {
                this.rowIdx = rowIdx;
                this.colIdx = colIdx;
            }
        }

        // Function to return the minimum cost to reach bottom-right cell from top-left
        public int minimumCostPath(int[][] grid) {
            // Handle edge case: null or empty grid returns 0
            if (grid == null || grid.length == 0) {
                return 0;
            }
            // Set grid dimensions
            totalRow = grid.length;
            totalColumn = grid[0].length;

            // Compute and return minimum cost path
            return findMinimumCostPath(grid);
        }

        // Finds minimum cost path from top-left to bottom-right using BFS
        private static int findMinimumCostPath(int[][] grid) {
            // Define starting and target positions
            int startingRow = 0, startingCol = 0;
            int targetRow = totalRow - 1, targetCol = totalColumn - 1;

            // Initialize distance array with maximum values
            int[][] dist = new int[totalRow][totalColumn];
            for (int row = 0; row < totalRow; row++) {
                for (int col = 0; col < totalColumn; col++) {
                    dist[row][col] = Integer.MAX_VALUE;
                }
            }

            // Set starting cell distance to its value
            dist[startingRow][startingCol] = grid[startingRow][startingCol];

            // Initialize queue for BFS and add starting cell
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(startingRow, startingCol));

            // Process queue to find shortest path costs
            while (!queue.isEmpty()) {
                // Get current cell from queue
                Pair pair = queue.poll();
                int rowIdx = pair.rowIdx;
                int colIdx = pair.colIdx;

                // Explore all four directions
                for (int idx = 0; idx < 4; idx++) {
                    // Calculate next cell coordinates
                    int newRow = rowIdx + ROW_DIRECTIONS[idx];
                    int newCol = colIdx + COLUMN_DIRECTIONS[idx];

                    // If next cell is within bounds
                    if (isSafe(newRow, newCol)) {
                        // Calculate new distance
                        int newDist = dist[rowIdx][colIdx] + grid[newRow][newCol];
                        // Update if shorter path found
                        if (newDist < dist[newRow][newCol]) {
                            dist[newRow][newCol] = newDist;
                            // Add next cell to queue
                            queue.offer(new Pair(newRow, newCol));
                        }
                    }
                }
            }
            // Return minimum cost to reach target cell
            return dist[targetRow][targetCol];
        }

        // Checks if a cell is within grid bounds
        private static boolean isSafe(int row, int col) {
            return (row >= 0 && row < totalRow) && (col >= 0 && col < totalColumn);
        }
    }
    public static void main(String[] args) {

    }
}
