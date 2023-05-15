import java.awt.*;
import java.util.Random;

public class Coin {
    private int x;
    private int y;
    private int size = 7;
    private Color color = Color.YELLOW;

    public Coin(int x , int y){
        this.x = x;
        this.y = y;
    }
//    public static void replace(Player player1 , Player player2 , Wall[] walls){
//        Random random = new Random();
//        int x;
//        int y;
//
//        do{
//           x = random.nextInt();
//           y = random.nextInt();
//        }while
//    }
//    public static boolean isCollision(Player player1 , Player player2 , Wall[] walls){
//        return false;
//    }

    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillOval(this.x, this.y, this.size, this.size);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
