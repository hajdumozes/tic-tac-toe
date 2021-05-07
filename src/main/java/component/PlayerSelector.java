package component;

import model.Player;

public class PlayerSelector {
    private static final Player PLAYER_X = new Player('X');
    private static final Player PLAYER_O = new Player('O');

    private Player currentPlayer;

    public PlayerSelector() {
        this.currentPlayer = PLAYER_X;
        printWhoStarts();
    }

    private void printWhoStarts() {
        System.out.println();
        System.out.printf("The game will start with player %s.", currentPlayer.getSign());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void endTurn() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
        printNewTurn();
    }

    private void printNewTurn() {
        System.out.println();
        System.out.printf("Turn of player %s.", currentPlayer.getSign());
    }
}
