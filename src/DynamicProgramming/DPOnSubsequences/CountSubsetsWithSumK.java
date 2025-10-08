package DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

//Problem link: https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532
public class CountSubsetsWithSumK {

    //Or Perfect Sum Problem
    public static class Solution {
        private final static int MOD = 1_000_000_007 ; ;
        public static int findWays(int[] num, int tar) {
            //Edge case
            if(num == null || num.length == 0) {
                return 0 ;
            }

            //Step 1: Create dp Array of size n * tar + 1
            int[][] dpArray = new int[num.length][tar + 1] ;

            //Initialization with -1
            for(int row = 0 ; row < num.length ; row++) {
                for(int col = 0 ; col <= tar ; col++ ) {
                    dpArray[row][col] = -1 ;
                }
            }

            return findTotalNumberOfWays(num , tar , num.length - 1 , dpArray) ;
        }

        private static int findTotalNumberOfWays(int[] nums , int target , int idx , int[][] dpArray) {
            //Base case
            if (idx == 0) {
                if (target == 0 && nums[0] == 0) return 2;  // two ways: take or not take zero
                if (target == 0 || target == nums[0]) return 1;
                return 0;
            }

            //Step 3: if the value is present, then return the answer
            if (dpArray[idx][target] != -1) {
                return dpArray[idx][target] ;
            }

            int includeCurrentElement = 0 ;
            if (target >= nums[idx]) {
                includeCurrentElement = findTotalNumberOfWays(nums , target - nums[idx] , idx - 1 , dpArray) % MOD;
            }

            int notIncludeCurrentElement = findTotalNumberOfWays(nums , target , idx - 1 , dpArray) % MOD ;

            return dpArray[idx][target] = (includeCurrentElement + notIncludeCurrentElement ) % MOD  ;
        }
    }
    public static void main(String[] args) {

    }
}
