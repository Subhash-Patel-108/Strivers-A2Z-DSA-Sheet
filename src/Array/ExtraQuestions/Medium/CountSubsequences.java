package Array.ExtraQuestions.Medium;
import java.util.*;

//Problem link : https://www.naukri.com/code360/problems/count-subsequences_630524?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class CountSubsequences {

    public static class Solution {
        // Corrected MOD constant definition. 1_000_000_007 is 10^9 + 7.
        private static final long MOD = 1_000_000_007L;

        public static long countSubsequences(int[] arr) {
            // Edge case for null or empty array
            if (arr == null || arr.length == 0) {
                return 0;
            }

            // First, we find the frequency of each element
            Map<Integer, Long> freqMap = new HashMap<>();
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0L) + 1);
            }

            return countTotalSubsequences(freqMap);
        }

        private static long countTotalSubsequences(Map<Integer, Long> freqMap) {
            long numberOfSubsequence = 0L;
            // Iterate through the frequencies
            for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
                long value = entry.getValue();
                // Calculate 2^value using modular exponentiation
                long subsequenceForNum = power(2, value);
                // Calculate (2^value - 1) % MOD safely
                long numberOfValidSubsequence = (subsequenceForNum - 1 + MOD) % MOD;
                // Add to the total, applying modulo at each step
                numberOfSubsequence = (numberOfSubsequence + numberOfValidSubsequence) % MOD;
            }
            return numberOfSubsequence;
        }

        /**
         * Helper function to compute (base^exp) % MOD efficiently using modular exponentiation.
         */
        private static long power(long base, long exp) {
            // Corrected base case: Any number to the power of 0 is 1.
            if (exp == 0) {
                return 1;
            }

            long ans = 1;
            base %= MOD; // Ensure base is within the modulo range from the start.

            while (exp > 0) {
                // If exponent is odd, multiply ans with base
                if (exp % 2 == 1) {
                    ans = (ans * base) % MOD;
                }
                // Exponent is now even, so we can halve it and square the base
                base = (base * base) % MOD;
                exp /= 2;
            }
            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
