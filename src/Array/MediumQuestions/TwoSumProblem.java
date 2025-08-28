package Array.MediumQuestions;
import java.util.* ;
public class TwoSumProblem {
    class Solution {

        //function to find the index of two elements in the array
        public int[] twoSum(int[] nums, int target) {
            HashMap <Integer , Integer> map = new HashMap<>() ;//hash map to store the element and its index

            int[] ans = new int[2] ;//ans array that will store the index of the two elements

            for(int i = 0 ; i < nums.length ; i++){
                int rem  = target - nums[i] ;

                if(map.containsKey(rem)) {
                    ans[0] = map.get(rem) ;
                    ans[1] = i ;
                    return ans;
                }

                map.put(nums[i] , i) ;
            }
            return ans ;
        }
    }
}
