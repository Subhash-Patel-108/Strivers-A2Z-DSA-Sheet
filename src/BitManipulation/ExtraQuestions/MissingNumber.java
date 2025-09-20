package BitManipulation.ExtraQuestions;
import java.util.* ;
//Problem Link : https://www.naukri.com/code360/problems/missing-number_1229390?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC
public class MissingNumber {
    public static class Solution {
        public static String findMissingNumber(ArrayList<String> binaryNums, int n)  {
            //Edge case
            if(binaryNums == null || binaryNums.isEmpty()){
                return "" ;
            }

            HashSet <Integer> set = new HashSet<>() ;
            for(String binaryNum : binaryNums) {
                set.add(Integer.parseInt(binaryNum , 2)) ;
            }

            for(int i = 0 ; i <= n ; i++) {
                if(!set.contains(i)) {
                    return Integer.toBinaryString(i) ;
                }
            }

            return "0" ;
        }
    }
    public static void main(String[] args) {

    }
}
