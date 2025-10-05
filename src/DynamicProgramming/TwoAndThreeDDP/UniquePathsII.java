package DynamicProgramming.TwoAndThreeDDP;
import java.util.ArrayList ;

//Problem Link: https://www.naukri.com/code360/problems/unique-paths-ii_977241
//Problem Link: https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1
//Problem Link: https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePathsII {

    public static class Solution {
        private static final int MOD = 100_000_0007;

        public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            // Handle edge case: null matrix or zero dimensions returns 0
            if (mat == null || (n == 0 && m == 0)) {
                return 0;
            }

            // Initialize dp array with -1 to indicate uncomputed states
            int[][] dpArray = new int[n][m];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    dpArray[row][col] = -1;
                }
            }

            // Compute and return total paths to reach bottom-right cell
            return findAllThePathWithObstacles(n - 1, m - 1, mat, dpArray);
        }

        // Recursively find paths to (row, col) with obstacles using memoization
        private static int findAllThePathWithObstacles(int row, int col, ArrayList<ArrayList<Integer>> grid, int[][] dpArray) {
            // Base case: reached top-left cell and it's not an obstacle, return 1
            if (row == 0 && col == 0 && grid.get(row).get(col) != -1) {
                return 1;
            }
            // Base case: out of bounds or obstacle encountered, return 0
            else if (row < 0 || col < 0 || grid.get(row).get(col) == -1) {
                return 0;
            }

            // Return cached result if already computed
            if (dpArray[row][col] != -1) {
                return dpArray[row][col];
            }

            // Calculate paths from up and left, applying modulo
            int upPaths = findAllThePathWithObstacles(row - 1, col, grid, dpArray) % MOD;
            int leftPaths = findAllThePathWithObstacles(row, col - 1, grid, dpArray) % MOD;

            // Store and return total paths for current cell, applying modulo
            return dpArray[row][col] = (upPaths + leftPaths) % MOD;
        }
    }

    public static void main(String[] args) {

    }
}
