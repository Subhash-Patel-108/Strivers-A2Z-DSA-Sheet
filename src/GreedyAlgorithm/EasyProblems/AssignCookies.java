package GreedyAlgorithm.EasyProblems;

import java.util.Arrays;

public class AssignCookies {
    public static class Solution {
        // Assigns cookies to children based on their greed factor, maximizing satisfied children
        public static int assignCookies(int[] greedFactors, int[] cookieSizes) {
            // Handle edge case: return 0 if either array is null
            if (greedFactors == null || cookieSizes == null) {
                return 0;
            }

            // Sort arrays to process smallest greed factors and cookie sizes first
            Arrays.sort(greedFactors);
            Arrays.sort(cookieSizes);

            int childIndex = 0, cookieIndex = 0;
            int satisfiedChildren = 0;

            // Assign cookies to children while both arrays have elements
            while (childIndex < greedFactors.length && cookieIndex < cookieSizes.length) {
                // If current cookie can satisfy current child's greed, assign it
                if (greedFactors[childIndex] <= cookieSizes[cookieIndex]) {
                    childIndex++;
                    satisfiedChildren++;
                }
                // Move to next cookie regardless of assignment
                cookieIndex++;
            }

            return satisfiedChildren;
        }

    }
    public static void main(String[] args) {

    }
}
