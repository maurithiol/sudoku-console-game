package me.maurithiol.sudoku.riddle;

import me.maurithiol.sudoku.board.Board;
import me.maurithiol.sudoku.board.Position;
import me.maurithiol.sudoku.util.PrinterUtil;

public class GridGenerator extends PrinterUtil {

    private String solution;

    public void generate(Board board) {
        generate(board, 0, 0);
        solution = board.toString();
        riddle(board);
    }

    private void riddle(Board board) {
        RiddleGenerator riddleGenerator = new RiddleGenerator();
        for (SubGrid all : SubGrid.values())
            riddleGenerator.generate(board, all.getStartColumn(), all.getStartRow(), all.getEndColumn(), all.getEndRow());
    }

    private boolean generate(Board board, int column, int row) {
        if (row == board.getRows()) return true;
        int nextColumn = (column + 1) % board.getColumns(), nextRow = (column == board.getColumns() - 1) ? row + 1 : row;
        for (int number = 1; number <= board.getRows(); number++) {
            if (isValid(board, column, row, number)) {
                board.setNumber(new Position(column, row), number);
                if (generate(board, nextColumn, nextRow)) return true;
                board.setNumber(new Position(column, row), 0);
            }
        }
        return false;
    }

    private boolean isValid(Board board, int column, int row, int number) {
        return !isInColumn(board, column, number) && !isInRow(board, row, number) && !isInBox(board, column - column % SUB_GRID_SIZE, row - row % SUB_GRID_SIZE, number);
    }

    private boolean isInRow(Board board, int row, int number) {
        for (int i = 0; i < board.getColumns(); i++)
            if (board.getNumber(new Position(i, row)) == number) return true;
        return false;
    }

    private boolean isInColumn(Board board, int column, int number) {
        for (int i = 0; i < board.getRows(); i++)
            if (board.getNumber(new Position(column, i)) == number) return true;
        return false;
    }

    private boolean isInBox(Board board, int column, int row, int number) {
        for (int currentRow = 0; currentRow < SUB_GRID_SIZE; currentRow++)
            for (int currentColumn = 0; currentColumn < SUB_GRID_SIZE; currentColumn++)
                if (board.getNumber(new Position(column + currentColumn, row + currentRow)) == number) return true;
        return false;
    }

    public String getSolution() {
        return solution;
    }

}