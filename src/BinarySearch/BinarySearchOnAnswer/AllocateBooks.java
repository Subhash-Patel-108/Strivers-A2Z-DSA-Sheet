package BinarySearch.BinarySearchOnAnswer;
import java.util.* ;
public class AllocateBooks {
    public class Solution {
        private static boolean isPossible(ArrayList<Integer> books , int students , int minPage) {
            int studentCount = 0 ;
            int totalPages = 0 ;

            for(int pages : books) {
                totalPages += pages ;
                if(totalPages > minPage) {
                    studentCount++ ;
                    totalPages = pages ;
                }
            }
            return studentCount < students ;
        }
        public static int findPages(ArrayList<Integer> arr, int n, int m) {
            //Edge case
            if(arr == null || arr.size() == 0 || m > arr.size()) {
                return -1 ;
            }

            int start = Integer.MIN_VALUE , end = 0 ;
            for(int pages : arr) {
                start = Math.max(start , pages) ;
                end += pages ;
            }

            int minimumPages = -1 , mid ;
            while (start <= end ) {
                mid = start + (end - start) / 2 ;

                if(isPossible(arr , m , mid)) {
                    minimumPages = mid ;
                    end = mid - 1 ;
                }else{
                    start = mid + 1;
                }

            }
            return minimumPages ;
        }
    }
    public static void main(String[] args) {

    }
}
