package String.EasyQuestions;
import java.util.* ;
//Problem Link: https://leetcode.com/problems/longest-palindrome/description/
public class CreateLongestPalindrome {
    public static class Solution {
        public int longestPalindrome(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return 0;
            }

            // Arrays to store frequency of lowercase and uppercase letters
            int[] lowercaseFreq = new int[26];
            int[] uppercaseFreq = new int[26];

            // Count frequency of each character
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    lowercaseFreq[ch - 'a']++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    uppercaseFreq[ch - 'A']++;
                }
            }

            // Initialize palindrome length
            int palindromeLength = 0;
            // Flag to indicate if any character has an odd count
            int hasOddCount = 0;

            // Calculate palindrome length using character frequencies
            for (int i = 0; i < 26; i++) {
                // For lowercase letters
                if (lowercaseFreq[i] % 2 == 0) {
                    palindromeLength += lowercaseFreq[i];
                } else {
                    palindromeLength += lowercaseFreq[i] - 1;
                    hasOddCount = 1;
                }

                // For uppercase letters
                if (uppercaseFreq[i] % 2 == 0) {
                    palindromeLength += uppercaseFreq[i];
                } else {
                    palindromeLength += uppercaseFreq[i] - 1;
                    hasOddCount = 1;
                }
            }

            // Add 1 to length if there’s at least one odd count for the center
            return palindromeLength + hasOddCount;
        }
    }
    public static void main(String[] args) {

    }
}
