package BinarySearch.BinarySearchOnOneDArray;

public class FindPeakElement {
    public static class Solution {
        /**
         * A helper function to find a peak element using binary search.
         * It searches within the range from index 1 to nums.length - 2.
         */
        private int findPeak(int[] nums) {
            // Initialize the search space to exclude the first and last elements,
            // as they are handled as edge cases in the main function.
            int start = 1, end = nums.length - 2;
            int mid;

            // Standard binary search loop.
            while (start <= end) {
                // Calculate the middle index to prevent potential integer overflow.
                mid = start + (end - start) / 2;

                // Check if the middle element is a peak (greater than both its neighbors).
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid; // Found a peak, return its index.
                }

                // If the middle element is on an "uphill slope" (the element to its right is larger),
                // a peak must exist on the right side.
                if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1; // Discard the left half.
                } else {
                    // If the middle element is on a "downhill slope",
                    // a peak must exist on the left side.
                    end = mid - 1; // Discard the right half.
                }
            }
            // This line is for completeness; given the problem's constraints,
            // a peak will always be found if the edge cases are passed.
            return -1;
        }

        /**
         * Finds a peak element in an array. A peak element is an element that is
         * strictly greater than its neighbors.
         */
        public int findPeakElement(int[] nums) {
            // Handle edge cases first for efficiency.

            // Case 1: The array is empty. No peak exists.
            if (nums.length == 0) {
                return -1;
            }
            // Case 2: Array has one element (it's a peak) or the first element is a peak.
            else if (nums.length == 1 || nums[0] > nums[1]) {
                return 0;
            }
            // Case 3: The last element is a peak.
            else if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }

            // If the peak is not at the edges, call the helper function
            // to find it in the middle part of the array.
            return findPeak(nums);
        }
    }
    public static void main(String[] args) {

    }
}
