package me.maurithiol.sudoku.handle;

import me.maurithiol.sudoku.board.Board;
import me.maurithiol.sudoku.board.Position;
import me.maurithiol.sudoku.riddle.GridGenerator;

public class Game {

    private final Board board;
    private Console console = new Console();
    private GridGenerator gridGenerator;

    public Game() {
        board = new Board(9, 9);
        gridGenerator = new GridGenerator();
    }

    public void initializeGame() {
        board.generate(gridGenerator);
    }

    public void updateGame(Move move) throws IllegalMoveException {
        updateGameInput(move.getDestinationPosition(), move.getInput());
    }

    public void updateGameInput(Position destinationPosition, int input) throws IllegalMoveException {
        if (board.isOutOfBoard(destinationPosition)) throw new IllegalMoveException("Destination position is out of bounds");
        if(input > 9 || input < 1) throw new IllegalMoveException("Input is not between 1 and 9");
        board.addInputToDestination(destinationPosition, input);
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasEnded() {
        return board.getBoard().toString().equals(gridGenerator.getSolution());
    }

    public Console getConsole() {
        return console;
    }

}