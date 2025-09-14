package SlidingWindow.MediumProblem;
import java.util.* ;
public class FruitIntoBaskets {
    public static class Solution {
        // Finds the maximum number of fruits that can be collected with at most two types
        public int maxFruitsCollected(int[] fruitTypes) {
            // Handle edge case: return 0 if array is null or empty
            if (fruitTypes == null || fruitTypes.length == 0) {
                return 0;
            }

            int windowStart = 0, windowEnd = 0;
            int maxFruits = 0;
            // Map to store count of each fruit type in the current window
            HashMap<Integer, Integer> fruitCounts = new HashMap<>();

            // Slide window to find longest subarray with at most two fruit types
            while (windowEnd < fruitTypes.length) {
                // Add current fruit to basket and update its count
                fruitCounts.put(fruitTypes[windowEnd], fruitCounts.getOrDefault(fruitTypes[windowEnd], 0) + 1);

                // Shrink window if more than two fruit types are present
                while (fruitCounts.size() > 2) {
                    int fruitAtStart = fruitTypes[windowStart];
                    // Remove fruit type if count becomes 0, otherwise decrement count
                    if (fruitCounts.get(fruitAtStart) == 1) {
                        fruitCounts.remove(fruitAtStart);
                    } else {
                        fruitCounts.put(fruitAtStart, fruitCounts.get(fruitAtStart) - 1);
                    }
                    windowStart++;
                }

                // Update maximum length of valid subarray
                maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
                windowEnd++;
            }

            return maxFruits;
        }
    }
    public static void main(String[] args) {

    }
}

