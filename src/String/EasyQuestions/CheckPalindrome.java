package String.EasyQuestions;
//Problem Link: https://www.naukri.com/code360/problems/check-palindrome_4219630?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class CheckPalindrome {
    public static class Solution {
        public static Boolean isPalindrome(String str) {
            //Edge case
            if(str == null || str.isEmpty()) {
                return true ;
            }

            int low = 0 , high = str.length() - 1 ;
            while (low < high) {
                if(str.charAt(low) != str.charAt(high)) {
                    return false ;
                }

                low ++ ;
                high -- ;
            }

            return true ;
        }

    }
    public static void main(String[] args) {

    }
}
