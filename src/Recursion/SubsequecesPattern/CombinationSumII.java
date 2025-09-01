package Recursion.SubsequecesPattern;
import java.util.* ;
public class CombinationSumII {
    public static class Solution {
        // Function to find all combinations of elements
        // in array arr that sum to target.
        static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;//to store the result

            //Edge case
            if(arr == null || arr.length == 0) {
                return result ;
            }

            //Sort the array
            Arrays.sort(arr) ;

            //Step 1: Initialization
            ArrayList<Integer> combination = new ArrayList<>() ;

            //Step 2: Function call
            helper(arr , 0 , target , combination , result) ;

            //Step 3: return the result
            return result ;
        }

        //function to find the combination sum with duplicates
        private static void helper(int[] arr , int idx , int target , ArrayList<Integer> combination , ArrayList<ArrayList<Integer>> result ) {
            if(target == 0) {
                result.add(new ArrayList<>(combination)) ;
                return ;
            }

            for(int i = idx ; i < arr.length ; i++) {
                if(i > idx && arr[i] == arr[i - 1]) continue;

                if(arr[i] > target) break ;

                combination.add(arr[i]) ;
                helper(arr , i + 1 , target - arr[i] , combination , result ) ;
                combination.remove(combination.size() - 1) ;
            }

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
