public class Utils {

    public static int getRandInt(int Min,int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }
}
