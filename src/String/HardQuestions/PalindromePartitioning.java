package String.HardQuestions;
import java.util.* ;

//Problem Link: https://leetcode.com/problems/palindrome-partitioning/description/
//Problem Link: https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class PalindromePartitioning {
    public static class Solution {
        public static List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }

            List<String> currentPartition = new ArrayList<>();
            backtrack(s, 0, currentPartition, result);
            return result;
        }

        /**
         * Backtracking helper method
         */
        private static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
            // Base case: reached end of string
            if (start == s.length()) {
                result.add(new ArrayList<>(currentPartition));
                return;
            }

            // Try all possible substrings starting from 'start'
            for (int end = start; end < s.length(); end++) {
                String substring = s.substring(start, end + 1);

                // If current substring is palindrome, add it and continue
                if (isPalindrome(substring)) {
                    currentPartition.add(substring);
                    backtrack(s, end + 1, currentPartition, result);
                    currentPartition.remove(currentPartition.size() - 1); // backtrack
                }
            }
        }

        private static boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
    public static void main(String[] args) {

    }
}
