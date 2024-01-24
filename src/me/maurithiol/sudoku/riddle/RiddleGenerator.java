package me.maurithiol.sudoku.riddle;

import me.maurithiol.sudoku.board.Board;
import me.maurithiol.sudoku.board.Position;

public class RiddleGenerator {

    public void generate(Board board, int startColumn, int startRow, int endColumn, int endRow) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                Position target = new Position(j, i);
                if (target.getX() >= startColumn && target.getX() <= endColumn && target.getY() >= startRow && target.getY() <= endRow)
                    if (canRemove(board, target))
                        board.setNumber(target, 0);
            }
        }
    }

    private boolean canRemove(Board board, Position position) {
        int dest = (int) Math.round(Math.random());
        return dest == 1;
    }

}