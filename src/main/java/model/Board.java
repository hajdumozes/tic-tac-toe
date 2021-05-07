package model;

public class Board {
    private final char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board.clone();
    }
}