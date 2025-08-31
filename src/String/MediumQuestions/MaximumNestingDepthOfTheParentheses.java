package String.MediumQuestions;

public class MaximumNestingDepthOfTheParentheses {
    public static class Solution {
        public int maxDepth(String s) {
            // Edge case: if string is null or empty, depth is 0
            if (s == null || s.length() == 0) {
                return 0;
            }

            int maxDepth = 0;     // Keep track of the maximum depth found
            int levelCount = 0;   // Current level of nested parentheses

            // Iterate over every character in the string
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    levelCount++;                       // Increase level count for '('
                } else if (ch == ')') {
                    maxDepth = Math.max(maxDepth, levelCount); // Update maxDepth if current level is deeper
                    levelCount--;                       // Decrease level count for ')'
                }
            }

            // Return maximum depth; also handle cases where string ends with unmatched '('
            return Math.max(maxDepth, levelCount);
        }

    }
    public static void main(String[] args) {

    }
}
