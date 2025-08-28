package Array.MediumQuestions;
import java.util.* ;
public class SetMatrixZero {
    public static class Solution {

        //function to set zero on the row and column
        private static void setMatrixZero(int[][] matrix , int row , int column) {
            //loop to set zeros for the row
            for(int col = 0; col < matrix[0].length ; col++) {
                matrix[row][col] = 0 ;
            }

            //for column
            for(int r = 0 ; r < matrix.length ; r++ ) {
                matrix[r][column] = 0 ;
            }
            return ;
        }
        private static class Pair {
            public int rowIndex ;
            public int columnIndex ;

            //constructor
            public Pair(int rowIndex , int columnIndex) {
                this.rowIndex = rowIndex ;
                this.columnIndex = columnIndex ;
            }
        }
        public static void setZeroes(int[][] matrix) {
            ArrayList<Pair> zerosIndex = new ArrayList<Pair>() ;
            for(int i = 0 ; i < matrix.length ; i++ ) {
                for(int j = 0 ; j < matrix[0].length ; j++ ) {
                    if(matrix[i][j] == 0){
                        zerosIndex.add(new Pair(i , j));
                    }
                }
            }
            for(int i = 0 ; i < zerosIndex.size() ; i++ ) {
                Pair temp = zerosIndex.get(i) ;
                setMatrixZero(matrix , temp.rowIndex , temp.columnIndex) ;
            }
            return ;
        }
    }
}
