package Graph.ProblemOnBFSAndDFS;

import java.util.*;

public class NumberOfEnclaves {
    public static class Solution {
        // Directional offsets for 4-directional movement (left, right, up, down)
        private final static int[] rowOffsets = {0, 0, -1, 1};
        // Directional offsets for columns (left, right, up, down)
        private final static int[] colOffsets = {-1, 1, 0, 0};

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

        public static int numberOfEnclaves(int[][] grid) {
            // Handle edge cases: null grid or empty rows
            if (grid == null || grid.length == 0) {
                return 0;
            }

            // Set grid dimensions
            int numRows = grid.length;
            int numCols = grid[0].length;

            // Traverse top boundary
            int col = 0;
            while (col < numCols) {
                if (grid[0][col] == 1) {
                    // Mark connected 1s as 0 using BFS
                    markConnectedZeros(grid, 0, col, numRows, numCols);
                }
                col++;
            }

            // Traverse right boundary
            int row = 0;
            while (row < numRows) {
                if (grid[row][numCols - 1] == 1) {
                    // Mark connected 1s as 0 using BFS
                    markConnectedZeros(grid, row, numCols - 1, numRows, numCols);
                }
                row++;
            }

            // Traverse bottom boundary
            col = numCols - 1;
            while (col >= 0) {
                if (grid[numRows - 1][col] == 1) {
                    // Mark connected 1s as 0 using BFS
                    markConnectedZeros(grid, numRows - 1, col, numRows, numCols);
                }
                col--;
            }

            // Traverse left boundary
            row = numRows - 1;
            while (row >= 0) {
                if (grid[row][0] == 1) {
                    // Mark connected 1s as 0 using BFS
                    markConnectedZeros(grid, row, 0, numRows, numCols);
                }
                row--;
            }

            // Count remaining 1s (enclaves)
            int enclaveCount = 0;
            for (int[] rowArray : grid) {
                for (int cell : rowArray) {
                    if (cell == 1) {
                        enclaveCount++; // Increment count for each remaining 1
                    }
                }
            }

            // Return the total number of enclaves
            return enclaveCount;
        }

        // Marks all connected 1s as 0 using BFS starting from the given cell
        private static void markConnectedZeros(int[][] grid, int row, int col, int numRows, int numCols) {
            // Initialize queue for BFS
            Queue<Coordinate> queue = new LinkedList<>();
            queue.offer(new Coordinate(row, col));
            // Mark the starting cell as 0
            grid[row][col] = 0;

            // Process all connected cells
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

                    // If the new position is valid and contains a 1, mark it as 0 and add to queue
                    if (isValidPosition(nextRow, nextCol, numRows, numCols) && grid[nextRow][nextCol] == 1) {
                        queue.offer(new Coordinate(nextRow, nextCol));
                        grid[nextRow][nextCol] = 0;
                    }
                }
            }
        }

        // Check if the given coordinates are within grid bounds
        private static boolean isValidPosition(int row, int col, int numRows, int numCols) {
            return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
        }
    }
    public static void main(String[] args) {

    }
}
