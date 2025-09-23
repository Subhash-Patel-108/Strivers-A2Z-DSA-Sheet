package String.MediumQuestions;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/print-permutations-string_758958?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class AllPossiblePermutations {
    public static class Solution {
        public static List<String> findPermutations(String input) {
            // Handle edge case: null or empty string
            if (input == null || input.isEmpty()) {
                return new ArrayList<>();
            }

            // Initialize list to store all permutations
            List<String> permutations = new ArrayList<>();
            // Convert input string to character array for swapping
            char[] chars = input.toCharArray();
            // Generate permutations starting from index 0
            generatePermutations(permutations, chars, 0);
            // Return all permutations
            return permutations;
        }

        // Recursively generates all permutations using backtracking
        private static void generatePermutations(List<String> permutations, char[] chars, int start) {
            // If start index reaches end, add current permutation to result
            if (start == chars.length) {
                permutations.add(new String(chars));
                return;
            }

            // Try each character as the start of the permutation
            for (int i = start; i < chars.length; i++) {
                // Swap characters at start and i
                swap(chars, start, i);
                // Recurse for next position
                generatePermutations(permutations, chars, start + 1);
                // Backtrack by swapping back
                swap(chars, start, i);
            }
        }

        // Swaps two characters in the array
        private static void swap(char[] chars, int first, int second) {
            char temp = chars[first];
            chars[first] = chars[second];
            chars[second] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
