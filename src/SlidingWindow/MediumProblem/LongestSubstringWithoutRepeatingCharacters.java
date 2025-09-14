package SlidingWindow.MediumProblem;
import java.util.* ;
public class LongestSubstringWithoutRepeatingCharacters {
    //By using HashMap but the space complexity is O(n)
    public static class Solution {
        // Finds the length of the longest substring with all unique characters
        public int longestUniqueSubstring(String input) {
            // Handle edge case: return 0 if string is null or empty
            if (input == null || input.isEmpty()) {
                return 0;
            }

            // Map to store the last index of each character
            HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
            int windowStart = 0, windowEnd = 0;
            int maxLength = 0;

            // Slide window to find longest substring with unique characters
            while (windowEnd < input.length()) {
                char currentChar = input.charAt(windowEnd);

                // If character is seen, move window start to the right of its last occurrence
                if (lastSeenIndex.containsKey(currentChar)) {
                    windowStart = Math.max(lastSeenIndex.get(currentChar) + 1, windowStart);
                }

                // Update last seen index of current character
                lastSeenIndex.put(currentChar, windowEnd);
                // Update max length of unique substring
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            }

            return maxLength;
        }
    }

    //By using Array and reduce the space complexity by O(1)
    public static class Solution2 {
        // Finds the length of the longest substring with all unique characters (assumes lowercase letters)
        public int longestUniqueSubstring(String input) {
            // Handle edge case: return 0 if string is null or empty
            if (input == null || input.isEmpty()) {
                return 0;
            }

            // Array to store last index of each lowercase letter (a-z)
            int[] lastSeenIndex = new int[26];
            for (int i = 0; i < 26; i++) {
                lastSeenIndex[i] = -1; // Initialize with -1 to indicate unseen characters
            }

            int windowStart = 0, windowEnd = 0;
            int maxLength = 0;

            // Slide window to find longest substring with unique characters
            while (windowEnd < input.length()) {
                char currentChar = input.charAt(windowEnd);

                // If character is seen, move window start to the right of its last occurrence
                if (lastSeenIndex[currentChar - 'a'] != -1) {
                    windowStart = Math.max(lastSeenIndex[currentChar - 'a'] + 1, windowStart);
                }

                // Update last seen index of current character
                lastSeenIndex[currentChar - 'a'] = windowEnd;
                // Update max length of unique substring
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            }

            return maxLength;
        }
    }
    public static void main(String[] args) {

    }
}
