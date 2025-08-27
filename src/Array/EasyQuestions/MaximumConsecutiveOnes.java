package Array.EasyQuestions;

public class MaximumConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maximumNumberOfOnes = 0;

            int count = 0 ;
            for(int i = 0 ; i < nums.length ; i++ ) {
                if(nums[i] == 1) {
                    count ++ ;
                }else{
                    maximumNumberOfOnes = Math.max(maximumNumberOfOnes , count) ;
                    count = 0 ;
                }
            }
            return Math.max(maximumNumberOfOnes , count) ; 
        }
    }
    public static void main(String[] args) {

    }
}
