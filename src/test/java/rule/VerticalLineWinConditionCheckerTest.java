package rule;

import component.Board;
import model.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class VerticalLineWinConditionCheckerTest {

    VerticalLineWinConditionChecker verticalLineWinConditionChecker;

    @BeforeEach
    public void init() {
        verticalLineWinConditionChecker = new VerticalLineWinConditionChecker();
    }

    @Test
    public void givenThereAreNoThreeExactSignNextToEachOther_checkWinner_shouldReturnWithNoWinner() {
        // Given
        Board board = new Board(3);
        char playerSign = 'X';
        board.editCell(new Cell(0,0), playerSign);
        board.editCell(new Cell(1,0), playerSign);
        // When
        Optional<Character> actual = verticalLineWinConditionChecker.checkWinner(board);
        // Then
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    public void givenThereAreThreeExactSignNextToEachOther_checkWinner_shouldReturnWinnerPlayerSign() {
        // Given
        Board board = new Board(3);
        char playerSign = 'X';
        board.editCell(new Cell(0,1), playerSign);
        board.editCell(new Cell(1,1), playerSign);
        board.editCell(new Cell(2,1), playerSign);
        // When
        Optional<Character> actual = verticalLineWinConditionChecker.checkWinner(board);
        // Then
        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get()).isEqualTo(playerSign);
    }

}