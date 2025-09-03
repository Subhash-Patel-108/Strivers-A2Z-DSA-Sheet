package Recursion.CombinationsOrHard;
import java.util.* ;
public class PalindromePartitioning {
    public static class Solution {
        public static List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>() ;

            //Edge case
            if(s == null || s.length() == 0 ) {
                return result ;
            }else if (s.equals(" ")) {
                result.add(new ArrayList<>()) ;
                return result ;
            }

            //Step 1: Initialization
            List<String> current = new ArrayList<>() ;

            //Step 2: Function call
            palindromePartitioning(s , 0 , current , result) ;

            //Step 3: return the result
            return result ;
        }

        //function for palindrome partitioning
        private static void palindromePartitioning(String str , int start , List<String> current , List<List<String>> result ) {
            //Base case
            if(str.length() == start) {
                result.add(new ArrayList<>(current)) ;
                return ;
            }

            for(int end = start; end < str.length() ; end ++ ) {
                if(isPalindrome(str , start , end)) {
                    current.add(str.substring(start , end + 1)) ;
                    palindromePartitioning(str , end + 1 , current , result) ;
                    current.remove(current.size() - 1) ;
                }
            }
        }

        //Function to check if a string is a palindrome
        private static boolean isPalindrome(String str , int start , int end ) {
            while(start < end) {
                if(str.charAt(start) != str.charAt(end)) {
                    return false ;
                }
                start++ ;
                end-- ;
            }
            return true ;
        }
    }
    public static void main(String[] args) {

    }
}
