package Array.HardQuestions;
import java.util.HashMap ;
public class LargestSubarrayWithZeroSum {
    public static class Solution {
        public static int maxLength(int arr[]) {
            int maxiLength = 0 ;
            //edge case
            if(arr == null || arr.length == 0) {
                return maxiLength ;
            }
            int prefixSum = 0 ;
            HashMap <Integer , Integer> prefixSumMap = new HashMap<>() ;
            prefixSumMap.put(0 , -1) ;
            for(int i = 0 ; i < arr.length ; i++) {
                prefixSum += arr[i] ;

                if(prefixSumMap.containsKey(prefixSum)) {
                    int length = i - prefixSumMap.get(prefixSum) ;
                    maxiLength = Math.max(maxiLength , length) ;
                }

                //we can add the first occurrence of the prefix sum which gives us the longest SubArray
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
