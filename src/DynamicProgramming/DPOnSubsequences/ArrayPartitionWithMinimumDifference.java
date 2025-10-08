package DynamicProgramming.DPOnSubsequences;

import javax.xml.transform.stax.StAXResult;

public class ArrayPartitionWithMinimumDifference {

    public static class Solution {
        public static int minSubsetSumDifference(int []arr, int n) {
            //Edge case
            if (arr == null || n == 0 ) {
                return 0 ;
            }

            //Find the totalSum
            int totalSum = 0 ;
            for(int num : arr ) {
                totalSum += num ;
            }

            //create a boolean array for tabulation
            boolean[][] dpArray = new boolean[n][totalSum + 1];

            subsetSumTabulation(arr , n , totalSum , dpArray);

            int minDiff = Integer.MAX_VALUE ;
            for(int col = 0 ; col <= totalSum / 2 ; col++ ){
                if(dpArray[n - 1][col]) {
                    int firstSet = col ;
                    int secondSet = totalSum - col ;
                    minDiff = Math.min(minDiff , Math.abs(firstSet - secondSet)) ;
                }
            }

            return minDiff ;
        }

        private static void subsetSumTabulation(int[] arr , int n , int k , boolean[][] dpArray) {

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

            return ;
        }
    }

    public static void main(String[] args) {

    }
}
