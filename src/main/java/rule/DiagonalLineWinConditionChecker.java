package rule;

import component.Board;
import model.Cell;

import java.util.Optional;

public class DiagonalLineWinConditionChecker implements WinConditionChecker {

    private static final char BLANK_SPACE = ' ';
    private static final int SUM_TO_WIN = 3;

    @Override
    public Optional<Character> checkWinner(Board board) {
        Optional<Character> withLeftToRight = checkLeftToRight(board);
        if (withLeftToRight.isPresent()) {
            return withLeftToRight;
        }
        return checkRightToLeft(board);
    }

    private Optional<Character> checkLeftToRight(Board board) {
        int row = 0;
        int column = 0;
        int counter = 1;
        char currentChar = BLANK_SPACE;
        for (int i = 0; i < board.getBoard().length; i++) {
            char nextChar = board.getCell(new Cell(row++, column++));
            if (currentChar != BLANK_SPACE && currentChar == nextChar) {
                counter++;
                if (isThereAWinner(counter)) {
                    return Optional.of(currentChar);
                }
            } else {
                counter = 1;
            }
            currentChar = nextChar;
        }
        return Optional.empty();
    }

    private Optional<Character> checkRightToLeft(Board board) {
        int column = 0;
        int row = board.getBoard().length - 1;
        int counter = 1;
        char currentChar = BLANK_SPACE;
        for (int i = 0; i < board.getBoard().length; i++) {
            char nextChar = board.getCell(new Cell(row--, column++));
            if (currentChar != BLANK_SPACE && currentChar == nextChar) {
                counter++;
                if (isThereAWinner(counter)) {
                    return Optional.of(currentChar);
                }
            } else {
                counter = 1;
            }
            currentChar = nextChar;
        }
        return Optional.empty();
    }


    private boolean isThereAWinner(int counter) {
        return counter >= SUM_TO_WIN;
    }
}
