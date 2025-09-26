package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/left-rotations-of-an-array_985298?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class LeftRotationsOfAnArray {

    public static class Solution {
        public static List<ArrayList<Integer>> leftRotationsOfArray(List<Integer> nums, List<Integer> queries) {
            // Handle edge case: null or empty nums or queries returns empty list
            if (nums == null || nums.isEmpty() || queries == null || queries.isEmpty()) {
                return new ArrayList<>();
            }
            // Store size of input array
            int size = nums.size();
            // Initialize result list to store rotated arrays
            List<ArrayList<Integer>> ans = new ArrayList<>();

            // Process each query
            for (int query : queries) {
                // Perform rotation with query modulo size to handle large rotations
                List<Integer> rotatedArray = findRotation(nums, query % size);
                // Add copy of rotated array to result
                ans.add(new ArrayList<>(rotatedArray));
            }

            // Return list of rotated arrays
            return ans;
        }

        // Performs left rotation of array by given number of positions
        private static List<Integer> findRotation(List<Integer> nums, int rotations) {
            // If no rotation needed, return original list
            if (rotations == 0) {
                return nums;
            }

            // Initialize new list for rotated array
            List<Integer> rotatedArray = new ArrayList<>();

            // Add elements from rotation point to end
            for (int i = rotations; i < nums.size(); i++) {
                rotatedArray.add(nums.get(i));
            }

            // Add elements from start to rotation point
            for (int i = 0; i < rotations; i++) {
                rotatedArray.add(nums.get(i));
            }

            // Return rotated array
            return rotatedArray;
        }
    }

    public static void main(String[] args) {

    }
}
