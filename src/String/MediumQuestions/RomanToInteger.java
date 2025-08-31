package String.MediumQuestions;

import java.util.HashMap;

public class RomanToInteger {
    public static class Solution {
        public int romanToInt(String s) {
            //Edge case
            if(s == null || s.length() == 0) {
                return 0 ;
            }

            //Step 1: Mapping of Roman to Integer
            HashMap <Character , Integer> romanMap = new HashMap<>() ;
            romanMap.put('I' , 1) ;
            romanMap.put('V' , 5) ;
            romanMap.put('X' , 10) ;
            romanMap.put('L' , 50) ;
            romanMap.put('C' , 100) ;
            romanMap.put('D' , 500) ;
            romanMap.put('M' , 1000) ;

            //Step 2: Initialize variables
            int result = 0 ;
            for(int i = 0 ; i < s.length() - 1 ; i++) {
                int currentValue = romanMap.get(s.charAt(i)) ;
                int nextValue = romanMap.get(s.charAt(i + 1)) ;

                if(currentValue >= nextValue ) {
                    result += currentValue ;
                }else{
                    result -= currentValue ;
                }
            }

            //Step 3: Add the last character
            result += romanMap.get(s.charAt(s.length() - 1)) ;

            return result ;
        }
    }
    public static void main(String[] args) {

    }
}
