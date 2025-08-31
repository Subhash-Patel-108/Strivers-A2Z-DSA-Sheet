package String.EasyQuestions;

public class LongestCommonPrefix {
    public static class Solution {
        //function to find common prefix of the array of strings
        public static String commonPrefix(String []arr,int n){
            //Edge case
            if(arr == null || arr.length == 0) {
                return "" ;
            }
            StringBuilder result = new StringBuilder() ;

            String minString = findMinimumLengthString(arr) ;
            int idx = 0 ;
            while (idx < minString.length() ) {
                char ch = minString.charAt(idx) ;
                if(isCommonPrefix(arr , ch , idx)) {
                    result.append(ch) ;
                }else{
                    break ;
                }
                idx ++ ;
            }
            return result.length() == 0 ? "-1" : result.toString() ;
        }

        private static String findMinimumLengthString(String []arr) {
            String minString = arr[0] ;
            for(int i = 1 ; i < arr.length ; i++) {
                if(minString.length() > arr[i].length()) {
                    minString = arr[i] ;
                }
            }
            return minString ;
        }

        //function to check if the character is common prefix of the array of strings
        private static boolean isCommonPrefix(String []arr,char ch , int idx) {
            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i].charAt(idx) != ch) {
                    return false ;
                }
            }
            return true ;
        }
    }
    public static void main(String[] args) {
        char[] ch = new char[26] ;
        System.out.println(ch[0]);
    }
}
