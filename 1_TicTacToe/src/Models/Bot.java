package Models;

import Strategy.BotPlayingStrategy;
import Strategy.RandomBotPlayer;

public class Bot extends Player {
    private BotDifficuiltyLevel bdl;
    private BotPlayingStrategy bps;
    public Bot(char symbol, String name, PlayerType type) {
        super(symbol, name, type);
        this.bdl=BotDifficuiltyLevel.EASY;
        this.setBps(new RandomBotPlayer());
    }
    RandomBotPlayer rbp = new RandomBotPlayer();

    public void setBps(BotPlayingStrategy bps) {
        this.bps = bps;
    }

    public Move decideMove(Board b)  {
        Move m = bps.botPlayingAlgo(this,b);
        return m;
    }
}
