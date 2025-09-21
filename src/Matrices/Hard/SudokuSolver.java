package Matrices.Hard;

//Problem Link: https://www.naukri.com/code360/problems/sudoku-solver_699919?interviewProblemRedirection=true&practice_topic%5B%5D=Matrices%20(2D%20Arrays)&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class SudokuSolver {
    public static class Solution {
        private final static int EMPTY_CELL = 0;
        private final static int GRID_SIZE = 9;
        private final static int SUBGRID_SIZE = 3;
        private final static int MIN_DIGIT = 1;
        private final static int MAX_DIGIT = 9;

        // Main method - should return boolean to indicate if puzzle is solvable
        public static void solveSudoku(int[][] sudoku) {
            // Edge case: validate input
            if (sudoku == null || sudoku.length < GRID_SIZE) {
                return;
            }

            // Call recursive solver (result doesn't matter for void method)
            solveSudokuRecursive(sudoku);
            return;
        }

        // FIXED: Return boolean to enable proper backtracking
        private static boolean solveSudokuRecursive(int[][] grid) {
            // Find the next empty cell to fill
            int[] emptyCell = findNextEmptyCell(grid);

            // Base case: no empty cells found, puzzle is solved
            if (emptyCell == null) {
                return true; // FIXED: Return true when solved
            }

            int currentRow = emptyCell[0];
            int currentCol = emptyCell[1];

            // Try each digit from 1 to 9
            for (int candidateDigit = MIN_DIGIT; candidateDigit <= MAX_DIGIT; candidateDigit++) {
                // Check if placing this digit is valid
                if (isValidPlace(grid, currentRow, currentCol, candidateDigit)) {
                    // Place the digit temporarily
                    grid[currentRow][currentCol] = candidateDigit;

                    // FIXED: Check if recursive call succeeds
                    if (solveSudokuRecursive(grid)) {
                        return true; // Solution found, propagate success
                    }

                    // FIXED: Backtrack only if recursive call fails
                    grid[currentRow][currentCol] = EMPTY_CELL;
                }
            }

            // FIXED: Return false if no valid digit found for this cell
            return false;
        }

        // Find next empty cell in the grid
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

        // Check if placing digit at given position is valid
        private static boolean isValidPlace(int[][] grid, int row, int col, int targetDigit) {
            // Check all three Sudoku constraints
            if (isExistInRow(grid, row, targetDigit)) {
                return false;
            }
            if (isExistInCol(grid, col, targetDigit)) {
                return false;
            }
            if (isExistInSubGrid(grid, row, col, targetDigit)) {
                return false;
            }

            return true; // All constraints satisfied
        }

        // FIXED: Check if digit exists in the specified row
        private static boolean isExistInRow(int[][] grid, int row, int targetDigit) {
            for (int currentCol = 0; currentCol < GRID_SIZE; currentCol++) {
                if (grid[row][currentCol] == targetDigit) {
                    return true;
                }
            }
            return false;
        }

        // FIXED: Check if digit exists in the specified column
        private static boolean isExistInCol(int[][] grid, int col, int targetDigit) {
            for (int currentRow = 0; currentRow < GRID_SIZE; currentRow++) {
                if (grid[currentRow][col] == targetDigit) {
                    return true;
                }
            }
            return false;
        }

        // Check if digit exists in the 3x3 subgrid containing the given position
        private static boolean isExistInSubGrid(int[][] grid, int row, int col, int targetDigit) {
            // Calculate top-left corner of the 3x3 subgrid
            int startRow = (row / SUBGRID_SIZE) * SUBGRID_SIZE;
            int startCol = (col / SUBGRID_SIZE) * SUBGRID_SIZE;

            // Check all cells in the 3x3 subgrid
            for (int currentRow = startRow; currentRow < startRow + SUBGRID_SIZE; currentRow++) {
                for (int currentCol = startCol; currentCol < startCol + SUBGRID_SIZE; currentCol++) {
                    if (grid[currentRow][currentCol] == targetDigit) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static class Solution2 {
        // Constants for Sudoku grid
        private static final int EMPTY_CELL = 0;
        private static final int GRID_SIZE = 9;
        private static final int SUBGRID_SIZE = 3;
        private static final int MIN_DIGIT = 1;
        private static final int MAX_DIGIT = 9;
        // Flag to indicate if a solution is found
        private static boolean isSolutionFound;

        public static void solveSudoku(int[][] board) {
            // Handle edge case: null or invalid board
            if (board == null || board.length < GRID_SIZE) {
                return;
            }

            // Initialize solution flag
            isSolutionFound = false;
            // Start backtracking from top-left cell
            solveSudokuBacktrack(board, 0, 0);
        }

        // Solves Sudoku using backtracking
        private static void solveSudokuBacktrack(int[][] board, int row, int col) {
            // If all rows are processed, solution is found
            if (row == GRID_SIZE) {
                isSolutionFound = true;
                return;
            }

            // Move to next row when current row is fully processed
            if (col == GRID_SIZE) {
                solveSudokuBacktrack(board, row + 1, 0);
                return;
            }

            // Skip pre-filled cells
            if (board[row][col] != EMPTY_CELL) {
                solveSudokuBacktrack(board, row, col + 1);
                return;
            }

            // Try digits 1-9 for the current cell
            for (int digit = MIN_DIGIT; digit <= MAX_DIGIT; digit++) {
                // Check if digit can be placed
                if (isValidPlacement(board, row, col, digit)) {
                    // Place the digit
                    board[row][col] = digit;

                    // Recurse to next cell
                    solveSudokuBacktrack(board, row, col + 1);
                    // If solution is found, stop
                    if (isSolutionFound) {
                        return;
                    }

                    // Backtrack by resetting the cell
                    board[row][col] = EMPTY_CELL;
                }
            }
        }

        // Checks if a digit can be placed in the given cell
        private static boolean isValidPlacement(int[][] board, int row, int col, int digit) {
            // Check row, column, and subgrid for conflicts
            return !isDigitInRow(board, row, digit) &&
                    !isDigitInColumn(board, col, digit) &&
                    !isDigitInSubgrid(board, row, col, digit);
        }

        // Checks if digit exists in the given row
        private static boolean isDigitInRow(int[][] board, int row, int digit) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == digit) {
                    return true;
                }
            }
            return false;
        }

        // Checks if digit exists in the given column
        private static boolean isDigitInColumn(int[][] board, int col, int digit) {
            for (int row = 0; row < GRID_SIZE; row++) {
                if (board[row][col] == digit) {
                    return true;
                }
            }
            return false;
        }

        // Checks if digit exists in the 3x3 subgrid containing the cell
        private static boolean isDigitInSubgrid(int[][] board, int row, int col, int digit) {
            // Calculate top-left corner of the subgrid
            int subgridRowStart = (row / SUBGRID_SIZE) * SUBGRID_SIZE;
            int subgridColStart = (col / SUBGRID_SIZE) * SUBGRID_SIZE;

            // Check all cells in the 3x3 subgrid
            for (int r = subgridRowStart; r < subgridRowStart + SUBGRID_SIZE; r++) {
                for (int c = subgridColStart; c < subgridColStart + SUBGRID_SIZE; c++) {
                    if (board[r][c] == digit) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
