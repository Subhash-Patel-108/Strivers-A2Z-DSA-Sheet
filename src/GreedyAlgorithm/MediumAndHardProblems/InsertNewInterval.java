package GreedyAlgorithm.MediumAndHardProblems;

import java.util.* ;

public class InsertNewInterval {
    public static class Solution {
        // Adds a new interval to a sorted list of non-overlapping intervals and merges overlapping intervals
        public static int[][] addInterval(int[][] intervals, int numIntervals, int[] newInterval) {
            List<int[]> mergedIntervals = new ArrayList<>();

            // Add all intervals that end before the new interval starts
            int currentIndex = 0;
            while (currentIndex < numIntervals && intervals[currentIndex][1] < newInterval[0]) {
                mergedIntervals.add(intervals[currentIndex]);
                currentIndex++;
            }

            // Merge overlapping intervals
            int mergedStart = newInterval[0];
            int mergedEnd = newInterval[1];
            while (currentIndex < numIntervals && intervals[currentIndex][0] <= mergedEnd) {
                mergedStart = Math.min(mergedStart, intervals[currentIndex][0]);
                mergedEnd = Math.max(mergedEnd, intervals[currentIndex][1]);
                currentIndex++;
            }
            mergedIntervals.add(new int[]{mergedStart, mergedEnd});

            // Add remaining intervals after the merged interval
            while (currentIndex < numIntervals) {
                mergedIntervals.add(intervals[currentIndex]);
                currentIndex++;
            }

            // Convert the list to an array
            int[][] result = new int[mergedIntervals.size()][];
            for (int i = 0; i < mergedIntervals.size(); i++) {
                result[i] = mergedIntervals.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
