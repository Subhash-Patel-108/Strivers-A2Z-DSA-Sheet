package Array.HardQuestions;
import java.util.* ;
public class MergeOverlappingIntervals {
    public static class Solution {
        public ArrayList<int[]> mergeOverlap(int[][] arr) {
            ArrayList<int[]> result = new ArrayList<>();

            // Edge case
            if (arr == null || arr.length == 0) {
                return result;
            }

            // Sort by start time
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int i = 0;
            while (i < arr.length) {
                int start = arr[i][0];
                int end = arr[i][1];

                // Merge overlapping intervals
                while (i + 1 < arr.length && arr[i + 1][0] <= end) {
                    i++;
                    end = Math.max(end, arr[i][1]);
                }

                result.add(new int[]{start, end});
                i++; // Move to the next interval
            }

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
