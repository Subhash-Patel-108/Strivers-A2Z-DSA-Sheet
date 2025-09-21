package BitManipulation.ExtraQuestions;

public class PowerOfTwo {
    public static class Solution {
        public static boolean isPowerOfTwo(int num) {
            // Handle Edge case: 0 is not a power of two
            if (num == 0) {
                return false;
            }

            // Check if num has exactly one set bit using bitwise AND
            return (num & (num - 1)) == 0;
        }
    }
}
