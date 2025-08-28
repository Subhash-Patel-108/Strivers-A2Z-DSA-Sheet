package Array.HardQuestions;
import java.util.* ;
public class ThreeSumProblem {
    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>() ;
            //edge case
            if(nums == null || nums.length == 0) {
                return result ;
            }

            //sort the array
            Arrays.sort(nums) ;

            //I am using the two pointers approach (fixed + 2sum)
            for(int i = 0 ; i < nums.length - 2 ; i++ ) {
                int start = i + 1 , end = nums.length - 1 ;
                while (start < end) {
                    int totalSum = nums[i] + nums[start] + nums[end] ;//the sum of all three pointers
                    //if the sum is equal to zero
                    if (totalSum == 0) {
                        result.add(Arrays.asList(nums[i] , nums[start] , nums[end])) ;
                        //now we skip the duplicate values from the array
                        while(start < end && nums[start] ==  nums[start + 1]) start ++ ;
                        while(start < end && nums[end] == nums[end - 1]) end -- ;

                        //if there is no duplicate
                        start ++ ;
                        end -- ;
                    }else if (totalSum > 0) { // go to the left side
                        end -- ;
                    }else{// go to the right side
                        start ++ ;
                    }
                }
                //skip the duplicate values
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i ++ ;
            }
            return result ;
        }
    }
    public static void main(String[] args) {

    }
}
