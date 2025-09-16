package StackAndQueue.MonotonicStackAndQueueProblem;

import java.util.Stack;

public class NextGreaterElementII {
    public static class Solution {
        // Finds the next greater element for each element in an array
        public int[] nextGreaterElements(int[] nums) {
            // Handle edge case: return empty array if input is null or empty
            if(nums == null || nums.length == 0) {
                return new int[]{} ;
            }
            // Initialize stack to track elements for finding next greater element
            Stack <Integer> stack = new Stack<>() ;
            // Store the length of the input array
            int size = nums.length ;
            // Initialize result array to store next greater elements
            int[] ans = new int[size];
            // Push all elements to stack in reverse order (last to first)
            for(int i = size - 1 ; i >= 0 ; i--) {
                stack.push(nums[i]) ;
            }
            // Iterate through array in reverse to find next greater element for each position
            for(int i = size - 1 ; i >= 0 ; i-- ) {
                // Pop elements from stack that are less than or equal to current element
                while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                    stack.pop() ;
                }
                // Set result: -1 if no greater element exists, otherwise top of stack
                ans[i] = stack.isEmpty() ? -1 : stack.peek() ;
                // Push current element to stack for future comparisons
                stack.push(nums[i]) ;
            }
            // Return the array containing next greater elements
            return ans ;
        }
    }
    public static void main(String[] args) {

    }
}
