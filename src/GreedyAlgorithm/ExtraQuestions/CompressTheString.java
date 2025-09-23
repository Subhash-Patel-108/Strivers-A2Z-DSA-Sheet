package GreedyAlgorithm.ExtraQuestions;
//Problem Link: https://www.naukri.com/code360/problems/compress-the-string_893402?interviewProblemRedirection=true&practice_topic%5B%5D=Greedy&sort_entity=company_count&sort_order=DESC
public class CompressTheString {

    public static class Solution {
        public static String compressTheString(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return input;
            }

            // Initialize StringBuilder for compressed result
            StringBuilder result = new StringBuilder();
            // Initialize count for consecutive characters
            int count = 1;
            // Store the first character
            char previousChar = input.charAt(0);

            // Iterate through string starting from second character
            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                // If current character matches previous, increment count
                if (previousChar == currentChar) {
                    count++;
                } else {
                    // Append previous character and count to result
                    appendCharWithCount(result, previousChar, count);
                    // Reset count and update previous character
                    count = 1;
                    previousChar = currentChar;
                }
            }

            // Append the last group of characters and count
            appendCharWithCount(result, previousChar, count);

            // Return the compressed string
            return result.toString();
        }

        // Appends a character and its count to the StringBuilder
        private static void appendCharWithCount(StringBuilder result, char character, int count) {
            // Append the character
            result.append(character);
            // Append count only if greater than 1
            if (count > 1) {
                result.append(count);
            }
        }
    }

    public static void main(String[] args) {

    }
}
