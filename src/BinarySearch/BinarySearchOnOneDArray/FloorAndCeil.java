package BinarySearch.BinarySearchOnOneDArray;

public class FloorAndCeil {
    public static class Solution {
        public static int[] getFloorAndCeil(int[] a, int n, int x) {
            int start = 0, end = n - 1;
            int mid;
            while (start <= end) {
                mid = start + (end - start) / 2;

                if (a[mid] == x) {
                    return new int[]{x, x};
                } else if (a[mid] > x) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return new int[]{end == -1 ? -1 : a[end], start == n ? -1 : a[start]};
        }
    }
    public static void main(String[] args) {

    }
}
