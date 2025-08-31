package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node;
public class FindTheLengthOfTheLoop {
    public static class Solution {
        public static int lengthOfLoop(Node head) {
            //Edge case
            if(head == null || head.next == null) {
                return 0;
            }

            int loopLength = 0 ;
            Node slowPointer = head ;
            Node fastPointer = head ;

            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next ;
                fastPointer = fastPointer.next.next ;

                if(slowPointer == fastPointer ) {//Cycle is present
                    break ;
                }
            }
            //if there is no cycle
            if(fastPointer == null || fastPointer.next == null) {
                return loopLength ;
            }

            //counting the length of the loop
            do {
                loopLength ++ ;
                slowPointer = slowPointer.next ;
            }while (slowPointer != fastPointer) ;

            return loopLength ;//return the loop length
        }
    }
    public static void main(String[] args) {

    }
}
