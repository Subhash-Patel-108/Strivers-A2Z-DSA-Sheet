package String.MediumQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/smallest-window-in-string-containing-all-the-characters-of-another-string_981175?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class SmallestWindow {

    public static class Solution {
        public static String smallestWindow(String input, String pattern) {
            // Handle edge case: null or empty input or pattern
            if (input == null || pattern == null || input.isEmpty() || pattern.isEmpty()) {
                return "";
            }

            int patternLength = pattern.length();
            int inputLength = input.length();

            // Array to store frequency of characters in pattern (assuming lowercase a-z)
            int[] charFreq = new int[26];
            // Count required characters from pattern
            for (int i = 0; i < patternLength; i++) {
                charFreq[pattern.charAt(i) - 'a']++;
            }

            // Initialize sliding window pointers and counters
            int left = 0;
            int right = 0;
            int matchedChars = 0; // Tracks number of characters matched
            int minWindowLength = Integer.MAX_VALUE;
            int windowStart = -1;

            // Process string using sliding window
            while (right < inputLength) {
                // Expand window: include right character
                char currentChar = input.charAt(right);
                charFreq[currentChar - 'a']--;

                // If frequency is non-negative, character contributes to match
                if (charFreq[currentChar - 'a'] >= 0) {
                    matchedChars++;
                }

                // Shrink window when all characters are matched
                while (matchedChars == patternLength) {
                    char leftChar = input.charAt(left);
                    charFreq[leftChar - 'a']++;

                    // If frequency becomes positive, reduce matched count
                    if (charFreq[leftChar - 'a'] > 0) {
                        matchedChars--;
                    }

                    // Update minimum window if current window is smaller
                    int currentWindowLength = right - left + 1;
                    if (currentWindowLength < minWindowLength) {
                        minWindowLength = currentWindowLength;
                        windowStart = left;
                    }
                    left++; // Shrink window
                }

                right++; // Expand window
            }

            // Return smallest window or empty string if no valid window found
            return windowStart == -1 ? "" : input.substring(windowStart, windowStart + minWindowLength);
        }
    }
    public static void main(String[] args) {

    }
}
