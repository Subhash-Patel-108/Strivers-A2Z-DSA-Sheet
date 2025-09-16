package StackAndQueue.ImplementationProblems;
import java.util.* ;
public class MinStack {
    public static class Solution {
        private static class Pair {
            public int value ;
            public int minValue ;

            //constructor
            public Pair (int value , int minValue) {
                this.value = value ;
                this.minValue = minValue ;
            }
        }
        static class MinStackClass {
            private static Stack<Pair> stack ;
            // Constructor
            MinStackClass() {
                stack = new Stack<>() ;
            }

            // Function to add another element equal to num at the top of stack.
            void push(int num) {
                if(stack.isEmpty()) {
                    stack.push(new Pair(num , num)) ;
                    return ;
                }
                int minValue = Math.min(stack.peek().minValue , num) ;
                stack.push(new Pair(num , minValue)) ;
                return ;
            }

            // Function to remove the top element of the stack.
            int pop() {
                //if the stack is empty
                if(stack.isEmpty()) {
                    return -1 ;
                }

                return stack.pop().value ;
            }

            // Function to return the top element of stack if it is present. Otherwise
            // return -1.
            int top() {
                //if the stack is Empty
                if(stack.isEmpty()) {
                    return -1 ;
                }
                return stack.peek().value ;
            }

            // Function to return minimum element of stack if it is present. Otherwise
            // return -1.
            int getMin() {
                //if the stack is empty
                if(stack.isEmpty()) {
                    return -1 ;
                }

                return stack.peek().minValue ;
            }
        }
    }
    public static void main(String[] args) {

    }
}
