package Graph.ProblemOnBFSAndDFS;
import java.util.* ;
public class DistanceOfNearestCellHaving1InABinaryMatrix {
    public static class Solution {
            // Directional offsets for 4-directional movement (down, up, right, left)
            private static final int[] rowOffsets = {1, -1, 0, 0};
            // Directional offsets for columns (down, up, right, left)
            private static final int[] colOffsets = {0, 0, 1, -1};
            // Number of rows in the matrix
            private static int numRows;
            // Number of columns in the matrix
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

            public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
                // Handle edge cases: null matrix or empty rows
                if (mat == null || n == 0) {
                    return null;
                }

                // Set matrix dimensions
                numRows = n;
                numCols = m;

                // Initialize queue for BFS
                Queue<Coordinate> queue = new LinkedList<>();

                // Mark all 1s as -1 and add their coordinates to the queue
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numCols; j++) {
                        if (mat.get(i).get(j) == 1) {
                            mat.get(i).set(j, -1); // Mark starting points
                            queue.offer(new Coordinate(i, j)); // Add to queue
                        }
                    }
                }

                // Initialize distance counter
                int distance = 1;

                // Perform BFS to calculate distances from 1s
                while (!queue.isEmpty()) {
                    // Process all nodes at the current distance level
                    int levelSize = queue.size();
                    while (levelSize-- > 0) {
                        // Get the next coordinate from the queue
                        Coordinate current = queue.poll();
                        int currentRow = current.row;
                        int currentCol = current.col;

                        // Check all four directions
                        for (int i = 0; i < 4; i++) {
                            // Calculate new coordinates
                            int nextRow = currentRow + rowOffsets[i];
                            int nextCol = currentCol + colOffsets[i];

                            // If the new position is valid and unvisited (0), update distance
                            if (isValidPosition(nextRow, nextCol) && mat.get(nextRow).get(nextCol) == 0) {
                                mat.get(nextRow).set(nextCol, distance); // Set distance
                                queue.offer(new Coordinate(nextRow, nextCol)); // Add to queue
                            }
                        }
                    }
                    // Increment distance for the next level
                    distance++;
                }

                // Restore original 1s by converting -1 back to 0
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numCols; j++) {
                        if (mat.get(i).get(j) == -1) {
                            mat.get(i).set(j, 0);
                        }
                    }
                }

                // Return the modified matrix with distances
                return mat;
            }

            // Check if the given coordinates are within matrix bounds
            private static boolean isValidPosition(int row, int col) {
                return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
            }
    }
    public static void main(String[] args) {

    }
}
