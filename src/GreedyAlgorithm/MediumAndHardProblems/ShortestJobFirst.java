package GreedyAlgorithm.MediumAndHardProblems;

import java.util.Arrays;

public class ShortestJobFirst {
    public static class Solution {
        // Calculates the average waiting time for processes using Shortest Job First scheduling
        public static int calculateAverageWaitingTime(int[] burstTimes) {
            // Handle edge case: return 0 if array is null or empty
            if (burstTimes == null || burstTimes.length == 0) {
                return 0;
            }

            // Sort burst times to process shortest jobs first
            Arrays.sort(burstTimes);

            int totalTurnaroundTime = 0; // Tracks cumulative turnaround time
            int totalWaitingTime = 0;   // Tracks cumulative waiting time

            // Calculate waiting time for each process
            for (int burstTime : burstTimes) {
                totalWaitingTime += totalTurnaroundTime; // Waiting time is previous turnaround time
                totalTurnaroundTime += burstTime;        // Turnaround time includes current burst time
            }

            // Return average waiting time
            return totalWaitingTime / burstTimes.length;
        }
    }

    public static void main(String[] args) {

    }
}
