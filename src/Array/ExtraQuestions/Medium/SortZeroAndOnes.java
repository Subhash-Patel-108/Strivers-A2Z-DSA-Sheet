package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link :https://www.naukri.com/code360/problems/sort-0-1_624379?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class SortZeroAndOnes {

    public static class Solution {
        public static void sortZeroesAndOne(int[] arr) {
            // Handle edge case: null or empty array, return without modification
            if (arr == null || arr.length == 0) {
                return;
            }
            // Store array length
            int size = arr.length;
            // Initialize pointer for next position to place 0
            int zerosIdx = 0;
            // Initialize pointer for next position to place 1
            int onesIdx = size - 1;
            // Initialize middle pointer for traversal
            int mid = 0;

            // Process array until pointers meet
            while (zerosIdx < onesIdx) {
                if (arr[mid] == 0) {
                    // Swap 0 to left side and increment pointers
                    swap(arr, mid, zerosIdx);
                    zerosIdx++;
                    mid++;
                } else {
                    // Swap 1 to right side and decrement ones pointer
                    swap(arr, mid, onesIdx);
                    onesIdx--;
                }
            }
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
