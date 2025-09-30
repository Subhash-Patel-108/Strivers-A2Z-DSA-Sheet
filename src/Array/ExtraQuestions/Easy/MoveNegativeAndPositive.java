package Array.ExtraQuestions.Easy;

//Problem Link: https://www.naukri.com/code360/problems/move-all-negative-numbers-to-beginning-and-positive-to-end_1112620?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class MoveNegativeAndPositive {

    public static class Solution {
        public static int[] separateNegativeAndPositive(int[] arr) {
            // Handle edge case: null or empty array returns empty array
            if (arr == null || arr.length == 0) {
                return new int[]{};
            }

            // Store array length
            int size = arr.length;
            // Initialize pointer for current element
            int idx = 0;
            // Initialize pointer for next position to place negative number
            int negativeIdx = 0;

            // Iterate through array to partition negative and positive numbers
            while (idx < size) {
                // If current element is negative, swap with element at negativeIdx
                if (arr[idx] < 0) {
                    swap(arr, negativeIdx, idx);
                    negativeIdx++;
                }
                // Move to next element
                idx++;
            }

            // Return modified array with negatives on left, positives on right
            return arr;
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
