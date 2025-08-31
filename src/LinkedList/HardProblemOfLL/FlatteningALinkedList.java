package LinkedList.HardProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class FlatteningALinkedList {
    public static class Solution {
        private static class Node {
            public int data ;
            public Node next ;
            public Node bottom ;

            public Node (int data) {
                this.data = data ;
                this.next = null ;
                this.bottom = null ;
            }
        };

        public static Node flatten(Node root) {
            //Edge case
            if(root == null ) {
                return null ;
            }

            Node head = root ;
            Node nextNode = root.next ;
            root.next = null ;

            while (nextNode != null) {
                Node tempNode = nextNode.next ;
                head = mergeTwoLists(head , nextNode) ;
                nextNode = tempNode ;
            }

            return head ;
        }

        private static Node mergeTwoLists(Node head1 , Node head2) {
            Node dummyHead = new Node(-1) ;
            Node tail = dummyHead ;

            while (head1 != null && head2 != null) {
                if(head1.data < head2.data) {
                    tail.bottom = head1 ;
                    head1 = head1.bottom ;
                }else{
                    tail.bottom = head2 ;
                    head2 = head2.bottom ;
                }
                tail = tail.bottom ;
            }

            tail.bottom = head1 != null ? head1 : head2 ;

            return dummyHead.bottom ;
        }
    }
    public static void main(String[] args) {

    }
}
