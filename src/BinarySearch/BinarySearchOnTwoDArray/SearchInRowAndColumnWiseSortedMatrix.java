package BinarySearch.BinarySearchOnTwoDArray;
import java.util.*;
public class SearchInRowAndColumnWiseSortedMatrix {
    public static class Solution {
        public static boolean findInMatrix(int target, ArrayList<ArrayList<Integer>> arr) {
            //Edge case
            if(arr == null || arr.size() == 0) {
                return false ;
            }

            int row = 0 , col = arr.get(0).size() ;
            while (row < arr.size() && col >= 0) {
                int currentElement = arr.get(row).get(col) ;
                if(currentElement == target) {
                    return true ;
                }else if (currentElement < target ) {
                    row ++ ;
                }else{
                    col -- ;
                }
            }
            return false ;
        }
    }
    public static void main(String[] args) {

    }
}
