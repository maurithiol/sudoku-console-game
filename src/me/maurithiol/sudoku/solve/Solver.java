package me.maurithiol.sudoku.solve;

import me.maurithiol.sudoku.util.PrinterUtil;

/**
 * The solver class for a simple sudoku game to implement a simple backtracking algorithm
 */
public class Solver extends PrinterUtil {

    /**
     * Constructs a solver instance, to solve a given 2 dimensional board array
     * Prints the solved version of the given board array
     *
     * @param board current game board
     */
    public Solver(int[][] board) {
        solve(board);
        System.out.println(print(board));
    }

    /**
     * Attempts to solve the given 2 dimensional sudoku board riddle
     * Implementation of the backtracking algorithm
     *
     * @param board two dimension sudoku game board array
     * @return {@code true} if a solution is found; {@code false} otherwise
     */
    private boolean solve(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValid(board, numberToTry, column, row)) {
                            board[row][column] = numberToTry;
                            if (solve(board)) return true;
                            else board[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the destination position of a given number is valid
     *
     * @param board  two dimension sudoku game board array
     * @param number value to be checked
     * @param column to check
     * @param row    to check
     * @return {@code true} if the number is valid; {@code false} otherwise
     */
    private boolean isValid(int[][] board, int number, int column, int row) {
        return !isInRow(board, row, number) && !isInColumn(board, column, number) && !isInBox(board, column, row, number);
    }

    /**
     * Checks if a given number is present in the specified row
     *
     * @param board  two dimension sudoku game board array
     * @param row    to check
     * @param number value to be checked
     * @return {@code true} if the number already exists in the specified row; {@code false} otherwise
     */
    private boolean isInRow(int[][] board, int row, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[row][i] == number) return true;
        return false;
    }

    /**
     * Checks if a given number is present in the specified column
     *
     * @param board  two dimension sudoku game board array
     * @param column to check
     * @param number value to be checked
     * @return {@code true} if the number already exists in the specified column; {@code false} otherwise
     */
    private boolean isInColumn(int[][] board, int column, int number) {
        for (int i = 0; i < GRID_SIZE; i++)
            if (board[i][column] == number) return true;
        return false;
    }

    /**
     * Checks if a given number is present in the specified subgrid
     *
     * @param board  two dimension sudoku game board array
     * @param column to check
     * @param row    to check
     * @param number value to be checked
     * @return {@code true} if the number already exists in the specified subgrid box; {@code false} otherwise
     */
    private boolean isInBox(int[][] board, int column, int row, int number) {
        int localRow = row - row % SUB_GRID_SIZE, localColumn = column - column % SUB_GRID_SIZE;
        for (int i = localRow; i < localRow + SUB_GRID_SIZE; i++)
            for (int j = localColumn; j < localColumn + SUB_GRID_SIZE; j++)
                if (board[i][j] == number) return true;
        return false;
    }

}