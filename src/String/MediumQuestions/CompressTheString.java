package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/compress-the-string_526?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class CompressTheString {
    public static class Solution {
        public static String getCompressedString(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return "";
            }

            // Initialize StringBuilder for compressed result
            StringBuilder result = new StringBuilder();
            // Initialize count for consecutive characters
            int count = 1;
            // Store the first character
            char previousChar = input.charAt(0);

            // Iterate through characters starting from the second
            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == previousChar) {
                    // Increment count for repeated character
                    count++;
                } else {
                    // Append previous character and count (if > 1)
                    result.append(previousChar);
                    if (count > 1) {
                        result.append(count);
                    }
                    // Update previous character and reset count
                    previousChar = currentChar;
                    count = 1;
                }
            }

            // Append the last group of characters and count
            result.append(previousChar);
            if (count > 1) {
                result.append(count);
            }

            // Return the compressed string
            return result.toString();
        }
    }

    public static void main(String[] args) {

    }
}
