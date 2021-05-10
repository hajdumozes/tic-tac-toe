import component.Board;
import component.BoardPrinter;
import component.GameManager;
import component.PlayerSelector;
import rule.DiagonalLineWinConditionChecker;
import rule.HorizontalLineWinConditionChecker;
import rule.VerticalLineWinConditionChecker;
import rule.WinConditionChecker;

import java.util.List;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
        PlayerSelector playerSelector = new PlayerSelector();
        List<WinConditionChecker> winConditionCheckers = List.of(
            new DiagonalLineWinConditionChecker(),
            new HorizontalLineWinConditionChecker(),
            new VerticalLineWinConditionChecker());
        GameManager gameManager = new GameManager(board, boardPrinter, playerSelector, winConditionCheckers);
        gameManager.start();
    }


}
