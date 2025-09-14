package Heap.MediumProblems;

import java.util.Arrays;

public class HandsOfStraights {

    public class Solution {
        static boolean isStraightHand(int N, int groupSize, int hand[]) {
            // Edge case: Hand is null or not divisible by groupSize.
            if (hand == null || hand.length % groupSize != 0) {
                return false;
            }

            // Sort the hand to easily find consecutive cards.
            Arrays.sort(hand);

            // Iterate through the sorted hand to find the start of each group.
            for (int i = 0; i < hand.length; i++) {
                // Only consider cards that haven't been used (value > 0).
                if (hand[i] > 0) {
                    if (!checkIsStraightHand(hand, groupSize, i)) {
                        return false;
                    }
                }
            }

            return true;
        }

        private static boolean checkIsStraightHand(int[] hand, int groupSize, int startIndex) {
            // Get the first card and mark it as used.
            int currentNumber = hand[startIndex];
            hand[startIndex] = -1;
            int count = 1;

            // Find the remaining consecutive cards in the hand.
            for (int j = startIndex + 1; j < hand.length && count < groupSize; j++) {
                if (hand[j] == currentNumber + 1) {
                    // Mark the found card as used.
                    hand[j] = -1;
                    count++;
                    currentNumber++;
                }
            }

            // Check if a full straight hand was formed.
            return count == groupSize;
        }
    }

    public static void main(String[] args) {

    }
}
