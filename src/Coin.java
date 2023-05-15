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
    public void replace(Player player1 , Player player2 , Wall[] walls){
        Random random = new Random();
        int x;
        int y;

        do{
           x = random.nextInt();
           y = random.nextInt();
        }while
    }
    public boolean isCollision(Player player1 , Player player2 , Wall[] walls){
        boolean flag = false;
        if(player1.getX() >= this.x+this.size && player1.getX()+player1.getWidth() <= this.x){
            flag = true
        }
        return flag;
    }

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

}
