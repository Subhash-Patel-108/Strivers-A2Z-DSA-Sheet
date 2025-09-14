package SlidingWindow.HardProlems;

public class LongestSubstringWithKUniques {
    public static class Solution {
        // Finds the length of the longest substring with exactly k distinct characters
        public int longestSubstringWithKDistinct(String input, int kDistinct) {
            // Handle edge case: return 0 if string is null or empty
            if (input == null || input.isEmpty()) {
                return 0;
            }

            int windowStart = 0, windowEnd = 0;
            int maxLength = -1;
            int distinctCount = 0;
            // Array to store frequency of each lowercase letter (a-z)
            int[] charFrequencies = new int[26];

            // Slide window to find longest substring with exactly kDistinct characters
            while (windowEnd < input.length()) {
                char currentChar = input.charAt(windowEnd);
                // Increment frequency of current character
                charFrequencies[currentChar - 'a']++;

                // If character appears for the first time, increment distinct count
                if (charFrequencies[currentChar - 'a'] == 1) {
                    distinctCount++;
                }

                // Update max length if exactly kDistinct characters are present
                if (distinctCount == kDistinct) {
                    maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                }

                // Shrink window if distinct character count exceeds kDistinct
                while (distinctCount > kDistinct) {
                    char charAtStart = input.charAt(windowStart);
                    // Decrement frequency of character at window start
                    charFrequencies[charAtStart - 'a']--;

                    // If character is no longer in window, decrement distinct count
                    if (charFrequencies[charAtStart - 'a'] == 0) {
                        distinctCount--;
                    }
                    windowStart++;
                }

                windowEnd++;
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {

    }
}
