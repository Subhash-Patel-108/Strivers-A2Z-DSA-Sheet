package LinkedList.LearnDoublyLinkedList;

public class DeletionInDoublyLinkedList {
    public class Solution {
        //Node class for doubly linked list
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

        // Function to delete a node at a given position in a doubly linked list
        public static Node deleteNode(Node head, int pos) {
            // If the list is empty, there's nothing to delete
            if (head == null) {
                return head;
            }

            // If the node to be deleted is the head (position 0)
            if (pos == 0) {
                Node newHead = head.next;       // Move head to next node
                if (newHead != null) {
                    newHead.prev = null;        // Set prev of new head to null
                }
                head.next = null;               // Disconnect old head from the list
                return newHead;                 // Return new head
            }

            // Traverse to the node at the given position
            Node prevNode = null;
            Node currentNode = head;
            while (pos-- > 0 && currentNode != null) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            // If the position is out of range, return head unchanged
            if (currentNode == null) {
                return head;
            } else {
                // Remove currentNode from the list
                prevNode.next = currentNode.next;   // Link previous node to next node
                if (currentNode.next != null) {
                    currentNode.next.prev = prevNode; // Link next node's prev to previous node
                }
                currentNode.next = null;            // Disconnect currentNode's next pointer
                currentNode.prev = null;            // Disconnect currentNode's prev pointer

                return head;                        // Return the unchanged head
            }
        }

    }
    public static void main(String[] args) {

    }
}
