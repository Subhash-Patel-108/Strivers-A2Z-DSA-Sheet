package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class SortLinkedListOf0s1s2s {
    public static class Solution {
        public static Node sortList(Node head) {
            if (head == null) {
                return null;
            }

            // Dummy heads for three separate lists for 0s, 1s, and 2s
            Node zerosHead = new Node(0);
            Node onesHead = new Node(0);
            Node twosHead = new Node(0);

            // Tails to keep track of last node in each list
            Node zerosTail = zerosHead;
            Node onesTail = onesHead;
            Node twosTail = twosHead;

            Node curr = head;

            // Traverse original list and append nodes to corresponding list
            while (curr != null) {
                if (curr.data == 0) {
                    zerosTail.next = curr;
                    zerosTail = zerosTail.next;
                } else if (curr.data == 1) {
                    onesTail.next = curr;
                    onesTail = onesTail.next;
                } else {
                    twosTail.next = curr;
                    twosTail = twosTail.next;
                }
                curr = curr.next;
            }

            // Connect the 0s list to 1s list, and 1s list to 2s list
            zerosTail.next = onesHead.next != null ? onesHead.next : twosHead.next;
            onesTail.next = twosHead.next;
            twosTail.next = null; // End the final list

            // Return the head of the sorted linked list
            return zerosHead.next;
        }
    }
    public static void main(String[] args) {

    }
}
