package DynamicProgramming.DPOnSubsequences;

//Problem Link : https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954
public class SubsetSumEqualToK {

    public static class SolutionUsingMemoization {
        public static boolean subsetSumToK(int n, int k, int[] arr) {
            // Handle edge case: null or empty array returns false
            if (arr == null || arr.length == 0) {
                return false;
            }

            // Initialize dp array of size n * (k + 1) with -1 for uncomputed states
            int[][] dpArray = new int[n][k + 1];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < k + 1; col++) {
                    dpArray[row][col] = -1;
                }
            }

            // Compute and return if subset with sum k exists
            return isSubsetPresent(arr, n - 1, k, dpArray);
        }

        // Recursively check if subset with given sum exists using memoization
        private static boolean isSubsetPresent(int[] arr, int idx, int target, int[][] dpArray) {
            // Base case: target sum is 0, subset exists
            if (target == 0) {
                return true;
            }
            // Base case: at first element, check if it equals target
            else if (idx == 0) {
                return arr[0] == target;
            }

            // Return cached result if already computed
            if (dpArray[idx][target] != -1) {
                return dpArray[idx][target] == 1;
            }

            // Initialize flag for including current element
            boolean includeCurrentElement = false;
            // Include current element if it doesn't exceed target
            if (target >= arr[idx]) {
                includeCurrentElement = isSubsetPresent(arr, idx - 1, target - arr[idx], dpArray);
            }
            // Exclude current element
            boolean notIncludeCurrentElement = isSubsetPresent(arr, idx - 1, target, dpArray);

            // Store result in dp array (1 for true, 0 for false)
            dpArray[idx][target] = includeCurrentElement || notIncludeCurrentElement ? 1 : 0;

            // Return true if subset exists
            return dpArray[idx][target] == 1;
        }
    }

    public static class SolutionUsingTabulation {
        public static boolean subsetSumToK(int n, int k, int[] arr) {
            // Handle edge case: null or empty array returns false
            if (arr == null || arr.length == 0) {
                return false;
            }

            // Initialize dp array of size n * (k + 1) with -1 for uncomputed states
            boolean [][] dpArray = new boolean[n][k + 1];

            //Write all the base cases
            for(int i = 0 ; i < n ; i++) {
                dpArray[i][0] = true ;
            }

            if(arr[0] <= k ) {
                dpArray[0][arr[0]] = true ;
            }

            for(int idx = 1 ; idx < n ; idx++ ) {
                for(int target = 1 ; target <= k ; target++ ) {
                    boolean includeCurrentElement = false ;
                    if(target >= arr[idx]) {
                        includeCurrentElement = dpArray[idx - 1][target - arr[idx]] ;
                    }
                    boolean notIncludeCurrentElement = dpArray[idx - 1][target] ;

                    dpArray[idx][target] = includeCurrentElement || notIncludeCurrentElement ;
                }
            }

            return dpArray[n - 1][k] ;
        }
    }
    public static void main(String[] args) {

    }
}
