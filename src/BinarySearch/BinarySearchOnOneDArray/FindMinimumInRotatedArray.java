package BinarySearch.BinarySearchOnOneDArray;

public class FindMinimumInRotatedArray {
    public static class Solution {
        //The function to find the pivot index in the rotated array
        private static int findPivotIndex(int[] arr) {
            int start = 0 , end = arr.length - 1 , mid ;
            while (start <= end) {
                mid = start + (end - start) / 2 ;

                //this is the condition for the pivot index
                if(mid < end && arr[mid] > arr[mid + 1]) {
                    return mid ;
                }else if (mid > 0 && arr[mid - 1 ] > arr[mid]) {
                    return mid - 1 ;
                }

                //condition to move start and end pointers
                if(arr[start] <= arr[mid]) {
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }
            return -1 ;
        }
        public int findMin(int[] arr) {
            //Edge case
            if(arr == null || arr.length == 0 ) {
                return -1 ;
            }

            //finding the pivot index
            int pivotIndex = findPivotIndex(arr) ;

            //if the pivot is -1, it means the array is not rotated(or Sorted)
            if(pivotIndex == -1) {
                return arr[0] ;
            }else{
                //return the element next to the pivot index
                return arr[pivotIndex + 1] ;
            }
        }
    }

    public static void main(String[] args) {

    }
}
