package BinarySearch.BinarySearchOnOneDArray;

public class SearchInsertPosition {
    public static class Solution {
        public int searchInsert(int[] arr, int target) {
            int start = 0 , end = arr.length - 1 ; // store the two pointers
            int ans = -1 ; //to store the index of the target

            while (start <= end) {
                int mid = start + (end - start) / 2 ;//find mid index

                if(arr[mid] == target) {
                    ans = mid ;//storing the potential ans and move to the right
                    start = mid + 1 ;
                }else if (arr[mid] > target){
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
            return ans != -1 ? ans : start ;//return the index of the target
        }
    }

    public static void main(String[] args) {

    }
}
