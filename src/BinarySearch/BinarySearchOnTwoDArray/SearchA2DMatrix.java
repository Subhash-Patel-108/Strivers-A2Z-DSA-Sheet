package BinarySearch.BinarySearchOnTwoDArray;

public class SearchA2DMatrix {
    public static class Solution {
        //function to search in 2D matrix
        public boolean searchMatrix(int[][] matrix, int target) {
            // Edge case: Check for null or empty matrix
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int row = 0; // Start at the first row
            int col = matrix[0].length - 1; // Start at the last column

            // Continue searching while within matrix bounds
            while (row < matrix.length && col >= 0) {
                // Current element at matrix[row][col]
                int current = matrix[row][col];
                if (current == target) {
                    // Target found
                    return true;
                } else if (current < target) {
                    // Current element is less than target, eliminate this row
                    // Move down to the next row, as target must be in a later row
                    row++;
                } else {
                    // Current element is greater than target, eliminate this column
                    // Move next to the previous column, as target must be in an earlier column
                    col--;
                }
            }

            // Target not found after searching
            return false;
        }
    }
    public static void main(String[] args) {

    }
}
