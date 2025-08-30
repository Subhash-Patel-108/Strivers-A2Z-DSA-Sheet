package BinarySearch.BinarySearchOnOneDArray;

public class SearchInRotatedSortedArrayWithDuplicates {
    public static class Solution {
        //function to apply binary search on rotated and sorted array with duplicates
        private static boolean applyBinarySearchWithDuplicates(int[] arr , int key) {
            int start = 0 , end = arr.length - 1 , mid ;

            while (start <= end) {
                mid = start + (end - start) / 2 ; //finding the middle value

                if(arr[mid] == key) {
                    return true ;
                }

                //the only condition come when the array contains duplicates
                if(arr[start] == arr[mid] && arr[mid] == arr[end] ) {//reduce the search space
                    start ++ ;
                    end -- ;
                    continue ;
                }

                //check if the left half is sorted
                if(arr[start] <= arr[mid]) {
                    //check for the key in the left half
                    if(arr[start] <= key && arr[mid] >= key) {
                        end = mid - 1 ;
                    }else{//go to the right half
                        start = mid + 1 ;
                    }
                }else{//right half is sorted
                    if(arr[mid] <= key && arr[end] >= key) {//checking for the key in the right half
                        start = mid + 1 ;
                    }else{//go to the left half
                        end = mid - 1 ;
                    }
                }
            }

            return false ; //the key is not present in the array
        }
        public boolean search(int[] arr, int key) {
            return applyBinarySearchWithDuplicates(arr , key) ;//the function calling that find the answer
        }
    }

    public static void main(String[] args) {

    }
}
