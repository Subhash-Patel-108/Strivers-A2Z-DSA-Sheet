package SlidingWindow.MediumProblem;
import java.util.* ;
public class MaxConsecutiveOnesIII {
    public static class Solution {
        // Finds the length of the longest subarray with at most k zeros
        public static int longestSubarrayWithLimitedZeros(ArrayList<Integer> numbers, int size, int maxZeros) {
            // Handle edge case: return 0 if array is null or empty
            if (numbers == null || numbers.isEmpty()) {
                return 0;
            }

            int windowStart = 0, windowEnd = 0;
            int maxLength = 0;
            int zeroCount = 0;

            // Slide window to find longest subarray with at most maxZeros zeros
            while (windowEnd < numbers.size()) {
                // Increment zero count if current element is 0
                if (numbers.get(windowEnd) == 0) {
                    zeroCount++;
                }

                // Shrink window if zero count exceeds maxZeros
                while (zeroCount > maxZeros) {
                    if (numbers.get(windowStart) == 0) {
                        zeroCount--;
                    }
                    windowStart++;
                }

                // Update max length of valid subarray
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            }

            return maxLength;
        }
    }
    public static void main(String[] args) {

    }
}
