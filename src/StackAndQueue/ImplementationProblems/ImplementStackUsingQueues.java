package StackAndQueue.ImplementationProblems;
import java.util.* ;
public class ImplementStackUsingQueues {
    // Implements a stack using two queues
    static class Stack {
        private Queue<Integer> primaryQueue; // Main queue for stack operations
        private Queue<Integer> secondaryQueue; // Helper queue for reordering elements
        private int topValue; // Tracks the top element of the stack

        // Constructor to initialize the stack with two empty queues
        public Stack() {
            this.primaryQueue = new LinkedList<>();
            this.secondaryQueue = new LinkedList<>();
            this.topValue = -1; // Indicates empty stack
        }

        // Returns the current size of the stack
        public int getSize() {
            // Return size of non-empty queue (only one queue holds elements at a time)
            return primaryQueue.isEmpty() ? secondaryQueue.size() : primaryQueue.size();
        }

        // Checks if the stack is empty
        public boolean isEmpty() {
            return primaryQueue.isEmpty() && secondaryQueue.isEmpty();
        }

        // Pushes an element onto the stack
        public void push(int value) {
            topValue = value; // Update top element
            // Add to the non-empty queue (primaryQueue or secondaryQueue)
            if (!primaryQueue.isEmpty()) {
                primaryQueue.offer(value);
            } else {
                secondaryQueue.offer(value);
            }
        }

        // Pops and returns the top element from the stack
        public int pop() {
            // Handle edge case: empty stack
            if (isEmpty()) {
                return -1;
            }

            int removedValue;
            if (primaryQueue.isEmpty()) {
                // Process secondaryQueue: move all but last element to primaryQueue
                while (secondaryQueue.size() > 1) {
                    int element = secondaryQueue.poll();
                    topValue = element; // Update top to the last moved element
                    primaryQueue.offer(element);
                }
                removedValue = secondaryQueue.poll(); // Remove and return the last element
            } else {
                // Process primaryQueue: move all but last element to secondaryQueue
                while (primaryQueue.size() > 1) {
                    int element = primaryQueue.poll();
                    topValue = element; // Update top to the last moved element
                    secondaryQueue.offer(element);
                }
                removedValue = primaryQueue.poll(); // Remove and return the last element
            }

            // Reset topValue if stack becomes empty
            if (isEmpty()) {
                topValue = -1;
            }

            return removedValue;
        }

        // Returns the top element without removing it
        public int top() {
            return topValue;
        }
    }
    public static void main(String[] args) {

    }
}
