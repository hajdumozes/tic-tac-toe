package component;

import model.Player;

public class PlayerSelector {
    private static final Player PLAYER_X = new Player('X');
    private static final Player PLAYER_O = new Player('O');

    private Player currentPlayer;

    public PlayerSelector() {
        this.currentPlayer = PLAYER_X;
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
    }
}
