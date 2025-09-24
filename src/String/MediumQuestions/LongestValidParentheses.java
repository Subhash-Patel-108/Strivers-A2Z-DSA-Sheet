package String.MediumQuestions;
import java.util.* ;
//Problem Link: https://www.naukri.com/code360/problems/longest-valid-parentheses_1089563?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class LongestValidParentheses {

    public static class Solution {
        public static int longestValidParentheses(String s) {
            //Edge case
            if(s == null || s.isEmpty()) {
                return 0 ;
            }

            Stack <Integer> stack = new Stack<>() ;
            stack.push(-1);

            int maxLength = 0 ;
            int idx = 0 ;
            for(char parentheses : s.toCharArray()) {
                if(parentheses == '(') {
                    stack.push(idx) ;
                }else{
                    stack.pop() ;

                    if(stack.isEmpty()) {
                        stack.push(idx) ;
                    }else{
                        int currentLength = idx - stack.peek() ;
                        maxLength = Math.max(maxLength , currentLength) ;
                    }
                }
                idx++ ;
            }

            return maxLength ;
        }
    }
    public static void main(String[] args) {
    }
}
