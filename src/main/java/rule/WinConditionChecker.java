package rule;

import component.Board;

import java.util.Optional;

public interface WinConditionChecker {
    Optional<Character> checkWinner(Board board);
}
