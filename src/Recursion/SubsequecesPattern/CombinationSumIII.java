package Recursion.SubsequecesPattern;
import java.util.* ;
public class CombinationSumIII {
    public static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>() ;

            //Edge case
            if(k == 0 || n == 0 ) {
                return result ;
            }

            //Step 1: Initialization
            List<Integer> subset = new ArrayList<>() ;

            //Step 2: Function call
            helper(k , n , 1 , subset , result) ;

            //Step 3: return the result
            return result ;
        }

        //Function to generate the subsets
        private static void helper(int totalSize , int target , int start , List<Integer> subset , List<List<Integer>> result) {
            if(target == 0 && totalSize == subset.size()) {
                result.add(new ArrayList<>(subset)) ;
                return ;
            }

            //Base case
            if(subset.size() > totalSize || target < 0) {
                return ;
            }

            for(int i = start ; i <= 9 ; i++) {
                subset.add(i) ;
                helper(totalSize , target - i , i + 1 , subset , result) ;
                subset.remove(subset.size() - 1) ;
            }
            return ;
        }
    }
}
