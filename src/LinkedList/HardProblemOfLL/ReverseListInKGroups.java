package LinkedList.HardProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class ReverseListInKGroups {
    public static class Solution {
        public static Node kReverse(Node head, int k) {
            // Base case: if head is null, return null
            if (head == null) {
                return null;
            }

            Node tempNode = head;
            int count = 0;

            // Check if there are at least k nodes to reverse
            while (count < k && tempNode != null) {
                count++;
                tempNode = tempNode.next;
            }

            // If we have k nodes, reverse them
            if (count == k) {
                Node prevNode = null;
                Node currNode = head;
                Node nextNode = null;
                count = 0;

                // Reverse the first k nodes
                while (count < k && currNode != null) {
                    nextNode = currNode.next;
                    currNode.next = prevNode;
                    prevNode = currNode;
                    currNode = nextNode;
                    count++;
                }

                // Recursively call for the rest of the list and connect
                head.next = kReverse(tempNode, k);

                // prevNode is the new head of the reversed segment
                return prevNode;
            } else {
                // Less than k nodes remaining, no reversal needed
                return head;
            }
        }

    }
    public static void main(String[] args) {

    }
}

