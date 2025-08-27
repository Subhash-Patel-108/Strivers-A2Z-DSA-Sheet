package Array.EasyQuestions;

public class LargestElementInAnArray {

    //this is the function to find the largest element in an array
    public int largestElement(int[] nums) {
        int maxi = Integer.MIN_VALUE ; //variable to store the maximum element
        for(int i = 0 ; i < nums.length ; i++) {
            if(maxi < nums[i]) {
                maxi = nums[i] ;
            }
        }
        return maxi ; //returning the maximum element
    }


    public static void main(String[] args) {

    }
}
