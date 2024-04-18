public class Tile {
    int X, Y;

    public enum Texture {
        SEA("~"),
        SHIP("s"),
        HIT("X"),
        MISS("O");

        final String TypeTexture;

        Texture(String TypeTexture) {
            this.TypeTexture = TypeTexture;
        }
    }

    public enum ShipsTextures {
        CRUISER("C"),
        DESTROYER("D"),
        CARRIER("c"),
        SUBMARINE("S"),
        BATTLESHIP("B");

        final String Value;

        public static boolean checkEnum(String text) {
            for (ShipsTextures b: ShipsTextures.values()) {
                if (b.Value.equalsIgnoreCase(text)) {
                    return true;
                }
            }
            return false;
        }

        ShipsTextures(String ShipsTextures) {
            this.Value = ShipsTextures;
        }
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int X) {
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
