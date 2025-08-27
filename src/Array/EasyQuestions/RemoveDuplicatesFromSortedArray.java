package Array.EasyQuestions;
import java.util.ArrayList ;
public class RemoveDuplicatesFromSortedArray {
    class Solution {
        // Function to remove duplicates from the given array.
        ArrayList<Integer> removeDuplicates(int[] arr) {
            ArrayList<Integer> nonDuplicateElements = new ArrayList<Integer>() ;

            int previousElement = arr[0] ;//to track the previous element
            nonDuplicateElements.add(previousElement) ; // adding the first element to the list
            for(int i = 1 ; i < arr.length ; i++) {
                if(previousElement != arr[i]) {
                    nonDuplicateElements.add(arr[i]) ;
                }
                previousElement = arr[i] ;
            }
            return nonDuplicateElements ;
        }
    }

    public static void main(String[] args) {

    }
}
