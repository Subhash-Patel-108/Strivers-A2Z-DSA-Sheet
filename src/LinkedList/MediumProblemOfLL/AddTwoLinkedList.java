package LinkedList.MediumProblemOfLL;
import LinkedList.LinkedListClasses.ListNode ;
public class AddTwoLinkedList {
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode current1 = l1;
            ListNode current2 = l2;
            ListNode dummyHead = new ListNode(0); // Dummy head for result list
            ListNode current = dummyHead;
            int carry = 0;

            // Iterate as long as there are nodes next in both lists
            while (current1 != null && current2 != null) {
                int sum = current1.val + current2.val + carry; // Sum digits and carry
                carry = sum / 10;                             // Calculate carry for next digit
                current.next = new ListNode(sum % 10);       // Create node for current digit
                current = current.next;
                current1 = current1.next;
                current2 = current2.next;
            }

            // Process remaining digits in l1 if any
            while (current1 != null) {
                int sum = current1.val + carry;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                current1 = current1.next;
            }

            // Process remaining digits in l2 if any
            while (current2 != null) {
                int sum = current2.val + carry;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                current2 = current2.next;
            }

            // If carry is still present after processing all digits, add a new node for it
            while (carry > 0) {
                current.next = new ListNode(carry % 10);
                carry /= 10;
                current = current.next;
            }

            // Return the sum list, skipping the dummy head
            return dummyHead.next;
        }

    }

    public static void main(String[] args) {

    }
}
