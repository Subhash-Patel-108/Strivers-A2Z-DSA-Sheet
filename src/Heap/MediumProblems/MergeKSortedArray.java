package Heap.MediumProblems;
import java.awt.geom.PathIterator;
import java.util.* ;
public class MergeKSortedArray {
    public static class Solution {
        public static class Pair {
            public int[] arr ;
            public int idx ;

            public Pair(int[] arr , int idx) {
                this.arr = arr ;
                this.idx = idx ;
            }
        }
        // Function to merge k sorted arrays.
        public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
            //Edge case
            ArrayList <Integer> sortedArray = new ArrayList<>();
            if(arr == null || arr.length == 0 ) {
                return sortedArray ;
            }

            PriorityQueue<Pair> minHeap = new PriorityQueue<>((a , b) -> a.arr[a.idx] - b.arr[b.idx]) ;

            for(int[] nums : arr) {
                if(nums.length != 0 ) {
                    minHeap.add(new Pair(nums , 0)) ;
                }
            }

            while (!minHeap.isEmpty()) {
                Pair pair = minHeap.poll() ;
                int idx = pair.idx ;
                int currentElement = pair.arr[idx] ;
                sortedArray.add(currentElement) ;

                if((idx + 1) < pair.arr.length) {
                    minHeap.offer(new Pair(pair.arr , idx + 1)) ;
                }
            }

            return sortedArray ;
        }
    }
    public static void main(String[] args) {

    }
}
