package GreedyAlgorithm.ExtraQuestions;
//Problem Link: https://www.naukri.com/code360/problems/equilibrium-index_893014?interviewProblemRedirection=true&practice_topic%5B%5D=Greedy&sort_entity=company_count&sort_order=DESC
public class EquilibriumIndex {
    public static class Solution {
        public static int arrayEquilibriumIndex(int[] array) {
            // Handle edge case: null or empty array
            if (array == null || array.length == 0) {
                return -1; // Return -1 for invalid input
            }

            int size = array.length;
            // Initialize array to store suffix sums
            int[] suffixSums = new int[size];
            // Set last suffix sum to last element
            suffixSums[size - 1] = array[size - 1];

            // Compute suffix sums from right to left
            for (int i = size - 2; i >= 0; i--) {
                suffixSums[i] = array[i] + suffixSums[i + 1];
            }

            // Initialize left sum
            int leftSum = 0;
            // Iterate through array to find equilibrium index
            for (int i = 0; i < size; i++) {
                // Subtract current element from left sum for comparison
                leftSum += array[i];
                // Right sum excludes current element
                int rightSum = (i + 1 < size) ? suffixSums[i + 1] : 0;

                // Check if left and right sums are equal
                if (leftSum - array[i] == rightSum) {
                    return i;
                }
            }

            // No equilibrium index found
            return -1;
        }
    }
    public static void main(String[] args) {

    }
}
