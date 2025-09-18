package Graph.ProblemOnBFSAndDFS;
import java.util.* ;
public class FloodFill {
    public static class Solution {
        // Array to store row direction offsets for 4-directional movement (down, up, right, left)
        private final static int[] rowOffsets = {1, -1, 0, 0};
        // Array to store column direction offsets for 4-directional movement (down, up, right, left)
        private final static int[] colOffsets = {0, 0, 1, -1};
        // Store the number of rows in the image
        private static int numRows;
        // Store the number of columns in the image
        private static int numCols;

        // Class to represent a coordinate pair (row, column)
        private static class Coordinate {
            public int row;
            public int col;

            // Constructor to initialize row and column
            public Coordinate(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            // Check for invalid inputs or if starting pixel is already the new color
            if (image == null || image.length == 0 || sr == -1 || sc == -1 ||
                    sr == image.length || sc == image[0].length || image[sr][sc] == newColor) {
                return image;
            }

            // Store the original color of the starting pixel
            int originalColor = image[sr][sc];
            // Set the dimensions of the image
            numRows = image.length;
            numCols = image[0].length;
            // Change the starting pixel to the new color
            image[sr][sc] = newColor;
            // Initialize a queue to store coordinates for BFS
            Queue<Coordinate> queue = new LinkedList<>();
            // Add the starting coordinate to the queue
            queue.offer(new Coordinate(sr, sc));

            // Process the queue until it's empty
            while (!queue.isEmpty()) {
                // Get the next coordinate from the queue
                Coordinate current = queue.poll();
                // Extract row and column indices
                int currentRow = current.row;
                int currentCol = current.col;

                // Check all four directions (down, up, right, left)
                for (int i = 0; i < 4; i++) {
                    // Calculate new row and column indices based on direction offsets
                    int nextRow = currentRow + rowOffsets[i];
                    int nextCol = currentCol + colOffsets[i];

                    // If the new position is valid and has the original color
                    if (isValidPosition(nextRow, nextCol) && image[nextRow][nextCol] == originalColor) {
                        // Add the new coordinate to the queue
                        queue.offer(new Coordinate(nextRow, nextCol));
                        // Change the pixel to the new color
                        image[nextRow][nextCol] = newColor;
                    }
                }
            }
            // Return the modified image
            return image;
        }

        // Check if the given row and column indices are within the image bounds
        private static boolean isValidPosition(int row, int col) {
            return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
        }
    }
    public static void main(String[] args) {

    }
}
