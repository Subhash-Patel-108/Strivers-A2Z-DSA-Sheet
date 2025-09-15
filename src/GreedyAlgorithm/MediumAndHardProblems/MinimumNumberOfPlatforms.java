package GreedyAlgorithm.MediumAndHardProblems;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static class Solution {
        // Calculates the minimum number of platforms required for a railway station
        public static int calculateMinPlatforms(int[] arrivalTimes, int[] departureTimes, int trainCount) {
            // Handle edge cases: return 0 if arrays are null or have different lengths
            if (arrivalTimes == null || departureTimes == null || arrivalTimes.length != departureTimes.length) {
                return 0;
            }

            // Sort arrays to process trains by arrival and departure times
            Arrays.sort(arrivalTimes);
            Arrays.sort(departureTimes);

            int currentTrains = 0; // Tracks number of trains at the station
            int maxPlatformsNeeded = 0; // Tracks maximum platforms needed at any time
            int arrivalIndex = 0; // Index for next arrival time
            int departureIndex = 0; // Index for next departure time

            // Process trains while there are arrivals to consider
            while (arrivalIndex < trainCount) {
                // If next arrival is before or at next departure, a train arrives
                if (arrivalTimes[arrivalIndex] <= departureTimes[departureIndex]) {
                    currentTrains++;
                    maxPlatformsNeeded = Math.max(maxPlatformsNeeded, currentTrains);
                    arrivalIndex++;
                } else {
                    // Otherwise, a train departs, freeing a platform
                    currentTrains--;
                    departureIndex++;
                }
            }

            return maxPlatformsNeeded;
        }
    }
    public static void main(String[] args) {

    }
}
