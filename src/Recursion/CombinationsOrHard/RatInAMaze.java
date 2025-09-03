package Recursion.CombinationsOrHard;
import java.util.* ;
public class RatInAMaze {
    public static class Solution {
        // Directions: Up, Down, Left, Right
        private static final int[] rowsIndex = {-1, 1, 0, 0};
        private static final int[] columnsIndex = {0, 0, -1, 1};
        private static final char[] directions = {'U', 'D', 'L', 'R'};

        public static ArrayList<String> ratInMaze(int[][] arr) {
            ArrayList<String> result = new ArrayList<>();
            if (arr == null ) return result;

            int rows = arr.length - 1;
            int cols = arr[0].length - 1;

            if (arr[0][0] == 0 || arr[rows][cols] == 0) return result;

            StringBuilder current = new StringBuilder();
            helper(arr, 0, 0, rows, cols, current, result);

            // sort to match expected lexicographic output
            Collections.sort(result);
            return result;
        }
        private static void helper(int[][] arr, int row, int col, int targetRow, int targetCol,
                                   StringBuilder current, ArrayList<String> result) {
            if (row == targetRow && col == targetCol) {
                result.add(current.toString());
                return;
            }

            arr[row][col] = 0; // mark visited

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowsIndex[i];
                int newCol = col + columnsIndex[i];
                char dir = directions[i];

                if (isSafe(newRow, newCol, targetRow, targetCol) && arr[newRow][newCol] == 1) {
                    current.append(dir);
                    helper(arr, newRow, newCol, targetRow, targetCol, current, result);
                    current.deleteCharAt(current.length() - 1); // backtrack
                }
            }

            arr[row][col] = 1; // unmark
        }

        private static boolean isSafe(int row, int col, int targetRow, int targetCol) {
            return row >= 0 && col >= 0 && row <= targetRow && col <= targetCol;
        }
    }
    public static void main(String[] args) {

    }
}
