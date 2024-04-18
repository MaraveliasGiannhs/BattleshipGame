import javax.swing.*;

public class Board {
    String[][] Map = new String[7][7];
    String[][] BotMap = new String[7][7];

    Ship[] ships;

    public Board() {
        this.ships = Ship.GetAllShips();

        for (int i = 0; i < 7; i++) {           //For player
            for (int j = 0; j < 7; j++) {
                Map[i][j] = Tile.Texture.SEA.TypeTexture;
            }
        }
        for (int i = 0; i < 7; i++) {                 //For bot
            for (int j = 0; j < 7; j++) {
                BotMap[i][j] = Tile.Texture.SEA.TypeTexture;
            }
        }
    }

    public void DrawBotMapAfterShot() {
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                if (Map[i][j]!=Tile.Texture.MISS.TypeTexture && Map[i][j]!=Tile.Texture.HIT.TypeTexture){
                    System.out.printf(BotMap[i][j]);
                }
                else System.out.printf(Map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void DrawBoardAfterShot() {
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.printf(Map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void PlaceAllShipsRandomly() {

        for (int i = 0; i < this.ships.length; i++) {
            boolean check = false;
            Ship ship = this.ships[i];
            while (check == false) {
                ship.SetRandCoordinates();
                check = placeShip(this.ships[i]);
            }
        }
    }

    public boolean placeShip(Ship ship) {
        //na teirei parametrous
        int Axis;
        Axis = ship.X;
        if (ship.Direction == 1)
            Axis = ship.Y;


        if (ship.Size > Map.length - Axis) {
            return false;
        }

        for (int i = Axis; i < ship.Size + Axis; i++) {
            switch (ship.Direction) {
                case 1:
                    if (Map[ship.X][i] != Tile.Texture.SEA.TypeTexture) {
                        return false;
                    }
                    break;
                case 0:
                    if (Map[i][ship.Y]!=Tile.Texture.SEA.TypeTexture){
                        return false;
                    }
                    break;
            }
        }
        for (int i = Axis; i < ship.Size + Axis; i++) {
            switch (ship.Direction) {
                case 1:
                    Map[ship.X][i] = ship.tile.Value;
                    break;
                case 0:
                    Map[i][ship.Y] = ship.tile.Value;
                    break;
            }
        }
        return true;
    }

    public void AllShipsDestroyed() {
        //gameover
    }
}
