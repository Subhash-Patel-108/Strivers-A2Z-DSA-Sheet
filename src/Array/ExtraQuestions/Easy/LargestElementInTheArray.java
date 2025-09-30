package Array.ExtraQuestions.Easy;

//Problem Link : https://www.naukri.com/code360/problems/largest-element-in-the-array-largest-element-in-the-array_5026279?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class LargestElementInTheArray {

    public static class Solution {
        static int largestElement(int[] arr, int n) {
            // Handle edge case: null or empty array returns -1
            if (arr == null || n == 0) {
                return -1;
            }

            // Initialize maximum element to minimum possible integer
            int maxElement = Integer.MIN_VALUE;

            // Iterate through array to find largest element
            for (int num : arr) {
                // Update maximum if current number is larger
                if (num > maxElement) {
                    maxElement = num;
                }
            }

            // Return the largest element
            return maxElement;
        }
    }

    public static void main(String[] args) {

    }
}
