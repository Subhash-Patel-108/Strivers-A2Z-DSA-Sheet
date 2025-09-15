package BinarySearch.BinarySearchOnOneDArray;

public class SearchInRotatedSortedArray {
    public static class Solution {
        //function to find the pivot index
        private static int findPivotIndex(int[] arr) {
            int start = 0 , end = arr.length - 1 ;
            while (start <= end ) {
                int mid = start + (end - start) / 2 ;
                if(mid < end && arr[mid] > arr[mid + 1]) {
                    return mid ;
                }else if (mid > 0 && arr[mid - 1 ] > arr[mid]) {
                    return mid - 1 ;
                }
                if (arr[start] <= arr[mid] ) {
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }
            return -1 ;
        }

        //function to perform binary search
        public static int binarySearch(int[] arr , int target , int start , int end) {
            while (start <= end) {
                int mid = start + (end - start) / 2 ;
                if(arr[mid] == target) {
                    return mid ;
                }else if (arr[mid] > target) {
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
            return -1 ;
        };

        public static int search(int[] arr, int key) {
            //edge case
            if(arr == null || arr.length == 0 ) {
                return -1 ;
            }
            int pivotIndex = findPivotIndex(arr) ;

            //if the value of pivot is -1 it means the array is not rotated
            if(pivotIndex == -1) {
                return binarySearch(arr , key , 0 , arr.length - 1 ) ;
            }

            //apply binary search on the next and right side of the pivot index
            int leftBinarySearch = binarySearch(arr , key , 0 , pivotIndex ) ;
            if(leftBinarySearch != -1) {
                return leftBinarySearch ;
            }
            return binarySearch(arr , key , pivotIndex + 1 , arr.length - 1 ) ; // for right side
        }
    }
    public static void main(String[] args) {

    }
}
