package Array.HardQuestions;
import java.util.* ;

public class FourSumProblem {
    public static class Solution {
        private List<List<Integer>> result;

        // Function for two sums using long to avoid overflow
        private void twoSum(int[] nums, long target, int i, int j, int start, int end) {
            while (start < end) {
                long totalSum = (long) nums[i] + nums[j] + nums[start] + nums[end]; // use long to prevent integer overflow

                if (totalSum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                    // skip duplicates
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                } else if (totalSum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        public List<List<Integer>> fourSum(int[] nums, int target) {
            result = new ArrayList<>();
            if (nums == null || nums.length < 4) return result;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;//skip the values
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;//skip the values
                    twoSum(nums, (long) target, i, j, j + 1, nums.length - 1);
                }
            }

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
