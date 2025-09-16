package StackAndQueue.MonotonicStackAndQueueProblem;

public class TrappingRainWater {
    public static class Solution {
        // Calculates the maximum water that can be trapped between bars of given heights
        public int maxWater(int[] arr) {
            // Handle edge case: return 0 if array is null or empty
            if (arr == null || arr.length == 0) {
                return 0;
            }
            // Store the size of the input array
            int size = arr.length;
            // Initialize array to store maximum height from the right (suffix max)
            int[] suffix = new int[size];
            // Set the last element's suffix max as itself
            suffix[size - 1] = arr[size - 1];

            // Compute suffix max array from right to left
            for (int idx = size - 2; idx >= 0; idx--) {
                suffix[idx] = Math.max(suffix[idx + 1], arr[idx]);
            }

            // Track maximum height from the left
            int leftMaxValue = 0;
            // Accumulate total units of trapped water
            int totalUnitWater = 0;

            // Iterate through the array to calculate trapped water at each position
            for (int i = 0; i < size; i++) {
                // Find the minimum of left and right max heights
                int minHeight = Math.min(suffix[i], leftMaxValue);

                // If minHeight exceeds current height, water can be trapped
                if (minHeight > arr[i]) {
                    totalUnitWater += minHeight - arr[i];
                }
                // Update left max height
                leftMaxValue = Math.max(leftMaxValue, arr[i]);
            }

            // Return the total units of trapped water
            return totalUnitWater;
        }
    }

    public static void main(String[] args) {

    }
}
