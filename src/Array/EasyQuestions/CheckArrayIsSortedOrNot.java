package Array.EasyQuestions;

public class CheckArrayIsSortedOrNot{

    class Solution {
        //function to check that the array is sorted or not
        public boolean isSorted(int[] arr) {
            for(int i = 0 ; i < arr.length - 1 ; i++ ){
                //if the condition is true then the array is not sorted
                if(arr[i] > arr[i + 1]) {
                    return false ;
                }
            }
            return true ;
        }
    }
    public static void main(String[] args) {

    }
}
