package Heap.Learning;

public class ConvertMinHeapToMaxHeap {
    public class Solution {
        /**
         * Converts an array into a max-heap in-place.
         */
        public static int[] buildMaxHeap(int n, int[] arr){
            // Handle empty or null arrays.
            if(arr == null || arr.length == 0) {
                return arr;
            }

            // Build the heap by heapifying all non-leaf nodes.
            buildHeapFromBottomUp(arr , n);
            return arr;
        }

        /**
         * Builds a max-heap by processing nodes from the last non-leaf up to the root.
         */
        private static void buildHeapFromBottomUp(int[] arr , int size) {
            // Start from the last non-leaf node and iterate backwards.
            for(int i = (size / 2 ) - 1 ; i >= 0 ; i-- ) {
                heapify(arr , i , size );
            }
        }

        /**
         * Ensures the subtree rooted at rootIndex satisfies the max-heap property.
         */
        private static void heapify(int[] arr , int rootIndex , int size) {
            // Assume the current root is the largest.
            int largest = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            // If the left child exists and is greater than the current largest, update largest.
            if(leftChild < size && arr[largest] < arr[leftChild] ) {
                largest = leftChild;
            }

            // If the right child exists and is greater than the current largest, update largest.
            if(rightChild < size && arr[largest] < arr[rightChild]) {
                largest = rightChild;
            }

            // If the root was not the largest, swap it with the largest child.
            if(largest != rootIndex){
                swap(arr , largest , rootIndex);

                // Recursively heapify the affected subtree.
                heapify(arr , largest , size);
            }
        }

        /**
         * Utility function to swap two elements in an array.
         */
        private static void swap(int[] arr , int firstIndex , int secondIndex) {
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
