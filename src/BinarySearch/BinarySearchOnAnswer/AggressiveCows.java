package BinarySearch.BinarySearchOnAnswer;
import java.util.* ;
public class AggressiveCows {
    public static class Solution {
        private static boolean isPossible(int[] stalls , int cows , int maxiDistance) {
            int cowsPlaced = 1 , lastPosition = stalls[0] ;

            for(int stall : stalls) {
                if(stall - lastPosition >= maxiDistance) {
                    cowsPlaced++ ;
                    lastPosition = stall ;
                }

                if(cowsPlaced >= cows) {
                    return true ;
                }
            }
            return false ;
        }
        public static int aggressiveCows(int []stalls, int k) {
            //first, we sort the Array
            Arrays.sort(stalls) ;

            int start = 1 , end = stalls[stalls.length - 1] - stalls[0] ;
            int maximumDistance = -1 , mid ;

            while (start <= end) {
                mid = start + (end - start) / 2 ;

                if (isPossible(stalls , k , mid)) {
                    maximumDistance = mid ;
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }
            return maximumDistance ;
        }
    }
    public static void main(String[] args) {

    }
}
