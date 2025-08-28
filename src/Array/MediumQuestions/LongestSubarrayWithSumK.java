package Array.MediumQuestions;
import java.util.* ;
public class LongestSubarrayWithSumK {
    public static class Solution {
        public static int longestSubarray(int[] arr, int k) {
            HashMap <Integer , Integer> prefixSumMap = new HashMap<>() ;
            prefixSumMap.put(0 , -1) ; // for the case when the subarray starts from index 0

            int prefixSum = 0 ;
            int maxiLength = 0 ;

            for(int i = 0 ; i < arr.length ; i++ ) {
                prefixSum += arr[i] ;

                if(prefixSumMap.get(prefixSum - k) != null) {
                    int length = i - prefixSumMap.get(prefixSum - k) ;
                    maxiLength = Math.max(maxiLength , length) ;
                }

                //now we only store the first occurrence of prefixSum
                if(!prefixSumMap.containsKey(prefixSum)) {
                    prefixSumMap.put(prefixSum , i) ;
                }
            }
            return maxiLength ;
        }
    }

    public static void main(String[] args) {

    }
}
