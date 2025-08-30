package BinarySearch.BinarySearchOnAnswer;

public class KokoEatingBananas {
    public static class Solution {
        private static boolean isKokoEatAllBananas(int[] piles , int hours, int rate) {
            int totalHours = 0 ;
            for(int banana : piles) {
                totalHours += banana / rate ;

                //if the pile containts more bananas than rate
                if(banana % rate >= 1 ) {
                    totalHours ++ ;
                }
            }
            return totalHours <= hours ;
        }
        //main function where the first call received
        public static int minimumRateToEatBananas(int []v, int h) {
            //we find the maximum element from the array which is out end and start is total sum divides by h
            long totalSum = 0 ;
            int end = 0 ;
            for(int num : v) {
                totalSum += num ;
                end = Math.max(end , num) ;
            }

            int start = (int) (totalSum / h) ;

            //if the start is 0 increase it by 1
            if(start == 0) start ++ ;

            int ans = -1 , mid ;

            while (start <= end ) {
                mid = start + (end - start) / 2 ;

                if(isKokoEatAllBananas(v , h , mid)) {
                    ans = mid ;
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
            return ans ;
        }
    }

    public static void main(String[] args) {

    }
}
