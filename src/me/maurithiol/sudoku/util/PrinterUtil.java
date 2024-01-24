package me.maurithiol.sudoku.util;

/**
 * Util class to manage the console printing format of the current game board
 */
public class PrinterUtil {

    /**
     * Converts and prints the 2 dimensional array representation of board
     * Prints out the current game board in the console
     *
     * @param board 2 dimensional game board array of a sudoku game
     * @return current game board as String
     */
    protected String print(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % SUB_GRID_SIZE == 0 && i != 0) sb.append("------+-------+------\n");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % SUB_GRID_SIZE == 0 && j != 0) sb.append("| ");
                sb.append(board[i][j] == 0 ? " " : board[i][j]);
                sb.append(" ");
            }
            sb.append("  " + i);
            sb.append("\n");
        }
        sb.append("\n");
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % SUB_GRID_SIZE == 0 && i != 0) sb.append("  ");
            sb.append(i + " ");
        }
        sb.append("\n");
        return sb.toString();
    }

    protected static final int GRID_SIZE = 9, SUB_GRID_SIZE = GRID_SIZE / 3;


}