package Heap.HardProblems;
import java.util.* ;
public class MinimumCostOfRopes {
    public static class Solution {
        public static int minCost(int[] arr) {
            // Handle edge case: if array is null or empty, the cost is 0.
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int totalCost = 0;
            // Use a min-heap to always get the two smallest ropes.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Add all rope lengths to the min-heap.
            for (int num : arr) {
                minHeap.offer(num);
            }

            // Continue until only one rope remains in the heap.
            while (minHeap.size() > 1) {
                // Get the two smallest ropes from the heap.
                int first = minHeap.poll();
                int second = minHeap.poll();

                // Calculate the cost of connecting them.
                int combinedRope = first + second;

                // Add this cost to the total.
                totalCost += combinedRope;

                // Add the newly combined rope back to the heap.
                minHeap.offer(combinedRope);
            }

            // The final result is the sum of all costs.
            return totalCost;
        }
    }
    public static void main(String[] args) {

    }
}
