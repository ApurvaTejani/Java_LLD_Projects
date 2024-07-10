package Strategy;

import Models.*;

import java.util.Random;

public interface BotPlayingStrategy {
     Move botPlayingAlgo(Bot bot, Board b);
}
