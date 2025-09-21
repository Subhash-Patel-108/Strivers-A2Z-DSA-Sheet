package Matrices.Medium;
import java.util.* ;

//Problem Link:https://www.naukri.com/code360/problems/row-of-a-matrix-with-maximum-ones_982768?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class RowWithMaxOnes {

    public static class Solution {
        public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int numRows, int numCols) {
            // Handle edge case: null or empty matrix
            if (matrix == null || matrix.isEmpty()) {
                return -1;
            }

            // Initialize variables to track maximum 1s and corresponding row index
            int maxOnes = Integer.MIN_VALUE;
            int maxRowIndex = -1;

            // Iterate through each row to find the one with maximum 1s
            for (int row = 0; row < numRows; row++) {
                // Count 1s in the current row using binary search
                int onesCount = countOnes(matrix.get(row), numCols);

                // Update maxOnes and maxRowIndex if current row has more 1s
                if (onesCount > maxOnes) {
                    maxRowIndex = row;
                    maxOnes = onesCount;
                }
            }

            // Return the index of the row with maximum 1s
            return maxRowIndex;
        }

        // Counts the number of 1s in a sorted row using binary search
        private static int countOnes(ArrayList<Integer> row, int numCols) {
            // Initialize binary search pointers
            int left = 0;
            int right = numCols - 1;
            int firstOneIndex = -1;

            // Find the first occurrence of 1 using binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row.get(mid) == 1) {
                    firstOneIndex = mid; // Store potential first 1
                    right = mid - 1;     // Search left for earlier 1
                } else {
                    left = mid + 1;      // Search right for 1
                }
            }

            // If no 1s found, return 0; otherwise, return count of 1s
            return firstOneIndex == -1 ? 0 : numCols - firstOneIndex;
        }
    }

    public static class Solution2 {
        public static int rowMaxOnesOptimal(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
            if (matrix == null || matrix.isEmpty()) {
                return -1;
            }
            int row = 0, col = m - 1;
            int maxRowIndex = -1;

            while (row < n && col >= 0) {
                if (matrix.get(row).get(col) == 1) {
                    maxRowIndex = row;  // update row index
                    col--;              // move left
                } else {
                    row++;              // move down
                }
            }
            return maxRowIndex;
        }

    }
    public static void main(String[] args) {

    }
}
