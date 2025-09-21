package Matrices.Easy;
//Problem Link: https://www.naukri.com/code360/problems/inplace-rotate-matrix-90-degree_839734?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class InPlaceRotateMatrix90Degree {

    public static class Solution {
        public static void inplaceRotate(int[][] matrix, int size) {
            // Handle edge case: null matrix or empty matrix
            if (matrix == null || size == 0) {
                return;
            }

            // Step 1: Transpose the matrix (swap elements across main diagonal)
            for (int row = 0; row < size; row++) {
                for (int col = row; col < size; col++) {
                    swapElements(matrix, row, col);
                }
            }

            // Step 2: Reverse each column
            reverseColumns(matrix, size);
        }

        // Swaps elements across the main diagonal
        private static void swapElements(int[][] matrix, int row, int col) {
            // Store the value at [row][col]
            int temp = matrix[row][col];
            // Swap with [col][row]
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;
        }

        // Reverses each column of the matrix
        private static void reverseColumns(int[][] matrix, int size) {
            for (int col = 0; col < size; col++) {
                // Initialize pointers for top and bottom of column
                int top = 0;
                int bottom = size - 1;
                // Swap elements until pointers meet
                while (top < bottom) {
                    int temp = matrix[top][col];
                    matrix[top][col] = matrix[bottom][col];
                    matrix[bottom][col] = temp;
                    top++;
                    bottom--;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
