package Heap.HardProblems;
import java.util.* ;
public class FindMedianFromDataStream {
    public static class MedianFinder {
        // maxHeap stores the smaller half of the numbers.
        private PriorityQueue<Integer> maxHeap;
        // minHeap stores the larger half of the numbers.
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            // The maxHeap is ordered by descending values.
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // The minHeap is ordered by ascending values.
            minHeap = new PriorityQueue<>();
        }

        // Adds a new number to the data structure.
        public void addNum(int num) {
            // If maxHeap is empty or the new number is smaller than the largest in maxHeap,
            // add it to the maxHeap. Otherwise, add it to the minHeap.
            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            balanceTheHeaps();
        }

        // Ensures that the heaps are balanced, with maxHeap having at most one more element than minHeap.
        private void balanceTheHeaps() {
            // If minHeap has more elements than maxHeap, move the smallest from minHeap to maxHeap.
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            // If maxHeap has more than one more element than minHeap, move the largest from maxHeap to minHeap.
            else if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }
        }

        // Finds the current median of all numbers added so far.
        public double findMedian() {
            //Edge case
            if(maxHeap.isEmpty()){
                return -1.0 ;
            }

            // The median is the largest element in the maxHeap.
            // If both heaps have the same size, the median is the average of the two middle elements.
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                // If the sizes are different, the median is simply the largest element in the maxHeap.
                return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {

    }
}
