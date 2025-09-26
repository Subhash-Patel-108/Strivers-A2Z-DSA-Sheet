package Array.ExtraQuestions.Medium;
import java.lang.reflect.Array;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/find-all-triplets-with-zero-sum_873143?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class FindAllTripletsWithZeroSum {

    public static class Solution {
        public static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> arr, int n) {
            // Handle edge case: null or empty array returns empty list
            if (arr == null || arr.isEmpty()) {
                return new ArrayList<>();
            }

            // Sort the array to enable two-pointer technique
            Collections.sort(arr);

            // Initialize list to store triplets with sum zero
            ArrayList<ArrayList<Integer>> zeroSumTuples = new ArrayList<>();

            // Iterate through array, fixing first element of triplet
            for (int idx = 0; idx < n - 2; idx++) {
                // Skip duplicates to avoid redundant triplets
                if (idx > 0 && arr.get(idx).equals(arr.get(idx - 1))) {
                    continue;
                }
                // Initialize two pointers for remaining elements
                int start = idx + 1, end = n - 1;
                // Use two-pointer technique to find pairs
                while (start < end) {
                    // Calculate sum of current triplet
                    int currSum = arr.get(idx) + arr.get(start) + arr.get(end);
                    if (currSum == 0) {
                        // Add valid triplet to result
                        addTuple(zeroSumTuples, arr, idx, start, end);
                        // Skip duplicates for start and end pointers
                        start = skipStart(arr, start, end);
                        end = skipEnd(arr, start, end);
                    } else if (currSum < 0) {
                        // Sum too small, increment start pointer
                        start = skipStart(arr, start, end);
                    } else {
                        // Sum too large, decrement end pointer
                        end = skipEnd(arr, start, end);
                    }
                }
            }
            // Return list of zero-sum triplets
            return zeroSumTuples;
        }

        // Adds a triplet to the result list
        private static void addTuple(ArrayList<ArrayList<Integer>> zeroSumTuples, ArrayList<Integer> arr, int idx, int start, int end) {
            // Create new triplet
            ArrayList<Integer> tuple = new ArrayList<>();
            // Add elements to triplet
            tuple.add(arr.get(idx));
            tuple.add(arr.get(start));
            tuple.add(arr.get(end));
            // Add triplet to result list
            zeroSumTuples.add(tuple);
        }

        // Skips duplicate start indices to avoid redundant triplets
        private static int skipStart(ArrayList<Integer> arr, int start, int end) {
            // Skip consecutive duplicates
            while (start < end && arr.get(start).equals(arr.get(start + 1))) {
                start++;
            }
            // Move to next unique element
            start++;
            return start;
        }

        // Skips duplicate end indices to avoid redundant triplets
        private static int skipEnd(ArrayList<Integer> arr, int start, int end) {
            // Skip consecutive duplicates
            while (end > start && arr.get(end).equals(arr.get(end - 1))) {
                end--;
            }
            // Move to next unique element
            end--;
            return end;
        }
    }

    public static void main(String[] args) {

    }
}
