package SlidingWindow.MediumProblem;
import java.util.* ;
public class BinarySubarraysWithSum {
    public static class Solution {
        // Counts the number of subarrays with sum equal to target
        public int countSubarraysWithSum(int[] numbers, int targetSum) {
            // Handle edge case: return 0 if array is null or empty
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            // Map to store frequency of prefix sums
            HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
            // Initialize with 0 sum having one occurrence to handle subarrays starting from index 0
            prefixSumFrequency.put(0, 1);

            int currentPrefixSum = 0;
            int subarrayCount = 0;

            // Iterate through array to compute prefix sums
            for (int num : numbers) {
                // Update current prefix sum
                currentPrefixSum += num;
                // Add count of subarrays ending at current index with sum equal to target
                subarrayCount += prefixSumFrequency.getOrDefault(currentPrefixSum - targetSum, 0);
                // Update frequency of current prefix sum
                prefixSumFrequency.put(currentPrefixSum, prefixSumFrequency.getOrDefault(currentPrefixSum, 0) + 1);
            }

            return subarrayCount;
        }
    }
    public static void main(String[] args) {

    }
}
