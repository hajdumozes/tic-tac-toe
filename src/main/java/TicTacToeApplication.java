import component.BoardPrinter;
import component.PlayerSelector;
import component.UserInputParser;
import model.Board;
import model.Cell;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
        PlayerSelector playerSelector = new PlayerSelector();
        UserInputParser userInputParser = new UserInputParser();
        Cell cell = userInputParser.askForInput();
        board.editCell(cell, playerSelector.getCurrentPlayer().getSign());
        boardPrinter.printBoardState(board.getBoard());
    }
}
