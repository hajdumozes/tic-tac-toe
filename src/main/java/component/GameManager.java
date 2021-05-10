package component;

import exception.CellAlreadyTakenException;
import model.Cell;
import rule.WinConditionChecker;

import java.util.List;
import java.util.Optional;

public class GameManager {
    Board board;
    BoardPrinter boardPrinter;
    PlayerSelector playerSelector;
    List<WinConditionChecker> winConditionCheckerList;

    public GameManager(Board board, BoardPrinter boardPrinter, PlayerSelector playerSelector, List<WinConditionChecker> winConditionCheckerList) {
        this.board = board;
        this.boardPrinter = boardPrinter;
        this.playerSelector = playerSelector;
        this.winConditionCheckerList = winConditionCheckerList;
    }

    public void start() {
        Optional<Character> winner = Optional.empty();
        while (winner.isEmpty()) {
            processTurn();
            winner = checkWinner();
        }
        System.out.println(winner.get() + " won!");
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

    private Optional<Character> checkWinner() {
        return winConditionCheckerList
            .stream()
            .flatMap(winConditionChecker -> winConditionChecker.checkWinner(board).stream())
            .findAny();
    }
}
