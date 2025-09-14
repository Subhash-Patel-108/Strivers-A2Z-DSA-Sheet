package Heap.MediumProblems;
import java.util.* ;
public class KthLargestElementInArray {
    public static class Solution {
        public int findKthLargest(int[] nums, int k) {
            // Handle invalid inputs.
            if(nums == null || k > nums.length || k <= 0) {
                // Or throw an IllegalArgumentException for invalid k.
                return -1;
            }

            // Use a min-heap to keep track of the k largest elements encountered so far.
            // The smallest of these k elements will be at the top of the heap.
            PriorityQueue <Integer> minHeap = new PriorityQueue<>();

            // Add the first k elements to the min-heap.
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }

            // Iterate through the rest of the array.
            for (int i = k; i < nums.length; i++) {
                // If the current element is larger than the smallest element in the heap...
                if(nums[i] > minHeap.peek()) {
                    // ...remove the smallest element...
                    minHeap.poll();
                    // ...and add the current, larger element.
                    minHeap.offer(nums[i]);
                }
            }

            // After the loop, the root of the min-heap is the k-th largest element.
            return minHeap.peek();
        }
    }
    public static void main(String[] args) {

    }
}
