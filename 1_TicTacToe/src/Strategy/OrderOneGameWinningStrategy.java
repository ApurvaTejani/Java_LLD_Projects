package Strategy;

import Models.Board;
import Models.Cell;
import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    List<HashMap<Character,Integer>> rowCount= new ArrayList<>();
    List<HashMap<Character,Integer>> colCount= new ArrayList<>();
    HashMap<Character,Integer> topLeftDiag = new HashMap<>();
    HashMap<Character,Integer> topRightDiag= new HashMap<>();
    public OrderOneGameWinningStrategy(int dimension){
        for (int i = 0; i < dimension; i++) {
            rowCount.add(new HashMap<>());
            colCount.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWinner(Board b, Player p, Cell moveCell) {
        char sym=p.getSymbol();
        int row=moveCell.getRow();
        int col=moveCell.getCol();
        int dimension=b.getBoard().size();
        if(!rowCount.get(row).containsKey(sym))
            rowCount.get(row).put(sym,1);
        else
            rowCount.get(row).put(sym,(rowCount.get(row).get(sym)+1));


        if(!colCount.get(col).containsKey(sym))
            colCount.get(col).put(sym,1);
        else
            colCount.get(col).put(sym,(colCount.get(col).get(sym)+1));

        if(isTopLeftDiag(row,col)){
            if(!topLeftDiag.containsKey(sym))
                topLeftDiag.put(sym,1);
            else
                topLeftDiag.put(sym,(topLeftDiag.get(sym)+1));
        }

        if(isTopRightDiag(row,col,dimension)){
            if(!topRightDiag.containsKey(sym))
                topRightDiag.put(sym,1);
            else
                topRightDiag.put(sym,(topRightDiag.get(sym)+1));
        }


        if(rowCount.get(row).get(sym)==dimension) return true;
        if(colCount.get(col).get(sym)==dimension) return true;
        if(isTopLeftDiag(row,col)){
            if(topLeftDiag.get(sym)==dimension) return true;
        }
        if(isTopRightDiag(row,col,dimension)){
            if(topRightDiag.get(sym)==dimension) return true;
        }
        return false;
    }

    public boolean isTopLeftDiag(int i,int j){
        return i==j;
    }

    public boolean isTopRightDiag(int i,int j,int n){
        return i+j==(n-1);
    }
}
