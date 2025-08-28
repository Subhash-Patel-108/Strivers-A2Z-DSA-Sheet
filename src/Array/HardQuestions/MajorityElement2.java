package Array.HardQuestions;
import java.util.* ;
public class MajorityElement2 {
    public static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            // Phase 1: Find potential candidates using voting
            Integer candidate1 = null, candidate2 = null;
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (candidate1 != null && candidate1 == num) {
                    count1++;
                } else if (candidate2 != null && candidate2 == num) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    // Both candidates are different from current number
                    count1--;
                    count2--;
                }
            }

            // Phase 2: Verify candidates by counting their actual frequency
            count1 = 0;
            count2 = 0;

            for (int num : nums) {
                if (candidate1 == num) count1++;
                else if (candidate2 != null && candidate2 == num) count2++;
            }

            int threshold = nums.length / 3;
            if (count1 > threshold) result.add(candidate1);
            if (count2 > threshold) result.add(candidate2);

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
