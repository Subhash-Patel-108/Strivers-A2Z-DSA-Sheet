package Recursion.SubsequecesPattern;
import java.util.* ;
public class GenerateAllParenthesis {
    public static class Solution {
        public static ArrayList<String> validParenthesis(int n){
            ArrayList <String> result = new ArrayList<String>() ;
            //Edge case
            if(n == 0) {
                return result ;
            }

            //Step 1: Initialization
            StringBuilder current = new StringBuilder() ;

            //Step 2: Function call
            helper(n*2 , 0 , 0 , 0 , current , result );

            //Step 3: return the result
            return result ;
        }

        private static void helper(int n , int pos , int openCount , int closeCount , StringBuilder current , ArrayList<String> result) {
            //Base case
            if(pos == n) {
                //add only when the generated string is valid
                if(openCount == closeCount) {
                    result.add(current.toString());
                }
                return ;
            }

            //Include open
            current.append("(") ;
            helper(n , pos + 1 , openCount + 1 , closeCount , current , result) ;
            current.deleteCharAt(current.length() - 1) ;

            //Include the close bracket
            if(openCount > closeCount) {//include if there is already an open bracket
                current.append(')') ;
                helper(n , pos + 1 , openCount , closeCount + 1 , current , result) ;
                current.deleteCharAt(current.length() - 1) ;
            }
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
