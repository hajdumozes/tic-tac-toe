import component.BoardPrinter;
import component.PlayerSelector;
import component.UserInputParser;
import exception.CellAlreadyTakenException;
import model.Board;
import model.Cell;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
        PlayerSelector playerSelector = new PlayerSelector();
        processGame(board, boardPrinter, playerSelector);
    }

    private static void processGame(Board board, BoardPrinter boardPrinter, PlayerSelector playerSelector) {
        while (true) {
            processTurn(board, boardPrinter, playerSelector);
        }
    }

    private static void processTurn(Board board, BoardPrinter boardPrinter, PlayerSelector playerSelector) {
        UserInputParser userInputParser = new UserInputParser();
        Cell cell = userInputParser.askForInput();
        try {
            board.editCell(cell, playerSelector.getCurrentPlayer().getSign());
            boardPrinter.printBoardState(board.getBoard());
            playerSelector.endTurn();
        } catch (CellAlreadyTakenException e) {
            System.out.println("Cell already taken. Try another one");
            processTurn(board, boardPrinter, playerSelector);
        }
    }
}
