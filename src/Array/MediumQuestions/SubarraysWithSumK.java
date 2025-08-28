package Array.MediumQuestions;
import java.util.* ;
public class SubarraysWithSumK {
    class Solution {
        public int cntSubarrays(int[] arr, int k) {
            HashMap <Integer , Integer> map = new HashMap<>() ;
            map.put(0 , 1) ;//0 is present
            int sum = 0 ;
            int count = 0 ; // to count the sunArray with sum k
            for(int i = 0 ; i < arr.length ; i++ ) {
                sum += arr[i] ;
                //check that sum - k is present then add the frequency of it to the count
                if(map.get(sum - k) != null) {
                    count += map.get(sum - k) ;
                }
                //put the current sum into the map
                map.put(sum , map.getOrDefault(sum , 0) + 1) ;
            }
            return count ;
        }
    }
    public static void main(String[] args) {

    }
}
