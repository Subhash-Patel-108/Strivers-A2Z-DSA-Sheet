package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class SortLinkedList {
    public static class Solution {
        // Entry function that starts merge sorting the linked list
        public static Node sortLL(Node head) {
            return sortLLUsingMergeSort(head);
        }

        // Recursive merge sort function
        private static Node sortLLUsingMergeSort(Node head) {
            // Base case: empty list or single node list is already sorted
            if (head == null || head.next == null) {
                return head;
            }

            // Find middle of the linked list
            Node middle = findMiddle(head);
            Node newHead = middle.next;
            middle.next = null;  // Split list into two halves

            // Recursively sort next half
            Node left = sortLLUsingMergeSort(head);
            // Recursively sort right half
            Node right = sortLLUsingMergeSort(newHead);

            // Merge the two sorted halves and return
            return mergeTwoSortedLinkedList(left, right);
        }

        // Function to find the middle node of the list using slow and fast pointers
        private static Node findMiddle(Node head) {
            Node slowPointer = head;
            Node fastPointer = head;
            // Move fast pointer by two and slow pointer by one until fast reaches the end
            while (fastPointer.next != null && fastPointer.next.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return slowPointer; // Slow pointer will be at middle
        }

        // Function to merge two sorted linked lists into one sorted linked list
        private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;

            Node newHead = new Node(-1); // Dummy node
            Node tail = newHead;

            Node currentNode1 = head1;
            Node currentNode2 = head2;

            // Merge lists by choosing smaller nodes one by one
            while (currentNode1 != null && currentNode2 != null) {
                if (currentNode1.data < currentNode2.data) {
                    tail.next = currentNode1;
                    currentNode1 = currentNode1.next;
                } else {
                    tail.next = currentNode2;
                    currentNode2 = currentNode2.next;
                }
                tail = tail.next;
            }

            // Append remaining nodes from the non-empty list
            tail.next = (currentNode1 != null) ? currentNode1 : currentNode2;

            // Return merged list (excluding dummy node)
            return newHead.next;
        }
    }
    public static void main(String[] args) {

    }
}
