package String.EasyQuestions;
//Problem Link : https://www.naukri.com/code360/problems/excel-column-number_630461?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class ExcelColumnNumber {
    public static class Solution {
        public static long excelColumnNumber(String input) {
            //Edge case
            if(input == null || input.isEmpty()) {
                return 0 ;
            }

            long result = 0 ;
            for(char currChar : input.toCharArray() ) {
                int currCharValue = currChar - 'A' + 1 ;

                result = result * 26 + currCharValue ;
            }

            return result ;
        }
    }
    public static void main(String[] args) {

    }
}
