package BitManipulation.InterviewProblems;

public class TwoNumbersWithOddOccurrences {
    public static class Solution {
        // Finds the two numbers that appear an odd number of times in the array
        public static int[] findTwoOddNumbers(int[] numbers) {
            int[] result = new int[2];
            // Handle edge case: return empty result if array is null or has fewer than 2 elements
            if (numbers == null || numbers.length < 2) return result;

            // Compute XOR of all numbers in the array
            int combinedXOR = 0;
            for (int num : numbers) {
                combinedXOR ^= num;
            }

            // Find the rightmost set bit in the combined XOR
            int rightmostSetBitPosition = 0;
            int tempXOR = combinedXOR;
            while ((tempXOR & 1) == 0) {
                rightmostSetBitPosition++;
                tempXOR /= 2;
            }

            // Divide numbers into two groups based on the rightmost set bit
            int groupWithZeroBit = 0, groupWithOneBit = 0;
            for (int num : numbers) {
                if ((num & (1 << rightmostSetBitPosition)) == 0) {
                    // Numbers with 0 at the rightmost set bit position
                    groupWithZeroBit ^= num;
                } else {
                    // Numbers with 1 at the rightmost set bit position
                    groupWithOneBit ^= num;
                }
            }

            // Return the two odd-occurring numbers in descending order
            if (groupWithZeroBit > groupWithOneBit) {
                result[0] = groupWithZeroBit;
                result[1] = groupWithOneBit;
            } else {
                result[0] = groupWithOneBit;
                result[1] = groupWithZeroBit;
            }

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
