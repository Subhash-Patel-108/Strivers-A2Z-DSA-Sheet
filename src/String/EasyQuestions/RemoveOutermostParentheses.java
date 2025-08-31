package String.EasyQuestions;
import java.util.* ;
public class RemoveOutermostParentheses {
    public static class Solution {
        public static String removeOuter(String s) {
            //edge case
            if(s.length() == 0) {
                return "" ;
            }
            StringBuilder result = new StringBuilder() ;
            int level = 0 ;

            for(char ch : s.toCharArray()) {
                if(ch == '(') {
                    level++ ;
                    if(level > 1) {//if the level is greater than 1 then it is not the outermost parentheses
                        result.append(ch) ;
                    }
                }else{
                    level-- ;
                    if(level > 0) {//if the level is greater than 0 then it is not the outermost parentheses
                        result.append(ch) ;
                    }
                }
            }

            return result.toString() ;//converting the StringBuilder to String
        }
    }

    public static void main(String[] args) {

    }
}
