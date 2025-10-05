package DynamicProgramming.OneDDynamicProgramming;
import java.util.Arrays ;

//Problem Link : https://leetcode.com/problems/house-robber-ii/submissions/1790186822/
public class HouseRobberII {
    public static class Solution {
        public static long houseRobber(int[] valueInHouse) {
            //Edge case
            if(valueInHouse == null || valueInHouse.length == 0 ) {
                return 0 ;
            }
            int size = valueInHouse.length ;

            //Edge case for one size array
            //Step 1: Create a dp array of size n + 1 and initialize it with -1
            int[] dpArray = new int[size + 1 ] ;
            Arrays.fill(dpArray, -1 );

            //First, we find in the range of 0 - (index - 1) or excluding the last value
            int includeFirstIndex = findTheMaximumProfit(valueInHouse , 0 , size - 2 , dpArray) ;

            Arrays.fill(dpArray , -1 );
            //Now, we find the maximum and include the last value
            int includeLastIndex = findTheMaximumProfit(valueInHouse , 1 , size - 1 , dpArray) ;

            return Math.max(includeFirstIndex , includeLastIndex ) ;
        }

        private static int findTheMaximumProfit(int[] arr , int start , int idx , int[] dpArray) {
            //Base case
            if (idx == start) {
                return arr[idx] ;
            }else if (idx < start) {
                return 0 ;
            }

            //Step 3: Check if the value is present then return the answer
            if (dpArray[idx] != -1) {
                return dpArray[idx] ;
            }

            int includeCurrentElement = arr[idx] + findTheMaximumProfit(arr , start , idx - 2 , dpArray) ;
            int notIncludeCurrentElement = findTheMaximumProfit(arr , start , idx - 1 , dpArray) ;

            //Step 2: Store the answer in the dp array and return the answer
            return dpArray[idx] = Math.max(notIncludeCurrentElement , includeCurrentElement) ;
        }
    }
    public static void main(String[] args) {
        
    }
}
