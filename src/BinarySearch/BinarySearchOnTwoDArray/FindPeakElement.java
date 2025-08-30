package BinarySearch.BinarySearchOnTwoDArray;
import java.util.* ;
public class FindPeakElement {
    public static class Solution {
        private static int columnIndex ;
        private static boolean isGreaterThanLeftAndRight(int[] row , int colIndex) {
            int left = colIndex == 0 ? -1 : row[colIndex - 1] ;
            int right = colIndex == row.length - 1 ? -1 : row[colIndex + 1] ;
            return row[colIndex] > left && row[colIndex] > right ;
        }

        private static boolean isGreaterThanTopAndBottom(int[][] mat , int colIndex , int rowIndex) {
            int top = rowIndex == 0 ? -1 : mat[rowIndex - 1][colIndex] ;
            int bottom = rowIndex == mat.length - 1 ? -1 : mat[rowIndex + 1][colIndex] ;

            return mat[rowIndex][colIndex] > top && mat[rowIndex][colIndex] > bottom ;
        }
        private static boolean isThereIsPeak(int[] row , int[][] mat , int rowIndex) {
            if(row.length == 1) {
                if(isGreaterThanTopAndBottom(mat , 0 , rowIndex)) {
                    columnIndex = 0 ;
                    return true ;
                }
                return false ;
            }else if (isGreaterThanLeftAndRight(row , 0) && isGreaterThanTopAndBottom(mat , 0 , rowIndex)) {
                columnIndex = 0 ;
                return true ;
            }else if (isGreaterThanLeftAndRight(row , row.length - 1) && isGreaterThanTopAndBottom(mat , row.length - 1 , rowIndex)) {
                columnIndex = row.length - 1 ;
                return true ;
            }

            int start = 1 , end = row.length - 2 ;
            while (start <= end ) {
                int colIndex = start + (end - start) / 2 ;

                if(isGreaterThanLeftAndRight(row , colIndex) && isGreaterThanTopAndBottom(mat , colIndex, rowIndex)) {
                    columnIndex = colIndex;
                    return true ;
                }
                if(row[colIndex] < row[colIndex + 1]) {
                    start = colIndex + 1 ;
                }else{
                    end = colIndex - 1;
                }
            }
            return false ;
        }
        //The function were the first call is received
        public int[] findPeakGrid(int[][] mat) {
            //Edge case
            if(mat == null || mat.length == 0) {
                return new int[] {-1 , -1} ;
            }
            columnIndex = -1 ;
            for(int i = 0 ; i < mat.length ; i++) {
                if(isThereIsPeak(mat[i] , mat , i)) {
                    return new int[] {i , columnIndex} ;
                }
            }
            return new int[] {-1 , -1} ;
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{10,50,40,30,20},{1,500,2,3,18},{2,4,5,6,17},{3,5,6,7,16},{4,6,7,14,15}};
        System.out.println(Arrays.toString(new Solution().findPeakGrid(mat)));
    }
}
