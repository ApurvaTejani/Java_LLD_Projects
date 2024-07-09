package Controller;

import Models.Game;
import Models.GameStatus;
import Models.Player;

import java.util.List;

public class GameController {


    public Game createGame(int dimensions, List<Player> players)  {
        try {
            return Game.getBuilder().setDimensions(dimensions)
                    .setPlayers(players)
                    .build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public void displayBoard(Game g){
        g.displayBoard();
    }


    public GameStatus getGameStatus(Game g) {
        return  g.getGamestatus();
    }

    public void undo(Game g) {
        g.undo();
    }

    public void executeNextMove(Game g) {
        g.makeNextMove();
    }

    public void replayMoves(Game g) {
        g.replayMoves();
    }
}
