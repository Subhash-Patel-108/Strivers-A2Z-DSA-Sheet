package BinarySearch.BinarySearchOnOneDArray;

public class FindNumberOfRotation {
    public static class Solution {
        //function to find the pivot index
        private static int findPivotIndex(int arr[]) {
            int start = 0 , end = arr.length - 1 , mid ;

            while (start <= end) {
                mid = start + (end - start) / 2 ;

                //this is the condition for the pivot index
                if(mid < end && arr[mid] > arr[mid + 1]) {
                    return mid ;
                }else if (mid > 0 && arr[mid - 1 ] > arr[mid]) {
                    return mid - 1 ;
                }

                //condition to move the start and end pointer
                if(arr[start] <= arr[mid]) { // this part is sorted move to the right side
                    start = mid + 1 ;
                }else{//move to the next side
                    end = mid - 1 ;
                }
            }
            return -1 ;
        }
        public int findKRotation(int arr[]) {
            //Edge case
            if(arr == null || arr.length == 0){
                return -1 ;
            }

            //first, we find the pivot index
            int pivotIndex = findPivotIndex(arr) ;

            return pivotIndex + 1 ;
        }
    }

    public static void main(String[] args) {

    }
}
