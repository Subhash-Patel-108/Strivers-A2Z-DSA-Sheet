package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node;
public class PalindromeCheck {
    public class Solution {
        private static Node slowPointer ;
        private static Node fastPointer ;
        // Function to check if a linked list is a palindrome
        public static boolean isPalindrome(Node head) {
            //Edge case
            if(head == null || head.next == null) {
                return true ;
            }
            slowPointer = head ;
            fastPointer = head ;

            findMiddle() ;//find the middle of the linked list where the slow pointer pointing to the middle

            Node secondHalf = slowPointer.next ;
            slowPointer.next = null ;

            secondHalf = reverseTheLinkedList(secondHalf) ;

            return checkLinkedListAreSame(head , secondHalf) ;
        }

        //function to find the middle of the linked list
        private static void findMiddle() {
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next ;
                fastPointer = fastPointer.next.next ;
            }
            return ;
        }

        //Function to reverse the linked list
        private static Node reverseTheLinkedList(Node head) {
            Node prevNode = null ;
            Node currentNode = head ;
            Node nextNode ;

            while (currentNode != null) {
                nextNode = currentNode.next ;
                currentNode.next = prevNode ;
                prevNode = currentNode ;
                currentNode = nextNode;
            }
            return prevNode ;
        }

        //function to check whether the given two Linked list are same (values)
        private static boolean checkLinkedListAreSame(Node head1, Node head2) {
            Node currentNode1 = head1 ;
            Node currentNode2 = head2 ;

            while (currentNode1 != null && currentNode2 != null ) {
                if(currentNode1.data != currentNode2.data) {
                    return false ;
                }
                currentNode1 = currentNode1.next ;
                currentNode2 = currentNode2.next ;
            }
            return true ;
        }
    }
    public static void main(String[] args) {

    }
}
