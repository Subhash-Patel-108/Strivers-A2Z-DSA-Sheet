package BitManipulation.ExtraQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/sort-an-array-according-to-the-count-of-set-bits_873142?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class SortAnArrayAccordingToTheCountOfSetBits {
    public static class Solution {
        private static class Tuple {
            public int numberOfSetBits ;
            public int number ;
            public int index ;

            //Constructor
            public Tuple(int number , int numberOfSetBits , int index) {
                this.number = number ;
                this.numberOfSetBits = numberOfSetBits ;
                this.index = index ;
            }
        };


        public static void sortSetBitsCount(ArrayList<Integer> arr, int size) {
            //Edge case
            if(arr == null || arr.isEmpty()) {
                return ;
            }

            ArrayList <Tuple> result = new ArrayList<>() ;
            for(int i = 0 ; i < size ; i++ ) {
                int numberOfSetBits = Integer.bitCount(arr.get(i)) ;
                result.add(new Tuple(arr.get(i) , numberOfSetBits , i)) ;
            }

            result.sort((a , b) -> {
                if(a.numberOfSetBits != b.numberOfSetBits) {
                    return b.numberOfSetBits - a.numberOfSetBits ;
                }else {
                    return a.index - b.index ;
                }
            });

            for(int i = 0 ; i < size ; i++) {
                arr.set(i , result.get(i).number) ;
            }

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
