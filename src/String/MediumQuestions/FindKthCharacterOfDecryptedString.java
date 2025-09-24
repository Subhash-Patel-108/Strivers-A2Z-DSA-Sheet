package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/find-k-th-character-of-decrypted-string_630508?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC
public class FindKthCharacterOfDecryptedString {

    public static class Solution {
        public static char kThCharaterOfDecryptedString(String s, Long k) {
            //Edge case
            if(s == null || s.isEmpty()) {
                return ' ' ;
            }

            String decryptedString = decryptString(s) ;

            int idx = Math.toIntExact(k) ;
            return decryptedString.charAt( idx - 1) ;
        }

        private static String decryptString(String str) {
            StringBuilder result = new StringBuilder() ;

            StringBuilder repeatingString = new StringBuilder() ;
            int count = 0 ;
            boolean isDigitHits = false ;
            for(char ch : str.toCharArray()) {
                if(ch >= '0' && ch <= '9') {
                    int value = ch - '0' ;
                    count = count * 10 + value ;
                    isDigitHits = true ;
                }else {
                    if(isDigitHits) {
                        result.append(repeatTheString(repeatingString.toString() , count)) ;
                        count = 0 ;
                        repeatingString = new StringBuilder() ;
                        isDigitHits = false ;
                    }
                    repeatingString.append(ch) ;
                }
            }

            if(count > 0 ){
                result.append(repeatTheString(repeatingString.toString() , count)) ;
            }

            return result.toString() ;
        }

        private static String repeatTheString(String str , int count) {
            StringBuilder result = new StringBuilder() ;
            for(int i = 1 ; i <= count ; i++ ){
                result.append(str) ;
            }

            return result.toString() ;
        }
    }
    public static void main(String[] args) {

    }
}
