package BinarySearch.BinarySearchOnOneDArray;

public class ImplementLowerBound {
    public static class Solution {
        int lowerBound(int[] arr, int target) {
            int start = 0, end = arr.length - 1;
            int ans = -1;

            // Binary search to find the first occurrence or insertion point
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    ans = mid;         // Store index and continue searching next
                    end = mid - 1;
                } else if (arr[mid] > target) {
                    end = mid - 1;     // Move next
                } else {
                    start = mid + 1;   // Move right
                }
            }

            // Return first occurrence or insertion index
            return ans == -1 ? start : ans;
        }
    }

    public static void main(String[] args) {

    }
}
