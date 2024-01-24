package me.maurithiol.sudoku.board;

import me.maurithiol.sudoku.handle.IllegalMoveException;
import me.maurithiol.sudoku.riddle.GridGenerator;
import me.maurithiol.sudoku.util.PrinterUtil;

/**
 * A class to initiate a sudoku game board by using the PrinterUtil class to implement the print method
 */
public class Board extends PrinterUtil {

    private final int columns, rows;
    private final int[][] board;

    /**
     * Constructs a game board
     *
     * @param columns amount of columns of the current board
     * @param rows    amount of rows of the current board
     */
    public Board(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.board = new int[columns][rows];
    }

    /**
     * Sets a given number at a given position on the current board
     *
     * @param position destination where to put the given number
     * @param number   input int value
     */
    public void setNumber(Position position, int number) {
        board[position.getX()][position.getY()] = number;
    }

    /**
     * Gets the number put in a given position on the current board
     *
     * @param position on the current board
     * @return number at the given position, x and y coordinates
     */
    public int getNumber(Position position) {
        return board[position.getX()][position.getY()];
    }

    /**
     * Checks if the specified position is empty
     *
     * @param position: position to test
     * @return {@code true} if the specified position is empty on the board; {@code false} otherwise
     */
    public boolean isEmpty(Position position) {
        int number = getNumber(position);
        return number == 0;
    }

    /**
     * Checks if the specified position is out of the board
     *
     * @param position: position to test
     * @return {@code true} if the specified position is out of the board; {@code false} otherwise
     */
    public boolean isOutOfBoard(Position position) {
        return position.isOutOfBounds(columns, rows);
    }

    /**
     * Generates the board by using a grid generator
     *
     * @param gridGenerator: generates the position for every number on the board
     */
    public void generate(GridGenerator gridGenerator) {
        gridGenerator.generate(this);
    }

    /**
     * Gets the number of columns of the current board
     *
     * @return value that contains the amount of columns on the current board
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Gets the number of rows of the current board
     *
     * @return value that contains the amount of rows on the current board
     */
    public int getRows() {
        return rows;
    }

    /**
     * Prints out the current game board in the console
     *
     * @return the given format from the PrintUtil class of the current game board
     */
    public String toString() {
        return print(board);
    }

    /**
     * Gets the 2 dimensional array of the current game board
     *
     * @return 2 dimensional board array
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Adds a given input to a specified destination position on the current game board
     *
     * @param destination position where to add the input value
     * @param input       value to add to the current board
     */
    public void addInputToDestination(Position destination, int input) {
        if (!isEmpty(destination)) try {
            throw new IllegalMoveException("Destination position is not empty");
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
        setNumber(destination, input);
    }

}