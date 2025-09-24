package String.MediumQuestions;
//Problem Link : https://www.naukri.com/code360/problems/next-greater-number_980529?&interviewProblemRedirection=true&practice_topic[]=Strings&attempt_status=COMPLETED&sort_entity=company_count&sort_order=DESC
public class NextGreaterNumber {

    public static class Solution {

        public static String nextGreater(String input) {
            // Handle edge case: null, empty string, or single digit
            if (input == null || input.isEmpty() || input.length() == 1) {
                return input == null || input.isEmpty() ? "" : "-1";
            }

            // Convert input string to character array for manipulation
            char[] digits = input.toCharArray();
            int length = digits.length;

            // Find pivot: rightmost index where digits[i] < digits[i+1]
            int pivotIndex = -1;
            for (int i = length - 2; i >= 0; i--) {
                if (digits[i] < digits[i + 1]) {
                    pivotIndex = i;
                    break;
                }
            }

            // If no pivot found, no greater number exists
            if (pivotIndex == -1) {
                return "-1";
            }

            // Find smallest digit on right side greater than pivot
            int smallestGreaterIndex = -1;
            for (int i = length - 1; i > pivotIndex; i--) {
                if (digits[i] > digits[pivotIndex]) {
                    smallestGreaterIndex = i;
                    break;
                }
            }

            // Swap pivot with smallest greater digit
            swap(digits, pivotIndex, smallestGreaterIndex);

            // Reverse digits after pivot to get smallest arrangement
            reverse(digits, pivotIndex + 1, length - 1);

            // Return resulting number as string
            return String.valueOf(digits);
        }

        // Reverses characters in array from start to end indices
        private static void reverse(char[] digits, int start, int end) {
            while (start < end) {
                swap(digits, start, end);
                start++;
                end--;
            }
        }

        // Swaps two characters in the array
        private static void swap(char[] digits, int first, int second) {
            char temp = digits[first];
            digits[first] = digits[second];
            digits[second] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
