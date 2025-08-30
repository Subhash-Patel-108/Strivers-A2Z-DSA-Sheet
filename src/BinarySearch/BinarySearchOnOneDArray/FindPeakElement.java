package BinarySearch.BinarySearchOnOneDArray;

public class FindPeakElement {
    public static class Solution {
        private int findPeak(int[] nums) {
            int start = 1 , end = nums.length - 2 , mid ;
            while (start <= end){
                mid = start + (end - start) / 2 ;

                if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid ;
                }

                if(nums[mid] < nums[mid + 1]) {
                    start = mid + 1 ;
                }else{
                    end = mid - 1;
                }
            }
            return -1 ;
        }
        public int findPeakElement(int[] nums) {
            //base case
            if(nums.length == 0 ) {
                return -1 ;
            }else if(nums.length == 1 || nums[0] > nums[1]) {
                return 0 ;
            }else if (nums[nums.length - 1] > nums[nums.length - 2] ){
                return nums.length - 1 ;
            }

            return findPeak(nums) ;
        }
    }
    public static void main(String[] args) {

    }
}
