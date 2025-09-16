package StackAndQueue.ImplementationProblems;

import java.util.* ;
public class BalancedParentheses {
    public static class Solution {
        // Checks if the given string of parentheses is balanced
        public static boolean isBalanced(String input) {
            // Handle edge case: return true if string is null or empty
            if (input == null || input.isEmpty()) {
                return true;
            }

            // Map to store opening-to-closing parenthesis mappings
            Map<Character, Character> openingToClosing = new HashMap<>();
            openingToClosing.put('(', ')');
            openingToClosing.put('{', '}');
            openingToClosing.put('[', ']');

            // MinStackClass to track opening parentheses
            Stack<Character> parenthesesStack = new Stack<>();

            // Iterate through each character in the input string
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                // If character is an opening parenthesis, push it onto the stack
                if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                    parenthesesStack.push(currentChar);
                } else {
                    // If stack is empty, no matching opening parenthesis exists
                    if (parenthesesStack.isEmpty()) {
                        return false;
                    }
                    // Pop the top opening parenthesis and check if it matches the current closing one
                    char top = parenthesesStack.pop();
                    if (!openingToClosing.get(top).equals(currentChar)) {
                        return false;
                    }
                }
            }

            // Return true only if all parentheses are matched (stack is empty)
            return parenthesesStack.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}
