package String.EasyQuestions;
//Problem Link :https://www.naukri.com/code360/problems/count-frequency_920323?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class CountFrequency {
    public static class Solution {
        public static int[] findFrequency(String S) {
            //Edge case
            if(S == null || S.isEmpty()) {
                return new int[26] ;
            }

            int[] freq = new int[26] ;
            for(int idx = 0 ; idx < S.length() ; idx++ ) {
                freq[S.charAt(idx) - 'a']++ ;
            }

            return freq ;
        }
    }
    public static void main(String[] args) {

    }
}
