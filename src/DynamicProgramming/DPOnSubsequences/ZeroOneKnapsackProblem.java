package DynamicProgramming.DPOnSubsequences;
import java.util.* ;


//Problem Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class ZeroOneKnapsackProblem {

    public static class Solution {
        public static int knapsack(int W, int val[], int wt[]) {
            // Handle edge case: zero capacity or null arrays return 0
            if (W == 0 || val == null || wt == null || val.length == 0 || wt.length == 0) {
                return 0;
            }

            // Initialize memoization array with -1 for uncomputed states
            int[][] memo = new int[val.length][W + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            // Compute and return maximum value for knapsack
            return findMaximumValue(val, wt, val.length - 1, W, memo);
        }

        // Recursively find maximum value using memoization
        private static int findMaximumValue(int[] values, int[] weights, int index, int capacity, int[][] memo) {
            // Base case: at first item
            if (index == 0) {
                // Include item if weight allows, else return 0
                if (weights[index] <= capacity) {
                    return values[index];
                }
                return 0;
            }

            // Return cached result if available
            if (memo[index][capacity] != -1) {
                return memo[index][capacity];
            }

            // Initialize value for including current item
            int includeValue = Integer.MIN_VALUE;
            // Include current item if weight allows
            if (capacity >= weights[index]) {
                includeValue = values[index] + findMaximumValue(values, weights, index - 1, capacity - weights[index], memo);
            }
            // Exclude current item
            int excludeValue = findMaximumValue(values, weights, index - 1, capacity, memo);

            // Store and return maximum of including or excluding current item
            return memo[index][capacity] = Math.max(includeValue, excludeValue);
        }
    }

    public static void main(String[] args) {
        
    }
}
