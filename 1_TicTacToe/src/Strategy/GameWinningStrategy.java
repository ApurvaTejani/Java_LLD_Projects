package Strategy;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board b, Player lastMovePlayer, Cell moveCell);
}
