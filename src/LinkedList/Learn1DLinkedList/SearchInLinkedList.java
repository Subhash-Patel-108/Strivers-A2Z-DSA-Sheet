package LinkedList.Learn1DLinkedList;
import LinkedList.LinkedListClasses.Node;
public class SearchInLinkedList {
    public static class Solution {
        public boolean searchKey(Node head, int key) {
           Node currentNode = head ;
           while (currentNode != null) {
               //if the node data is equal to the key then return true
               if(currentNode.data == key) {
                   return true ;
               }
               currentNode = currentNode.next ;
           }
           return false ; // the value is not present in the linkedList
        }
    }
    public static void main(String[] args) {

    }
}
