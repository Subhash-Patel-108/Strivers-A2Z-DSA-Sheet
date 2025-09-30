package Sorting.MediumQuestions;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/pythagorean-triplets_797917?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class PythagoreanTriplets {

    public static class Solution {
        public static boolean check(int[] arr) {
            // Handle edge case: null array or length <= 2 returns false
            if (arr == null || arr.length <= 2) {
                return false;
            }

            // Initialize HashSet to store squares of array elements
            Set<Long> squaresSet = new HashSet<>();

            // Calculate and store squares of all elements
            for (long num : arr) {
                long square = num * num;
                squaresSet.add(square);
            }

            // Check pairs to see if sum of their squares exists in set
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    // Calculate sum of squares for current pair
                    long sumOfSquares = (long) arr[i] * arr[i] + (long) arr[j] * arr[j];
                    // If sum exists in set, a valid triplet is found
                    if (squaresSet.contains(sumOfSquares)) {
                        return true;
                    }
                }
            }

            // Return false if no valid triplet is found
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
