package component;

import exception.CellAlreadyTakenException;
import model.Cell;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BoardTest {

    Board board;

    @BeforeEach
    public void init() {
        board = new Board(3);
    }

    @Test
    public void givenCellIsNotEditedYet_editCell_shouldEdit() {
        // Given
        Cell cell = new Cell(1, 1);
        char newValue = 'X';
        // When
        board.editCell(cell, newValue);
        // Then
        assertThat(board.getCell(cell)).isEqualTo(newValue);
    }

    @Test
    public void givenCellIsAlreadyEdited_editCell_shouldThrowError() {
        // Given
        Cell cell = new Cell(1, 1);
        char newValue = 'X';
        // When
        board.editCell(cell, newValue);
        ThrowableAssert.ThrowingCallable operation = () -> board.editCell(cell, newValue);
        // Then
        assertThatThrownBy(operation).isInstanceOf(CellAlreadyTakenException.class);
    }
}
