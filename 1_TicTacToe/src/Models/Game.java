package Models;

import java.util.ArrayList;
import java.util.List;
import Exception.InvalidGameConstructorParameterException;
import Strategy.GameWinningStrategy;
import Strategy.OrderOneGameWinningStrategy;
import Exception.CellAlreadyFilledException;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves; // needed for undo
    private GameStatus gamestatus;
    private int currentPlayerIndex;

    public List<Move> getMoves() {
        return moves;
    }

    private GameWinningStrategy gws;
    int reservedPositionForUndo;

    public void setGws(GameWinningStrategy gws) {
        this.gws = gws;
    }

    private Player winner;
    public void undo(){
        Move undoMove= moves.get(moves.size()-1);
        int row=undoMove.getCell().getRow();
        int col=undoMove.getCell().getCol();

        board.getBoard().get(row).get(col).setCellState(CellState.EMPTY);
        board.getBoard().get(row).get(col).setPlayer(null);
        moves.remove(moves.size()-1);
        currentPlayerIndex=reservedPositionForUndo;
    }
    private Game(){


    }
    public void makeNextMove() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println(players.get(currentPlayerIndex).getName()+" 's Turn to play");
        Move move = null;
        try {
            move = currentPlayer.decideMove(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        CellState validateCell=board.getBoard().get(row).get(col).getCellState();
        try {
            if (validateCell.equals(CellState.FILLED)) {
                throw new CellAlreadyFilledException("This placed is already filled by " + players.get((currentPlayerIndex+1)%players.size()).getName());

            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("Move happened at: "+row+" ,"+col);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);

        Move finalMove=new Move(currentPlayer,board.getBoard().get(row).get(col));
        moves.add(finalMove);

        if(gws.checkWinner(board,currentPlayer,finalMove.getCell()))
        {
            gamestatus=GameStatus.WIN;
            winner=currentPlayer;
            System.out.println(winner.getName()+" is the winner -> "+winner.getSymbol());
            board.display();
            System.out.println("Game is ending now. <<Congratulations>>");
        }
        if(checkDraw()){
            System.out.println("Game has been Draw .  Ending now");
        }
        reservedPositionForUndo=currentPlayerIndex;
        currentPlayerIndex=currentPlayerIndex+1;
        currentPlayerIndex =currentPlayerIndex%players.size();
    }

    public boolean checkDraw(){
        if(moves.size()== board.getDimensions()* board.getDimensions()) {
            List<String> names = new ArrayList<>();
            for (Player p :
                    players) {
                names.add(p.getName());
            }
            gamestatus=GameStatus.DRAW;
            System.out.println("Players "+names+" have been tied in this match");
            return true;
        }
        return false;
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

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
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

    public GameStatus getGamestatus() {
        return gamestatus;
    }

    public void replayMoves() {
        for (Move m:
             moves) {
            System.out.print("("+m.getCell().getRow()+", "+m.getCell().getCol()+") ");
        }
        System.out.println(" were the past moves.");
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


        public Game build()  {
            try {
                if (validate()) {
                    Game g = new Game();
                    g.setGamestatus(GameStatus.IN_PROGRESS);
                    g.setPlayers(players);
                    g.setMoves(new ArrayList<>());
                    g.setBoard(new Board(dimensions));
                    g.setCurrentPlayerIndex(0);
                    g.setGws(new OrderOneGameWinningStrategy(dimensions));
                    return g;
                }
            }
            catch (InvalidGameConstructorParameterException e){
                System.out.println(e);

            }
            return null;
        }
        public boolean validate() throws InvalidGameConstructorParameterException {
            if(dimensions<3)
                throw new InvalidGameConstructorParameterException("Dimensions should be greater or equal to 3");
            if(this.dimensions-1!=this.players.size())
                throw new InvalidGameConstructorParameterException("There is some mismatch");
            for (Player p:
                 players) {
                if(Character.isDigit(p.getSymbol()))
                    throw new InvalidGameConstructorParameterException("Symbol cannot be digits");
                else if (p.getName().length()==0) {
                    throw new InvalidGameConstructorParameterException("Name cant be empty");
                }
                else if(Character.toString(p.getSymbol()).length()!=1){
                    throw new InvalidGameConstructorParameterException("Symbol should be of 1 Letter only");
                    }
                }
            return true;
            }


        }
    }
