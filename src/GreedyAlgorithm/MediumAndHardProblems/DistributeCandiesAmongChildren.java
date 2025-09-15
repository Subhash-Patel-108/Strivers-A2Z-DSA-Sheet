package GreedyAlgorithm.MediumAndHardProblems;

public class DistributeCandiesAmongChildren {
    public static class Solution {
        // Calculates the minimum number of candies needed for students based on their ratings
        public static int minimumCandies(int[] ratings) {
            // Handle edge case: return 0 if array is null or empty
            if (ratings == null || ratings.length == 0) {
                return 0;
            }

            int numStudents = ratings.length;
            int[] candiesLeftToRight = new int[numStudents];
            int[] candiesRightToLeft = new int[numStudents];

            // Assign candies from next to right based on ratings
            candiesLeftToRight[0] = 1; // First student gets at least 1 candy
            for (int i = 1; i < numStudents; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    // Higher rating than previous student, give one more candy
                    candiesLeftToRight[i] = candiesLeftToRight[i - 1] + 1;
                } else {
                    // Equal or lower rating, give minimum 1 candy
                    candiesLeftToRight[i] = 1;
                }
            }

            // Assign candies from right to next based on ratings
            candiesRightToLeft[numStudents - 1] = 1; // Last student gets at least 1 candy
            for (int i = numStudents - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    // Higher rating than next student, give one more candy
                    candiesRightToLeft[i] = candiesRightToLeft[i + 1] + 1;
                } else {
                    // Equal or lower rating, give minimum 1 candy
                    candiesRightToLeft[i] = 1;
                }
            }

            // Calculate total candies by taking the maximum for each student
            int totalCandies = 0;
            for (int i = 0; i < numStudents; i++) {
                totalCandies += Math.max(candiesLeftToRight[i], candiesRightToLeft[i]);
            }

            return totalCandies;
        }
    }

    public static void main(String[] args) {

    }
}
