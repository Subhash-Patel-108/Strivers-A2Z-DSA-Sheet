package String.EasyQuestions;
//Problem Link: https://www.naukri.com/code360/problems/check-permutation_1172164?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class CheckAnagram {
    public static class Solution {
        public static boolean areAnagram(String first, String second) {
            // Handle edge cases: null strings or different lengths
            if (first == null || second == null || first.length() != second.length()) {
                return false;
            }
            // Empty strings are considered anagrams
            if (first.isEmpty() && second.isEmpty()) {
                return true;
            }

            // Arrays to store frequency of lowercase letters (a-z)
            int[] firstFreq = new int[26];
            int[] secondFreq = new int[26];

            // Count frequency of each character in both strings
            for (int i = 0; i < first.length(); i++) {
                firstFreq[first.charAt(i) - 'a']++;
                secondFreq[second.charAt(i) - 'a']++;
            }

            // Compare frequency arrays
            for (int i = 0; i < 26; i++) {
                if (firstFreq[i] != secondFreq[i]) {
                    return false;
                }
            }

            // Strings are anagrams if frequencies match
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
