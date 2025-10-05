package DynamicProgramming.OneDDynamicProgramming;
import java.util.ArrayList ;
import java.util.Arrays ;

//Problem Link :https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261
//Problem Link :https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1

public class MaxSumWithoutAdjacent {
    //Solution Using Memoization (Top Down)
    public static class SolutionUsingMemoization {
        public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
            //Edge case
            if(nums == null || nums.isEmpty()) {
                return 0 ;
            }

            //Step 1: Create a DP array of size n + 1 and initialize it with -1
            int[] dpArray = new int[nums.size() + 1] ;
            Arrays.fill(dpArray , -1) ;

            return findMaximumSumOfNonAdjacentElements(nums , nums.size() - 1 , dpArray) ;
        }

        private static int findMaximumSumOfNonAdjacentElements(ArrayList<Integer> nums , int idx , int[] dpArray)  {
            //Base case
            if(idx == 0) {
                return nums.get(0) ;
            }else if (idx < 0) {
                return 0 ;
            }

            //Step 3: if the value is presents then return the answer
            if(dpArray[idx] != -1) {
                return dpArray[idx] ;
            }

            int includeCurrentElement = findMaximumSumOfNonAdjacentElements(nums , idx - 2 , dpArray) + nums.get(idx) ;
            int notIncludeCurrentElement = findMaximumSumOfNonAdjacentElements(nums , idx - 1 , dpArray )  ;

            //Step 2: Store the answer in the dp array
            return dpArray[idx] = Math.max(includeCurrentElement , notIncludeCurrentElement) ;
        }
    }

    //Solution using Tabulation (Bottom Up)
    public static class SolutionUsingTabulation {
        public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
            //Edge case
            if(nums == null || nums.isEmpty()) {
                return 0 ;
            }

            int[] dpArray = new int[nums.size() + 1] ;
            dpArray[0] = nums.get(0) ;

            for(int idx = 1 ; idx < nums.size() ; idx++ ) {
                int includeCurrentElement = nums.get(idx) ;
                if(idx >= 2) {
                    includeCurrentElement += dpArray[idx - 2] ;
                }
                int notIncludeCurrentElement = dpArray[idx - 1] ;

                dpArray[idx] = Math.max(includeCurrentElement , notIncludeCurrentElement) ;
            }

            return dpArray[nums.size() - 1] ;
        }
    }
    public static void main(String[] args) {

    }
}
