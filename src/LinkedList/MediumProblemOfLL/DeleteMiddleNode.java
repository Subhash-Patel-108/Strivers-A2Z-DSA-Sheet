package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class DeleteMiddleNode {
    public static class Solution {
        public static Node deleteMiddle(Node head) {
            // Edge case: if list is empty or has only one node, return null (list becomes empty)
            if (head == null || head.next == null) {
                return null;
            }

            Node slowPointer = head;   // Will move one step at a time
            Node fastPointer = head;   // Will move two steps at a time
            Node prevNode = null;      // To keep track of node before slowPointer

            // Move fastPointer by 2 and slowPointer by 1 until fastPointer reaches end
            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                prevNode = slowPointer;         // Remember the node before slowPointer
                slowPointer = slowPointer.next; // Move slowPointer by one
            }

            // Delete the middle node by skipping it in the list
            prevNode.next = slowPointer.next;

            // Return the head of the modified list
            return head;
        }

    }
    public static void main(String[] args) {

    }
}
