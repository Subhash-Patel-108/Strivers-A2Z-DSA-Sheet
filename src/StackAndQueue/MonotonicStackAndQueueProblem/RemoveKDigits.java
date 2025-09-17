package StackAndQueue.MonotonicStackAndQueueProblem;
import java.util.* ;
public class RemoveKDigits {
    public static class Solution {
        // Removes k digits from the string to form the smallest possible number
        public String removeKDigits(String number, int k) {
            // Handle edge cases: return input if null, empty, or k is 0; return "0" if k equals string length
            if (number == null || number.isEmpty() || k == 0) {
                return number;
            }
            if (number.length() == k) {
                return "0";
            }

            // Stack to build the smallest number by keeping digits in increasing order
            Stack<Character> digitStack = new Stack<>();
            // Track number of digits removed
            int digitsRemoved = 0;

            // Iterate through each character in the input string
            for (int i = 0; i < number.length(); i++) {
                char currentDigit = number.charAt(i);

                // Remove larger digits from stack while possible and k allows
                while (!digitStack.isEmpty() && digitStack.peek() > currentDigit && digitsRemoved < k) {
                    digitStack.pop();
                    digitsRemoved++;
                }

                // Push current digit to stack
                digitStack.push(currentDigit);
            }

            // Remove additional digits from the end if k not fully used
            while (digitsRemoved < k && !digitStack.isEmpty()) {
                digitStack.pop();
                digitsRemoved++;
            }
            // Handle case where stack is empty after removals
            if (digitStack.isEmpty()) {
                return "0";
            }

            // Build result string by popping stack and reversing
            StringBuilder result = new StringBuilder();
            while (!digitStack.isEmpty()) {
                result.append(digitStack.pop());
            }
            // Reverse to get correct order and remove leading zeros
            String finalResult = removeLeadingZeros(result.reverse().toString());
            // Return "0" if result is empty, otherwise return result
            return finalResult.isEmpty() ? "0" : finalResult;
        }

        // Removes leading zeros from a string
        private static String removeLeadingZeros(String str) {
            int startIndex = 0;
            // Skip all leading zeros
            while (startIndex < str.length() && str.charAt(startIndex) == '0') {
                startIndex++;
            }
            // Return substring starting from first non-zero character
            return str.substring(startIndex);
        }
    }
    public static void main(String[] args) {

    }
}
