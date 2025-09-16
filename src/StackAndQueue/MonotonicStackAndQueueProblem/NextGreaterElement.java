package StackAndQueue.MonotonicStackAndQueueProblem;

import java.util.Stack;

public class NextGreaterElement {
    public static class Solution {
        // Finds the next greater element for each element in the array
        public static int[] nextGreaterElement(int[] numbers, int size) {
            // Handle edge case: return empty array if input is null or size is 0
            if (numbers == null || size == 0) {
                return new int[]{};
            }

            // Initialize result array to store next greater elements
            int[] result = new int[size];
            // Last element has no greater element, so set to -1
            result[size - 1] = -1;
            // Stack to track elements for comparison
            Stack<Integer> stack = new Stack<>();
            stack.push(numbers[size - 1]); // Push last element to stack

            // Iterate from second-to-last element to the first
            for (int i = size - 2; i >= 0; i--) {
                // Pop elements from stack that are less than or equal to current element
                while (!stack.isEmpty() && numbers[i] >= stack.peek()) {
                    stack.pop();
                }
                // If stack is empty, no greater element exists; otherwise, take stack's top
                result[i] = stack.isEmpty() ? -1 : stack.peek();
                // Push current element to stack for future comparisons
                stack.push(numbers[i]);
            }

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
