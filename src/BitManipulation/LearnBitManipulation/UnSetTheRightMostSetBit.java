package BitManipulation.LearnBitManipulation;

public class UnSetTheRightMostSetBit {
    public static class Solution {
        public static int unsetLSB(int n) {
            return n & (n - 1);
        }
    }
    public static void main(String[] args) {

    }
}
