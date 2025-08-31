package LinkedList.Learn1DLinkedList;
import LinkedList.LinkedListClasses.Node;
public class FindTheLengthOfTheLinkedList {
    public static class Solution {
        public int getCount(Node head) {
            int count = 0 ;
            Node currentNode = head ;
            while (currentNode != null) {
                count ++ ;
                currentNode = currentNode.next ;
            }
            return count ;
        }
    }
    public static void main(String[] args) {

    }
}
