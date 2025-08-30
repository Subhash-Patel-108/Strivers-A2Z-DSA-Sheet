package BinarySearch.BinarySearchOnAnswer;

public class FindKthMissingPositive {
    public static class Solution {
        public static int findKthPositive(int[] arr, int k) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int missing = arr[mid] - (mid + 1);
                if (missing < k)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return left + k;
        }
    }
    public static void main(String[] args) {

    }
}
