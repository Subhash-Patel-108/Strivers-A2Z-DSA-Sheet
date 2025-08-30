package BinarySearch.BinarySearchOnAnswer;

public class CapacityToShipPackagesWithinDDays {
    public static class Solution {
        // Helper method to check if it's possible to ship all packages within 'day' days
// without exceeding the given 'maxWeight' per day
        private static boolean isPossible(int[] weights, int day, int maxWeight) {
            int totalDays = 0;     // Counts the number of days needed
            int totalWeight = 0;   // Accumulates weight for the current day

            // Loop through each package's weight
            for (int weight : weights) {
                totalWeight += weight;  // Add current package to day's total

                // If the day's total exceeds the maxWeight, allocate a new day
                if (totalWeight > maxWeight) {
                    totalDays++;
                    totalWeight = weight;  // Start new day with current package
                }
            }

            // Account for last day if any uncounted weight remains
            if (totalWeight > 0) {
                totalDays++;
            }

            // Return true if packages can be shipped in 'day' days or less
            return totalDays <= day;
        }

        // Main function to find the least weight capacity needed to ship all packages in 'd' days
        public static int leastWeightCapacity(int[] weights, int d) {
            int start = Integer.MIN_VALUE, end = 0;

            // Find the initial search bounds:
            // 'start' is the largest single package (minimum possible maxWeight)
            // 'end' is the sum of all weights (maximum possible maxWeight)
            for (int weight : weights) {
                start = Math.max(start, weight);
                end += weight;
            }

            int minWeight = -1, mid;

            // Binary search for the minimal maxWeight that works
            while (start <= end) {
                mid = start + (end - start) / 2;

                // If it's possible to ship with 'mid' as max weight, try for a lower value
                if (isPossible(weights, d, mid)) {
                    minWeight = mid;
                    end = mid - 1;
                } else {
                    // Otherwise, increase the maxWeight and try again
                    start = mid + 1;
                }
            }

            // Returns the minimal shipping capacity found
            return minWeight;
        }

    }
    public static void main(String[] args) {

    }
}
