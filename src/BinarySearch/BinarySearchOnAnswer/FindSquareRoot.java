package BinarySearch.BinarySearchOnAnswer;

public class FindSquareRoot {
    public static class Solution {
        //function to find the floor square root of a number
        int floorSqrt(int n) {
            //base case
            if(n == 1) return 1 ;

            int start = 1 , end = n , mid ;
            int ans = -1;

            while (start <= end) {
                mid = start + (end - start) / 2 ;

                if((mid * mid) == n ) {
                    return mid ;
                }

                if((mid * mid) < n) {
                    //storing the potential answer
                    ans = Math.max(ans , mid ) ;
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }
            return ans ;
        }
    }
    public static void main(String[] args) {

    }
}
