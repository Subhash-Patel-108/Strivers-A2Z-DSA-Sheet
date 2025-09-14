package BitManipulation.InterviewProblems;

public class FindOddOccurrenceElement {
    public static class Solution {
        public static int findOdd(int[] arr, int n) {
            int result = 0;
            for (int num : arr) {
                result ^= num; // XORing all elements
            }
            return result; // The result will be the element with odd occurrences
        }
    }

    public static void main(String[] args) {

    }
}
