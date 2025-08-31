package LinkedList.MediumProblemOfDLL;
import java.util.* ;
public class TwoSumPairInLinkedList {
    public static class Solution {
        public static class Node {
            public int data ;
            public Node next ;
            public Node prev ;

            public Node (int data) {
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
        };

        //We solve the given problem using two pointers approach
        public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                          Node head) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;
            //Edge case
            if(head == null || head.next == null) {
                return result ;
            }
            Node end = head ;
            while(end.next != null) {
                end = end.next ;
            }
            Node start = head ;
            while(start.data < end.data) {
                if(start.data + end.data == target) {
                    result.add((ArrayList<Integer>)(Arrays.asList(start.data , end.data))) ;
                    start = start.next ;
                    end = end.prev ;
                }else if(start.data + end.data < target) {
                    start = start.next ;
                }else{
                    end = end.prev ;
                }
            }
            return result ;
        }

    }
    public static void main(String[] args) {

    }
}
