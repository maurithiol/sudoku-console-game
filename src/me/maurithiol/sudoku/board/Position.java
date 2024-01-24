package me.maurithiol.sudoku.board;

import java.util.Objects;

/**
 * Class to initiate a new position with the coordinates x and y
 */
public class Position {

    private final int x, y;

    /**
     * Constructs a Position with the coordinates x and y.
     *
     * @param x : horizontal coordinate.
     * @param y : vertical coordinate.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gives the value of the x coordinate.
     *
     * @return int x, value of the horizontal coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gives the value of the y coordinate.
     *
     * @return int y, value of the vertical coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Checks if the given number of columns and rows are out of the game board or out of bounds.
     *
     * @return {@code true} if coordinates are not located on the current game board, {@code false} if coordinates are located on the current game board.
     */
    public boolean isOutOfBounds(int columns, int rows) {
        return x < 0 || x >= columns || y < 0 || y >= rows;
    }

    /**
     * Checks if the object is equal to the initiated position.
     *
     * @return {@code true} if they are equal, {@code false} if they are not equal.
     */
    public boolean equals(Object other) {
        return x == ((Position) other).x && y == ((Position) other).y;
    }

    /**
     * Gives a hash code of the initiated position coordinates, x and y.
     *
     * @return Objects.hash(x, y) hashed version of x and y, type int
     */
    public int hashCode() {
        return Objects.hash(x, y);
    }

}