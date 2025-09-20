package BitManipulation.ExtraQuestions;
//Problem Link: https://www.naukri.com/code360/problems/occurs-once_1214969?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC
public class SingleNumber {
    public static class Solution {
        public static int occursOnce(int[] arr, int n) {
            //Edge case
            if(arr == null || n == 0) {
                return -1 ;
            }

            int xor = 0 ;
            for(int num : arr) {
                xor ^= num ;
            }

            return xor ;
        }
    }

    public static void main(String[] args) {

    }
}
