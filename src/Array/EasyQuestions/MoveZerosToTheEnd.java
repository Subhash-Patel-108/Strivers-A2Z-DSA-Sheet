package Array.EasyQuestions;

public class MoveZerosToTheEnd {
    public static class  Solution {
        public void pushZerosToEnd(int[] arr) {
            int nonZeroElementPosition = 0 ;
            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i] != 0) {
                    arr[nonZeroElementPosition] = arr[i] ;
                    nonZeroElementPosition++ ;
                }
            }

            //now put the zero at the end
            while(nonZeroElementPosition < arr.length) {
                arr[nonZeroElementPosition++] = 0 ;
            }
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
