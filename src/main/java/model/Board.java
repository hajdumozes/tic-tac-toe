package model;

import exception.CellAlreadyTakenException;

public class Board {
    private static final char BLANK_SPACE = ' ';

    private final char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = BLANK_SPACE;
            }
        }
    }

    public char[][] getBoard() {
        return board.clone();
    }

    public void editCell(Cell cell, char newValue) {
        if (isCellTaken(cell)) {
            throw new CellAlreadyTakenException();
        }
        board[cell.getRow()][cell.getColumn()] = newValue;
    }

    private boolean isCellTaken(Cell cell) {
        return board[cell.getRow()][cell.getColumn()] != BLANK_SPACE;
    }
}