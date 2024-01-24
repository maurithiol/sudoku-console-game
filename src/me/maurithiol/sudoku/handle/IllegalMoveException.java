package me.maurithiol.sudoku.handle;

public class IllegalMoveException extends Exception {

    public IllegalMoveException(String message) {
        super(message);
    }

}