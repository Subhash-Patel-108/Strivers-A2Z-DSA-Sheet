package BitManipulation.LearnBitManipulation;

public class CheckWhetherKthBitIsSetOrNot {
    public static class Solution {
        static boolean isKthBitSet(int n, int k) {
            //NOTE: k - 1 is for 1 based index otherwise k for 0 based indexing
            return((n)& (1 << k-1)) > 0 ;
        }
    }
    public static void main(String[] args) {

    }
}
