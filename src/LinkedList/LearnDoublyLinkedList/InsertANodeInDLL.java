package LinkedList.LearnDoublyLinkedList;

public class InsertANodeInDLL {

    public static class Solution {

        // Doubly Linked List Node class
        public static class Node {
            int data;
            Node next;
            Node prev;

            // Constructor to initialize a node with data
            public Node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        /*
         * Inserts a new node with value 'val' at position 'k' in the doubly linked list.
         * Returns the head of the modified list.
         */
        static Node insert(int k, int val, Node head) {
            // Edge case: If the list is empty, insert and return new node as head
            if (head == null) {
                return new Node(val);
            }

            // If insertion is at the head (position 0)
            if (k == 0) {
                Node newNode = new Node(val);
                newNode.next = head;
                head.prev = newNode; // Set previous of old head to new node
                return newNode; // New node becomes the new head
            }

            // Traverse the list to position k
            Node prevNode = null;
            Node currNode = head;
            while (k-- > 0 && currNode != null) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            // Create new node to insert
            Node newNode = new Node(val);

            // If inserting at the end of list
            if (currNode == null) {
                prevNode.next = newNode;
                newNode.prev = prevNode;
            } else {
                // Inserting between prevNode and currNode
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = currNode;
                currNode.prev = newNode;
            }

            // Head remains unchanged unless insertion is at position 0
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
