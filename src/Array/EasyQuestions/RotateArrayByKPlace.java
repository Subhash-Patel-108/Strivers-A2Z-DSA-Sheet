package Array.EasyQuestions;

public class RotateArrayByKPlace {
    public static class  Solution {
        public void leftRotate(int arr[], int d) {
            //first, we copy all the first d element into the new array
            int[] firstDElements = new int[d] ;
            for(int i = 0 ; i < d ; i++ ){
                firstDElements[i] = arr[i] ;
            }

            //shift the remaining element to the next
            for(int i = 0 ; i < arr.length - d ; i++) {
                arr[i] = arr[i + d] ;
            }

            //now copy the first d element into the array at the last
            for(int i = 0 ; i < d ; i++) {
                arr[arr.length - d + i] = firstDElements[i] ;
            }
            return ;
        }
    }

    public static void main(String[] args) {

    }
}
