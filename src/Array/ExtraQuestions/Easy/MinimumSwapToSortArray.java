package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/minimum-number-of-swaps-required-to-sort-an-array_973251?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class MinimumSwapToSortArray {

    public static class Solution {
        public static int minSwaps(int[] arr) {
            // Handle edge case: null or empty array returns 0
            if (arr == null || arr.length == 0) {
                return 0;
            }

            // Store array length
            int size = arr.length;
            // Create a copy of array for sorting
            int[] sortedArray = new int[size];
            // Initialize HashMap to store value-to-index mapping for unsorted array
            HashMap<Integer, Integer> unSortedIndexMap = new HashMap<>();

            // Populate sorted array and index map
            for (int idx = 0; idx < size; idx++) {
                sortedArray[idx] = arr[idx];
                unSortedIndexMap.put(arr[idx], idx);
            }
            // Sort the copy to get desired order
            Arrays.sort(sortedArray);

            // Initialize swap count
            int swapCount = 0;
            // Iterate through array to correct positions
            for (int idx = 0; idx < size; idx++) {
                // If current element is not in correct position
                if (arr[idx] != sortedArray[idx]) {
                    // Increment swap count
                    swapCount++;

                    // Store current index and element
                    int currentIdx = idx;
                    int currentElement = arr[idx];

                    // Get index where correct element should be
                    int swapIdx = unSortedIndexMap.get(sortedArray[idx]);
                    // Get correct element for current position
                    int swapElement = sortedArray[idx];

                    // Swap elements to place correct element at current index
                    swap(arr, currentIdx, swapIdx);

                    // Update index map for swapped elements
                    unSortedIndexMap.put(swapElement, currentIdx);
                    unSortedIndexMap.put(currentElement, swapIdx);
                }
            }

            // Return total number of swaps needed
            return swapCount;
        }

        // Swaps two elements in the array
        private static void swap(int[] arr, int first, int second) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
