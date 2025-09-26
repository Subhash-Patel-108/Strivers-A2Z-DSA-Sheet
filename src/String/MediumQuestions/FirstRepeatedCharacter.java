package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/first-repeated-character_1214646?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class FirstRepeatedCharacter {

    public static class Solution {
        public static char repeatedCharacter(String str) {
            // Handle edge case: null or empty string returns space
            if (str == null || str.isEmpty()) {
                return ' ';
            }

            // Initialize array to store frequency of lowercase letters (a-z)
            int[] charFreq = new int[26];
            // Convert string to character array for iteration
            char[] charArray = str.toCharArray();

            // Count frequency of each character
            for (char currChar : charArray) {
                charFreq[currChar - 'a']++;
            }

            // Find first character with frequency > 1
            for (char currChar : charArray) {
                if (charFreq[currChar - 'a'] > 1) {
                    return currChar;
                }
            }

            // Return '%' if no repeated character is found
            return '%';
        }
    }
    public static void main(String[] args) {
        
    }
}
