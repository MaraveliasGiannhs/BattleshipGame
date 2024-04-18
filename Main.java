import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.multiplyExact;
import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {

        int x, y, answer;
        boolean CheckFire = false;
        boolean CheckBotFire = false;
        boolean CheckParameters = false;
        boolean allShipsSet = false;
        int Direction;

        Scanner input = new Scanner(System.in);

        Player player = new Player();  //players
        Player Bot = new Player();    //


        System.out.println("\n\nWelcome To SeaFight");
        System.out.println("      SELECT:   ");
        System.out.print("\n   1. Place my ships at random coordinates.");
        System.out.print("\n   2. I will choose the coordinates of each ship.");
        System.out.println("\n   3. EXIT");

        answer = input.nextInt();
        if (answer == 1) {
            player.board.PlaceAllShipsRandomly();
            Bot.board.PlaceAllShipsRandomly();

            while (player.SuccessfulShots != 16 && Bot.SuccessfulShots != 16) {
                CheckFire=false;
                CheckBotFire=false;
                System.out.println("BOT BOARD");
                Bot.board.DrawBotMapAfterShot();

                System.out.println("YOUR BOARD");
                player.board.DrawBoardAfterShot();



                while (CheckFire == false) {
                    System.out.println("Choose Vertical direction for your shot");
                    x = input.nextInt();
                    System.out.println("Choose Horizontal direction for your shot");
                    y = input.nextInt();
                    CheckFire = player.Fire(x, y, Bot.board.Map);
                }
                while (CheckBotFire==false){
                    CheckBotFire = Bot.botFire(player.board.Map);

                }
            }
//            Board.PlaceAllShipsRandomly(randomX1,randomX2,randomY1,randomY2, Carrier.Size);
//            x=Utils.getRandInt();
//                    Board.PlaceAllShipsRandomly(randomX1,randomX2,randomY1,randomY2, Destroyer.Size);
        } else if (answer == 2) {
            Bot.board.PlaceAllShipsRandomly();

            System.out.println("BOT BOARD");
            Bot.board.DrawBotMapAfterShot();

            System.out.println("YOUR BOARD");
            player.board.DrawBoardAfterShot();


            for (int i=0;i<5;i++){

                allShipsSet=false;

                while (allShipsSet==false){
                    System.out.println("Choose coordinates for ship "+i+"/5:");

                    System.out.println("Vertical:");
                    x=input.nextInt();
                    System.out.println("Horizontal:");
                    y=input.nextInt();
                    System.out.println("Direction (0 for Horizontal, 1 for Vertical):");
                    Direction=input.nextInt();

                    allShipsSet=player.PlayerPlaceShip(x,y,Direction,player.board.Map,i);

                }
                System.out.println("BOT BOARD");
                Bot.board.DrawBotMapAfterShot();

                System.out.println("YOUR BOARD");
                player.board.DrawBoardAfterShot();

            }
            while (player.SuccessfulShots != 16 && Bot.SuccessfulShots != 16) {
                CheckFire=false;
                CheckBotFire=false;
                System.out.println("BOT BOARD");
                Bot.board.DrawBotMapAfterShot();

                System.out.println("YOUR BOARD");
                player.board.DrawBoardAfterShot();



                while (CheckFire == false) {
                    System.out.println("Choose Vertical direction for your shot");
                    x = input.nextInt();
                    System.out.println("Choose Horizontal direction for your shot");
                    y = input.nextInt();
                    CheckFire = player.Fire(x, y, Bot.board.Map);
                }
                while (CheckBotFire==false){
                    CheckBotFire = Bot.botFire(player.board.Map);

                }
            }

        } else if (answer == 3) {
            System.out.println("bye");
        }


//        Board PlayerBoard = new Board();
//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(PlayerBoard.Map[i][j]);
//            }
//            System.out.print("\n");
//
//        }
    }
}
