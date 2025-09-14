package Heap.HardProblems;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    class KthLargest {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            // Use a min-heap to keep track of the k largest elements.
            this.minHeap = new PriorityQueue<>();

            // Initialize the heap with the initial numbers.
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            // If the heap has less than k elements, just add the new value.
            if (minHeap.size() < k) {
                minHeap.offer(val);
            }
            // If the new value is larger than the smallest element in the heap,
            // replace the smallest with the new value.
            else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }

            // The root of the min-heap is the Kth largest element.
            return minHeap.peek();
        }
    }
    public static void main(String[] args) {

    }
}
