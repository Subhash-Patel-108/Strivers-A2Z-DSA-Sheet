package LinkedList.MediumProblemOfDLL;
//import LinkedList.LinkedListClasses.Node ;
public class DeleteAllTheOccurrenceOfKey {
    public static class Solution {
        private static class  Node{
            public int data;
            public Node next ;
            public Node prev ;

            public Node(int data) {
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
        }
        public static Node deleteAllOccurrences(Node head, int key) {
            // Edge case: if list is empty
            if (head == null) {
                return null;
            }

            // Remove leading nodes whose data matches the key
            while (head != null && head.data == key) {
                head = head.next;
            }

            // If list became empty after removing leading key nodes
            if (head == null) {
                return null;
            }

            // Set the prev pointer of the new head to null
            head.prev = null;

            Node currNode = head;
            // Traverse through the list
            while (currNode != null) {
                if (currNode.data == key) {
                    Node prevNode = currNode.prev;
                    Node nextNode = currNode.next;

                    // Remove current node by linking previous with next node
                    prevNode.next = nextNode;
                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }

                    // Move current to nextNode after deletion
                    currNode = nextNode;
                } else {
                    currNode = currNode.next;
                }
            }

            // Return updated head of the list
            return head;
        }

    }
    public static void main(String[] args) {

    }
}
