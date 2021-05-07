import component.BoardPrinter;
import component.UserInputParser;
import model.Board;
import model.Cell;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
        UserInputParser userInputParser = new UserInputParser();
        Cell cell = userInputParser.askForInput();
        board.editCell(cell, 'X');
        boardPrinter.printBoardState(board.getBoard());
    }
}
