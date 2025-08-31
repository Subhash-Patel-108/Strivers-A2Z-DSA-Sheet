package LinkedList.HardProblemOfLL;

import java.awt.font.GraphicAttribute;
import java.util.* ;
public class CopyListWithRandomPointer {
    public class Solution {

        private static class Node {
            public int data ;
            public Node next ;
            public Node random ;

            public Node (int data) {
                this.data = data ;
                this.next = null ;
                this.random = null ;
            }
        };

        // Function to clone a linked list with next and random pointers
        public static Node cloneLL(Node head) {
            // Edge case: if the original list is empty, return null
            if (head == null) {
                return null;
            }

            // Step 1: Make a normal copy of the linked list with next pointers only
            Node copyHead = copyTheList(head);

            // Step 2: Copy the random pointers from the original list to the copied list
            copyHead = copyTheListWithRandomPointers(head, copyHead);

            // Return the head of the fully copied list including random pointers
            return copyHead;
        }

        // Function to copy the linked list nodes and next pointers only (without random pointers)
        private static Node copyTheList(Node head) {
            Node copyHead = new Node(-1);  // Dummy node to simplify list building
            Node copyTail = copyHead;

            Node currNode = head;

            // Traverse the original list and create new nodes copying the data
            while (currNode != null) {
                copyTail.next = new Node(currNode.data);  // Create new node
                currNode = currNode.next;                  // Move forward in original list
                copyTail = copyTail.next;                  // Move forward in copied list
            }

            // Return the real head of the copied list (next of the dummy node)
            return copyHead.next;
        }

        // Function to copy random pointers from original list to the copied list
        private static Node copyTheListWithRandomPointers(Node head, Node copyHead) {
            Node copyTail = copyHead;
            Node tail = head;

            // Traverse both lists simultaneously
            while (tail != null) {
                // For each node in the copied list, find and assign correct random pointer
                copyTail.random = findTheRandomPointer(head, copyHead, tail.random);
                tail = tail.next;
                copyTail = copyTail.next;
            }

            return copyHead;
        }

        // Helper function to find the corresponding node in the copy list for a given random pointer in the original
        private static Node findTheRandomPointer(Node head, Node copyHead, Node randomPointer) {
            // If the original random pointer is null, return null in copy list
            if (randomPointer == null) {
                return null;
            }

            // Traverse original and copied lists simultaneously until original pointer matches the random pointer node
            while (head != randomPointer) {
                head = head.next;
                copyHead = copyHead.next;
            }

            // Return the node in copied list that corresponds to random pointer
            return copyHead;
        }
    }

    public static class Solution2 {

        private static class Node {
            public int data ;
            public Node next ;
            public Node random ;

            public Node (int data) {
                this.data = data ;
                this.next = null ;
                this.random = null ;
            }
        };

        private static HashMap <Node , Node> nodesMap ;
        // Function to clone a linked list with next and random pointers
        public static Node cloneLL(Node head) {
            // Edge case: if the original list is empty, return null
            if (head == null) {
                return null;
            }
            nodesMap = new HashMap<>() ;

            // Step 1: Make a normal copy of the linked list with next pointers only
            Node copyHead = copyTheList(head);

            // Step 2: Copy the random pointers from the original list to the copied list
            copyHead = copyTheListWithRandomPointers(head, copyHead);

            // Return the head of the fully copied list including random pointers
            return copyHead;
        }

        // Function to copy the linked list nodes and next pointers only (without random pointers)
        private static Node copyTheList(Node head) {
            Node copyHead = new Node(-1);  // Dummy node to simplify list building
            Node copyTail = copyHead;

            Node currNode = head;

            // Traverse the original list and create new nodes copying the data
            while (currNode != null) {
                copyTail.next = new Node(currNode.data);  // Create new node
                nodesMap.put(currNode , copyTail.next) ; // mapping the nodes
                currNode = currNode.next;                  // Move forward in original list
                copyTail = copyTail.next;                  // Move forward in copied list
            }

            // Return the real head of the copied list (next of the dummy node)
            return copyHead.next;
        }

        // Function to copy random pointers from original list to the copied list
        private static Node copyTheListWithRandomPointers(Node head, Node copyHead) {
            Node copyTail = copyHead;
            Node tail = head;

            // Traverse both lists simultaneously
            while (tail != null) {
                // For each node in the copied list, find and assign correct random pointer
                copyTail.random = findTheRandomPointer(head, copyHead, tail.random);
                tail = tail.next;
                copyTail = copyTail.next;
            }

            return copyHead;
        }

        // Helper function to find the corresponding node in the copy list for a given random pointer in the original
        private static Node findTheRandomPointer(Node head, Node copyHead, Node randomPointer) {
            // If the original random pointer is null, return null in copy list
            if (randomPointer == null) {
                return null;
            }
            return nodesMap.get(randomPointer) ;
        }

    }
    public static void main(String[] args) {

    }
}
