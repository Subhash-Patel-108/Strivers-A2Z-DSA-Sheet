package StackAndQueue.MonotonicStackAndQueueProblem;
import java.util.* ;
public class NextSmallerElement {
    public class Solution{
        // Finds the next smaller element for each element in the array
        static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
            // Handle edge case: return empty list if array is null or size is 0
            if (arr == null || n == 0) {
                return new ArrayList<>();
            }
            // Initialize result list to store next smaller elements
            ArrayList<Integer> ans = new ArrayList<>();

            // Stack to track elements for finding next smaller element
            Stack<Integer> stack = new Stack<>();
            // Iterate from right to left to process elements
            for (int i = n - 1; i >= 0; i--) {
                // Pop elements from stack that are greater than or equal to current element
                while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                    stack.pop();
                }
                // Add next smaller element: -1 if no smaller element exists, otherwise top of stack
                ans.add(stack.isEmpty() ? -1 : stack.peek());
                // Push current element to stack for future comparisons
                stack.push(arr.get(i));
            }
            // Reverse the result list to restore original order
            Collections.reverse(ans);
            // Return the list containing next smaller elements
            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
