package String.EasyQuestions;

public class IsomorphicStrings {
    public static class Solution {
        public static boolean areIsomorphic(String str1, String str2) {
            //Edge case
            if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || str1.length() != str2.length()) {
                return false ;
            }

            char[] str1MapArray = new char[26] ;
            char[] str2MapArray = new char[26] ;

            for(int i = 0 ; i < str1.length() ; i++) {
                char ch1 = str1.charAt(i) ;
                char ch2 = str2.charAt(i) ;

                int idx1 = ch1 - 'a' ;
                int idx2 = ch2 - 'a' ;

                if(str1MapArray[idx1] == 0 && str2MapArray[idx2] == 0) {
                    str1MapArray[idx1] = ch2 ;
                    str2MapArray[idx2] = ch1 ;
                }else if ((str1MapArray[idx1] == 0 && str2MapArray[idx2] != 0) || (str1MapArray[idx1] != 0 && str2MapArray[idx2] == 0)) {
                    return false ;
                }else if (str1MapArray[idx1] != ch2 || str2MapArray[idx2] != ch1) {
                    return false ;
                }
            }
            return true ;
        }
    }
    public static void main(String[] args) {

    }
}
