package DynamicProgramming.TwoAndThreeDDP;

//Problem link:https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

    public static class Solution {
        public int minPathSum(int[][] grid) {
            // Handle edge case: null or empty grid returns 0
            if (grid == null || grid.length == 0) {
                return 0;
            }

            // Get dimensions of the grid
            int totalRows = grid.length;
            int totalColumns = grid[0].length;

            // Initialize dp array with -1 to indicate uncomputed states
            int[][] dpArray = new int[totalRows][totalColumns];
            for (int row = 0; row < totalRows; row++) {
                for (int col = 0; col < totalColumns; col++) {
                    dpArray[row][col] = -1;
                }
            }

            // Compute and return minimum path sum to reach bottom-right cell
            return findMinimumPath(grid, totalRows - 1, totalColumns - 1, dpArray);
        }

        // Recursively find minimum path sum to (row, col) using memoization
        private static int findMinimumPath(int[][] grid, int row, int col, int[][] dpArray) {
            // Base case: reached top-left cell, return its value
            if (row == 0 && col == 0) {
                return grid[row][col];
            }
            // Base case: out of bounds, return large value to avoid selection
            else if (row < 0 || col < 0) {
                return Integer.MAX_VALUE;
            }

            // Return cached result if already computed
            if (dpArray[row][col] != -1) {
                return dpArray[row][col];
            }

            // Calculate minimum path sum from up and left paths
            int upPath = findMinimumPath(grid, row - 1, col, dpArray);
            int leftPath = findMinimumPath(grid, row, col - 1, dpArray);

            // Store and return minimum path sum including current cell's value
            return dpArray[row][col] = Math.min(upPath, leftPath) + grid[row][col];
        }
    }

    public static void main(String[] args) {

    }
}
