package LinkedList.Learn1DLinkedList;
import LinkedList.LinkedListClasses.ListNode;

public class InsertionAtTheHeadOfLL {
    public static class Solution {
        public ListNode insertAtHead(ListNode head, int X) {
            //Edge case
            if(head == null) {
                return new ListNode(X) ;
            }else{
                ListNode newNode = new ListNode(X); // creating new node
                newNode.next = head ;//linking the new node with the head
                return head ;
            }
        }
    }
    public static void main(String[] args) {

    }
}
