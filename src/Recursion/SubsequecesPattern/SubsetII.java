package Recursion.SubsequecesPattern;
import java.util.* ;
public class SubsetII {
    public static class Solution {
        public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;

            //Edge case
            if(arr == null || arr.length == 0) {
                return result ;
            }

            //Step 1: Sort the given Array
            Arrays.sort(arr) ;

            //Step 2: Initialization
            ArrayList<Integer> subset = new ArrayList<>() ;
            //Step 3: Function calling
            helper(arr, 0 , subset , result);

            //Step 4: return the result
            return result ;
        }

        //Function to generate the subsets
        private static void helper(int[] arr , int idx , ArrayList<Integer> subset , ArrayList<ArrayList<Integer>> result) {
            //Add every time
            result.add(new ArrayList<>(subset)) ;


            for(int i = idx ; i < arr.length ; i++ ) {
                if(i > idx && arr[i] == arr[i - 1] ) continue ;

                subset.add(arr[i]) ;
                helper(arr , i + 1 , subset , result) ;
                subset.remove(subset.size() - 1) ;
            }

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
