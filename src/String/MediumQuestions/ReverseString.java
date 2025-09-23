package String.MediumQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/reverse-string_4605861?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class ReverseString {
    public static class Solution {
        public static String reverseString(String input, int numOperations, ArrayList<Integer> indices) {
            // Handle edge cases: null/empty string, null indices, or no operations
            if (input == null || input.isEmpty() || indices == null || numOperations == 0) {
                return input;
            }

            // Initialize StringBuilder for in-place modifications
            StringBuilder result = new StringBuilder(input);
            int length = input.length();

            // Process each index for substring reversal
            for (int i = 0; i < numOperations; i++) {
                // Get start index from input array
                int start = indices.get(i);
                // Calculate mirrored end index (length - start - 1)
                int end = length - start - 1;

                // Reverse substring from start to end
                reverseSubstring(result, start, end);
            }

            // Return the modified string
            return result.toString();
        }

        // Reverses characters in StringBuilder from start to end indices
        private static void reverseSubstring(StringBuilder result, int start, int end) {
            // Skip if start index is not less than end index
            if (start >= end) {
                return;
            }

            // Swap characters from start to end
            while (start < end) {
                char temp = result.charAt(start);
                result.setCharAt(start, result.charAt(end));
                result.setCharAt(end, temp);
                start++;
                end--;
            }
        }
    }
    public static void main(String[] args) {

    }
}
