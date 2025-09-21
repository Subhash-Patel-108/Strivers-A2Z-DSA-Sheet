package Matrices.Medium;

import java.util.*;

public class WordSearchI {
    public static class Solution {
        // Directional offsets for 4-directional movement (down, up, right, left)
        private final static int[] rowOffsets = {1, -1, 0, 0};
        private final static int[] colOffsets = {0, 0, 1, -1};
        // Number of rows in the grid
        private static int numRows;
        // Number of columns in the grid
        private static int numCols;

        public static boolean present(char[][] board, String word, int n, int m) {
            // Handle edge cases: null board, empty board, or empty word
            if (board == null || board.length == 0 || word.isEmpty()) {
                return false;
            }

            // Set grid dimensions
            numRows = n;
            numCols = m;

            // Find the first character of the word in the grid
            char firstChar = word.charAt(0);
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (board[row][col] == firstChar) {
                        // Initialize visited array for DFS
                        boolean[][] visited = new boolean[numRows][numCols];
                        // Start DFS from current cell
                        if (searchWord(board, visited, row, col, word, 0)) {
                            return true;
                        }
                    }
                }
            }

            // Word not found
            return false;
        }

        // Recursively searches for the word in the grid using DFS
        private static boolean searchWord(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
            // If all characters are matched, word is found
            if (index == word.length()) {
                return true;
            }

            // Check if current position is invalid or character doesn't match
            if (row < 0 || row >= numRows || col < 0 || col >= numCols ||
                    visited[row][col] || board[row][col] != word.charAt(index)) {
                return false;
            }

            // Mark current cell as visited
            visited[row][col] = true;

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int nextRow = row + rowOffsets[i];
                int nextCol = col + colOffsets[i];

                // Recursively search for next character
                if (searchWord(board, visited, nextRow, nextCol, word, index + 1)) {
                    return true;
                }
            }

            // Backtrack by unmarking the current cell
            visited[row][col] = false;

            // Word not found in this path
            return false;
        }
    }
    public static void main(String[] args) {
        return ;
    }
}
