package LinkedList.LearnDoublyLinkedList;

public class ReverseADoublyLinkedList {
    public static class Solution {
        public static class Node {
            int data ;
            Node next ;
            Node prev ;

            public Node(int data) {
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
        }
        // Function to reverse a doubly linked list
        public static Node reverseDLL(Node head) {
            // Edge case: if the list is empty, return null
            if (head == null) {
                return null;
            }

            Node prevNode = null;              // Tracks the previous node
            Node currentNode = head;           // Tracks the current node
            Node futureNode;                   // Used to store next node before swapping

            // Traverse the list and reverse
            while (currentNode != null) {
                futureNode = currentNode.next; // Save the next node

                // Reverse the 'next' pointer
                currentNode.next = prevNode;

                // Adjust the 'prev' pointer of previous node (if exists)
                if (prevNode != null) {
                    prevNode.prev = currentNode;
                }

                // Move prevNode and currentNode one step forward
                prevNode = currentNode;
                currentNode = futureNode;
            }
            // After loop, prevNode points to the new head (last node of original list)
            return prevNode;
        }

    }
    public static void main(String[] args) {

    }
}
