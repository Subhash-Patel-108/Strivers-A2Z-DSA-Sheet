package Matrices.Medium;
import java.util.* ;
//Problem Link : https://leetcode.com/problems/snakes-and-ladders/submissions/1777140722/
public class SnakesAndLadders {

    public static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            int target = n * n;

            // BFS setup
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[target + 1];

            queue.offer(1); // Start at position 1
            visited[1] = true;
            int moves = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                // Process all positions at current move count
                for (int i = 0; i < size; i++) {
                    int currentPos = queue.poll();

                    // Check if we reached the target
                    if (currentPos == target) {
                        return moves;
                    }

                    // Try all possible dice rolls (1 to 6)
                    for (int dice = 1; dice <= 6; dice++) {
                        int nextPos = currentPos + dice;

                        // Check bounds
                        if (nextPos > target) break;

                        // Convert 1D position to 2D coordinates
                        int[] coordinates = getCoordinates(nextPos, n);
                        int row = coordinates[0];
                        int col = coordinates[1];

                        // Check for snake or ladder
                        int finalPos = nextPos;
                        if (board[row][col] != -1) {
                            finalPos = board[row][col];
                        }

                        // Add to queue if not visited
                        if (!visited[finalPos]) {
                            visited[finalPos] = true;
                            queue.offer(finalPos);
                        }
                    }
                }
                moves++;
            }

            return -1; // Cannot reach the target
        }

        /**
         * Convert 1D position to 2D board coordinates
         * Board numbering follows boustrophedon (zigzag) pattern
         */
        private int[] getCoordinates(int pos, int n) {
            pos--; // Convert to 0-indexed

            int row = pos / n;
            int col = pos % n;

            // Reverse column for odd rows (boustrophedon pattern)
            if (row % 2 == 1) {
                col = n - 1 - col;
            }

            // Convert to board coordinates (board is given bottom-up)
            row = n - 1 - row;

            return new int[]{row, col};
        }
    }
    public static void main(String[] args) {

    }
}
