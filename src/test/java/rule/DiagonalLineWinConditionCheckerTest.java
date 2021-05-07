package rule;

import component.Board;
import model.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class DiagonalLineWinConditionCheckerTest {

    DiagonalLineWinConditionChecker diagonalLineWinConditionChecker;

    @BeforeEach
    public void init() {
        diagonalLineWinConditionChecker = new DiagonalLineWinConditionChecker();
    }

    @Test
    public void givenThereAreNoThreeExactSignNextToEachOther_checkWinner_shouldReturnWithNoWinner() {
        // Given
        Board board = new Board(3);
        char playerSign = 'X';
        board.editCell(new Cell(0,0), playerSign);
        board.editCell(new Cell(1,1), playerSign);
        // When
        Optional<Character> actual = diagonalLineWinConditionChecker.checkWinner(board);
        // Then
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    public void givenThereAreThreeExactSignNextToEachOther_checkWinner_shouldReturnWinnerPlayerSign() {
        // Given
        Board board = new Board(3);
        char playerSign = 'X';
        board.editCell(new Cell(0,0), playerSign);
        board.editCell(new Cell(1,1), playerSign);
        board.editCell(new Cell(2,2), playerSign);
        // When
        Optional<Character> actual = diagonalLineWinConditionChecker.checkWinner(board);
        // Then
        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get()).isEqualTo(playerSign);
    }

    @Test
    public void givenThereAreThreeExactSignNextToEachOtherInInverse_checkWinner_shouldReturnWinnerPlayerSign() {
        // Given
        Board board = new Board(3);
        char playerSign = 'X';
        board.editCell(new Cell(0,2), playerSign);
        board.editCell(new Cell(1,1), playerSign);
        board.editCell(new Cell(2,0), playerSign);
        // When
        Optional<Character> actual = diagonalLineWinConditionChecker.checkWinner(board);
        // Then
        assertThat(actual.isPresent()).isTrue();
        assertThat(actual.get()).isEqualTo(playerSign);
    }
}