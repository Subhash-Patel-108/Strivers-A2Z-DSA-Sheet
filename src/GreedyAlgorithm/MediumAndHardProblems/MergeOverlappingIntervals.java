package GreedyAlgorithm.MediumAndHardProblems;
import java.util.* ;
public class MergeOverlappingIntervals {
    public static class Solution {
        // Merges overlapping intervals in a given array of intervals
        public ArrayList<int[]> mergeOverlappingIntervals(int[][] intervals) {
            ArrayList<int[]> mergedIntervals = new ArrayList<>();

            // Handle edge case: return empty list if array is null or empty
            if (intervals == null || intervals.length == 0) {
                return mergedIntervals;
            }

            // Sort intervals by start time to process them in order
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int currentIndex = 0;
            // Process all intervals
            while (currentIndex < intervals.length) {
                int mergedStart = intervals[currentIndex][0];
                int mergedEnd = intervals[currentIndex][1];

                // Merge all overlapping intervals
                while (currentIndex + 1 < intervals.length && intervals[currentIndex + 1][0] <= mergedEnd) {
                    currentIndex++;
                    mergedEnd = Math.max(mergedEnd, intervals[currentIndex][1]);
                }

                // Add merged interval to result
                mergedIntervals.add(new int[]{mergedStart, mergedEnd});
                currentIndex++; // Move to the next non-overlapping interval
            }

            return mergedIntervals;
        }
    }
    public static void main(String[] args) {

    }
}
