package String.MediumQuestions;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/shortest-substring-with-all-characters_704894?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class ShortestSubStringWithAllCharacters {

    public static class Solution {
        public static String shortestSubstring(String s) {
            // Handle edge case: null or empty string returns empty string
            if (s == null || s.isEmpty()) {
                return "";
            }

            // Get unique characters from input string
            String uniqueCharacters = findUniqueCharacters(s);
            // Store length of unique characters
            int uniqueCharactersLength = uniqueCharacters.length();
            // Array to track frequency of characters (assuming lowercase a-z)
            int[] charFreq = new int[26];

            // Initialize frequency array with required counts from unique characters
            for (int idx = 0; idx < uniqueCharactersLength; idx++) {
                char currChar = uniqueCharacters.charAt(idx);
                charFreq[currChar - 'a']++;
            }

            // Initialize sliding window pointers and variables
            int left = 0;
            int right = 0;
            int startIdx = 0;
            int minLength = Integer.MAX_VALUE;
            int seenCharCount = 0;

            // Process string using sliding window
            while (right < s.length()) {
                // Expand window: include current character
                char currChar = s.charAt(right);
                charFreq[currChar - 'a']--;

                // If a required character's frequency becomes 0, increment seen count
                if (charFreq[currChar - 'a'] == 0) {
                    seenCharCount++;
                }

                // Shrink window when all unique characters are included
                while (seenCharCount >= uniqueCharactersLength) {
                    // Update minimum window if current window is smaller
                    if (minLength > (right - left + 1)) {
                        minLength = right - left + 1;
                        startIdx = left;
                    }

                    // Remove left character from window
                    char leftChar = s.charAt(left);
                    charFreq[leftChar - 'a']++;

                    // If a required character's frequency becomes positive, decrement seen count
                    if (charFreq[leftChar - 'a'] > 0) {
                        seenCharCount--;
                    }
                    left++;
                }

                // Expand window
                right++;
            }

            // Return shortest substring containing all unique characters
            return minLength == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLength);
        }

        // Finds unique characters in the string
        private static String findUniqueCharacters(String str) {
            // Array to mark presence of lowercase letters
            boolean[] check = new boolean[26];
            // Mark each character as present
            for (int idx = 0; idx < str.length(); idx++) {
                char currChar = str.charAt(idx);
                check[currChar - 'a'] = true;
            }

            // Build string of unique characters in order
            StringBuilder uniqueChar = new StringBuilder();
            for (int idx = 0; idx < 26; idx++) {
                if (check[idx]) {
                    uniqueChar.append((char) (idx + 'a'));
                }
            }

            // Return string of unique characters
            return uniqueChar.toString();
        }
    }
    public static void main(String[] args) {

    }
}
