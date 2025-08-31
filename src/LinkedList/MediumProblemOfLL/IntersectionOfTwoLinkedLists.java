package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.Node ;
public class IntersectionOfTwoLinkedLists {
    public static class Solution {
        // Returns the data of the intersection node or -1 if no intersection
        public static int findIntersection(Node firstHead, Node secondHead) {
            int first_size = 0, second_size = 0;
            Node curr = firstHead;

            // Calculate length of first linked list
            while (curr != null) {
                first_size++;
                curr = curr.next;
            }

            // Calculate length of second linked list
            curr = secondHead;
            while (curr != null) {
                second_size++;
                curr = curr.next;
            }

            // Advance the head of the longer list by the difference in lengths
            if (first_size > second_size) {
                return findTheNode(firstHead, secondHead, first_size - second_size);
            } else {
                return findTheNode(secondHead, firstHead, second_size - first_size);
            }
        }

        // Advance head1 by count nodes, then move both heads together until intersection is found
        private static int findTheNode(Node head1, Node head2, int count) {
            while (count-- > 0 && head1 != null) {
                head1 = head1.next;
            }
            // Move both lists simultaneously until intersection node found or end reached
            while (head1 != null && head2 != null) {
                if (head1 == head2) {
                    return head1.data;  // Return the data of intersection node
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return -1;  // No intersection found
        }
    }
    public static void main(String[] args) {

    }
}
