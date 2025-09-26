package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/chocolate-problem_893280?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class ChocolateProblem {
    public static class Solution {
        static int findMinDiff(int n, int m, ArrayList<Integer> chocolates) {
            //Edge case
            if(chocolates == null || chocolates.isEmpty()) {
                return -1 ;
            }else if (m > n) {
                return -1 ;
            }

            Collections.sort(chocolates) ;
            int minDiff = Integer.MAX_VALUE ;

            for(int idx = 0 ; idx <= n - m ; idx++ ){
                int currDiff = chocolates.get(idx + m - 1) - chocolates.get(idx) ;

                if (currDiff < minDiff) {
                    minDiff = currDiff ;
                }
            }

            return minDiff ;
        }
    }
    public static void main(String[] args) {

    }
}
