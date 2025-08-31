package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class DeleteKthNodeFromEnd {
    public static class Solution {
        public static Node removeKthNode(Node head, int K) {
            Node curr = head;
            int count = 0;

            // Count the total number of nodes in the list
            while (curr != null) {
                curr = curr.next;
                count++;
            }

            // If K equals the length of the list, remove the head node
            if (count == K) {
                return head.next;
            }

            // Find the (count - K)th node (node before the one to be deleted)
            int steps = count - K;
            curr = head;
            steps--;

            // Traverse to the node before the node to delete
            while (steps-- > 0) {
                curr = curr.next;
            }

            // Skip the Kth node from the end to remove it
            curr.next = curr.next.next;

            // Return the head of the modified list
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
