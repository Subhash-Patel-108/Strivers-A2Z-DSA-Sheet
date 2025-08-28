package Array.MediumQuestions;
import java.util.* ;
public class MajorityElement1 {
    class Solution {
        //I am using the most optimised approach
        //Moore's voting algorithm
        public static int majorityElement(int arr[]) {
            int count = 0 ;
            int candidate = -1 ;

            //first, we find out the potential candidate
            for(int i = 0 ; i < arr.length ; i++) {
                if(count == 0) {
                    candidate = arr[i] ;
                    count ++ ;
                }else if (candidate == arr[i]) {
                    count ++ ;
                }else{
                    count -- ;
                }
            }

            //now, we can verify the candidate based on the count
            count = 0 ;
            for(int i = 0 ; i < arr.length ; i++ ) {
                if(arr[i] == candidate) {
                    count ++ ;
                }
            }
            return count > arr.length / 2 ? candidate : -1 ;
        }
    }


    public static void main(String[] args) {

    }
}
