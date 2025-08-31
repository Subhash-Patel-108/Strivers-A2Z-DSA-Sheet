package LinkedList.HardProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class RotateLinkedList {
    public static class Solution {
        public static Node rotate(Node head, int k) {
            // Edge cases: empty list or single node
            if (head == null || head.next == null || k < 0) {
                return head;
            }

            // Find length and tail in one pass
            int length = 1;
            Node tail = head;
            while (tail.next != null) {
                length++;
                tail = tail.next;
            }

            // Compute effective rotations
            k = k % length;
            if (k == 0) {
                return head;
            }

            // Find the new tail (at position length - k - 1)
            Node newTail = head;
            for (int i = 1; i < length - k; i++) {
                newTail = newTail.next;
            }

            // Perform rotation
            Node newHead = newTail.next;
            newTail.next = null;
            tail.next = head;

            return newHead;
        }
    }
    public static void main(String[] args) {

    }
}
