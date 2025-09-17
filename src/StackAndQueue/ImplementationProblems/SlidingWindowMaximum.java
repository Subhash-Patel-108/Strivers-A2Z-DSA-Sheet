package StackAndQueue.ImplementationProblems;
import java.util.* ;
public class SlidingWindowMaximum {
    public static class Solution {
        // Finds the maximum element in each sliding window of size k in the given array
        public int[] maxSlidingWindow(int[] nums, int k) {
            // Handle edge case: return empty array if input is null, empty, or k is 0
            if (nums == null || nums.length == 0 || k == 0) {
                return new int[] {};
            }

            // Initialize deque to store indices of potential maximum elements
            Deque<Integer> deque = new LinkedList<>();
            // Initialize window pointers: low (start) and high (end)
            int low = 0, high = 0;
            // Process the first k elements to initialize the deque
            while (high < k) {
                // Remove indices of smaller elements from the back of the deque
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[high]) {
                    deque.pollLast();
                }
                // Add current index to the back of the deque
                deque.offerLast(high);
                high++;
            }

            high--; // Adjust high to point to the last element of the window
            // Initialize result list to store maximums of each window
            ArrayList<Integer> result = new ArrayList<>();

            // Process all windows of size k
            while (high < nums.length) {
                // Remove indices outside the current window from the front
                while (!deque.isEmpty() && deque.peekFirst() < low) {
                    deque.pollFirst();
                }

                // Remove indices of smaller elements from the back
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[high]) {
                    deque.pollLast();
                }

                // Add current index to the back of the deque
                deque.offerLast(high);
                // Add maximum element of current window (front of deque) to result
                result.add(nums[deque.peekFirst()]);

                // Slide window forward
                low++;
                high++;
            }

            // Convert result list to array
            int[] ans = new int[result.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = result.get(i);
            }

            // Return the array of maximums for each sliding window
            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
