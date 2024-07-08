package Models;

import java.util.ArrayList;
import java.util.List;
import Exception.InvalidGameConstructorParameterException;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves; // needed for undo
    private GameStatus gamestatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gws;
    private Player winner;
    public void undo(){

    }
    private Game(){


    }
    public void makeNextMove(){

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setGamestatus(GameStatus gamestatus) {
        this.gamestatus = gamestatus;
    }

    public void displayBoard() {
        this.board.display();
    }

    public static class Builder {
    private  int dimensions;
    private List<Player> players;



        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Game build() throws InvalidGameConstructorParameterException {
                if(validate()) {
                    Game g = new Game();
                    g.setGamestatus(GameStatus.IN_PROGRESS);
                    g.setPlayers(players);
                    g.setMoves(new ArrayList<>());
                    g.setBoard(new Board(dimensions));
                    g.setNextPlayerIndex(0);
                    return g;
                }

                return null;



        }
        public boolean validate() throws InvalidGameConstructorParameterException {
            if(dimensions<3)
                throw new InvalidGameConstructorParameterException("Dimensions should be greater or equal to 3");
            if(this.dimensions-1!=this.players.size())
                throw new InvalidGameConstructorParameterException("There is some mismatch");


            return true;
        }
    }
}
