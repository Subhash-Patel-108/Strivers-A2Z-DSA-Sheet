package Array.MediumQuestions;
import java.util.* ;
public class LongestConsecutiveSubsequence {
    public static class Solution {
        // Function to return length of longest subsequence of consecutive integers.
        public int longestConsecutive(int[] arr) {
            //edge case
            if(arr.length == 0) {
                return 0 ;
            }
            //set to remove the duplicate element
            Set <Integer> numberSet = new TreeSet<Integer>() ;
            for(int num : arr) {
                numberSet.add(num) ;
            }

            //number to track the present number
            int number = numberSet.stream().findFirst().orElse(null) ; // to take the first element
            int count = 0 ;//to count the consecutive subArray size
            int maxiCount = 0 ;//to store the maximum size

            for(int num : numberSet) {
                //the number is present in the subArray
                if(number == num) {
                    count ++ ;//increase the count
                }else {
                    maxiCount = Math.max(count , maxiCount) ;
                    count = 1 ;
                    number = num ;
                }
                number ++ ;
            }
            return Math.max(count , maxiCount) ;
        }
    }
    public static void main(String[] args) {

    }
}
