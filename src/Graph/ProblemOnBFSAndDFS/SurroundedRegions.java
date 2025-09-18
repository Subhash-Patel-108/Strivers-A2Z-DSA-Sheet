package Graph.ProblemOnBFSAndDFS;
import java.util.* ;
public class SurroundedRegions {
    public static class Solution {
        // Directional offsets for 4-directional movement (left, right, up, down)
        private static final int[] rowOffsets = {0, 0, -1, 1};
        // Directional offsets for columns (left, right, up, down)
        private static final int[] colOffsets = {-1, 1, 0, 0};

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

        public static char[][] captureRegion(char[][] board, int n, int m) {
            // Handle edge cases: null board or empty rows
            if (board == null || n == 0) {
                return board;
            }

            // Initialize row and column for boundary traversal
            int currentRow = 0, currentCol = 0;

            // Traverse top boundary
            while (currentCol < m) {
                if (board[currentRow][currentCol] == 'O') {
                    // Mark connected 'O' regions as 'S' using BFS
                    markSafeRegion(board, currentRow, currentCol, n, m);
                }
                currentCol++;
            }

            // Traverse right boundary
            currentRow = 0;
            currentCol = m - 1;
            while (currentRow < n) {
                if (board[currentRow][currentCol] == 'O') {
                    // Mark connected 'O' regions as 'S' using BFS
                    markSafeRegion(board, currentRow, currentCol, n, m);
                }
                currentRow++;
            }

            // Traverse bottom boundary
            currentRow = n - 1;
            currentCol = m - 1;
            while (currentCol >= 0) {
                if (board[currentRow][currentCol] == 'O') {
                    // Mark connected 'O' regions as 'S' using BFS
                    markSafeRegion(board, currentRow, currentCol, n, m);
                }
                currentCol--;
            }

            // Traverse left boundary
            currentRow = n - 1;
            currentCol = 0;
            while (currentRow >= 0) {
                if (board[currentRow][currentCol] == 'O') {
                    // Mark connected 'O' regions as 'S' using BFS
                    markSafeRegion(board, currentRow, currentCol, n, m);
                }
                currentRow--;
            }

            // Update board: convert remaining 'O' to 'X' and 'S' back to 'O'
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X'; // Capture surrounded regions
                    } else if (board[i][j] == 'S') {
                        board[i][j] = 'O'; // Restore safe regions
                    }
                }
            }

            // Return the modified board
            return board;
        }

        // Marks all connected 'O' regions as 'S' using BFS
        private static void markSafeRegion(char[][] board, int row, int col, int numRows, int numCols) {
            // Mark the starting cell as 'S'
            board[row][col] = 'S';
            // Initialize queue for BFS
            Queue<Coordinate> queue = new LinkedList<>();
            queue.offer(new Coordinate(row, col));

            // Process all connected 'O' cells
            while (!queue.isEmpty()) {
                // Get the next coordinate from the queue
                Coordinate current = queue.poll();
                int currentRow = current.row;
                int currentCol = current.col;

                // Ensure the current cell is marked as 'S'
                board[currentRow][currentCol] = 'S';

                // Check all four directions
                for (int i = 0; i < 4; i++) {
                    // Calculate new coordinates
                    int nextRow = currentRow + rowOffsets[i];
                    int nextCol = currentCol + colOffsets[i];

                    // If the new position is valid and contains 'O', add to queue
                    if (isValidPosition(nextRow, nextCol, numRows, numCols) && board[nextRow][nextCol] == 'O') {
                        queue.offer(new Coordinate(nextRow, nextCol));
                    }
                }
            }
        }

        // Check if the given coordinates are within board bounds
        private static boolean isValidPosition(int row, int col, int numRows, int numCols) {
            return (row >= 0 && row < numRows) && (col >= 0 && col < numCols);
        }
    }

    public static void main(String[] args) {

    }
}
