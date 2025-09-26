package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/find-peak-element_1081482?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class FindPeakElement {
    public static class Solution {
        public static int findPeakElement(ArrayList<Integer> arr) {
            //Edge case
            if(arr == null || arr.isEmpty()) {
                return -1 ;
            }

            int size = arr.size() ;
            if(size == 1) {
                return 0 ;
            }

            return peakIndex(arr , 0 , size - 1) ;
        }

        private static int peakIndex(ArrayList<Integer> arr , int start , int end ) {
            while (start <= end) {
                int mid = start + (end - start ) / 2 ;

                if(mid < end && arr.get(mid) > arr.get(mid + 1)) {
                    return mid ;
                }else if (mid > 0 && arr.get(mid - 1) > arr.get(mid)){
                    return mid - 1 ;
                }

                if (arr.get(start) < arr.get(mid)) {
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }

            return -1 ;
        }
    };

    public static void main(String[] args) {

    }
}
