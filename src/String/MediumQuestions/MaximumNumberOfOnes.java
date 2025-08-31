package String.MediumQuestions;

public class MaximumNumberOfOnes {
    public static class Solution {
        public int maxOnes(int arr[], int k) {
            //Edge case
            if(arr == null || arr.length == 0) {
                return 0 ;
            }

            //Step 1: Initialize variables
            int leftPointer = 0 , rightPointer = 0 ;
            int maxLength = 0 ;
            int zerosCount = 0 ;

            //Step 2: Iterate over the array (Using sliding pointer approach)
            while (rightPointer < arr.length ) {
                //Step 2.1: If the current element is 0, increment the zeroCount
                if(arr[rightPointer] == 0) {
                    zerosCount ++ ;
                }

                //Step 2.2: If the zeroCount is greater than k, shrink the window from the left
                while (zerosCount > k ) {
                    if(arr[leftPointer] == 0) {
                        zerosCount -- ;
                    }
                    leftPointer ++ ;
                }

                //Step 2.3: Update the maxLength
                maxLength = Math.max(maxLength , (rightPointer - leftPointer + 1)) ;

                rightPointer ++ ;
            }

            //Step 3: Return the maxLength
            return maxLength ;
        }
    }
    public static void main(String[] args) {

    }
}
