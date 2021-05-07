package rule;

import component.Board;
import model.Cell;

import java.util.Optional;

public class HorizontalLineWinConditionChecker implements WinConditionChecker {
    private static final char BLANK_SPACE = ' ';
    private static final int SUM_TO_WIN = 3;

    @Override
    public Optional<Character> checkWinner(Board board) {
        for (int i = 0; i < board.getBoard().length; i++) {
            Optional<Character> winner = checkRow(i, board);
            if (winner.isPresent()) {
                return winner;
            }
        }
        return Optional.empty();
    }

    private Optional<Character> checkRow(int rowIndex, Board board) {
        int counter = 1;
        char currentChar = BLANK_SPACE;
        for (int columnIndex = 0; columnIndex < board.getBoard().length; columnIndex++) {
            char nextChar = board.getCell(new Cell(rowIndex, columnIndex));
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
