package BitManipulation.InterviewProblems;

public class LToRXOR {
    public static class Solution {

        // Calculates the XOR of all numbers in the range [next, right]
        public static int findRangeXOR(int left, int right) {
            // XOR from 1 to right XORed with XOR from 1 to (next-1) gives XOR of range [next, right]
            return computeXORUpTo(right) ^ computeXORUpTo(left - 1);
        }

        // Computes XOR of all numbers from 1 to n
        private static int computeXORUpTo(int number) {
            // Use modulo 4 to determine XOR pattern
            int remainder = number % 4;

            // Return based on modulo pattern
            if (remainder == 0) return number;
            if (remainder == 1) return 1;
            if (remainder == 2) return number + 1;
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
