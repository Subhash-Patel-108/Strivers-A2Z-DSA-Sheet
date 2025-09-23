package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/longest-unique-substring_630418?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=PROBLEM
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static class Solution {
        public static int uniqueSubstrings(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return 0;
            }

            // Initialize sliding window pointers
            int left = 0;
            int right = 0;
            // Track maximum length of substring without repeating characters
            int maxLength = 0;
            // Array to track visited characters (assuming lowercase letters a-z)
            boolean[] seen = new boolean[26];

            // Process string using sliding window
            while (right < input.length()) {
                // Get current character and its index (relative to 'a')
                char currentChar = input.charAt(right);
                int charIndex = currentChar - 'a';

                // Shrink window while current character is already seen
                while (seen[charIndex]) {
                    // Mark character at left pointer as unseen and advance left
                    seen[input.charAt(left) - 'a'] = false;
                    left++;
                }

                // Update maximum length of substring
                maxLength = Math.max(maxLength, right - left + 1);
                // Mark current character as seen
                seen[charIndex] = true;
                // Expand window
                right++;
            }

            // Return length of longest substring without repeating characters
            return maxLength;
        }
    }

    public static class Solution2 {
        public static int uniqueSubstrings(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return 0;
            }

            // Map to store the last index of each character
            HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
            // Initialize sliding window pointers
            int left = 0;
            int right = 0;
            // Track maximum length of substring without repeating characters
            int maxLength = 0;

            // Process string using sliding window
            while (right < input.length()) {
                // Get current character
                char currentChar = input.charAt(right);
                // If character is seen and its last index is >= left, adjust window
                if (lastSeenIndex.containsKey(currentChar) && lastSeenIndex.get(currentChar) >= left) {
                    left = lastSeenIndex.get(currentChar) + 1;
                }

                // Calculate current window length and update maxLength
                int currentLength = right - left + 1;
                maxLength = Math.max(currentLength, maxLength);
                // Update last seen index of current character
                lastSeenIndex.put(currentChar, right);
                // Expand window
                right++;
            }

            // Return length of longest substring without repeating characters
            return maxLength;
        }
    }

    public static void main(String[] args) {

    }
}
