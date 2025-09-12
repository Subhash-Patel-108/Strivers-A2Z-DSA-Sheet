package BitManipulation.LearnBitManipulation;

public class NumberOf1Bits {
    public static class Solution {
        /**
         * Counts the number of set bits (1s) in the binary representation of the given integer.
         *
         * @return the total count of bits set to 1 in the input integer
         */
        public static int setBits(int n) {
            int count = 0;  // Initialize the count of set bits to zero

            // Loop until all bits of n are processed
            while (n > 0) {
                // Check if the least significant bit is set (1)
                if ((n & 1) != 0) {
                    count++;  // Increment count if current bit is 1
                }
                // Right shift n by 1 bit (using division by 2)
                n /= 2;
            }

            return count;  // Return total number of set bits found
        }
    }

    public static void main(String[] args) {

    }
}
