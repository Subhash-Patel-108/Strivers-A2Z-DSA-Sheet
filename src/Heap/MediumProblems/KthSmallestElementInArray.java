package Heap.MediumProblems;

import java.util.*;

public class KthSmallestElementInArray {
    public static class Solution {
        public static int kthSmallest(int[] arr, int k) {
            // Handle invalid input: null array, k out of bounds.
            if (arr == null || k <= 0 || k > arr.length) {
                return -1;
            }

            // Use a max-heap to keep track of the k largest elements seen so far.
            // The top of this heap will always be the largest among these k elements.
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int index = 0;

            // Fill the heap with the first k elements of the array.
            while (index < k) {
                maxHeap.add(arr[index++]);
            }

            // For the rest of the array, compare each element with the heap's top.
            while (index < arr.length) {
                // If the current element is smaller than the largest in the heap,
                // it means this element is a candidate for being one of the k smallest.
                if (maxHeap.peek() > arr[index]) {
                    // Remove the current largest element from the heap.
                    maxHeap.poll();
                    // Add the smaller element to the heap.
                    maxHeap.offer(arr[index]);
                }
                index++;
            }

            // The element at the top of the heap is the k-th smallest element.
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}
