package Array.MediumQuestions;
import java.util.* ;
public class RotateBy90Degree {
    public static class Solution {
        private static void swap(int[][] mat , int row , int col) {
            int temp = mat[row][col] ;
            mat[row][col] = mat[col][row] ;
            mat[col][row] = temp ;
            return ;
        }
        public void rotateMatrix(int[][] mat) {
            //first, finding the inverse of the matrix
            for(int i = 0 ; i < mat.length ; i++) {
                for(int j = 0 ; j < i ; j ++) {
                    swap(mat , i , j) ;
                }
            }

            //Now, reverse the row
            for(int i = 0 ; i < mat.length ; i++ ) {
                int start = 0 , end = mat[i].length - 1 ;
                while (start < end ) {
                    //swapping the values
                    int temp = mat[i][start] ;
                    mat[i][start] = mat[i][end] ;
                    mat[i][end] = temp ;
                    start++;
                    end--;
                }
            }
            return ;
        }
    }
}
