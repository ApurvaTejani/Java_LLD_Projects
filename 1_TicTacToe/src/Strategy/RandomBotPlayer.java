package Strategy;

import Models.*;

import java.util.Random;

public class RandomBotPlayer implements BotPlayingStrategy {

    @Override
    public Move botPlayingAlgo(Bot bot, Board b) {
        int row=0;
        int col=0;
        while(true){
            Random r = new Random();
            int i= r.nextInt(b.getDimensions());
            int j=r.nextInt(b.getDimensions());
            if(b.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                row=i;
                col=j;
                break;
            }
        }
        return new Move(bot,new Cell(row,col));
    }
}
