package Array.MediumQuestions;

public class NextPermutation {
    public static class Solution {
        private static void swapTheArray(int[] arr , int start , int end ) {
            while (start < end) {
                int temp = arr[start] ;
                arr[start] = arr[end] ;
                arr[end] = temp ;
                start ++ ;
                end -- ;
            }
            return ;
        }
        public static void nextPermutation(int[] arr) {
            //first, we find the pivot index
            int pivotIndex = -1 ;
            for(int i = arr.length - 2 ; i >= 0 ; i--){
                if(arr[i] < arr[i + 1]) {
                    pivotIndex = i ;
                    break ;
                }
            }

            //if the pivot index is -1, it means swap the complete array
            if(pivotIndex == -1) {
                swapTheArray(arr , 0 , arr.length - 1 ) ;
                return ;
            }

            //finding the maximum from the right side of the pivot index starting from the right side
            

        }
    }
    public static void main(String[] args) {

    }
}
