package BinarySearch.BinarySearchOnOneDArray;

public class BinarySearchAlgorithm {
    public static class Solution {
        public int binarysearch(int[] arr, int target) {
            // Initialize the start and end pointers for the search range
            int start = 0, end = arr.length - 1;

            // Continue searching while the range is valid
            while (start <= end) {
                // Calculate the middle index to avoid potential overflow
                int mid = start + (end - start) / 2;

                // If the middle element matches the target, return its index
                if (arr[mid] == target) {
                    return mid;
                }
                // If the middle element is greater than the target,
                // narrow the search to the next half
                else if (arr[mid] > target) {
                    end = mid - 1;
                }
                // If the middle element is less than the target,
                // narrow the search to the right half
                else {
                    start = mid + 1;
                }
            }

            // If the target is not found, return -1
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
