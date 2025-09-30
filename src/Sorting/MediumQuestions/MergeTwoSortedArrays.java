package Sorting.MediumQuestions;
import java.util.* ;

//Problem Link :https://www.naukri.com/code360/problems/ninja-and-sorted-arrays_1214628?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class MergeTwoSortedArrays {

    public static class Solution {
        public static int[] ninjaAndSortedArrays(int[] arr1, int[] arr2, int m, int n) {
            //Edge case
            if(arr1 == null){
                return new int[]{} ;
            }

            int firstArrIdx = m - 1 ;
            int secondArrIdx = n - 1 ;

            int lastIdx = arr1.length - 1 ;

            while (firstArrIdx >= 0 && secondArrIdx >= 0 ) {
                if(arr1[firstArrIdx] > arr2[secondArrIdx]) {
                    arr1[lastIdx] = arr1[firstArrIdx] ;
                    firstArrIdx -- ;
                }else{
                    arr1[lastIdx] = arr2[secondArrIdx] ;
                    secondArrIdx -- ;
                }

                lastIdx -- ;
            }

            while (secondArrIdx >= 0) {
                arr1[lastIdx] = arr2[secondArrIdx] ;
                lastIdx-- ;
                secondArrIdx-- ;
            }

            return arr1 ;
        }
    }
    public static void main(String[] args) {

    }
}
