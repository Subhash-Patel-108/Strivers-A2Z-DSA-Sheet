package BitManipulation.ExtraQuestions;
//Problem Link : https://www.naukri.com/code360/problems/unique-pair-using-bits_972997?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
import java.util.* ;
public class TwoNonRepeatingNumber {
    public static class Solution {
        public static ArrayList<Integer> findNonRepeating(ArrayList<Integer> arr) {
            // Handle edge case: null or empty array
            if (arr == null || arr.isEmpty()) {
                return new ArrayList<>();
            }

            // Compute XOR of all numbers to get XOR of the two non-repeating numbers
            int xorResult = 0;
            for (int num : arr) {
                xorResult ^= num;
            }

            // Find position of rightmost set bit in xorResult
            int rightmostSetBitPos = findRightmostSetBitPosition(xorResult);

            // Partition numbers based on rightmost set bit
            int groupZero = 0; // XOR of numbers with 0 at rightmost set bit position
            int groupOne = 0;  // XOR of numbers with 1 at rightmost set bit position

            // Divide numbers into two groups based on the bit at rightmostSetBitPos
            for (int num : arr) {
                if ((num & (1 << rightmostSetBitPos)) == 0) {
                    groupZero ^= num;
                } else {
                    groupOne ^= num;
                }
            }

            // Initialize result list for the two non-repeating numbers
            ArrayList<Integer> result = new ArrayList<>();

            // Add numbers in ascending order
            if (groupZero > groupOne) {
                result.add(groupOne);
                result.add(groupZero);
            } else {
                result.add(groupZero);
                result.add(groupOne);
            }

            // Return the list of non-repeating numbers
            return result;
        }

        // Finds the position of the rightmost set bit in a number
        private static int findRightmostSetBitPosition(int num) {
            int position = 0;
            // Shift right until a set bit is found
            while ((num & 1) == 0) {
                position++;
                num /= 2 ; // Right shift by 1
            }
            return position;
        }
    }
    public static void main(String[] args) {

    }
}
