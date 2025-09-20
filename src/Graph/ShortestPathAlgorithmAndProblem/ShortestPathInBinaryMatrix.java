package Graph.ShortestPathAlgorithmAndProblem;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static class Solution {
        // Directional offsets for 8-directional movement (right, down, left, up, and diagonals)
        private final static int[] rowOffsets = {0, 1, 0, -1, 1, 1, -1, -1};
        // Directional offsets for columns (right, down, left, up, and diagonals)
        private final static int[] colOffsets = {1, 0, -1, 0, 1, -1, 1, -1};
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

        public int shortestPathBinaryMatrix(int[][] grid) {
            // Handle edge cases: null grid or empty grid
            if (grid == null || grid.length == 0) {
                return 0;
            }

            // Set grid dimensions
            numRows = grid.length;
            numCols = grid[0].length;

            // Check if start or end cell is blocked
            if (grid[0][0] == 1 || grid[numRows - 1][numCols - 1] == 1) {
                return -1;
            }

            // Compute shortest path using BFS
            return findShortestPath(grid);
        }

        // Finds the shortest path from (0,0) to (n-1,n-1) using BFS
        private static int findShortestPath(int[][] grid) {
            // Initialize queue for BFS
            Queue<Coordinate> queue = new LinkedList<>();
            // Add starting cell to queue
            queue.offer(new Coordinate(0, 0));
            // Mark starting cell as visited by setting it to 1
            grid[0][0] = 1;

            // Initialize step counter (each level represents one step)
            int steps = 1;

            // Process queue level by level
            while (!queue.isEmpty()) {
                // Get number of cells at current level
                int levelSize = queue.size();

                // Process all cells at current level
                while (levelSize-- > 0) {
                    // Get next coordinate from queue
                    Coordinate current = queue.poll();
                    int currentRow = current.row;
                    int currentCol = current.col;

                    // If destination is reached, return steps
                    if (currentRow == numRows - 1 && currentCol == numCols - 1) {
                        return steps;
                    }

                    // Check all eight directions
                    for (int i = 0; i < 8; i++) {
                        // Calculate new coordinates
                        int nextRow = currentRow + rowOffsets[i];
                        int nextCol = currentCol + colOffsets[i];

                        // If new position is valid and unblocked (0), add to queue
                        if (isValidPosition(nextRow, nextCol) && grid[nextRow][nextCol] == 0) {
                            queue.offer(new Coordinate(nextRow, nextCol));
                            // Mark as visited
                            grid[nextRow][nextCol] = 1;
                        }
                    }
                }

                // Increment steps for next level
                steps++;
            }

            // No path found to destination
            return -1;
        }

        // Check if the given coordinates are within grid bounds
        private static boolean isValidPosition(int row, int col) {
            return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
        }
    }
    public static void main(String[] args) {

    }
}
