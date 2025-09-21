package Matrices.Medium;

import java.util.*;

//Problem Link : https://www.naukri.com/code360/problems/min-jumps_985273?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class MinJumps {

    public static class Solution {
        // Direction vectors for allowed moves: down, right, diagonal down-right
        private final static int[] rowDirections = {1, 0, 1};
        private final static int[] colDirections = {0, 1, 1};

        // Data structure to hold cell position and accumulated cost for Dijkstra's algorithm
        private static class Cell {
            public int row;
            public int col;
            public int accumulatedCost;

            // Constructor to initialize cell with position and cost
            public Cell(int row, int col, int accumulatedCost) {
                this.row = row;
                this.col = col;
                this.accumulatedCost = accumulatedCost;
            }
        }

        /**
         * Finds minimum cost path from top-left to bottom-right corner of a 2D grid
         * Uses Dijkstra's algorithm with allowed moves: down, right, diagonal down-right
         * Cost between adjacent cells is absolute difference of their values
         */
        public static int findMinCost(int[][] grid, int totalRows, int totalCols) {
            // Handle edge case: null or empty grid
            if (grid == null || totalRows == 0) {
                return 0;
            }

            // Define destination coordinates
            int destinationRow = totalRows - 1;
            int destinationCol = totalCols - 1;

            // Distance array to track minimum cost to reach each cell
            int[][] minCostToReach = new int[totalRows][totalCols];
            // Initialize all distances to infinity (maximum possible value)
            for (int[] row : minCostToReach) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            // Starting position has zero cost
            minCostToReach[0][0] = 0;

            // Priority queue to always process cell with minimum cost first (Dijkstra's greedy approach)
            PriorityQueue<Cell> minHeap = new PriorityQueue<>((cellA, cellB) ->
                    cellA.accumulatedCost - cellB.accumulatedCost);
            // Start from top-left corner with zero initial cost
            minHeap.offer(new Cell(0, 0, 0));

            // Main Dijkstra's algorithm loop
            while (!minHeap.isEmpty()) {
                // Get the cell with minimum cost from priority queue
                Cell currentCell = minHeap.poll();
                int currentRow = currentCell.row;
                int currentCol = currentCell.col;
                int currentCost = currentCell.accumulatedCost;

                // Early termination: if we reached destination, return the cost
                if (currentRow == destinationRow && currentCol == destinationCol) {
                    return currentCost;
                }

                // Optimization: skip if we already found a better path to this cell
                if (currentCost > minCostToReach[currentRow][currentCol]) {
                    continue;
                }

                // Explore all three possible moves: down, right, diagonal down-right
                for (int directionIndex = 0; directionIndex < 3; directionIndex++) {
                    int nextRow = currentRow + rowDirections[directionIndex];
                    int nextCol = currentCol + colDirections[directionIndex];

                    // Check if the next position is within grid boundaries
                    if (isValidPosition(nextRow, nextCol, totalRows, totalCols)) {
                        // Calculate movement cost as absolute difference between cell values
                        int movementCost = Math.abs(grid[currentRow][currentCol] - grid[nextRow][nextCol]);
                        int totalCostToNext = currentCost + movementCost;

                        // If we found a cheaper path to the next cell, update it
                        if (totalCostToNext < minCostToReach[nextRow][nextCol]) {
                            minCostToReach[nextRow][nextCol] = totalCostToNext;
                            // Add the next cell to priority queue for future processing
                            minHeap.offer(new Cell(nextRow, nextCol, totalCostToNext));
                        }
                    }
                }
            }

            // This should never be reached for a valid grid since destination is always reachable
            return -1;
        }

        // Helper method to check if given coordinates are within grid boundaries
        private static boolean isValidPosition(int row, int col, int maxRows, int maxCols) {
            return (row >= 0 && row < maxRows) && (col >= 0 && col < maxCols);
        }
    }
    public static void main(String[] args) {

    }
}
