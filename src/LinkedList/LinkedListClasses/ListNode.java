package LinkedList.LinkedListClasses;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = 0;
        next = null;
    }

    public ListNode(int data1) {
        val = data1;
        next = null;
    }

    public ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
