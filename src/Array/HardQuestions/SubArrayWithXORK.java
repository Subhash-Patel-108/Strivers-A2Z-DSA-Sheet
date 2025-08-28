package Array.HardQuestions;

import java.util.HashMap;

/**
 * This class provides a solution to find the number of subarrays with XOR equal to a given value K.
 * It uses the concept of prefix XOR and hashmap for efficient computation.
 */
public class SubArrayWithXORK {
    public static class Solution {
        public static int subarraysWithSumK(int[] arr, int k) {
            int count = 0; // Initialize count of subarrays with XOR equal to K
            
            // Edge case: if array is null or empty, return 0 as no subarrays exist
            if (arr == null || arr.length == 0) {
                return count;
            }

            int prefixXOR = 0; // Initialize prefix XOR to 0
            // HashMap to store the frequency of prefix XOR values
            HashMap<Integer, Integer> prefixXORMap = new HashMap<>();
            
            // Initialize with {0,1} to handle the case when prefixXOR equals k
            prefixXORMap.put(0, 1);
            
            for (int i = 0; i < arr.length; i++) {
                // Compute prefix XOR up to current element
                prefixXOR ^= arr[i];
                
                // Calculate the target XOR value that would make the current prefix XOR equal to k
                // If we've seen this target before, it means there are subarrays ending at current index
                // with XOR equal to k
                int target = prefixXOR ^ k;
                
                // If target exists in map, add its frequency to count
                if (prefixXORMap.containsKey(target)) {
                    count += prefixXORMap.get(target);
                }
                
                // Update the frequency of current prefixXOR in the map
                prefixXORMap.put(prefixXOR, prefixXORMap.getOrDefault(prefixXOR, 0) + 1);
            }
            return count;
        }
    }
    public static void main(String[] args) {
        // Example usage
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        int result = Solution.subarraysWithSumK(arr, k);
        System.out.println("Number of subarrays with XOR " + k + " is: " + result);
        // Expected Output: 4
        // Explanation: The subarrays are [4,2], [4,2,2,6,4], [2,2,6], [6]
    }
}
