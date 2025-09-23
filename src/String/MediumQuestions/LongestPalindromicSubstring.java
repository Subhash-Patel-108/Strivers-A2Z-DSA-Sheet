package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/longest-palindromic-substring_758900?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class LongestPalindromicSubstring {

    public static class Solution {
        public static String longestPalinSubstring(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return "";
            }

            // Initialize start index and length of longest palindrome
            int startIndex = 0;
            int maxLength = 1;

            // Iterate through each index as potential palindrome center
            for (int i = 0; i < input.length(); i++) {
                // Check for odd-length palindrome (single character center)
                int oddLength = expandAroundCenter(input, i, i);
                // Check for even-length palindrome (between two characters)
                int evenLength = expandAroundCenter(input, i, i + 1);

                // Get maximum length of current palindrome
                int currentLength = Math.max(oddLength, evenLength);

                // Update startIndex and maxLength if a longer palindrome is found
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = i - (currentLength - 1) / 2;
                }
            }

            // Return the longest palindromic substring
            return input.substring(startIndex, startIndex + maxLength);
        }

        // Expands around center to find palindrome length
        private static int expandAroundCenter(String input, int left, int right) {
            // Expand while within bounds and characters match
            while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                left--;
                right++;
            }

            // Return length of palindrome (right - left - 1)
            return right - left - 1;
        }
    }
    public static void main(String[] args) {

    }
}
