package LinkedList.Learn1DLinkedList;
import LinkedList.LinkedListClasses.Node;
public class DeleteInASinglyLinkedList {
    public static class Solution {
        Node deleteNode(Node head, int x) {
            //edge case
            if(head == null){
                return null ;
            }
            if(x == 1) {
                return head.next ;
            }
            Node prevNode = null ;
            Node currentNode = head ;
            while (--x > 0 && currentNode != null ) {
                prevNode = currentNode ;
                currentNode = currentNode.next ;
            }
            if(currentNode != null) {
                prevNode.next = currentNode.next ;
            }
            return head ;
        }
    }
    public static void main(String[] args) {

    }
}
