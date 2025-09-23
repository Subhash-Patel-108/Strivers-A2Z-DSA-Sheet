package BitManipulation.Advancedmath;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/sum-of-digits_1464021?interviewProblemRedirection=true&practice_topic%5B%5D=Number%20Theory&sort_entity=company_count&sort_order=DESC
public class SumOfDigits {
    public static class Solution {
        public static int sumofDigits(int n) {
            //Edge case
            if(n < 10) {
                return n ;
            }

            int digitSum = 0 ;

            while (n > 0) {
                digitSum +=  n % 10 ;
                n /= 10 ;

                if(digitSum >= 10 && n == 0 ) {
                    n = digitSum ;
                    digitSum = 0 ;
                }
            }

            return digitSum ;

        }
    }
    public static void main(String[] args) {

    }
}
