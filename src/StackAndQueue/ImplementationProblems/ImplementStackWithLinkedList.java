package StackAndQueue.ImplementationProblems;
import java.util.* ;
public class ImplementStackWithLinkedList {
    public static class Node {
        public int value ;
        public Node next ;

        //constructor
        public Node(int value) {
            this.value = value ;
            this.next = null ;
        }
    };


    static class Stack {
        private Node head ;
        private int size ;
        Stack() {
            head = null ;
            size = 0 ;
        }

        int getSize() {
            return size ;
        }

        boolean isEmpty() {
            return head == null ;
        }

        void push(int data) {
            size++ ;
            if(head == null) {
                head = new Node(data) ;
                return ;
            }
            Node newNode = new Node(data) ;
            newNode.next = head ;
            head = newNode ;
            return ;
        }

        void pop() {
            if(head == null) {
                return ;
            }
            size-- ;
            head = head.next ;
            return ;
        }

        int getTop() {
            return head == null ? -1 : head.value ;
        }
    }
    public static void main(String[] args) {

    }
}
