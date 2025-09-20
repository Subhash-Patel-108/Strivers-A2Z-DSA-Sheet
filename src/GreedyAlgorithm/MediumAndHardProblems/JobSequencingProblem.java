package GreedyAlgorithm.MediumAndHardProblems;
import java.util.* ;
public class JobSequencingProblem {
    public static class Solution {
        // Represents a job with its deadline and profit
        private static class Job {
            int deadline;
            int profit;

            // Constructor to initialize job properties
            Job(int deadline, int profit) {
                this.deadline = deadline;
                this.profit = profit;
            }
        }

        // Disjoint Set (Union-Find) to find the nearest available time slot
        private static int findAvailableSlot(int[] parent, int slot) {
            // Base case: slot is its own parent (available)
            if (parent[slot] == slot) {
                return slot;
            }
            // Path compression: update parent to root for efficiency
            return parent[slot] = findAvailableSlot(parent, parent[slot]);
        }

        // Solves the job sequencing problem to maximize profit
        public static ArrayList<Integer> jobSequencing(int[] deadlines, int[] profits) {
            int jobCount = deadlines.length;
            ArrayList<Job> jobList = new ArrayList<>();

            // Create list of jobs from deadlines and profits
            for (int i = 0; i < jobCount; i++) {
                jobList.add(new Job(deadlines[i], profits[i]));
            }

            // Sort jobs by profit in descending order for greedy selection
            jobList.sort((a, b) -> Integer.compare(b.profit, a.profit));

            // Find maximum deadline to determine size of parent array
            int maxDeadline = 0;
            for (int d : deadlines) {
                maxDeadline = Math.max(maxDeadline, d);
            }

            // Initialize Disjoint Set parent array (1-based indexing for slots)
            int[] parent = new int[maxDeadline + 1];
            for (int i = 0; i <= maxDeadline; i++) {
                parent[i] = i; // Each slot initially points to itself
            }

            int selectedJobs = 0; // Count of scheduled jobs
            int totalProfit = 0;  // Total profit from scheduled jobs

            // Process jobs in order of decreasing profit
            for (Job job : jobList) {
                // Find the latest available slot before or at the job's deadline
                int availableSlot = findAvailableSlot(parent, job.deadline);
                if (availableSlot > 0) {
                    // Schedule the job in the available slot
                    selectedJobs++;
                    totalProfit += job.profit;

                    // Mark slot as used by linking it to the previous slot
                    parent[availableSlot] = findAvailableSlot(parent, availableSlot - 1);
                }
            }

            // Return result containing count of jobs and total profit
            ArrayList<Integer> result = new ArrayList<>();
            result.add(selectedJobs);
            result.add(totalProfit);
            return result;
        }
    }
    public static void main(String[] args) {

    }
}
