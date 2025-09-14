package BitManipulation.InterviewProblems;

public class MinimumBitFlipsToConvertNumber {
    public static class Solution {
        /**
         * Calculates the number of bits that need to be flipped to convert integer 'a' to 'b'.
         * This is equivalent to counting the number of set bits (1s) in the result of 'a XOR b'.
         *
         * @param a The first integer.
         * @param b The second integer.
         * @return The number of bits to flip.
         */
        public static int numberOfFlips(int a, int b) {
            // The XOR operation (a ^ b) results in a number where each bit is set (1)
            // if the corresponding bits in 'a' and 'b' are different.
            int difference = a ^ b;
            int count = 0;

            // Loop through the bits of the 'difference' number.
            while (difference > 0) {
                // Check the least significant bit (LSB) using bitwise AND with 1.
                // If the LSB is 1, it means a flip is needed for that bit position.
                count += (difference & 1);

                // Right-shift the number by one to move to the next bit.
                difference >>= 1;
            }

            return count;
        }
    }

    public static void main(String[] args) {

    }
}
