package SlidingWindow.MediumProblem;

public class LongestRepeatingCharacterReplacement {
    public static class Solution {
        // Finds the length of the longest substring with at most k character replacements
        public int longestRepeatingCharacterSubstring(String input, int maxReplacements) {
            // Handle edge case: return 0 if string is null or empty
            if (input == null || input.isEmpty()) {
                return 0;
            }

            int windowStart = 0, windowEnd = 0;
            int maxCharFrequency = 0;
            int maxLength = 0;
            // Array to store frequency of each uppercase letter (A-Z)
            int[] charFrequencies = new int[26];

            // Slide window to find longest substring with at most maxReplacements replacements
            while (windowEnd < input.length()) {
                char currentChar = input.charAt(windowEnd);
                // Increment frequency of current character
                charFrequencies[currentChar - 'A']++;
                // Update max frequency of any character in current window
                maxCharFrequency = Math.max(maxCharFrequency, charFrequencies[currentChar - 'A']);

                // Shrink window if replacements needed exceed maxReplacements
                while ((windowEnd - windowStart + 1) - maxCharFrequency > maxReplacements) {
                    charFrequencies[input.charAt(windowStart) - 'A']--;
                    windowStart++;
                    // Recalculate max frequency after shrinking window
                    for (int i = 0; i < 26; i++) {
                        maxCharFrequency = Math.max(maxCharFrequency, charFrequencies[i]);
                    }
                }

                // Update max length of valid substring
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            }

            return maxLength;
        }
    }
    public static void main(String[] args) {

    }
}
