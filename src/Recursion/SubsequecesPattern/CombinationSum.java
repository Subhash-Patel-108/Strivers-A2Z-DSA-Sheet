package Recursion.SubsequecesPattern;
import java.util.* ;
public class CombinationSum {
    public static class Solution {
        public static List<List<Integer>> combSum(int []arr, int target) {
            List<List<Integer>> result = new ArrayList<>() ;

            //Edge case
            if(arr == null || arr.length == 0 ) {
                return result ;
            }

            //Sort the array
            Arrays.sort(arr) ;

            //Step 1: Initialization
            ArrayList<Integer> combination = new ArrayList<>() ;

            //Step 2: Function call
            helper(arr , 0 , target , combination , result ) ;

            //Step 3: return the result
            return result ;
        }

        //Function to find the combination
        private static void helper(int[] arr , int idx , int target , ArrayList<Integer> combination , List<List<Integer>> result) {
            //Base case
            if(arr.length == idx) {
                if(target == 0) {
                    result.add(new ArrayList<>(combination)) ;
                }
                return ;
            }

            if(target == 0) {
                result.add(new ArrayList<>(combination)) ;
                return ;
            }

            //Include the current element
            if(target >= arr[idx]) {
                combination.add(arr[idx]) ;
                helper(arr , idx , target - arr[idx] , combination , result) ;
                combination.remove(combination.size() - 1) ;
            }

            //if not, then skip the current element
            helper(arr , idx + 1 , target , combination , result) ;

            return ;
        }

        private static void helper2(int[] arr , int idx , int target , ArrayList<Integer> combination , List<List<Integer>> result) {
            if(target == 0) {
                result.add(new ArrayList<>(combination)) ;
                return ;
            }

            //Base case
            if(arr.length == idx || target < 0 ) {
                return ;
            }

            combination.add(arr[idx]);
            helper2(arr , idx , target - arr[idx] , combination , result) ;
            combination.remove(combination.size() - 1) ;

            helper2(arr , idx + 1 , target , combination , result) ;

            return ;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Solution.combSum(new int[] {2 , 3, 5} , 8) ;
        System.out.println(result) ;
    }
}
