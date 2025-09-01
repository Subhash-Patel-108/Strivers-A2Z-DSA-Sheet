package Recursion.SubsequecesPattern;
import java.util.* ;
public class GenerateAllBinaryStrings {
    public static class Solution {
        public static List<String> generateBinaryStrings(int n) {
            //Edge case
            List<String> result = new ArrayList<>() ;
            if(n == 0 ){
                return result ;
            }

            //Step 1: Initialization
            StringBuilder sb = new StringBuilder() ;
            helper(n , 0 , sb , result , '0') ;
            return result ;
        }

        //Helper function to generate all the binary strings
        private static void helper(int n , int pos , StringBuilder str , List<String> result , char lastChar) {
            //Base case
            if(pos == n) {
                result.add(str.toString());
                return ;
            }

            //Include 0
            str.append('0') ;
            helper(n , pos + 1 , str , result , '0') ;
            str.deleteCharAt(str.length() - 1) ;

            //Include 1, but we check if the last character is 1 or not
            if(lastChar != '1') {
                str.append('1') ;
                helper(n , pos + 1 , str , result , '1') ;
                str.deleteCharAt(str.length() - 1) ;
            }

            return ;
        }
    }

    public static void main(String[] args) {

    }
}
