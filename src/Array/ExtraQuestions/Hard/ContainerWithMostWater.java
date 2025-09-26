package Array.ExtraQuestions.Hard;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/container-with-most-water_873860?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class ContainerWithMostWater {

    public static class Solution {
        public static int maxArea(int[] height) {
            //Edge case
            if(height == null || height.length == 0 ) {
                return 0 ;
            }

            int left = 0 , right = height.length - 1 ;
            int maxWater = 0 ;
            while (left < right) {
                int minHeight = Math.min(height[left] , height[right]) ;
                int width = right - left ;

                int currWater = minHeight * width ;

                maxWater = Math.max(currWater , maxWater) ;

                if(height[left] < height[right]) {
                    left++ ;
                }else{
                    right -- ;
                }
            }

            return maxWater ;
        }
    }
    public static void main(String[] args) {

    }
}
