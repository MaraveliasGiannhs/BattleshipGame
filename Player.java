public class Player {
    int Shots;
    int MissedShots;
    int SuccessfulShots;
    Board board;

    public Player() {
        board = new Board();
    }

    public boolean Fire(int X, int Y, String BotBoard[][]) {
        //Tile.ShipsTextures.checkEnum(board.BotMap[X][Y])
        if (X>6 || X<0 || Y>6 || Y<0){
            System.out.println("Choose the correct parameters (0-6)");
            return false;
        }
        if (Tile.ShipsTextures.checkEnum(BotBoard[X][Y])) {

            System.out.println("You hit an enemy ship!");
            //board.Map[X][Y] = Tile.Texture.HIT.TypeTexture;

            BotBoard[X][Y] = Tile.Texture.HIT.TypeTexture;
            this.SuccessfulShots++;


            //this.board.Map[X][Y] = Tile.Texture.HIT.TypeTexture;
            return true;

        }else if (BotBoard[X][Y]==Tile.Texture.MISS.TypeTexture || BotBoard[X][Y]==Tile.Texture.HIT.TypeTexture) {
            System.out.println("You've already shot there. Try again.");
            return false;
            //System.out.println("You've already hit a ship there. Try again.");

        }else if (!Tile.ShipsTextures.checkEnum(BotBoard[X][Y])) {

            System.out.println("You missed!");
            this.MissedShots++;
            //board.Map[X][Y] = Tile.Texture.MISS.TypeTexture;

            BotBoard[X][Y] = Tile.Texture.MISS.TypeTexture;
            //this.board.Map[X][Y] = Tile.Texture.MISS.TypeTexture;
            return true;

        }
        return false;
    }
    public boolean botFire(String playerMap[][]){
        int x=Utils.getRandInt(0,6);
        int y=Utils.getRandInt(0,6);

        if (Tile.ShipsTextures.checkEnum(playerMap[x][y])) {

            playerMap[x][y] = Tile.Texture.HIT.TypeTexture;
            this.SuccessfulShots++;
            return true;

        } else if (!Tile.ShipsTextures.checkEnum(playerMap[x][y])) {
            playerMap[x][y] = Tile.Texture.MISS.TypeTexture;
            return true;
        }
        else return false;

    }

    public boolean PlayerPlaceShip(int x, int y, int direction, String playerMap[][],int i) {
        boolean check;
        if (x > 6 || x < 0 || y > 6 || y < 0) {
            System.out.println("Choose the correct parameters (0-6)");
            return false;
        }
//        direction=x;
//        if (direction==1)
//            direction=y;
            Ship ship = this.board.ships[i];
            this.board.ships[i].X=x;
            this.board.ships[i].Y=y;
            this.board.ships[i].Direction=direction;
            check=this.board.placeShip(this.board.ships[i]);
            return check;


    }



    public void getStats() {
        System.out.println("Your Stats:");
        System.out.println("Sucessful shots:"+SuccessfulShots);
        System.out.println("MissedShots"+MissedShots);
    }
}
