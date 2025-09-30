package Sorting.EasyQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/squares-of-a-sorted-array_1230552?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class SquaresOfASortedArray {

    public static class Solution {
        public static ArrayList<Integer> sqsorted(ArrayList<Integer> arr) {
            // Handle edge case: null or empty array returns empty list
            if (arr == null || arr.isEmpty()) {
                return new ArrayList<>();
            }

            // Initialize result list to store squared values
            ArrayList<Integer> ans = new ArrayList<>();
            // Square each number and add to result
            for (int num : arr) {
                ans.add(num * num);
            }

            // Sort the squared values in ascending order
            Collections.sort(ans);

            // Return sorted list of squared values
            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
