package Matrices.Medium;
import java.util.* ;
//Problem Link: https://www.naukri.com/code360/problems/minimum-path-sum_985349?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class MinimumPathSum {

    public static class Solution {
        // Directional offsets for movement (down, right)
        private static final int[] ROW_OFFSETS = {1, 0};
        private static final int[] COL_OFFSETS = {0, 1};
        // Number of rows in the grid
        private static int numRows;
        // Number of columns in the grid
        private static int numCols;

        // Class to store cell coordinates and path cost
        private static class Cell {
            public int row;
            public int col;
            public int cost;

            // Constructor to initialize cell coordinates and cost
            public Cell(int row, int col, int cost) {
                this.row = row;
                this.col = col;
                this.cost = cost;
            }
        }

        public static int minSumPath(int[][] grid) {
            // Handle edge case: null or empty grid
            if (grid == null || grid.length == 0) {
                return 0;
            }

            // Set grid dimensions
            numRows = grid.length;
            numCols = grid[0].length;

            // Initialize distance array with maximum values
            int[][] distances = new int[numRows][numCols];
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    distances[row][col] = Integer.MAX_VALUE;
                }
            }

            // Initialize priority queue to select minimum cost path
            PriorityQueue<Cell> priorityQueue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            // Add starting cell (0,0) with its value
            priorityQueue.offer(new Cell(0, 0, grid[0][0]));
            distances[0][0] = grid[0][0];

            // Define target cell (bottom-right)
            int targetRow = numRows - 1;
            int targetCol = numCols - 1;

            // Process queue to find minimum path sum
            while (!priorityQueue.isEmpty()) {
                // Get cell with minimum cost
                Cell current = priorityQueue.poll();
                int row = current.row;
                int col = current.col;
                int cost = current.cost;

                // If target cell reached, return minimum path sum
                if (row == targetRow && col == targetCol) {
                    return cost;
                }

                // Explore allowed directions (down, right)
                for (int i = 0; i < 2; i++) {
                    int nextRow = row + ROW_OFFSETS[i];
                    int nextCol = col + COL_OFFSETS[i];

                    // Check if new position is within grid bounds
                    if (isValidCell(nextRow, nextCol)) {
                        // Calculate new path cost
                        int newCost = cost + grid[nextRow][nextCol];
                        // Update distance if a shorter path is found
                        if (newCost < distances[nextRow][nextCol]) {
                            distances[nextRow][nextCol] = newCost;
                            priorityQueue.offer(new Cell(nextRow, nextCol, newCost));
                        }
                    }
                }
            }

            // Return -1 if no path is found (should not occur for valid input)
            return -1;
        }

        // Checks if a cell is within grid bounds
        private static boolean isValidCell(int row, int col) {
            return row >= 0 && row < numRows && col >= 0 && col < numCols;
        }
    }
    public static void main(String[] args) {

    }
}
