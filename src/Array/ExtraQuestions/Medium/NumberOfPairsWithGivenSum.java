package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/number-of-pairs-with-given-sum_630509?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class NumberOfPairsWithGivenSum {

    public static class Solution {
        public static long pairsWithGivenSum(int[] arr, int sum) {
            //Edge case
            if(arr == null || arr.length == 0) {
                return 0 ;
            }
            long count = 0 ;
            HashMap <Integer , Integer> map = new HashMap<>() ;

            for(int num : arr) {
                int target = sum - num ;

                if(map.containsKey(target)) {
                    count += map.get(target) ;
                }
                map.put(num , map.getOrDefault(num , 0) + 1) ;
            }

            return count ;
        }
    }
    public static void main(String[] args) {

    }
}
