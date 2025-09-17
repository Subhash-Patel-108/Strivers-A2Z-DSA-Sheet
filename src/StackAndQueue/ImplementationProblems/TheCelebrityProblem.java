package StackAndQueue.ImplementationProblems;

import java.util.Stack;

public class TheCelebrityProblem {
    public static class Solution {
        // Finds the celebrity in a party, if one exists, using a matrix representation
        public int findCelebrity(int[][] knowsMatrix) {
            // Handle edge case: return 0 if matrix is null or empty
            if (knowsMatrix == null || knowsMatrix.length == 0) {
                return 0;
            }

            //Initialize stack with all potential celebrity indices
            Stack<Integer> candidates = new Stack<>();
            for (int i = 0; i < knowsMatrix.length; i++) {
                candidates.push(i);
            }

            // Eliminate non-celebrities by comparing pairs
            while (candidates.size() > 1) {
                // Pop two people to compare
                int person1 = candidates.pop();
                int person2 = candidates.pop();

                // If person1 doesn't know person2, person1 could be a celebrity
                if (knowsMatrix[person1][person2] == 0) {
                    candidates.push(person1);
                } else {
                    // If person1 knows person2, person2 could be a celebrity
                    candidates.push(person2);
                }
            }

            // Get the potential celebrity
            int potentialCelebrity = candidates.pop();
            // Verify if this person is a celebrity
            for (int col = 0; col < knowsMatrix[potentialCelebrity].length; col++) {
                // Check if everyone knows the celebrity (except themselves)
                if (knowsMatrix[col][potentialCelebrity] == 0 && col != potentialCelebrity) {
                    return -1; // Not a celebrity if someone doesn't know them
                }
                // Check if the celebrity knows anyone (except themselves)
                if (knowsMatrix[potentialCelebrity][col] == 1 && potentialCelebrity != col) {
                    return -1; // Not a celebrity if they know someone
                }
            }

            // Return the celebrity's index
            return potentialCelebrity;
        }
    }
    public static void main(String[] args) {

    }
}
