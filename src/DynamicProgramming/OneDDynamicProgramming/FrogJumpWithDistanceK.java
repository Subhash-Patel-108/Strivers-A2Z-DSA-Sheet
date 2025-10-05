package DynamicProgramming.OneDDynamicProgramming;
import java.util.Arrays ;
public class FrogJumpWithDistanceK {

    //Solve the problem using top to bottom (Memoization + Recursion)
    public static class Solution {

        public int frogJump(int[] heights, int k) {
            //Edge case
            if(heights == null || heights.length <= k ) {
                return 0 ;
            }

            //Step 1: Create a DP array of size n + 1 and initialize it with -1
            int[] dpArray = new int[heights.length + 1] ;
            Arrays.fill(dpArray , -1 ) ;

            return minCostWithAtMostKJump(heights , heights.length - 1 , k , dpArray) ;
        }
        private static int minCostWithAtMostKJump(int[] heights , int idx , int k , int[] dpArray) {
            //Base case
            if(idx == 0) {
                return 0 ;
            }

            //Step 3: Check if the answer is present in the dp array
            if (dpArray[idx] != -1) {
                return dpArray[idx] ;
            }

            int minSteps = Integer.MAX_VALUE;

            // Try all possible jumps (1 to k)
            for (int steps = 1; steps <= k; steps++) {
                if (idx - steps >= 0) {
                    int currentCost = minCostWithAtMostKJump(heights, idx - steps, k, dpArray) + Math.abs(heights[idx] - heights[idx - steps]);
                    minSteps = Math.min(minSteps, currentCost);
                }
            }

            dpArray[idx] = minSteps;

            //Step 2: Return the answer
            return dpArray[idx] ;
        }
    }
    public static void main(String[] args) {

    }
}
