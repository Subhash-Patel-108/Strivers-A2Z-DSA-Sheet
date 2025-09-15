package BinarySearch.BinarySearchOnAnswer;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static class Solution {
        // Determines the minimum number of days required to get m bouquets of k consecutive flowers
        public int minDays(int[] bloomDay, int m, int k) {
            // If there are not enough flowers to make the required bouquets, return -1
            if (m * k > bloomDay.length) {
                return -1;
            }
            // Initialize the minimum and maximum days from the bloomDay array
            int minDays = Integer.MAX_VALUE, maxDays = Integer.MIN_VALUE;
            for (int day : bloomDay) {
                minDays = Math.min(minDays, day);
                maxDays = Math.max(maxDays, day);
            }
            // Use binary search to find the minimum day
            int left = minDays, right = maxDays;
            while (left < right) {
                int mid = (left + right) >>> 1;
                // Check if it's possible to make the bouquets by this day
                if (canMakeBouquets(bloomDay, m, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // The next boundary of binary search will be the answer
            return left;
        }

        // Helper method to check if it's possible to make the required number of bouquets by day 'currentDay'
        private boolean canMakeBouquets(int[] bloomDay, int numBouquets, int bouquetSize, int currentDay) {
            int bouquetsMade = 0, flowersInBouquet = 0;
            for (int day : bloomDay) {
                // If the flower is bloomed by 'currentDay', include it in the current bouquet
                if (day <= currentDay) {
                    flowersInBouquet++;
                    // If we've gathered enough flowers for a bouquet, increase the count and reset
                    if (flowersInBouquet == bouquetSize) {
                        bouquetsMade++;
                        flowersInBouquet = 0;
                    }
                } else {
                    // Flower is not bloomed, reset the count for the current bouquet
                    flowersInBouquet = 0;
                }
            }
            // Check if we have made at least 'numBouquets' bouquets
            return bouquetsMade >= numBouquets;
        }
    }

    public static void main(String[] args) {

    }
}
