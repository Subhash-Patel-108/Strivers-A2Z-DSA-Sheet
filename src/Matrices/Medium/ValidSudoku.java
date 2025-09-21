package Matrices.Medium;
//Problem Link : https://www.naukri.com/code360/problems/sudoku_758961?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC
public class ValidSudoku {

    public static class Solution {
        // Constants for Sudoku dimensions
        private static final int GRID_SIZE = 9;
        private static final int SUBGRID_SIZE = 3;
        private static final int EMPTY_CELL = 0;
        private static final int MIN_DIGIT = 1;
        private static final int MAX_DIGIT = 9;

        /**
         * Main method to determine if Sudoku puzzle can be solved
         * Returns "yes" if solvable, "no" otherwise
         */
        public static boolean solveSudoku(int[][] sudokuGrid) {
            // Create a copy of the grid to avoid modifying original
            int[][] workingGrid = createGridCopy(sudokuGrid);

            // Use backtracking to attempt solving the puzzle
            boolean canBeSolved = solveSudokuRecursive(workingGrid);

            return canBeSolved;
        }

        /**
         * Recursive backtracking method to solve Sudoku puzzle
         * Tries to fill each empty cell with valid digits (1-9)
         */
        private static boolean solveSudokuRecursive(int[][] grid) {
            // Find the next empty cell to fill
            int[] emptyCell = findNextEmptyCell(grid);

            // Base case: no empty cells found, puzzle is solved
            if (emptyCell == null) {
                return true;
            }

            int currentRow = emptyCell[0];
            int currentCol = emptyCell[1];

            // Try each digit from 1 to 9 in the empty cell
            for (int candidateDigit = MIN_DIGIT; candidateDigit <= MAX_DIGIT; candidateDigit++) {
                // Check if placing this digit violates Sudoku rules
                if (isValidPlacement(grid, currentRow, currentCol, candidateDigit)) {
                    // Place the digit temporarily
                    grid[currentRow][currentCol] = candidateDigit;

                    // Recursively try to solve the remaining puzzle
                    if (solveSudokuRecursive(grid)) {
                        return true; // Found a valid solution
                    }

                    // Backtrack: remove the digit and try next candidate
                    grid[currentRow][currentCol] = EMPTY_CELL;
                }
            }

            // No valid digit found for this cell, backtrack
            return false;
        }

        /**
         * Find the next empty cell (containing 0) in the grid
         * Uses row-by-row, left-to-right scanning
         */
        private static int[] findNextEmptyCell(int[][] grid) {
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    if (grid[row][col] == EMPTY_CELL) {
                        return new int[]{row, col};
                    }
                }
            }
            return null; // No empty cell found
        }

        /**
         * Check if placing a digit at given position is valid according to Sudoku rules
         * Must satisfy: row uniqueness, column uniqueness, and 3x3 subgrid uniqueness
         */
        private static boolean isValidPlacement(int[][] grid, int targetRow, int targetCol, int digit) {
            // Check row constraint: digit must not already exist in the row
            if (existsInRow(grid, targetRow, digit)) {
                return false;
            }

            // Check column constraint: digit must not already exist in the column
            if (existsInColumn(grid, targetCol, digit)) {
                return false;
            }

            // Check 3x3 subgrid constraint: digit must not already exist in the subgrid
            if (existsInSubgrid(grid, targetRow, targetCol, digit)) {
                return false;
            }

            return true; // All constraints satisfied
        }

        /**
         * Check if digit already exists in the specified row
         */
        private static boolean existsInRow(int[][] grid, int row, int digit) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == digit) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Check if digit already exists in the specified column
         */
        private static boolean existsInColumn(int[][] grid, int col, int digit) {
            for (int row = 0; row < GRID_SIZE; row++) {
                if (grid[row][col] == digit) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Check if digit already exists in the 3x3 subgrid containing the target position
         */
        private static boolean existsInSubgrid(int[][] grid, int targetRow, int targetCol, int digit) {
            // Calculate the top-left corner of the 3x3 subgrid
            int subgridStartRow = (targetRow / SUBGRID_SIZE) * SUBGRID_SIZE;
            int subgridStartCol = (targetCol / SUBGRID_SIZE) * SUBGRID_SIZE;

            // Check all cells in the 3x3 subgrid
            for (int row = subgridStartRow; row < subgridStartRow + SUBGRID_SIZE; row++) {
                for (int col = subgridStartCol; col < subgridStartCol + SUBGRID_SIZE; col++) {
                    if (grid[row][col] == digit) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Create a deep copy of the Sudoku grid to avoid modifying original
         */
        private static int[][] createGridCopy(int[][] originalGrid) {
            int[][] gridCopy = new int[GRID_SIZE][GRID_SIZE];
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    gridCopy[row][col] = originalGrid[row][col];
                }
            }
            return gridCopy;
        }
    }
}
