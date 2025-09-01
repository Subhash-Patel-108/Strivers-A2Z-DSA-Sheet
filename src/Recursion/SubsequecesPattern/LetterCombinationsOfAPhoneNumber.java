package Recursion.SubsequecesPattern;
import java.util.* ;
public class LetterCombinationsOfAPhoneNumber {
    public static class Solution {
        private static String[] mapping = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"} ;
        public static ArrayList<String> combinations(String s){
            ArrayList<String> result = new ArrayList<String>() ;

            //Edge case
            if(s == null || s.length() == 0 ){
                return result ;
            }

            //Step 1: Initialization
            StringBuilder current = new StringBuilder() ;

            //Step 2: Function call
            helper(s , 0 , current , result) ;

            //Step 3: return the result
            return result ;
        }

        private static void helper(String str , int idx , StringBuilder current , ArrayList<String> result) {
            if(str.length() == current.length()) {
                result.add(current.toString()) ;
                return ;
            }

            for(int i = 0 ; i < mapping[str.charAt(idx) - '0'].length() ; i++ ){
                current.append(mapping[str.charAt(idx) - '0'].charAt(i));
                helper(str , idx + 1 , current , result) ;
                current.deleteCharAt(current.length() - 1) ;
            }
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
