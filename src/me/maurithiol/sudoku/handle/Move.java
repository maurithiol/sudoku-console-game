package me.maurithiol.sudoku.handle;

import me.maurithiol.sudoku.board.Position;

import java.util.Objects;

public class Move {

    private Position destinationPosition;
    private int input;

    public Move(Position destinationPosition, int input) {
        this.destinationPosition = destinationPosition;
        this.input = input;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Move move = (Move) obj;
        return Objects.equals(destinationPosition, move.destinationPosition) && Objects.equals(input, move.input);
    }

    @Override
    public String toString() {
        return destinationPosition + "->" + input;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationPosition, input);
    }

    public Position getDestinationPosition() {
        return destinationPosition;
    }

    public int getInput() {
        return input;
    }

}