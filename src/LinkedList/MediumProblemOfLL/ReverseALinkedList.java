package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.ListNode;
public class ReverseALinkedList {
    public static class Solution {
        // Function to reverse a singly linked list
        public ListNode reverseList(ListNode head) {
            // Edge case: if the list is empty, return null
            if (head == null) {
                return null;
            }

            ListNode prevNode = null;         // To keep track of the previous node
            ListNode currentNode = head;      // To traverse the list
            ListNode nextNode;                // To store the next node temporarily

            // Traverse the list and reverse links one by one
            while (currentNode != null) {
                nextNode = currentNode.next;      // Save next node before changing the link
                currentNode.next = prevNode;      // Reverse the current node's pointer
                prevNode = currentNode;           // Move prevNode and currentNode one step forward
                currentNode = nextNode;
            }
            // prevNode will be the new head after the entire list is reversed
            return prevNode;
        }

    }
    public static void main(String[] args) {

    }
}
