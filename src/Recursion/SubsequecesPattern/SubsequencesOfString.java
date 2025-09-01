package Recursion.SubsequecesPattern;
import java.util.* ;
public class SubsequencesOfString {
    public static class Solution {
        public static ArrayList<String> subsequences(String str) {
            ArrayList<String> result = new ArrayList<String>() ;

            //Edge case
            if(str == null || str.length() == 0) {
                return result ;
            }

            //Step 1: Initialization
            StringBuilder current = new StringBuilder() ;

            //Step 2: Function call
            helper(str , 0 , current , result) ;

            //Step 3: return the result
            return result ;
        }

        private static void helper(String str , int pos , StringBuilder current , ArrayList<String> result) {
            //Base case
            if(str.length() == pos) {
                //Condition to exclude the empty string
                if(current.length() != 0) {
                    result.add(current.toString());
                }
                return ;
            }

            //Include the current character
            current.append(str.charAt(pos)) ;
            helper(str , pos + 1 , current , result) ;
            current.deleteCharAt(current.length() - 1) ;

            //Exclude the current character
            helper(str , pos + 1 , current , result) ;

            return ;
        }
    }
}
