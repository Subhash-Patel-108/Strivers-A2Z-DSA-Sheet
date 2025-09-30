package Array.ExtraQuestions.Easy;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/missing-numbers_762938?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class MissingNumbers {

    public static class Solution {
        public static ArrayList<Integer> missingNumbers(int[] arr, int n) {
            // Handle edge case: null or empty array returns empty list
            if (arr == null || n == 0) {
                return new ArrayList<>();
            }

            // Initialize variables to find range of numbers
            int minElement = Integer.MAX_VALUE;
            int maxElement = Integer.MIN_VALUE;

            // HashMap to track seen numbers
            HashMap<Integer, Boolean> seen = new HashMap<>();
            // Find min, max, and mark numbers as seen
            for (int num : arr) {
                seen.put(num, true);
                minElement = Math.min(minElement, num);
                maxElement = Math.max(maxElement, num);
            }

            // Initialize result list for missing numbers
            ArrayList<Integer> ans = new ArrayList<>();
            // Add all numbers in range [minElement + 1, maxElement - 1] that are not seen
            for (int num = minElement + 1; num < maxElement; num++) {
                if (!seen.containsKey(num)) {
                    ans.add(num);
                }
            }

            // Return list of missing numbers
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
