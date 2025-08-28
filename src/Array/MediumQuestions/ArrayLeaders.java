package Array.MediumQuestions;
import java.util.* ;
public class ArrayLeaders {
    public static class Solution {
        public static ArrayList<Integer> leaders(int arr[]) {
            //edge case
            if(arr.length == 0) {
                return new ArrayList<>() ;
            }

            ArrayList<Integer> leadersArray = new ArrayList<Integer>();
            Stack<Integer> stack = new Stack<Integer>() ;
            stack.push(arr[arr.length - 1 ] ) ;
            for(int i = arr.length - 2 ; i >= 0 ; i-- ) {
                if(stack.peek() <= arr[i]) {
                    stack.push(arr[i]) ;
                }
            }

            while (!stack.isEmpty()) {
                leadersArray.add(stack.pop()) ;
            }
            return leadersArray ;
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3 ,5 ,2} ;
        System.out.println(Solution.leaders(arr));
    }
}
