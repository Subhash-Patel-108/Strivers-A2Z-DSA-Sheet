package GreedyAlgorithm.MediumAndHardProblems;

import java.util.*;

public class FractionalKnapsack {
    class Solution {
        // Represents an item with weight, value, and value-to-weight ratio
        private static class Item {
            public int weight;
            public int value;
            public double valuePerUnit;

            // Constructor to initialize item properties
            public Item(int weight, int value) {
                this.weight = weight;
                this.value = value;
                this.valuePerUnit = (double) value / weight;
            }
        }

        // Solves the fractional knapsack problem to maximize total value within capacity
        public double fractionalKnapsack(int[] values, int[] weights, int maxCapacity) {
            // Handle edge cases: return 0 if arrays are null or have different lengths
            if (values == null || weights == null || values.length != weights.length) {
                return 0.0;
            }

            // Create list of items from weights and values
            ArrayList<Item> items = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                items.add(new Item(weights[i], values[i]));
            }

            // Sort items by value-per-unit in descending order
            Collections.sort(items, (a, b) -> Double.compare(b.valuePerUnit, a.valuePerUnit));

            double totalValue = 0.0;
            int currentIndex = 0;
            // Process items while capacity remains and there are items next
            while (maxCapacity > 0 && currentIndex < items.size()) {
                Item currentItem = items.get(currentIndex);
                int itemWeight = currentItem.weight;
                int itemValue = currentItem.value;
                double itemValuePerUnit = currentItem.valuePerUnit;

                // If capacity allows, take the whole item
                if (maxCapacity >= itemWeight) {
                    totalValue += itemValue;
                    maxCapacity -= itemWeight;
                } else {
                    // Take a fraction of the item to fill remaining capacity
                    totalValue += (maxCapacity * itemValuePerUnit);
                    maxCapacity = 0;
                }
                currentIndex++;
            }

            return totalValue;
        }
    }

    public static void main(String[] args) {

    }
}
