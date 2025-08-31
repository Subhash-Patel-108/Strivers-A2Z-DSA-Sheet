package String.EasyQuestions;

public class LargestOddNumberInString {
    public static class Solution {
        public String largestOddNumber(String num) {
            //edge case
            if(num == null && num.length() == 0) {
                return "" ;
            }

            //first, we remove the leading zeros
            int startPosition = 0 ;
            while (startPosition < num.length() && num.charAt(startPosition) == '0') {
                startPosition ++ ;
            }

            //now find the largest odd number
            int endPosition = num.length() - 1 ;

            while (endPosition >= startPosition) {
                //check if the number is odd
                if(((num.charAt(endPosition) - '0' ) & 1) != 0) {
                    return num.substring(startPosition , endPosition + 1) ;
                }
                endPosition -- ;
            }
            return "" ;
        }
    }
    public static void main(String[] args) {

    }
}
