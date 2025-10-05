package DynamicProgramming.TwoAndThreeDDP;
import java.util.List ;
import java.util.LinkedList ;
import java.util.Queue ;

//Problem Link: https://leetcode.com/problems/triangle/
public class TriangleArray {

    public static class Solution {
        private final static int[] ROW_DIRECTION = { 1 , 1 } ;
        private final static int[] COLUMN_DIRECTION = {0 , 1 } ;

        private static class Pair {
            public int rowIdx ;
            public int colIdx ;

            //constructor
            public Pair(int row , int col) {
                this.rowIdx = row ;
                this.colIdx = col ;
            }
        };

        public int minimumTotal(List<List<Integer>> triangle) {
            //Edge case
            if (triangle == null || triangle.isEmpty()) {
                return 0 ;
            }
            int rowSize = triangle.size() ;

            int[][] dist = new int[rowSize][] ;

            for(int i = 0 ; i < rowSize ; i++ ) {
                dist[i] = new int[i + 1] ;
                for(int j = 0 ; j <= i ; j++) {
                    dist[i][j] = Integer.MAX_VALUE ;
                }
            }

            dist[0][0] = triangle.get(0).get(0) ;

            Queue <Pair> queue = new LinkedList<>() ;
            queue.offer(new Pair(0 , 0)) ;

            while(!queue.isEmpty()) {
                int size = queue.size() ;

                while (size-- > 0) {
                    Pair pair = queue.poll() ;
                    int rowIdx = pair.rowIdx ;
                    int colIdx = pair.colIdx ;

                    for(int idx = 0; idx < 2 ; idx++ ) {
                        int newRowIdx = rowIdx + ROW_DIRECTION[idx] ;
                        int newColIdx = colIdx + COLUMN_DIRECTION[idx] ;

                        if (isSafe(newRowIdx , newColIdx , triangle)) {
                            int newDist = dist[rowIdx][colIdx] + triangle.get(newRowIdx).get(newColIdx) ;
                            if (newDist < dist[newRowIdx][newColIdx]) {
                                dist[newRowIdx][newColIdx] = newDist ;
                                queue.offer(new Pair(newRowIdx , newColIdx)) ;
                            }
                        }
                    }
                }
            }

            int mini = Integer.MAX_VALUE ;
            for(int col = 0 ; col < rowSize ; col++ ) {
                mini = Math.min(mini, dist[rowSize - 1][col]) ;
            }

            return mini;
        }

        private static boolean isSafe(int row , int col , List<List<Integer>> triangle) {
            return (row >= 0 && row < triangle.size() ) && (col >= 0 && col < triangle.get(row).size()) ;
        }
    }
    public static void main(String[] args) {

    }
}
