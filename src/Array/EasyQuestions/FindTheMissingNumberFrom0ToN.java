package Array.EasyQuestions;
import java.util.* ;
public class FindTheMissingNumberFrom0ToN {
    public static class Solution {
        public int missingNumber(int[] nums) {
            int arraySize = nums.length ;
            //use long to store the expected sum to avoid overflow
            long expectedSum = arraySize * (arraySize + 1) / 2 ;
            long actualSum = 0 ;
            for(int num : nums) {
                actualSum += num ;
            }
            return (int)(expectedSum - actualSum) ;
        }
    }
    public static void main(String[] args) {

    }
}
