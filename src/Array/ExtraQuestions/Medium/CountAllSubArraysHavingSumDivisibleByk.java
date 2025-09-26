package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/count-all-sub-arrays-having-sum-divisible-by-k_973254?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class CountAllSubArraysHavingSumDivisibleByk {

    public static class Solution {
        public static int subArrayCount(ArrayList<Integer> arr, int k) {
            // Handle edge cases: null array, empty array, or k equals 0 returns 0
            if (arr == null || arr.isEmpty() || k == 0) {
                return 0;
            }

            // Initialize HashMap to store frequency of prefix sum remainders
            Map<Integer, Integer> remainderCount = new HashMap<>();
            // Seed map with remainder 0 at index -1 for subarrays starting from index 0
            remainderCount.put(0, 1);

            // Initialize variables for prefix sum and subarray count
            int prefixSum = 0;
            int count = 0;

            // Iterate through array to compute prefix sums
            for (int num : arr) {
                // Update running prefix sum
                prefixSum += num;

                // Calculate remainder of prefix sum divided by k
                int remainder = prefixSum % k;

                // Adjust negative remainders to positive
                if (remainder < 0) {
                    remainder += k;
                }

                // Add count of previous subarrays with same remainder
                count += remainderCount.getOrDefault(remainder, 0);

                // Update frequency of current remainder
                remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
            }

            // Return total count of subarrays with sum divisible by k
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
