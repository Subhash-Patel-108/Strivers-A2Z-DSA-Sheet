package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/array-intersection_625161?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class IntersectionOfTwoArraysII {

    public static class Solution {
        public static void intersections(int arr1[], int arr2[]) {
            // Handle edge case: null or empty arrays, return without processing
            if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
                return;
            }

            // Call findIntersection with smaller array first for efficiency
            if (arr1.length < arr2.length) {
                findIntersection(arr1, arr2);
            } else {
                findIntersection(arr2, arr1);
            }
        }

        // Finds and prints intersection of two arrays
        private static void findIntersection(int arr1[], int arr2[]) {
            // Initialize HashMap to store frequency of elements in smaller array
            HashMap<Integer, Integer> map = new HashMap<>();
            // Count frequency of each element in arr1
            for (int num : arr1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Initialize StringBuilder to store intersection elements
            StringBuilder ans = new StringBuilder();

            // Check each element in arr2 and append to result if present in map
            for (int num : arr2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    // Decrease frequency and append element to result
                    map.put(num, map.get(num) - 1);
                    ans.append(num).append(" ");
                }
            }

            // Convert result to string and trim trailing space
            String finalStr = ans.toString().trim();

            // Print intersection elements
            System.out.println(finalStr);
        }
    }
    public static void main(String[] args) {

    }
}
