package GreedyAlgorithm.EasyProblems;
import java.util.* ;

public class ValidParentheses {
    public class Solution {
        // Checks if the given string of parentheses is valid
        public static boolean isValidParenthesis(String input) {
            // Initialize stack to track opening parentheses
            Stack<Character> parenthesesStack = new Stack<>();
            // Map to store closing-to-opening parenthesis mappings
            Map<Character, Character> closingToOpening = new HashMap<>();
            closingToOpening.put(']', '[');
            closingToOpening.put(')', '(');
            closingToOpening.put('}', '{');

            // Iterate through each character in the input string
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                // If character is an opening parenthesis, push it onto the stack
                if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                    parenthesesStack.push(currentChar);
                } else {
                    // If stack is empty, no matching opening parenthesis exists
                    if (parenthesesStack.isEmpty()) {
                        return false;
                    }
                    // Pop the top opening parenthesis and check if it matches
                    char top = parenthesesStack.pop();
                    if (closingToOpening.get(currentChar) != top) {
                        return false;
                    }
                }
            }

            // Return true if stack is empty (all parentheses matched), false otherwise
            return parenthesesStack.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}
