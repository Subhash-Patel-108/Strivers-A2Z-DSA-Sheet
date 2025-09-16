package StackAndQueue.ImplementationProblems;

public class StackImplementationUsingArray {
    public class Solution{
        // Implements a stack data structure using an array
        static class Stack {
            private final int[] elements; // Array to store stack elements
            private int topIndex; // Index of the top element
            private final int capacity; // Maximum capacity of the stack

            // Constructor to initialize the stack with given capacity
            Stack(int capacity) {
                this.elements = new int[capacity];
                this.topIndex = -1; // MinStackClass is initially empty
                this.capacity = capacity;
            }

            // Pushes an element onto the stack
            public void push(int value) {
                // Check if stack is full
                if (isFull()) {
                    return; // Do nothing if stack is full
                }
                topIndex++;
                elements[topIndex] = value;
            }

            // Pops and returns the top element from the stack
            public int pop() {
                // Check if stack is empty
                if (isEmpty()) {
                    return -1; // Return -1 for empty stack
                }
                int topValue = elements[topIndex];
                topIndex--;
                return topValue;
            }

            // Returns the top element without removing it
            public int top() {
                return isEmpty() ? -1 : elements[topIndex];
            }

            // Checks if the stack is empty
            public boolean isEmpty() {
                return topIndex == -1;
            }

            // Checks if the stack is full
            public boolean isFull() {
                return topIndex == capacity - 1;
            }
        }
    }
    public static void main(String[] args) {

    }
}
