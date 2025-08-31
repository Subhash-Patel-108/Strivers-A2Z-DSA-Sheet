package LinkedList.MediumProblemOfDLL;

public class RemoveDuplicatesFromASortedDoublyLinkedList {
    public static class Solution {
        private static class Node {
            public int data ;
            public Node next ;
            public Node prev ;

            //Constructor
            public Node(int data) {
                this.data = data ;
                this.next = null ;
                this.prev = null ;
            }
        };

        //Function to remove the duplicate element from the doubly linked list
        public static Node removeDuplicates(Node head) {
            //Edge case
            if(head == null || head.next == null) {
                return head ;
            }
            Node currNode = head.next ;
            Node prevNode = head ;
            while (currNode != null ) {
                if(prevNode.data == currNode.data) {
                    Node nextNode = currNode.next ;
                    prevNode.next = nextNode ;
                    if(nextNode != null) {
                        nextNode.prev = prevNode ;
                    }
                    currNode = nextNode ;
                }else{
                    prevNode = currNode ;
                    currNode = currNode.next ;
                }
            }
            return head ;

        }
    }
    public static void main(String[] args) {

    }
}
