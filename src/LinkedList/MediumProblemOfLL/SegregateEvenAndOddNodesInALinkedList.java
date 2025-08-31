package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class SegregateEvenAndOddNodesInALinkedList {
    public static class Solution {
        //the function where the first call is received
        public static Node segregateEvenOdd(Node head) {
            // Edge case: if list is empty, return null
            if (head == null) {
                return null;
            }

            // Dummy nodes to start even and odd lists
            Node evenHead = new Node(-1);
            Node oddHead = new Node(-1);

            // Tails for even and odd lists to append nodes
            Node evenTail = evenHead;
            Node oddTail = oddHead;

            Node currNode = head;
            while (currNode != null) {
                // Check if current node data is even using bitwise AND with 1
                if ((currNode.data & 1) == 0) {
                    evenTail.next = currNode;  // Append to even list
                    evenTail = evenTail.next;
                } else {
                    oddTail.next = currNode;   // Append to odd list
                    oddTail = oddTail.next;
                }
                currNode = currNode.next;      // Move to next node
            }

            // Connect even list with odd list
            head = evenHead.next;              // Head points to start of even list
            evenTail.next = oddHead.next;      // Link even list tail to start of odd list
            oddTail.next = null;               // Mark end of list with null

            return head;                      // Return new head of rearranged list
        }

    }
    public static void main(String[] args) {

    }
}
