package Array.HardQuestions;

public class MissingAndRepeatingNumbers {
     public static class Solution {
        public static int[] findMissingRepeatingNumbers(int []arr) {
            int n = arr.length;
            int duplicated = 0;
            int missing = 0;

            // Step 1: Mark elements and find the duplicated number
            for (int i = 0; i < n; i++) {
                int index = Math.abs(arr[i]) - 1; // Get index from value (1-based to 0-based)
                if (arr[index] > 0) {
                    arr[index] = -arr[index]; // Mark as visited by making negative
                } else {
                    duplicated = Math.abs(arr[i]); // Already negative, this is the duplicated number
                }
            }

            // Step 2: Find the missing number
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    missing = i + 1; // Positive value means this index + 1 is missing
                    break;
                }
            }

            // Return the result as [duplicated, missing]
            return new int[] {duplicated, missing};
        }
    }
    public static void main(String[] args) {

    }
}
