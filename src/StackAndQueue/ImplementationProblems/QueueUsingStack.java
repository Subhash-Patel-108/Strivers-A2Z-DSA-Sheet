package StackAndQueue.ImplementationProblems;
import java.util.* ;
public class QueueUsingStack {
    // Implements a queue using two stacks
    static class Queue {
        private Stack<Integer> primaryStack; // Main stack to store queue elements
        private Stack<Integer> secondaryStack; // Temporary stack for reordering elements

        // Constructor to initialize the queue with two empty stacks
        Queue() {
            primaryStack = new Stack<>();
            secondaryStack = new Stack<>();
        }

        // Enqueues (adds) a value to the rear of the queue
        void enqueue(int value) {
            // Move all elements from primaryStack to secondaryStack to reverse order
            while (!primaryStack.isEmpty()) {
                secondaryStack.push(primaryStack.pop());
            }

            // Add the new value to the bottom of primaryStack
            primaryStack.push(value);

            // Move all elements back from secondaryStack to primaryStack
            while (!secondaryStack.isEmpty()) {
                primaryStack.push(secondaryStack.pop());
            }
        }

        // Dequeues (removes and returns) the front element of the queue
        int dequeue() {
            // Return -1 if queue is empty, otherwise pop the top element
            return primaryStack.isEmpty() ? -1 : primaryStack.pop();
        }

        // Returns the front element without removing it
        int peek() {
            // Return -1 if queue is empty, otherwise peek at the top element
            return primaryStack.isEmpty() ? -1 : primaryStack.peek();
        }

        // Checks if the queue is empty
        boolean isEmpty() {
            return primaryStack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
