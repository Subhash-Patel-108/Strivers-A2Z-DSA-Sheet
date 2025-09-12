package BitManipulation.LearnBitManipulation;
import java.util.* ;
public class SwapTwoNumber {
    public static class Solution {
        static List<Integer> get(int a, int b) {
            List<Integer> ans = new ArrayList<>() ;

            //Swapping the values 
            a = a ^ b ;
            b = a ^ b ;
            a = a ^ b ;

            ans.add(a) ;
            ans.add(b) ;

            return ans ;
        }
    }
    public static void main(String[] args) {

    }
}
