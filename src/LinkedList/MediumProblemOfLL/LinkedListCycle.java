package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.ListNode;
public class LinkedListCycle {
    public static class Solution {
        // Function to detect if a linked list has a cycle
        public boolean hasCycle(ListNode head) {
            // Edge case: if the list is empty, it cannot have a cycle
            if (head == null) {
                return false;
            }

            ListNode slowPointer = head;  // Moves one step at a time
            ListNode fastPointer = head;  // Moves two steps at a time

            // Traverse the list with slow and fast pointers
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;           // Move slow pointer by 1 step
                fastPointer = fastPointer.next.next;      // Move fast pointer by 2 steps

                // If slow and fast meet, a cycle exists
                if (slowPointer == fastPointer) {
                    return true;
                }
            }

            // If fast pointer reaches the end, no cycle exists
            return false;
        }

    }
    public static void main(String[] args) {

    }
}
