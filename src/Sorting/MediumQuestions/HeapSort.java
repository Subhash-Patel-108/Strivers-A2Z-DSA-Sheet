package Sorting.MediumQuestions;
import java.util.* ;

//Problem link: https://www.naukri.com/code360/problems/heap-sort_1262153?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class HeapSort {

    public static class Solution {
        public static ArrayList<Integer> heapSort(ArrayList<Integer> arr, int n) {
            // Handle edge case: null or empty array returns empty list
            if (arr == null || arr.isEmpty()) {
                return new ArrayList<>();
            }

            // Build max heap from array
            createHeap(arr, n);

            // Extract elements from heap one by one
            for (int idx = 0; idx < n; idx++) {
                // Swap root (largest) with last element
                swap(arr, 0, n - idx - 1);
                // Heapify reduced heap
                heapify(arr, 0, n - idx - 1);
            }

            // Return sorted ArrayList
            return arr;
        }

        // Builds max heap by heapifying non-leaf nodes
        private static void createHeap(ArrayList<Integer> arr, int n) {
            // Start from last non-leaf node
            for (int idx = n / 2 - 1; idx >= 0; idx--) {
                heapify(arr, idx, n);
            }
        }

        // Heapifies subtree rooted at idx to maintain max heap property
        private static void heapify(ArrayList<Integer> arr, int idx, int size) {
            // Initialize largest as root
            int largest = idx;
            // Calculate left and right child indices
            int leftChild = 2 * idx + 1;
            int rightChild = 2 * idx + 2;

            // Compare with left child
            if (leftChild < size && arr.get(largest) < arr.get(leftChild)) {
                largest = leftChild;
            }

            // Compare with right child
            if (rightChild < size && arr.get(largest) < arr.get(rightChild)) {
                largest = rightChild;
            }

            // If largest is not root, swap and heapify affected subtree
            if (largest != idx) {
                swap(arr, idx, largest);
                heapify(arr, largest, size);
            }
        }

        // Swaps two elements in the ArrayList
        private static void swap(ArrayList<Integer> arr, int first, int second) {
            int temp = arr.get(first);
            arr.set(first, arr.get(second));
            arr.set(second, temp);
        }
    }
    public static void main(String[] args) {

    }
}
