package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/longest-consecutive-sequence_759408?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class LongestConsecutiveSequence {

    public static class Solution {
        public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
            // Handle edge case: null or empty array returns -1
            if (arr == null || arr.length == 0) {
                return -1;
            }

            // Sort the array in ascending order
            Arrays.sort(arr);
            // Initialize longest consecutive sequence length
            int longestStreak = 1;
            // Initialize current consecutive sequence count
            int count = 1;
            // Store previous value for comparison
            int prevValue = arr[0];

            // Iterate through the sorted array
            for (int idx = 1; idx < N; idx++) {
                // Skip duplicates
                if (prevValue == arr[idx]) {
                    continue;
                } else if (prevValue == arr[idx] - 1) {
                    // Increment count if current element extends sequence
                    count++;
                } else {
                    // Update longest streak and reset count for new sequence
                    longestStreak = Math.max(longestStreak, count);
                    count = 1;
                }
                // Update previous value
                prevValue = arr[idx];
            }

            // Return maximum of longest streak and final count
            return Math.max(longestStreak, count);
        }
    }

    public static class Solution2 {
        public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
            // Handle edge case: null or empty array returns -1
            if (arr == null || arr.length == 0) {
                return -1;
            }

            // Initialize HashMap to store numbers as keys with true value
            HashMap<Integer, Boolean> numberSet = new HashMap<>();
            // Populate HashMap with all numbers from array
            for (int num : arr) {
                numberSet.put(num, true);
            }

            // Initialize longest consecutive sequence length
            int longestStreak = 1;
            // Iterate through array to find sequence starts
            for (int idx = 0; idx < N; idx++) {
                // Check if current number is the start of a sequence
                if (!numberSet.containsKey(arr[idx] - 1)) {
                    // Initialize current number and streak length
                    int currNum = arr[idx];
                    int currStreak = 1;
                    // Extend sequence by checking consecutive numbers
                    while (numberSet.containsKey(currNum + 1)) {
                        currStreak++;
                        currNum++;
                    }
                    // Update longest streak if current streak is larger
                    longestStreak = Math.max(longestStreak, currStreak);
                }
            }

            // Return length of longest consecutive sequence
            return longestStreak;
        }
    }

    public static void main(String[] args) {

    }
}
