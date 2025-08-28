package Array.MediumQuestions;

public class NextPermutation {
    public static class Solution {
        //function to swap two values of the array
        private static void swap(int[] arr , int start , int end) {
            int temp = arr[start] ;
            arr[start] = arr[end] ;
            arr[end] = temp ;
            return ;
        }

        //function to swap element of the array from start to end
        private static void swapTheArray(int[] arr , int start , int end ) {
            while (start < end) {
                swap(arr , start , end);
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
            int maxiAtRight = -1 ;
            for(int i = arr.length - 1 ; i > pivotIndex ; i-- ) {
                if(arr[i] > arr[pivotIndex]) {
                    maxiAtRight = i ;
                    break ;
                }
            }

            //now swap the maximum value with the pivot index
            swap(arr , pivotIndex , maxiAtRight) ;

            swapTheArray(arr , pivotIndex + 1 , arr.length - 1 ); // swapping the element after the pivot index
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
