package DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

//Problem Link : https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PartitionsWithGivenDifference {


    public static class Solution {
        private static final int MOD = 1_000_000_007;

        public static int countPartitions(int[] numbers, int difference) {
            // Handle edge case: null or empty array returns 0
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            // Calculate total sum of array elements
            int totalSum = 0;
            for (int num : numbers) {
                totalSum += num;
            }

            /*
             * Sum(subset1) - Sum(subset2) = difference
             * Sum(subset1) + Sum(subset2) = totalSum
             * 2 * Sum(subset1) = totalSum + difference
             * Sum(subset1) = (totalSum + difference) / 2
             */
            if ((totalSum + difference) % 2 != 0) {
                return 0; // If sum is odd, partitioning is impossible
            }

            // Calculate target sum for subset1
            int targetSum = (totalSum + difference) / 2;

            // Initialize memoization array
            int[][] memo = new int[numbers.length][targetSum + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            // Count subsets with target sum
            return countSubsetsWithSum(numbers, numbers.length - 1, targetSum, memo);
        }

        // Recursively count subsets with given sum using memoization
        private static int countSubsetsWithSum(int[] numbers, int index, int targetSum, int[][] memo) {
            // Base case: at index 0
            if (index == 0) {
                // If target is 0 and element is 0, return 2 (include or exclude)
                if (targetSum == 0 && numbers[0] == 0) return 2;
                // If target is 0 or equals first element, return 1
                if (targetSum == 0 || numbers[0] == targetSum) return 1;
                return 0;
            }

            // Return cached result if available
            if (memo[index][targetSum] != -1) {
                return memo[index][targetSum];
            }

            // Initialize count for including current element
            int includeCount = 0;
            // Include current element if it doesn't exceed target
            if (targetSum >= numbers[index]) {
                includeCount = countSubsetsWithSum(numbers, index - 1, targetSum - numbers[index], memo);
            }

            // Count excluding current element
            int excludeCount = countSubsetsWithSum(numbers, index - 1, targetSum, memo);

            // Store and return total count, applying modulo
            return memo[index][targetSum] = (includeCount + excludeCount) % MOD;
        }
    }


    public static void main(String[] args) {

    }
}
