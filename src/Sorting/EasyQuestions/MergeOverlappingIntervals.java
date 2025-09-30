package Sorting.EasyQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/merge-overlapping-intervals_1082151?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class MergeOverlappingIntervals {

    public static class Solution {
        public static ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> intervals) {
            // Handle edge case: null intervals returns empty list
            if (intervals == null) {
                return new ArrayList<>();
            }

            // Sort intervals by start time
            Collections.sort(intervals, (a, b) -> Integer.compare(a.get(0), b.get(0)));

            // Initialize result list for merged intervals
            ArrayList<ArrayList<Integer>> nonOverlappingIntervals = new ArrayList<>();
            // Initialize index for iteration
            int idx = 0;

            // Process all intervals
            while (idx < intervals.size()) {
                // Get start and end times of current interval
                int startingTime = intervals.get(idx).get(0);
                int endingTime = intervals.get(idx).get(1);

                // Merge overlapping intervals by updating end time
                while (idx + 1 < intervals.size() && intervals.get(idx + 1).get(0) <= endingTime) {
                    endingTime = Math.max(endingTime, intervals.get(idx + 1).get(1));
                    idx++;
                }

                // Create new merged interval
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(startingTime);
                interval.add(endingTime);

                // Add merged interval to result
                nonOverlappingIntervals.add(interval);

                // Move to next interval
                idx++;
            }

            // Return list of merged non-overlapping intervals
            return nonOverlappingIntervals;
        }
    }
    public static void main(String[] args) {

    }
}
