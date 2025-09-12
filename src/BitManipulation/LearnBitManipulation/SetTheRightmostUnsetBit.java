package BitManipulation.LearnBitManipulation;

public class SetTheRightmostUnsetBit {
    public static class Solution {
        public static int setBit(int n) {
            //Or return n | (~n & (n + 1)) ;
            return n | (n + 1) ;
        }
    }

    public static void main(String[] args) {

    }
}
