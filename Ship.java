import javax.naming.Name;

public abstract class Ship {  //abstract

    int X, Y, Direction, Size;
    String Name;
    Tile.ShipsTextures tile;

    public Ship(int Size, String Name, Tile.ShipsTextures tile) {
        this.Name = Name;
        this.Size = Size;
        this.tile = tile;
    }

    public void SetRandCoordinates() {
        this.X = Utils.getRandInt(0, 6);
        this.Y = Utils.getRandInt(0, 6);
        this.Direction = Utils.getRandInt(0, 1);
    }

    public void SetCoordinates() {
        this.X = X;
        this.Y = Y;
        this.Direction = Direction;
    }

    public static Ship[] GetAllShips() {
        Ship[] ships = {new Cruiser(), new Battleship(), new Carrier(), new Destroyer(), new Submarine()};
        return ships;
    }
}

class Carrier extends Ship {
    public Carrier() {
        super(5, "Carrier", Tile.ShipsTextures.CARRIER);
    }
}

class Battleship extends Ship {
    public Battleship() {
        super(4, "Battleship", Tile.ShipsTextures.BATTLESHIP);
    }
}

class Cruiser extends Ship {
    public Cruiser() {
        super(3, "Cruiser", Tile.ShipsTextures.CRUISER);
    }
}

class Submarine extends Ship {
    public Submarine() {
        super(2, "Submarine", Tile.ShipsTextures.SUBMARINE);
    }
}

class Destroyer extends Ship {
    public Destroyer() {
        super(2, "Destroyer", Tile.ShipsTextures.DESTROYER);
    }

}

