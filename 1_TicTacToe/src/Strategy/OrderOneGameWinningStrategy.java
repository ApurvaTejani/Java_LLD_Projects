package Strategy;

import Models.Board;
import Models.Cell;
import Models.Player;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {

    public OrderOneGameWinningStrategy(int dimension){

    }
    @Override
    public boolean checkWinner(Board b, Player lastMovePlayer, Cell moveCell) {
        return false;
    }
}
