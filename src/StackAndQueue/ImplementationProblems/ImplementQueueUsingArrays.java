package StackAndQueue.ImplementationProblems;

public class ImplementQueueUsingArrays {
    public static class Queue {
        private int frontIndex; // Index of the front element
        private int rearIndex;  // Index of the rear element
        private int[] elements; // Array to store queue elements

        // Constructor to initialize an empty queue with a fixed capacity
        Queue() {
            frontIndex = -1; // Indicates empty queue
            rearIndex = -1;  // Indicates empty queue
            elements = new int[100001]; // Fixed-size array for queue
        }

        // Enqueues (adds) an element to the rear of the queue
        public void enqueue(int value) {
            // Check if queue is full
            if (rearIndex == elements.length - 1) {
                return; // Do nothing if queue is full
            }
            // If queue is empty, initialize front index
            if (rearIndex == -1) {
                frontIndex = 0;
            }
            rearIndex++;
            elements[rearIndex] = value;
        }

        // Dequeues (removes and returns) the element from the front of the queue
        public int dequeue() {
            // Check if queue is empty
            if (rearIndex == -1 || frontIndex > rearIndex) {
                return -1; // Return -1 for empty queue
            }
            int frontValue = elements[frontIndex];
            frontIndex++;
            // Reset indices if queue becomes empty
            if (frontIndex > rearIndex) {
                frontIndex = -1;
                rearIndex = -1;
            }
            return frontValue;
        }
    }
    public static void main(String[] args) {

    }
}
