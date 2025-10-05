package DynamicProgramming.OneDDynamicProgramming;
import String.MediumQuestions.IntegerToRoman;

import java.util.Arrays ;
//Problem Link : https://www.naukri.com/code360/problems/frog-jump_3621012
//Problem Link : https://www.geeksforgeeks.org/problems/geek-jump/1

public class FrogJump {

    //Solve the problem using top to bottom (Memoization + Recursion) DP
    public static class SolutionUsingMemoization {
        public static int frogJump(int n, int[] heights) {
            //Edge case
            if(heights == null || n == 1 ) {
                return 0 ;
            }

            //Step 1: Create a dp array of size n + 1
            int[] dpArray = new int[n + 1] ;

            //Step 2: Initialize the dp array with -1
            Arrays.fill(dpArray , -1) ;

            return findMinCost(n - 1 , heights , dpArray) ;
        }

        private static int findMinCost(int idx , int[] heights , int[] dp) {
            //Base case
            if(idx == 0) {
                return 0 ;
            }

            //Step 3: Check if the answer is present in the dp array
            if(dp[idx] != -1 ) {
                return dp[idx] ; // if already presents return the ans
            }

            int leftCost = findMinCost(idx - 1 , heights , dp) + Math.abs(heights[idx] - heights[idx - 1]) ;

            int rightCost = Integer.MAX_VALUE ;
            if(idx > 1 ) {
                rightCost = findMinCost(idx - 2 , heights , dp) + Math.abs(heights[idx] - heights[idx - 2]) ;
            }

            //Step 2: Store the answer in the dp array
            return dp[idx] = Math.min(leftCost , rightCost) ;
        }

    }

    //Solve the problem using bottom to top (tabulation)DP
    public static class SolutionUsingTabulation {
        public static int frogJump(int n, int[] heights) {
            //Edge case
            if(heights == null || n == 1 ) {
                return 0 ;
            }

            //Step 1: Create a dp array of size n + 1
            int[] dpArray = new int[n + 1] ;

            //Step 2: Initialize the dp array with base cases
            dpArray[0] = 0 ;

            for(int idx = 1 ; idx < n ; idx++ ) {
                //Find the left and right cost
                int left = dpArray[idx - 1] + Math.abs(heights[idx] - heights[idx - 1]) ;

                int right = Integer.MAX_VALUE ;
                if (idx > 1) {
                    right = dpArray[idx - 2] + Math.abs(heights[idx] - heights[idx - 2]) ;
                }

                dpArray[idx] = Math.min(left , right) ;
            }
            return dpArray[n - 1];
        }
    }

    //Solve the problem using tabulation with space optimization
    public static class SolutionUsingTabulationWithSpaceOptimization {
        public static int frogJump(int n, int[] heights) {
            // Handle edge case: null array or single stone returns 0
            if (heights == null || n == 1) {
                return 0;
            }

            // Initialize variables for previous one-step and two-step costs
            int oneStepPrev = 0, twoStepPrev = Integer.MAX_VALUE;

            // Iterate through stones starting from index 1
            for (int idx = 1; idx < n; idx++) {
                // Cost of jumping from one step back
                int left = oneStepPrev + Math.abs(heights[idx] - heights[idx - 1]);
                // Cost of jumping from two steps back, if possible
                int right = Integer.MAX_VALUE;
                if (idx > 1) {
                    right = twoStepPrev + Math.abs(heights[idx] - heights[idx - 2]);
                }
                // Minimum cost to reach current stone
                int curr = Math.min(left, right);
                // Update previous costs: shift oneStepPrev to twoStepPrev, set curr as oneStepPrev
                twoStepPrev = oneStepPrev;
                oneStepPrev = curr;
            }

            // Return minimum cost to reach last stone
            return oneStepPrev;
        }
    }

    public static void main(String[] args) {

    }
}
