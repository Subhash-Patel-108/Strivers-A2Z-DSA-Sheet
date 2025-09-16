package StackAndQueue.ImplementationProblems;

public class ImplementQueueUsingLinkedList {
    // Represents a node in the linked list used for the queue
    public static class QueueNode {
        public int value; // Value stored in the node
        public QueueNode next; // Reference to the next node

        // Constructor to initialize the node with a value
        public QueueNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Implements a queue using a linked list
    class MyQueue {
        private QueueNode front; // Points to the front node of the queue
        private QueueNode rear; // Points to the rear node of the queue

        // Constructor to initialize an empty queue
        public MyQueue() {
            this.front = null;
            this.rear = null;
        }

        // Pushes an element to the rear of the queue
        void push(int value) {
            // Create a new node with the given value
            QueueNode newNode = new QueueNode(value);
            // If queue is empty, set both front and rear to the new node
            if (rear == null) {
                front = rear = newNode;
            } else {
                // Add new node at the rear and update rear pointer
                rear.next = newNode;
                rear = newNode;
            }
        }

        // Pops and returns the front element from the queue
        int pop() {
            // Handle empty queue case
            if (front == null) {
                return -1; // Return -1 if queue is empty
            }
            // Store front value to return
            int frontValue = front.value;
            // Move front to the next node
            front = front.next;
            // If queue becomes empty, reset rear to null
            if (front == null) {
                rear = null;
            }
            return frontValue;
        }
    }
    public static void main(String[] args) {

    }
}
