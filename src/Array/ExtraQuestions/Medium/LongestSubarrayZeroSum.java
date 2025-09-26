package Array.ExtraQuestions.Medium;
import java.util.* ;
//Problem Link :https://www.naukri.com/code360/problems/longest-subarray-zero-sum_757507?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class LongestSubarrayZeroSum {

    public static class Solution {
        /**
         * Calculates the length of the longest contiguous subarray with a sum of zero.
         * This method uses a HashMap to store the first seen index of each prefix sum,
         * allowing for an efficient O(n) time complexity solution.
         */
        public static int lengthOfLongestSubarray(int[] arr) {
            // Handle null or empty array case, return 0
            if (arr == null || arr.length == 0) {
                return 0;
            }

            // Store array length
            int n = arr.length;
            // Track maximum length of zero-sum subarray
            int maxLength = 0;

            // Map to store prefix sum to its first occurrence index
            HashMap<Integer, Integer> prefixSumToIndexMap = new HashMap<>();

            // Initialize map with 0 sum at index -1 for subarrays starting from 0
            prefixSumToIndexMap.put(0, -1);

            // Track running prefix sum
            int currentSum = 0;

            // Iterate through array to compute prefix sums
            for (int i = 0; i < n; i++) {
                // Add current element to prefix sum
                currentSum += arr[i];

                // Check if current sum exists in map
                if (prefixSumToIndexMap.containsKey(currentSum)) {
                    // Calculate length of zero-sum subarray
                    int previousIndex = prefixSumToIndexMap.get(currentSum);
                    int currentLength = i - previousIndex;

                    // Update maximum length if current length is larger
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    // Store new prefix sum with its index
                    prefixSumToIndexMap.put(currentSum, i);
                }
            }

            // Return length of longest zero-sum subarray
            return maxLength;
        }
    }

    public static void main(String[] args) {

    }
}
