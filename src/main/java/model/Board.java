package model;

public class Board {
    private static final char CHARACTER_SEPARATOR = '|';
    private static final char LINE_SEPARATOR = '-';
    private static final char ALTERNATE_LINE_SEPARATOR = '+';

    private final char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoardState() {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                printCharacterSeparator(j);
            }
            printLineSeparator(i);
        }
    }

    private void printCharacterSeparator(int index) {
        if (isPrintingNeeded(index)) {
            System.out.print(CHARACTER_SEPARATOR);
        }
    }

    private void printLineSeparator(int index) {
        if (isPrintingNeeded(index)) {
            System.out.println();
            int charactersNeeded = board.length * 2 - 1;
            boolean useAlternate = false;
            for (int i = 0; i < charactersNeeded; i++) {
                if (useAlternate) {
                    System.out.print(ALTERNATE_LINE_SEPARATOR);
                    useAlternate = false;
                } else {
                    System.out.print(LINE_SEPARATOR);
                    useAlternate = true;
                }
            }
        }
    }

    private boolean isPrintingNeeded(int index) {
        return index < board.length - 1;
    }
}