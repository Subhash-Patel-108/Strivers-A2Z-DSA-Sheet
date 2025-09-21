package BitManipulation.ExtraQuestions;
import java.util.* ;
public class SingleNumberII {

    public static class Solution{
        public static int elementThatAppearsOnce(int[] arr) {
            //Edge case
            if(arr == null || arr.length == 0) {
                return -1 ;
            }

            HashMap <Integer , Integer> map = new HashMap<>();

            for(int num : arr) {
                map.putIfAbsent(num , 0) ;
                map.put(num , map.get(num) + 1) ;
            }

            for(Map.Entry<Integer , Integer> entry : map.entrySet()) {
                if(entry.getValue() == 1) {
                    return entry.getKey() ;
                }
            }
            return -1 ;
        }
    }
    public static void main(String[] args) {

    }
}
