package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.ListNode;
public class MiddleOfTheLinkedList {
    class Solution {
        // Function to find the middle node in a singly linked list
        public ListNode middleNode(ListNode head) {
            // Edge case: if the list is empty, return null
            if (head == null) {
                return null;
            }

            ListNode slowPointer = head;  // Moves one node at a time
            ListNode fastPointer = head;  // Moves two nodes at a time

            // Traverse until fastPointer reaches end of the list
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;       // Move by one node
                fastPointer = fastPointer.next.next;  // Move by two nodes
            }

            // When fastPointer reaches end, slowPointer is at the middle
            return slowPointer;
        }
    }
    public static void main(String[] args) {

    }
}
