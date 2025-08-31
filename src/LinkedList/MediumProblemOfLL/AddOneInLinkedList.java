package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class AddOneInLinkedList {
    public static class Solution {
        public static Node addOne(Node head) {
            // Edge case: if list is empty
            if (head == null) {
                return null;
            }

            // Reverse the linked list to process digits from least significant to most
            Node reversedHead = reverseTheLinkedList(head);

            Node currentNode = reversedHead;
            Node prevNode = null;
            int carry = 1; // Start with adding 1

            while (currentNode != null) {
                int sum = currentNode.data + carry;
                carry = sum / 10;                 // Calculate carry for next digit
                currentNode.data = sum % 10;     // Update current node's digit
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            // If carry remains after last node, append a new node with carry value
            if (carry > 0) {
                prevNode.next = new Node(carry);
            }

            // Reverse again to restore original order
            return reverseTheLinkedList(reversedHead);
        }

        // Helper function to reverse a singly linked list
        private static Node reverseTheLinkedList(Node head) {
            Node prevNode = null;
            Node currentNode = head;
            Node nextNode;

            while (currentNode != null) {
                nextNode = currentNode.next;    // Temporarily store next node
                currentNode.next = prevNode;    // Reverse current node pointer
                prevNode = currentNode;         // Move prevNode forward
                currentNode = nextNode;         // Move currentNode forward
            }

            // prevNode now points to the new head of reversed list
            return prevNode;
        }

    }
    public static void main(String[] args) {

    }
}
