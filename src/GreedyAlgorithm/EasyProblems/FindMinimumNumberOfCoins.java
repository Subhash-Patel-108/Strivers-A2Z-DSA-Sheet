package GreedyAlgorithm.EasyProblems;

import java.util.*;

public class FindMinimumNumberOfCoins {
    public static class Solution {
        // Returns the minimum coins needed to make up the given amount
        public static List<Integer> minimumCoins(int amount) {
            List<Integer> selectedCoins = new ArrayList<>();

            // Handle edge case: return empty list if amount is 0
            if (amount == 0) {
                return selectedCoins;
            }

            // Available coin denominations in ascending order
            int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

            // Process denominations from largest to smallest
            for (int i = denominations.length - 1; i >= 0; i--) {
                int currentCoin = denominations[i];
                // Calculate how many of the current coin can be used
                int coinCount = amount / currentCoin;
                if (coinCount > 0) {
                    // Add the coin to the result the required number of times
                    while (coinCount-- > 0) {
                        selectedCoins.add(currentCoin);
                    }
                    // Update remaining amount
                    amount %= currentCoin;
                }
            }

            return selectedCoins;
        }
    }

    public static void main(String[] args) {

    }
}
