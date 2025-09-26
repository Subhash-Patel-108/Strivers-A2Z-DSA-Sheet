package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/duplicate-in-array_893397?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class DuplicateInArray {

    public static class Solution {
        public static int findDuplicate(ArrayList<Integer> arr) {
            //Edge case
            if(arr == null || arr.isEmpty()) {
                return -1 ;
            }

            HashMap <Integer , Boolean> map = new HashMap<>() ;
            for(int num : arr ) {
                if (map.containsKey(num)) {
                    return num ;
                }

                map.put(num , true) ;
            }

            return -1 ;
        }
    }
    public static void main(String[] args) {

    }
}
