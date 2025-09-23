package BitManipulation.Advancedmath;
//Problem Link: https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1
public class GreatestCommonDivisor {
    public static class Solution {
        public static int GCD(int num1 , int num2) {
            //Base case
            if(num2 == 0) {
                return num1 ;
            }

            return GCD(num2 , num1 % num2) ;
        }
    }
    public static void main(String[] args) {

    }
}
