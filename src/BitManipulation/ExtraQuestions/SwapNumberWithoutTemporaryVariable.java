package BitManipulation.ExtraQuestions;
//Problem Link : https://www.naukri.com/code360/problems/swap-number-without-temporary-variable_893054?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=PROBLEM
public class SwapNumberWithoutTemporaryVariable {
    public class Solution {
        public static int[] swapNumber(int x, int y) {
            x = x ^ y ;
            y = x ^ y ;
            x = x ^ y ;
            return new int[] {x , y} ;
        }
    }

    public static void main(String[] args) {

    }
}
