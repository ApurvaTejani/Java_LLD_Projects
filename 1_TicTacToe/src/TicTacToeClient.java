import Controller.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension no of the game");
        int dimension= sc.nextInt();
        System.out.println("Enter if you need a bot or not (y/n)");
        String isBot=sc.next();
        int noOfPlayer=dimension-1;
        List<Player> players= new ArrayList<>();
        if(isBot.equalsIgnoreCase("y"))
        {
            noOfPlayer=noOfPlayer-1;
            System.out.println("Enter the name of the bot 1");
            String name = sc.next();
            System.out.println("Enter the symbol for bot 1");
            char symbol=sc.next().charAt(0);
            System.out.println("Enter the Difficultity Level- Easy,Medium or Hard");
            String bdlString= sc.next();
            BotDifficuiltyLevel bdl=(bdlString.equalsIgnoreCase("easy")?BotDifficuiltyLevel.EASY:BotDifficuiltyLevel.MEDIUM);
            players.add(new Bot(symbol,name, PlayerType.BOT,bdl));

        }

        for (int i = 0; i < noOfPlayer; i++) {
            System.out.println("Enter the name of the player "+(i+1));
            String name = sc.next();
            System.out.println("Enter the symbol for player "+(i+1));
            char symbol=sc.next().charAt(0);
            players.add(new Player(symbol,name, PlayerType.HUMAN));
        }
        GameController gc = new GameController();
        Game g= gc.createGame(dimension,players);
        int count=0;
        while(gc.getGameStatus(g).equals(GameStatus.IN_PROGRESS))
        {
            System.out.println("This is the current board below");
            gc.displayBoard(g);
            String isUndo="";
            if(count!=0) {
                System.out.println("Do you want to do undo? y/n or want to see reply (history) of moves?");
                 isUndo = sc.next();
            }

            if(isUndo.equalsIgnoreCase("y")){
                gc.undo(g);
                count=0;
            } else if (isUndo.equalsIgnoreCase("history")) {
                gc.replayMoves(g);
            } else {
                gc.executeNextMove(g);
                count=1;
            }

        }


    }
}
