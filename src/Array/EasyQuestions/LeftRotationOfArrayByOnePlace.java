package Array.EasyQuestions;

public class LeftRotationOfArrayByOnePlace {
    class Solution {
        //function to rotate the array by one place to the left
        public void rotate(int[] arr) {
            //edge case
            if(arr.length == 0) {
                return ;
            }
            //first take the copy of last element and after rotation put it at the last
            int lastElement = arr[arr.length - 1] ;
            for(int i = arr.length - 1 ; i > 0 ; i--) {
                arr[i] = arr[i - 1] ; // copy the previous element to the current element
            }

             arr[0] = lastElement ;//put the last element at the last
            return ;
        }
    }

    public static void main(String[] args) {

    }
}
