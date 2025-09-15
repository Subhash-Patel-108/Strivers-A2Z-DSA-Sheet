package Heap.Learning;

public class CheckArrayIsMaxHeapOrNot {
    public static class Solution {
        public boolean countSub(long arr[], long n) {
            // A null or empty array is considered to satisfy the condition
            if (arr == null || arr.length == 0){
                return true ;
            }

            // Pointers for children and current node (parent)
            int leftChild, rightChild, idx = 0;

            // Loop through all parent nodes in the array representation of the heap
            while (idx <= (n / 2 - 1) ) {
                // Calculate the indices of the next and right children
                leftChild = 2 * idx + 1;
                rightChild = 2 * idx + 2;

                // Check if next child exists and violates the max-heap property
                if (leftChild < n && arr[leftChild] > arr[idx]) {
                    return false;
                }

                // Check if right child exists and violates the max-heap property
                if (rightChild < n && arr[rightChild] > arr[idx]) {
                    return false;
                }

                // Move to the next parent node
                idx++;
            }

            // If no violations were found, the array is a max-heap
            return true;
        }
    }
}
