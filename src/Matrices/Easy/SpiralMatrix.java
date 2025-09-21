package Matrices.Easy;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/spiral-matrix_840698?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class SpiralMatrix {
    public static class Solution {
        public static List<Integer> spiralPathMatrix(int[][] matrix, int n, int m) {
            //Edge case
            if(matrix == null || matrix.length == 0){
                return new ArrayList<>() ;
            }

            List <Integer> spiralTraversal = new ArrayList<>() ;
            int top = 0 , right = matrix[0].length - 1 , bottom = matrix.length - 1 , left = 0 ;

            while ((top <= bottom) && (left <= right)) {
                //Top traversal
                for(int col = left ; col <= right ; col++ ) {
                    spiralTraversal.add(matrix[top][col]) ;
                }
                top ++ ;

                //Right traversal
                for(int row = top ; row <= bottom ; row++ ) {
                    spiralTraversal.add(matrix[row][right]) ;
                }
                right -- ;

                //bottom traversal
                if(top <= bottom) {
                    for(int col = right ; col >= left ; col-- ) {
                        spiralTraversal.add(matrix[bottom][col]) ;
                    }
                    bottom-- ;
                }

                //left traversal
                if(left <= right ) {
                    for(int row = bottom ; row >= top ; row --) {
                        spiralTraversal.add(matrix[row][left]) ;
                    }
                    left++ ;
                }
            }

            return spiralTraversal ;
        }
    }
    public static void main(String[] args) {

    }
}
