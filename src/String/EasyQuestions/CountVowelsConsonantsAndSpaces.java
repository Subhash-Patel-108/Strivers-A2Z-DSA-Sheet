package String.EasyQuestions;
//Problem link: https://www.naukri.com/code360/problems/count-vowels-consonants-and-spaces_5026361?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class CountVowelsConsonantsAndSpaces {

    public static class Solution {
        public static int[] countVowelsConsonantsSpaces(String input, int length) {
            // Handle edge case: null string or zero length
            if (input == null || length == 0) {
                return new int[] {};
            }

            // Initialize counters for vowels, consonants, and spaces
            int vowelCount = 0;
            int consonantCount = 0;
            int spaceCount = 0;

            // Count vowels, consonants, and spaces
            for (char ch : input.toCharArray()) {
                if (ch == ' ') {
                    spaceCount++;
                } else if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            // Return array with counts
            return new int[] {vowelCount, consonantCount, spaceCount};
        }

        // Checks if a character is a vowel (case-insensitive)
        private static boolean isVowel(char ch) {
            // Check for both lowercase and uppercase vowels
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
        }
    }
    public static void main(String[] args) {

    }
}
