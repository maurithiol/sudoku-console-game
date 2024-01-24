package me.maurithiol.sudoku.riddle;

public enum SubGrid {

    TOP_LEFT(0, 0, 2, 2), TOP_MID(3, 0, 5, 2), TOP_RIGHT(6, 0, 8, 2),
    MID_LEFT(0, 3, 2, 5), MID_MID(3, 3, 5, 5), MID_RIGHT(6, 3, 8, 5),
    BOTTOM_LEFT(0, 6, 2, 8), BOTTOM_MID(3, 6, 5, 8), BOTTOM_RIGHT(6, 6, 8, 8);

    private final int startColumn, startRow, endColumn, endRow;

    SubGrid(int startColumn, int startRow, int endColumn, int endRow) {
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.endColumn = endColumn;
        this.endRow = endRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public int getEndRow() {
        return endRow;
    }

}