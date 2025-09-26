package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/intersection-of-2-arrays_1082149?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class IntersectionOfTwoSortedArrays {

    public static class Solution {
        public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
            // Handle edge case: null or empty arrays return empty list
            if (arr1 == null || arr2 == null || arr1.isEmpty() || arr2.isEmpty()) {
                return new ArrayList<>();
            }

            // Initialize result list to store common elements
            ArrayList<Integer> ans = new ArrayList<>();

            // Initialize pointers for both arrays
            int first = 0, second = 0;

            // Use two-pointer technique to find common elements
            while (first < n && second < m) {
                // If current elements match, add to result and move both pointers
                if (arr1.get(first).equals(arr2.get(second))) {
                    ans.add(arr1.get(first));
                    first++;
                    second++;
                } else if (arr1.get(first) < arr2.get(second)) {
                    // Move pointer of smaller element
                    first++;
                } else {
                    // Move pointer of larger element
                    second++;
                }
            }

            // Return list of common elements (intersection)
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
