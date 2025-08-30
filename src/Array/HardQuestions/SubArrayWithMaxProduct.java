package Array.HardQuestions;

public class SubArrayWithMaxProduct {
    public static class Solution {
        public static int subarrayWithMaxProduct(int[] arr) {
            int maximumProduct = 0;

            // Edge case: if array is null or empty, return 0
            if (arr == null || arr.length == 0) {
                return maximumProduct;
            }

            int size = arr.length;
            int prefixProduct = 1, suffixProduct = 1;

            // Traverse array from both ends simultaneously
            for (int i = 0; i < size; i++) {
                // If prefixProduct becomes 0, reset it to 1 to start fresh
                if (prefixProduct == 0) {
                    prefixProduct = 1;
                }
                // If suffixProduct becomes 0, reset it to 1 to start fresh
                if (suffixProduct == 0) {
                    suffixProduct = 1;
                }

                // Multiply prefixProduct by current element from left
                prefixProduct *= arr[i];

                // Multiply suffixProduct by current element from right
                suffixProduct *= arr[size - i - 1];

                // Update maximumProduct with the maximum of current prefixProduct and suffixProduct
                maximumProduct = Math.max(maximumProduct, Math.max(prefixProduct, suffixProduct));
            }

            return maximumProduct;
        }

    }
    public static void main(String[] args) {

    }
}
