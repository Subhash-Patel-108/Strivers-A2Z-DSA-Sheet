package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/count-inversions_615?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class CountInversions {

    public static class Solution {
        // Global variable to track total number of inversions
        private static long countOfInversions;

        public static long getInversions(long arr[], int n) {
            // Handle edge case: null or empty array returns 0
            if (arr == null || arr.length == 0) {
                return 0;
            }

            // Initialize inversion count
            countOfInversions = 0;
            // Perform merge sort and count inversions
            mergeSortAndCount(arr, 0, n - 1);
            // Return total number of inversions
            return countOfInversions;
        }

        // Recursively sorts array and counts inversions using divide-and-conquer
        private static void mergeSortAndCount(long[] arr, int low, int high) {
            // Base case: if low < high, split and process subarrays
            if (low < high) {
                // Calculate middle index
                int mid = low + (high - low) / 2;

                // Recursively sort and count inversions in left half
                mergeSortAndCount(arr, low, mid);
                // Recursively sort and count inversions in right half
                mergeSortAndCount(arr, mid + 1, high);

                // Merge subarrays and count inversions
                mergeArrayAndCount(arr, low, mid, high);
            }
        }

        // Merges two sorted subarrays and counts inversions
        private static void mergeArrayAndCount(long[] arr, int low, int mid, int high) {
            // Initialize pointers for left and right subarrays
            int left = low, right = mid + 1;
            // Temporary list to store merged elements
            ArrayList<Long> sortedArray = new ArrayList<>();

            // Merge elements from both subarrays
            while (left <= mid && right <= high) {
                // If left element is smaller or equal, add it
                if (arr[left] <= arr[right]) {
                    sortedArray.add(arr[left]);
                    left++;
                } else {
                    // If right element is smaller, add it and count inversions
                    sortedArray.add(arr[right]);
                    countOfInversions += (mid - left + 1); // Count inversions for remaining left elements
                    right++;
                }
            }

            // Add remaining elements from left subarray
            while (left <= mid) {
                sortedArray.add(arr[left++]);
            }

            // Add remaining elements from right subarray
            while (right <= high) {
                sortedArray.add(arr[right++]);
            }

            // Copy merged elements back to original array
            int arrIdx = low;
            for (int i = 0; i < sortedArray.size(); i++) {
                arr[arrIdx++] = sortedArray.get(i);
            }
        }
    }
    public static void main(String[] args) {

    }
}
