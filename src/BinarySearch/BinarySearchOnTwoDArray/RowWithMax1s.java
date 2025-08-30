package BinarySearch.BinarySearchOnTwoDArray;

public class RowWithMax1s {
    public static class Solution {
        //function to find the first position of 1 in a row
        private static int findFirstPositionOfOne(int arr[]) {
            int start = 0 , end = arr.length - 1 , mid ;
            int ans = -1 ;
            while (start <= end ) {
                mid = start + (end - start) / 2 ;
                if(arr[mid] == 1) {
                    ans = mid ;
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
            return ans ;
        }
        public int rowWithMax1s(int arr[][]) {
            int maxRowIdx = -1 , maximumOnesCount = -1 ;
            for(int i = 0 ; i < arr.length ; i++ ) {
                int firstPositionOfOne = findFirstPositionOfOne(arr[i]) ;
                if(firstPositionOfOne != -1 && (arr[i].length - firstPositionOfOne) > maximumOnesCount) {
                    maxRowIdx = i;
                    maximumOnesCount = Math.max(maximumOnesCount , arr[i].length - firstPositionOfOne);
                }
            }
            return maxRowIdx ;
        }
    }

    public static void main(String[] args) {

    }
}
