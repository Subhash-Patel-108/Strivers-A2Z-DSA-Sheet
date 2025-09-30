package Sorting.MediumQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/mergesort-linked-list_630514?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class MergeSortLinkedList {

    public static class Solution {

        private static class Node <T> {
            public T data ;
            public Node<T> next ;

            public Node (T data ) {
                this.data = data ;
                this.next = null ;
            }
        };

        public static Node<Integer> mergeSort(Node<Integer> head) {
            //Edge case
            if(head == null || head.next == null ) {
                return head ;
            }

            head = mergeSortOnLinkedList(head) ;
            return head ;
        }

        private static Node<Integer> mergeSortOnLinkedList(Node<Integer> head) {
            //Base case
            if (head == null || head.next == null) {
                return head ;
            }

            Node <Integer> midNode = getMidNode(head) ;

            Node<Integer> leftNode = mergeSortOnLinkedList(head) ;
            Node<Integer> rightNode = mergeSortOnLinkedList(midNode) ;

            return mergeTwoSortedLinkedList(leftNode, rightNode) ;
        }

        private static Node<Integer> getMidNode(Node<Integer> head) {
            Node<Integer> midPrev = null ;
            Node<Integer> fastNode = head ;

            while (fastNode != null && fastNode.next != null) {
                midPrev = midPrev == null ? head : midPrev.next ;
                fastNode = fastNode.next.next ;
            }

            Node newHead = midPrev.next ;
            midPrev.next = null ;

            return newHead ;
        }

        private static Node<Integer> mergeTwoSortedLinkedList(Node<Integer> leftHead , Node<Integer> rightHead) {
            //Dummy node
            Node <Integer> dummyHead = new Node<>(-1);
            Node <Integer> tailNode = dummyHead ;

            while (leftHead != null && rightHead != null) {
                if(leftHead.data <= rightHead.data) {
                    tailNode.next = leftHead ;
                    leftHead = leftHead.next ;
                }else{
                    tailNode.next = rightHead ;
                    rightHead = rightHead.next ;
                }

                tailNode = tailNode.next ;
            }

            tailNode.next = rightHead != null ? rightHead : leftHead ;

            return dummyHead.next ;
        }
    }

    public static void main(String[] args) {

    }
}
