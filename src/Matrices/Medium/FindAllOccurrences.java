package Matrices.Medium;

import java.util.ArrayList;

public class FindAllOccurrences {
    public static class Solution {
        // 8 directions: N, S, E, W, NE, NW, SE, SW
        private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0, -1, -1, 1, 1};
        private static final int[] COL_DIRECTIONS = {0, 0, 1, -1, 1, -1, 1, -1};
        private static int rowSize ;
        private static int colSize ;
        private static ArrayList<String> ans ;
        private static boolean[][] visited ;
        public static void findOccurrences(char[][] characterMatrix, String word) {
            //Edge case
            if(characterMatrix == null || characterMatrix.length == 0 || word == null || word.isEmpty()) {
                return ;
            }

            rowSize = characterMatrix.length ;
            colSize = characterMatrix[0].length ;
            ans = new ArrayList<>() ;
            char firstChar = word.charAt(0) ;
            for(int row = 0 ; row < rowSize ; row++ ) {
                for(int col = 0 ; col < colSize ; col++ ) {
                    if(characterMatrix[row][col] == firstChar) {
                        visited = new boolean[rowSize][colSize] ;
                        searchWord(characterMatrix , row , col , word , 0 , new StringBuilder()) ;
                    }
                }
            }

            for(String currentStr : ans) {
                System.out.println(currentStr) ;
            }
            return ;
        }

        private static void searchWord(char[][] characterMatrix, int row, int col, String word, int index , StringBuilder path) {
            //Base case
            if(row < 0 || row >= rowSize || col < 0 || col >= colSize || index >= word.length() || visited[row][col]) {
                return ;
            }

            if(characterMatrix[row][col] != word.charAt(index)) {
                return ;
            }

            if(index == word.length() - 1) {
                String currentPath = "'" + characterMatrix[row][col] + "'" + "(" + row + ", " + col + ")" ;
                path.append(currentPath) ;
                ans.add(path.toString()) ;
                path.delete(path.length() - currentPath.length(), path.length());
                return ;
            }

            String currentPath = "'" + characterMatrix[row][col] + "'" + "(" + row + ", " + col + ") " ;
            path.append(currentPath) ;
            visited[row][col] = true ;

            for(int idx = 0 ; idx < 8 ; idx++ ) {
                int newRow = row + ROW_DIRECTIONS[idx] ;
                int newCol = col + COL_DIRECTIONS[idx] ;

                searchWord(characterMatrix , newRow , newCol , word , index + 1 , path) ;

            }
            visited[row][col] = false ;
            path.delete(path.length() - currentPath.length() , path.length()) ;

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
