package GreedyAlgorithm.ExtraQuestions;
import java.util.* ;
public class ReverseStringWordWise {
    public static class Solution {
        static String reverseStringWordWise(String input) {
            String[] strArr = input.trim().split("\\s+") ;
            Collections.reverse(Arrays.asList(strArr)) ;
            return String.join(" ", strArr) ;
        }
    }
    public static void main(String[] args) {

    }
}
