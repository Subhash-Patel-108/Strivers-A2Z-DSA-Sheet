package Recursion.CombinationsOrHard;

public class WordSearch {
    public static class Solution {
        public static boolean exist(char[][] board, String word) {
            // Edge cases
            if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
                return false;
            }

            int m = board.length;
            int n = board[0].length;

            // Try starting from each cell
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        //function to perform DFS
        private static boolean dfs(char[][] board, int i, int j, String word, int index) {
            // Base case: If all characters are matched
            if (index == word.length()) {
                return true;
            }

            // Check if current position is valid
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
                return false;
            }

            // Mark cell as visited
            char temp = board[i][j];
            board[i][j] = '#'; // Temporary marker to avoid reuse

            // Explore four directions: up, down, next, right
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if (dfs(board, newI, newJ, word, index + 1)) {
                    return true;
                }
            }

            // Backtrack: Restore cell
            board[i][j] = temp;
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
