package BitManipulation.ExtraQuestions;
//Problem Link: https://www.naukri.com/code360/problems/check-palindrome_920555?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class CheckIfBinaryRepresentationOfANumberIsPalindrome {

    public static class Solution {
        public static boolean checkPalindrome(long N) {
            //Convert the string into binary string
            String binaryStr = Long.toBinaryString(N) ;

            //check for palindrome
            int left = 0 , right = binaryStr.length() - 1 ;
            while (left < right) {
                if(binaryStr.charAt(left) != binaryStr.charAt(right)) {
                    return false ; // the string is not a palindrome
                }
                left ++ ;
                right -- ;
            }

            return true; // the string is a palindrome
        }

    }
    public static void main(String[] args) {

    }
}
