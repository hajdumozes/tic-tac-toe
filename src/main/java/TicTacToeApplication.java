import component.BoardPrinter;
import model.Board;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
    }
}
