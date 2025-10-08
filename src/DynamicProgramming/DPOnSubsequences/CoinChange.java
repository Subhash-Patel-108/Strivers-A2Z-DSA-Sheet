package DynamicProgramming.DPOnSubsequences;
import java.util.Arrays ;

//Problem link: https://www.geeksforgeeks.org/problems/number-of-coins1824/1
public class CoinChange {

    public static class Solution {
        public int minCoins(int[] coins, int sum) {
            // Handle edge case: null coins array or zero sum returns 0
            if (coins == null || sum == 0) {
                return 0;
            }

            // Initialize memoization array with -1 for uncomputed states
            int[][] dpArray = new int[coins.length][sum + 1];
            for (int[] row : dpArray) {
                Arrays.fill(row, -1);
            }

            // Compute minimum coins needed
            int minimumCoins = findMinimumCoinsChange(coins, sum, coins.length - 1, dpArray);

            // Return -1 if minimum coins exceed a large value (impossible case), else return result
            return minimumCoins > sum ? -1 : minimumCoins;
        }

        // Recursively find minimum coins needed for target sum using memoization
        private static int findMinimumCoinsChange(int[] coins, int target, int index, int[][] dpArray) {
            // Base case: at first coin
            if (index == 0) {
                // If target is divisible by first coin, return number of coins needed
                if (target % coins[index] == 0) {
                    return target / coins[index];
                }
                // Otherwise, return large value to indicate impossible
                return (int) 1e9;
            }

            // Return cached result if available
            if (dpArray[index][target] != -1) {
                return dpArray[index][target];
            }

            // Initialize include option with large value
            int includeCurrentCoin = Integer.MAX_VALUE;
            // Include current coin if it doesn't exceed target
            if (target >= coins[index]) {
                includeCurrentCoin = 1 + findMinimumCoinsChange(coins, target - coins[index], index, dpArray);
            }

            // Exclude current coin
            int excludeCurrentCoin = findMinimumCoinsChange(coins, target, index - 1, dpArray);

            // Store and return minimum of including or excluding current coin
            return dpArray[index][target] = Math.min(includeCurrentCoin, excludeCurrentCoin);
        }
    }

    public static void main(String[] args) {

    }
}
