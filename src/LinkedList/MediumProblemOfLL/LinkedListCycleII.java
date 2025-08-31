package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.ListNode;
public class LinkedListCycleII {
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            //Edge cases
            if(head == null || head.next == null) {
                return null ;
            }
            if(head.next == head) {
                return head ;
            }

            ListNode slowPointer = head ;
            ListNode fastPointer = head.next ;

            while (fastPointer != null && fastPointer.next != null ) {
                if(slowPointer == fastPointer) {
                    break ;
                }
                slowPointer = slowPointer.next ;
                fastPointer = fastPointer.next.next ;
            }

            if(fastPointer == null || fastPointer.next == null) {
                return null ;
            }

            slowPointer = slowPointer.next ;
            fastPointer = head ;

            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next ;
                fastPointer = fastPointer.next ;
            }

            return slowPointer ;
        }
    }
    public static void main(String[] args) {

    }
}
