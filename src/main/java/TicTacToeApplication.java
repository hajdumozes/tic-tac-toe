import component.Board;
import component.BoardPrinter;
import component.GameManager;
import component.PlayerSelector;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board(3);
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoardState(board.getBoard());
        PlayerSelector playerSelector = new PlayerSelector();
        GameManager gameManager = new GameManager(board, boardPrinter, playerSelector);
        gameManager.start();
    }


}
