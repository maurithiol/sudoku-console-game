package me.maurithiol.sudoku.handle;

import me.maurithiol.sudoku.board.Position;

import java.util.Scanner;

public class Console {

    private final static Scanner inputScanner = new Scanner(System.in);

    public Move play(Move move) {
        System.out.println("select destination? (enter X Y coordinate)");
        int y = inputScanner.nextInt();
        int x = inputScanner.nextInt();
        Position destination = new Position(x, y);
        System.out.println("select input? (enter value 1-9)");
        int input = inputScanner.nextInt();
        return new Move(destination, input);
    }

}