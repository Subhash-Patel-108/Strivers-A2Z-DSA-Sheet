package DynamicProgramming.OneDDynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    //The solution using the top to bottom approach (recursion + Memoization)
    public static class SolutionUsingMemoization {
        public static int houseRobber(int[] arr) {
            //Edge case
            if(arr == null || arr.length == 0 ) {
                return 0 ;
            }
            int size = arr.length ;
            //Step 1: Create a dp array of size n + 1 and initialize it with -1
            int[] dpArray = new int[size + 1 ] ;
            Arrays.fill(dpArray, -1 );

            return helper(arr , size - 1 , dpArray) ;
        }

        private static int helper (int[] arr , int idx , int[] dpArray ) {
            //Base case
            if(idx == 0 ) {
                return arr[idx] ;
            }else if (idx < 0) {
                return 0 ;
            }

            //Step 3: check, if the value is present then return the answer
            if (dpArray[idx] != -1) {
                return dpArray[idx] ;
            }

            int includeCurrentElement = arr[idx] + helper(arr , idx - 2 , dpArray) ;
            int notIncludeCurrentElement = helper(arr , idx - 1 , dpArray) ;

            //Step 2: store the answer in the dp array and return the answer
            return dpArray[idx] = Math.max(includeCurrentElement , notIncludeCurrentElement) ;
        }
    }

    //The solution using the bottom to top approach (Tabulation)
    public static class SolutionUsingTabulation {
        public static int houseRobber(int[] arr) {
            //Edge case
            if(arr == null || arr.length == 0 ) {
                return 0 ;
            }
            int size = arr.length ;
            //Step 1: Create a dp array of size n + 1 and initialize it with -1
            int[] dpArray = new int[size + 1 ] ;
            Arrays.fill(dpArray, -1 );

            //Step 2: Set array value as base values
            dpArray[0] = arr[0] ;

            for(int idx = 1 ; idx < size ; idx++ ){
                int includeCurrentElement = arr[idx]  ;

                if (idx >= 2) {
                    includeCurrentElement += dpArray[idx - 2] ;
                }

                int notIncludeCurrentElement = dpArray[idx - 1] ;

                dpArray[idx] = Math.max(includeCurrentElement , notIncludeCurrentElement) ;
            }

            return  dpArray[size - 1] ;
        }
    }
    public static void main(String[] args) {

    }
}
