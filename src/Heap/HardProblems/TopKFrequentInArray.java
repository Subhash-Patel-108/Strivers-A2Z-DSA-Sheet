package Heap.HardProblems;
import java.util.* ;
public class TopKFrequentInArray {
    public static class Solution {
        private static class Pair {
            // Frequency of the number.
            public int freq;
            // The number itself.
            public int num;

            public Pair(int freq, int num) {
                this.freq = freq;
                this.num = num;
            }
        }

        /**
         * Finds the k most frequent numbers in an array.
         *
         * @param arr An array of integers.
         * @param k   The number of most frequent elements to return.
         * @return An ArrayList containing the k most frequent numbers.
         */
        public ArrayList<Integer> topKFrequent(int[] arr, int k) {
            ArrayList<Integer> result = new ArrayList<>();

            // Handle edge cases: if the array is null or empty, return an empty list.
            if (arr == null || arr.length == 0) {
                return result;
            }

            // Count the frequency of each number using a HashMap.
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Use a max-heap to store pairs of (frequency, number).
            // The heap is ordered primarily by frequency in descending order.
            // If frequencies are equal, it's ordered by the number in descending order.
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
                if (a.freq != b.freq) {
                    return b.freq - a.freq;
                } else {
                    return b.num - a.num;
                }
            });

            // Add all number-frequency pairs to the max-heap.
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                maxHeap.offer(new Pair(entry.getValue(), entry.getKey()));
            }

            // Extract the k most frequent numbers from the heap.
            while (k-- > 0 && !maxHeap.isEmpty()) {
                result.add(maxHeap.poll().num);
            }

            return result;
        }
    }

    public static void main(String[] args) {

    }
}
