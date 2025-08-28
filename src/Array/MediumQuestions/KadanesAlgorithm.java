package Array.MediumQuestions;

public class KadanesAlgorithm {
    public static class Solution {
        //Function to find the maximum subarray sum
        //or to implement the Kadane's algorithm
        public static int maxSubarraySum(int[] arr) {
            int sum = 0 ;//for storing the sum of the subarray
            int maxiSum = Integer.MIN_VALUE ;//to store the maximum sum of the subarray
            for(int i = 0 ; i < arr.length ; i++) {
                //if the sum is negative, we will make it zero
                if(sum < 0) {
                    sum = 0 ;
                }
                sum += arr[i] ;
                //update the maximum sum
                maxiSum = Math.max(sum , maxiSum) ;
            }
            return maxiSum ;//return the maximum sum
        }
    }

    public static void main(String[] args) {

    }
}
