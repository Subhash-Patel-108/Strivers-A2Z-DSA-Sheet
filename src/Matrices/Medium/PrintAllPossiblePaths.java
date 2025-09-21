package Matrices.Medium;

import java.util.ArrayList;

public class PrintAllPossiblePaths {
    public static class Solution {
        // List to store all valid paths
        private static ArrayList<ArrayList<Integer>> allPaths;
        // Directional offsets for movement (down, right)
        private static final int[] ROW_OFFSETS = {1, 0};
        private static final int[] COL_OFFSETS = {0, 1};
        // Number of rows in the grid
        private static int numRows;
        // Number of columns in the grid
        private static int numCols;

        public static int[][] printAllPaths(int[][] grid, int numRows, int numCols) {
            // Handle edge case: null or empty grid
            if (grid == null || grid.length == 0) {
                return null;
            }

            // Initialize grid dimensions
            Solution.numRows = numRows;
            Solution.numCols = numCols;

            // Initialize list to store all paths
            allPaths = new ArrayList<>();

            // Find all paths using backtracking
            findAllPaths(grid, 0, 0, new ArrayList<>());

            // Convert paths to 2D array format
            int[][] result = new int[allPaths.size()][];
            for (int i = 0; i < allPaths.size(); i++) {
                ArrayList<Integer> path = allPaths.get(i);
                result[i] = new int[path.size()];
                for (int j = 0; j < path.size(); j++) {
                    result[i][j] = path.get(j);
                }
            }

            // Return all paths
            return result;
        }

        // Recursively finds all paths from current cell to bottom-right
        private static void findAllPaths(int[][] grid, int row, int col, ArrayList<Integer> currentPath) {
            // If bottom-right cell is reached, add path to result
            if (row == numRows - 1 && col == numCols - 1) {
                currentPath.add(grid[numRows - 1][numCols - 1]);
                allPaths.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size() - 1);
                return;
            }

            // Add current cell value to path
            currentPath.add(grid[row][col]);

            // Explore allowed directions (down, right)
            for (int i = 0; i < 2; i++) {
                int nextRow = row + ROW_OFFSETS[i];
                int nextCol = col + COL_OFFSETS[i];
                // Check if next position is within grid bounds
                if (isValidCell(nextRow, nextCol)) {
                    findAllPaths(grid, nextRow, nextCol, currentPath);
                }
            }

            // Backtrack by removing current cell from path
            currentPath.remove(currentPath.size() - 1);
        }

        // Checks if a cell is within grid bounds
        private static boolean isValidCell(int row, int col) {
            return row >= 0 && row < numRows && col >= 0 && col < numCols;
        }
    }

    public static void main(String[] args) {

    }
}
