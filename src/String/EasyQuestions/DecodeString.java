package String.EasyQuestions;

import java.util.Stack;

public class DecodeString {

    public static class Solution {
        public static String decodeString(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }

            Stack<Integer> countStack = new Stack<>();
            Stack<StringBuilder> stringStack = new Stack<>();
            StringBuilder currentString = new StringBuilder();
            int currentCount = 0;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    // Build the number (can be multi-digit)
                    currentCount = currentCount * 10 + (c - '0');
                } else if (c == '[') {
                    // Push current state to stacks and reset
                    countStack.push(currentCount);
                    stringStack.push(currentString);
                    currentString = new StringBuilder();
                    currentCount = 0;
                } else if (c == ']') {
                    // Pop and decode
                    StringBuilder decodedString = stringStack.pop();
                    int count = countStack.pop();

                    // Repeat current string 'count' times
                    for (int i = 0; i < count; i++) {
                        decodedString.append(currentString);
                    }

                    currentString = decodedString;
                } else {
                    // Regular character
                    currentString.append(c);
                }
            }

            return currentString.toString();
        }
    }
    public static void main(String[] args) {

    }
}
