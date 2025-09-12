package BitManipulation.LearnBitManipulation;

public class PowerOfTwo {
    public static class Solution {
        public static boolean isPowerOfTwo(int n) {
            if(n == 0 ) {
                return false ;
            }
            return (n & (n - 1)) == 0 ;
        }
    }
    public static void main(String[] args) {

    }
}
