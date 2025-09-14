package SlidingWindow.HardProlems;

public class MinimumWindowSubstring {
    public static class Solution {
        // Finds the minimum window substring in string 'input' that contains all characters from 'pattern'
        public static String minWindowSubstring(String input, String pattern) {
            // Handle edge cases: return empty string if either input or pattern is null or empty
            if (input == null || pattern == null || input.isEmpty() || pattern.isEmpty()) {
                return "";
            }

            // Array to store frequency of characters in pattern (supports ASCII characters)
            int[] charFrequency = new int[256];
            for (char ch : pattern.toCharArray()) {
                charFrequency[ch]++;
            }

            int requiredChars = pattern.length(); // Total characters needed from pattern
            int windowStart = 0, minWindowLength = Integer.MAX_VALUE, minWindowStart = 0;

            // Slide window to find minimum substring containing all pattern characters
            for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
                char currentChar = input.charAt(windowEnd);

                // If current character is needed, reduce required count
                if (charFrequency[currentChar] > 0) {
                    requiredChars--;
                }
                // Decrease frequency (negative means extra occurrences)
                charFrequency[currentChar]--;

                // When all required characters are covered, try to shrink window
                while (requiredChars == 0) {
                    // Update minimum window if current window is smaller
                    if (windowEnd - windowStart + 1 < minWindowLength) {
                        minWindowLength = windowEnd - windowStart + 1;
                        minWindowStart = windowStart;
                    }

                    char charAtStart = input.charAt(windowStart);
                    // Increment frequency of character at window start
                    charFrequency[charAtStart]++;

                    // If we lose a required character, increase required count
                    if (charFrequency[charAtStart] > 0) {
                        requiredChars++;
                    }
                    windowStart++;
                }
            }

            // Return empty string if no valid window found, otherwise return minimum window
            return (minWindowLength == Integer.MAX_VALUE) ? "" : input.substring(minWindowStart, minWindowStart + minWindowLength);
        }
    }
    public static void main(String[] args) {

    }
}
