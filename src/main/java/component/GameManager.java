package component;

import exception.CellAlreadyTakenException;
import model.Cell;

public class GameManager {
    Board board;
    BoardPrinter boardPrinter;
    PlayerSelector playerSelector;

    public GameManager(Board board, BoardPrinter boardPrinter, PlayerSelector playerSelector) {
        this.board = board;
        this.boardPrinter = boardPrinter;
        this.playerSelector = playerSelector;
    }

    public void start() {
        while (true) {
            processTurn();
        }
    }

    private void processTurn() {
        UserInputParser userInputParser = new UserInputParser();
        Cell cell = userInputParser.askForInput();
        try {
            board.editCell(cell, playerSelector.getCurrentPlayer().getSign());
            boardPrinter.printBoardState(board.getBoard());
            playerSelector.endTurn();
        } catch (CellAlreadyTakenException e) {
            System.out.println("Cell already taken. Try another one");
            processTurn();
        }
    }
}
