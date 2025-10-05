package DynamicProgramming.TwoAndThreeDDP;

//Problem Link: https://leetcode.com/problems/unique-paths/description/
public class CountAllUniquePath {

    public static class SolutionUsingMemoization {
        public int uniquePaths(int m, int n) {
            // Handle edge case: zero rows or columns returns 0
            if (m == 0 || n == 0) {
                return 0;
            }

            // Initialize dp array with -1 to indicate uncomputed states
            int[][] dpArray = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dpArray[i][j] = -1;
                }
            }

            // Compute and return total unique paths to reach (m-1, n-1)
            return findAllUniquePath(m - 1, n - 1, dpArray);
        }

        // Recursively find unique paths to (row, col) using memoization
        private static int findAllUniquePath(int row, int col, int[][] dpArray) {
            // Base case: reached starting point (0, 0), one valid path
            if (row == 0 && col == 0) {
                return 1;
            }
            // Base case: out of bounds, no valid path
            else if (row < 0 || col < 0) {
                return 0;
            }

            // Return cached result if already computed
            if (dpArray[row][col] != -1) {
                return dpArray[row][col];
            }

            // Calculate paths from moving up and left
            int upPaths = findAllUniquePath(row - 1, col, dpArray);
            int leftPaths = findAllUniquePath(row, col - 1, dpArray);

            // Store and return total paths for current position
            return dpArray[row][col] = upPaths + leftPaths;
        }
    }

    public static void main(String[] args) {

    }
}
