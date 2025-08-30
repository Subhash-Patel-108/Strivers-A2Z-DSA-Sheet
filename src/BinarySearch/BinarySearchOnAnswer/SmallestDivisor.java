package BinarySearch.BinarySearchOnAnswer;

public class SmallestDivisor {
    public static class Solution {
        private static boolean isPossible(int[] nums, int threshold, int divisor) {
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num / divisor; // Integer division for the quotient
                if (num % divisor >= 1) {  // If there's a remainder, round up by adding 1
                    totalSum++;
                }
            }
            return totalSum <= threshold;
        }

        public int smallestDivisor(int[] nums, int threshold) {
            // Edge case: Check for null or empty array
            if (nums == null || nums.length == 0 || nums.length > threshold) {
                return -1;
            }

            // Initialize binary search bounds
            int low = 1; // Minimum possible divisor
            int high = Integer.MIN_VALUE; // Maximum value in nums
            for (int num : nums) {
                high = Math.max(high, num); // Find the maximum element to set upper bound
            }

            int smallestDivisor = -1; // Store the result
            int mid;

            // Binary search to find the smallest divisor
            while (low <= high) {
                mid = low + (high - low) / 2; // Avoid integer overflow
                if (isPossible(nums, threshold, mid)) {
                    smallestDivisor = mid; // Current divisor is valid, try a smaller one
                    high = mid - 1;
                } else {
                    low = mid + 1; // Sum exceeds threshold, try a larger divisor
                }
            }

            return smallestDivisor;
        }
    }
    public static void main(String[] args) {

    }
}
