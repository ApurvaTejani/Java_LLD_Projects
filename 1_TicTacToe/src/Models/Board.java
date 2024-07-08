package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimensions;
    private List<List<Cell>> board;
    public Board(int dimensions){

        this.dimensions=dimensions;
        this.board= new ArrayList<>();
        for (int i = 0; i <dimensions ; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < dimensions ; j++) {
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void display(){
        for (int i = 0; i <board.size() ; i++) {
            for (int j = 0; j <board.size() ; j++) {
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.print("[ ]");
                else
                    System.out.println("[ "+board.get(i).get(j).getPlayer().getSymbol()+" ]");
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
