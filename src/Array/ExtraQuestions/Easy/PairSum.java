package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/pair-sum_1171154?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class PairSum {

    public static class Solution {
        public static int pairSum(int[] arr, int n, int target) {
            //Edge case
            if(arr == null || n == 0 ) {
                return -1 ;
            }

            int count = 0 ;
            int left = 0 , right = n - 1 ;

            while (left < right) {
                int currSum = arr[left] + arr[right] ;

                if (target == currSum) {
                    count ++ ;
                    left ++ ;
                    right -- ;
                    continue;
                }

                if (target > currSum) {
                    left++ ;
                }else{
                    right -- ;
                }
            }

            return count == 0 ? -1 : count ;
        }
    }
    public static void main(String[] args) {

    }
}
