package String.MediumQuestions;
import java.util.* ;
public class IntegerToRoman {
    public static class Solution {
        public static String convertToRoman(int n) {
            //Edge case
            if(n == 0) {
                return "" ;
            }
            //Step 1: Create a mapping of Roman to Integer
            Map <Integer , String> romanMap = new LinkedHashMap<>();
            romanMap.put(1000, "M");
            romanMap.put(900, "CM");
            romanMap.put(500, "D");
            romanMap.put(400, "CD");
            romanMap.put(100, "C");
            romanMap.put(90, "XC");
            romanMap.put(50, "L");
            romanMap.put(40, "XL");
            romanMap.put(10, "X");
            romanMap.put(9, "IX");
            romanMap.put(5, "V");
            romanMap.put(4, "IV");
            romanMap.put(1, "I");


        //Step 2: Initialize variables
            StringBuilder result = new StringBuilder() ;

            //Step 3: Iterate over the map
            for(Map.Entry<Integer , String> entry : romanMap.entrySet()) {
                int key = entry.getKey() ;
                String value = entry.getValue() ;
                while (n >= key) {
                    result.append(value) ;
                    n -= key ;
                }
            }

            //Step 4: Return the result
            return result.toString() ;
        }
    }
    public static void main(String[] args) {

    }
}
