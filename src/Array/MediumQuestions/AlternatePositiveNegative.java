package Array.MediumQuestions;
import java.util.* ;
public class AlternatePositiveNegative {
    class Solution {
        //Function to rearrange the array in alternate positive and negative elements
        //by using two arraylist and then merge them
        void rearrange(ArrayList<Integer> arr) {
            ArrayList <Integer> positiveElements = new ArrayList<Integer>() ;
            ArrayList <Integer> negativeElements = new ArrayList<Integer>() ;

            //filtering the array
            for(int i = 0 ; i < arr.size() ; i++) {
                if(arr.get(i) <= 0) {
                    positiveElements.add(arr.get(i)) ;
                }else{
                    negativeElements.add(arr.get(i)) ;
                }
            }

            //Merging the Arraylist
            int idx = 0 ;
            int positiveIdx = 0 , negativeIdx = 0 ;
            while (positiveIdx < positiveElements.size() && negativeIdx < negativeElements.size()) {
                if((idx & 1) == 0) {//even index
                    arr.set(idx , positiveElements.get(positiveIdx)) ;
                    positiveIdx++ ;
                }else {
                    arr.set(idx , negativeElements.get(negativeIdx)) ;
                    negativeIdx ++ ;
                }
                idx ++ ;
            }

            //
        }
    }
    public static void main(String[] args) {

    }
}
