package Array.MediumQuestions;

public class SortZerosOnesAndTwos {
    public static class Solution {
        //function to swap two values from the array
        private static void swap(int[] arr , int first , int second) {
            int temp = arr[first] ;
            arr[first] = arr[second] ;
            arr[second] = temp ;
            return ;
        }
        //I am using the most optimised approach
        //DNF(Dutch National Flag)
        public void sort012(int[] arr) {
            int start = 0 , mid = 0 , end = arr.length - 1 ;
            while (mid <= end) {
                if(arr[mid] == 0) {
                    //swap start and mid and increment both
                    swap(arr , start , mid ) ;
                    start++ ;
                    mid ++ ;
                }else if (arr[mid] == 1) {
                    //just increment mid
                    mid ++ ;
                }else {
                    //swap mid and end and decrement end
                    swap(arr , mid , end) ;
                    end -- ;
                }
            }
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
