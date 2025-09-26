package String.MediumQuestions;

public class ImplementATOI {
    public static class Solution {
        public int myATOI(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            // Remove leading/trailing whitespace
            s = s.trim();

            if (s.isEmpty()) {
                return 0;
            }

            boolean isNegative = false;
            int idx = 0;
            if (s.charAt(0) == '-') {
                isNegative = true;
                idx++;
            } else if (s.charAt(0) == '+') {
                idx++;
            }

            int result = 0;
            int limit = isNegative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
            // Use negative range to prevent overflow when negating after calculation

            while (idx < s.length() && (s.charAt(idx ) >= '0' && s.charAt(idx) <= '9')) {
                int digit = s.charAt(idx) - '0';

                // Check if result will overflow if multiplied by 10 or digit added
                if (result < (limit + digit) / 10) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                result = result * 10 - digit; // Store as negative number to handle MIN_VALUE correctly
                idx++;
            }

            return isNegative ? result : -result; // Convert back to positive if needed
        }

    }
    public static void main(String[] args) {

    }
}
