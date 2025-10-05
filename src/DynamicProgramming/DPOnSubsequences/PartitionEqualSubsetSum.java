package DynamicProgramming.DPOnSubsequences;
import java.util.Arrays;

//Problem Link : https://www.naukri.com/code360/problems/partition-equal-subset-sum_892980?interviewProblemRedirection=true&page=2&practice_topic%5B%5D=Dynamic%20Programming&sort_entity=company_count&sort_order=DESC
public class PartitionEqualSubsetSum {

    public static class Solution {
        public static boolean canPartition(int[] arr, int n) {
            // Handle edge case: null or empty array returns true
            if (arr == null || n == 0) {
                return true;
            }

            // Calculate total sum of array elements
            int totalSum = 0;
            for (int num : arr) {
                totalSum += num;
            }

            // If total sum is odd, cannot partition into two equal subsets
            if ((totalSum & 1) != 0) {
                return false;
            }

            // Target sum for each subset is half of total sum
            int targetSum = totalSum / 2;

            // Initialize dp array of size n * (targetSum + 1) with -1
            int[][] dpArray = new int[n][targetSum + 1];
            for (int row = 0; row < n; row++) {
                Arrays.fill(dpArray[row], -1);
            }

            // Check if subset with target sum exists
            return isSubsetPresent(arr, n - 1, targetSum, dpArray);
        }

        // Recursively check if subset with given sum exists using memoization
        private static boolean isSubsetPresent(int[] arr, int idx, int target, int[][] dpArray) {
            // Base case: target sum is 0, subset exists
            if (target == 0) {
                return true;
            }
            // Base case: at first element, check if it equals target
            else if (idx == 0) {
                return arr[idx] == target;
            }

            // Return cached result if already computed
            if (dpArray[idx][target] != -1) {
                return dpArray[idx][target] == 1;
            }

            // Check if including current element leads to valid subset
            boolean includeCurrentElement = false;
            if (target >= arr[idx]) {
                includeCurrentElement = isSubsetPresent(arr, idx - 1, target - arr[idx], dpArray);
            }

            // Check if excluding current element leads to valid subset
            boolean notIncludeCurrentElement = isSubsetPresent(arr, idx - 1, target, dpArray);

            // Store result in dp array (1 for true, 0 for false)
            dpArray[idx][target] = (includeCurrentElement || notIncludeCurrentElement) ? 1 : 0;

            // Return true if subset exists
            return dpArray[idx][target] == 1;
        }
    }
    public static void main(String[] args) {

    }
}
