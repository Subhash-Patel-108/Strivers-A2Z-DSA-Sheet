package Recursion.CombinationsOrHard;
import java.util.* ;
public class NQueen {
    public static class Solution {
        public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;

            //Edge case: all are invalid cases
            if(n <= 0 || n == 2 || n == 3) {
                return result ;
            }

            //Step 1: Initialization
            ArrayList<Integer> current = new ArrayList<>() ;
            boolean[] isQueenPresent = new boolean[n] ;

            //Step 2: Initialize the current array
            for(int i = 0 ; i < n*n ; i++) {
                current.add(0) ;
            }

            //Step 3: Function call
            placeQueens(n , 0 , current , isQueenPresent, result) ;

            //Step 4: Return the result
            return result ;
        }

        private static void placeQueens(int num , int row , ArrayList<Integer> current , boolean[] isQueenPresent , ArrayList<ArrayList<Integer>> result ) {
            //base case
            if(row == num) {
                result.add(new ArrayList<>(current));
                return ;
            }

            for(int col = 0 ; col < num ; col ++) {
                int oneDIndex = row * num + col ;

                if(!isQueenPresent[col] && isSafeToPlaceQueen(num , row , col , current)) {
                    isQueenPresent[col] = true ;
                    current.set(oneDIndex , 1) ;
                    placeQueens(num , row + 1 , current , isQueenPresent , result) ;

                    current.set(oneDIndex , 0) ;
                    isQueenPresent[col] = false ;
                }
            }

            return ;
        }

        private static boolean isSafeToPlaceQueen(int num , int rowIdx , int colIdx , ArrayList<Integer> current) {
            //First, we check for the main diagonal
            int row = rowIdx , col = colIdx ;

            while (row >= 0 && col >= 0) {
                int oneDIndex = row * num + col ;
                if(current.get(oneDIndex) == 1) {
                    return false ;
                }
                row -- ;
                col -- ;
            }

            //Second, we check for the secondary diagonal
            row = rowIdx ;
            col = colIdx ;

            while (row >= 0 && col < num) {
                int oneDIndex = row * num + col ;
                if(current.get(oneDIndex) == 1) {
                    return false ;
                }
                row -- ;
                col ++ ;
            }

            return true ;
        }
    }
}
