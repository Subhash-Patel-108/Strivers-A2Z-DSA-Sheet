package Heap.MediumProblems;

import java.util.* ;
public class MergeKSortedLinkedList {
    public static class ListNode {
        public int val ;
        public ListNode next ;

        //constructor
        public ListNode(int data ){
            this.val = data ;
            this.next = null ;
        }
    }

    //Time Complexity : O(N.K)
    public static class Solution1 {
        private ListNode mergeLinkedList(ListNode list1, ListNode list2) {
            // Create a dummy node to simplify list building.
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;

            // Merge nodes from both lists.
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            }

            // Attach any remaining nodes.
            tail.next = (list1 != null) ? list1 : list2;

            // Return the head of the merged list.
            return dummyHead.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            // Handle empty input.
            if (lists.length == 0) {
                return null;
            }

            // Iteratively merge all lists.
            ListNode mergedListHead = lists[0];
            for (int i = 1; i < lists.length; i++) {
                mergedListHead = mergeLinkedList(mergedListHead, lists[i]);
            }

            return mergedListHead;
        }
    }

    //Time Complexity : O(NlogN) using heap
    public static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // Handle edge cases: if the array is null or empty, there's nothing to merge.
            if (lists == null || lists.length == 0) {
                return null;
            }

            // Use a min-heap to efficiently get the smallest node from all lists.
            // The comparator sorts nodes based on their integer value.
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

            // Create a dummy head to simplify building the new list.
            // The tail pointer will be used to append nodes.
            ListNode dummyHead = new ListNode(-1);
            ListNode tail = dummyHead;

            // Add the head of each linked list to the min-heap.
            // Only add non-null lists to avoid errors.
            for (ListNode node : lists) {
                if (node != null) {
                    minHeap.offer(node);
                }
            }

            // While the heap is not empty, merge the lists.
            while (!minHeap.isEmpty()) {
                // Get the node with the smallest value from the heap.
                ListNode smallestNode = minHeap.poll();

                // Append this node to the merged list.
                tail.next = smallestNode;
                // Move the tail pointer to the newly added node.
                tail = tail.next;

                // If the current node has a next node, add it to the heap.
                // This ensures the heap always has the next available nodes from each list.
                if (smallestNode.next != null) {
                    minHeap.offer(smallestNode.next);
                }
            }

            // After the loop, the last node in the merged list should point to null.
            tail.next = null;

            // The merged list starts after the dummy head.
            return dummyHead.next;
        }
    }


    public static void main(String[] args) {

    }
}
