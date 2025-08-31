package String.EasyQuestions;

import java.util.Arrays;

public class ReverseEveryWordInAString {
    public static class Solution {
        public static String reverseWords(String s) {
            String[] strArray = s.split(" ") ;
            int idx = strArray.length - 1 ;
            StringBuilder result = new StringBuilder() ;
            while (idx >= 0 ) {
                while (idx >= 0 && strArray[idx].isEmpty()) {
                    idx -- ;
                }
                if(idx > 0) {
                    result.append(strArray[idx] + " ");
                }else if (idx == 0){
                    result.append(strArray[idx]) ;
                }
                idx -- ;
            }
            return result.toString() ;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.reverseWords("welcome to the jungle"));

        return ;
    }
}
