package GreedyAlgorithm.MediumAndHardProblems;
import java.util.* ;
public class NonOverlappingIntervals {
    public static class Solution {
        public static int minimumReschedules(int n, int[][] intervals) {
            //Edge case
            if(intervals == null || n == 0) {
                return 0 ;
            }

            Arrays.sort(intervals , (a , b ) -> Integer.compare(a[0] , b[0]));
            int count = 0 ;
            int lastEndingTime = intervals[0][1] ;
            for(int i = 1 ; i < n ; i++ ) {
                if(intervals[i][0] < lastEndingTime) {
                    count ++ ;
                    lastEndingTime = Math.min(lastEndingTime , intervals[i][1]) ;
                }else{
                    lastEndingTime = intervals[i][1] ;
                }
            }
            return count ;
        }
    }
    public static void main(String[] args) {

    }
}
