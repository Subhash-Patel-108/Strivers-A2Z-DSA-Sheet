package Sorting.MediumQuestions;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
    public static class Pair {
        public int weight ;
        public int value;

        public Pair(int weight , int value) {
            this.weight = weight ;
            this.value = value;
        }
    };

    public static class Solution {

        // Class to store item weight, price, and price per unit weight
        private static class Tuple {
            public int weight;
            public int price;
            public double pricePerUnit;

            // Constructor to initialize weight, price, and calculate price per unit
            public Tuple(int weight, int price) {
                this.weight = weight;
                this.price = price;
                double currPricePerUnit = (double) price / weight;
                this.pricePerUnit = currPricePerUnit;
            }
        }

        public static double maximumValue(Pair[] items, int n, int w) {
            // Handle edge case: null items, zero items, or zero weight returns 0.0
            if (items == null || n == 0 || w == 0) {
                return 0.0;
            }

            // Initialize maximum value achievable
            double maxValue = 0;
            // Create list to store tuples of items
            ArrayList<Tuple> tupleList = new ArrayList<>();
            // Populate tuple list with items
            for (int idx = 0; idx < n; idx++) {
                tupleList.add(new Tuple(items[idx].weight, items[idx].value));
            }

            // Sort tuples by price per unit in descending order
            Collections.sort(tupleList, (a, b) -> Double.compare(b.pricePerUnit, a.pricePerUnit));

            // Initialize index for iteration
            int idx = 0;
            // Process items while capacity remains and items are available
            while (w > 0 && idx < n) {
                // Get current item
                Tuple currPackage = tupleList.get(idx);
                int packageWeight = currPackage.weight;
                int packagePrice = currPackage.price;
                double pricePerUnit = currPackage.pricePerUnit;

                // If item fits fully, include entire item
                if (packageWeight <= w) {
                    maxValue += packagePrice;
                    w -= packageWeight;
                } else {
                    // If item doesn't fit, include fractional part
                    maxValue += pricePerUnit * w;
                    break;
                }
                idx++;
            }
            // Return maximum achievable value
            return maxValue;
        }
    }
    public static void main(String[] args) {

    }
}
