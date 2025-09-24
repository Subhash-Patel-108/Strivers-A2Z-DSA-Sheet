package String.EasyQuestions;
//Problem Link: https://www.naukri.com/code360/problems/remove-consecutive-duplicates_893195?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class RemoveConsecutiveDuplicates {

    public static class Solution {
        public static String removeConsecutiveDuplicates(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return "";
            }

            // Initialize StringBuilder for result
            StringBuilder result = new StringBuilder();
            // Initialize previous character with first character
            char previousChar = input.charAt(0);
            // Append first character to result
            result.append(previousChar);

            // Process string starting from second character
            for (int i = 1; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                // Append character only if different from previous
                if (currentChar != previousChar) {
                    result.append(currentChar);
                    previousChar = currentChar;
                }
            }

            // Return string with consecutive duplicates removed
            return result.toString();
        }
    }

    public static void main(String[] args) {

    }
}
