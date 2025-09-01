package Recursion.SubsequecesPattern;
import java.util.* ;
public class SubsetSum {
    public static class Solution {
        public static ArrayList<Integer> subsetSum(int num[]) {
            ArrayList<Integer> result = new ArrayList<>() ;

            //Edge case
            if(num == null || num.length == 0) {
                return result ;
            }

            //Step 1: calling to the helper function
            helper(num ,  0 , 0 , result) ;

            //Step 2: Sort the result
            Collections.sort(result) ;

            //Step 3: return the result
            return result ;
        }

        private static void helper(int[] nums , int idx , int totalSum , ArrayList<Integer> result ) {
            //Base case
            if(nums.length == idx) {
                result.add(totalSum);
                return ;
            }

            //Include the current element
            helper(nums , idx + 1 , totalSum + nums[idx] , result ) ;

            //Exclude the current element
            helper(nums , idx + 1 , totalSum , result ) ;

            return ;
        }

    }
    public static void main(String[] args) {

    }
}
