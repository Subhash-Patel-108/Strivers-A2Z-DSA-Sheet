package Array.MediumQuestions;
import java.util.* ;
public class SpiralMatrix {
    public static class Solution {
        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> spiral = new ArrayList<Integer>() ;
            int top = 0 , right = matrix[0].length - 1 , bottom = matrix.length - 1 , left = 0 ;
            while (top <= bottom || left <= right) {
                //for top element
                for(int i = left ; i <= right ; i++) {
                    spiral.add(matrix[top][i]) ;
                }
                top ++ ;
                //for right
                for(int i = top ; i <= bottom ; i++ ) {
                    spiral.add(matrix[i][right]) ;
                }
                right -- ;

                //for bottom
                if(top <= bottom) {
                    for(int i = right ; i >= left ; i-- ) {
                        spiral.add(matrix[bottom][i]) ;
                    }
                    bottom-- ;
                }

                //for left side
                if(left <= right) {
                    for(int i = bottom ; i >= top ; i-- ) {
                        spiral.add(matrix[i][left]) ;
                    }
                    left ++ ;
                }
            }
            return spiral ;
        }
    }
}
