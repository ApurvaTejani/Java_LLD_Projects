package Models;

public class Bot extends Player {
    private BotDifficuiltyLevel bdl;
    private BotPlayingStrategy bps;
    public Bot(char symbol, String name, PlayerType type,BotDifficuiltyLevel bdl) {
        super(symbol, name, type);
        this.bdl=bdl;

    }
}
