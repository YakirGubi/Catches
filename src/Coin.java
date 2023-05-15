import java.awt.*;
import java.util.Random;

public class Coin {
    private int x;
    private int y;
    private int size = 15;
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
        }while(isCollision(player1,player2,walls));

        this.x = x;
        this.y = y;
    }
    public boolean isCollision(Player player1 , Player player2 , Wall[] walls){
        boolean flag = false;
        if(player1.getX() >= this.x+this.size && player1.getX()+player1.getWidth() <= this.x && player1.getY() >= this.y+this.size && player1.getY()+player1.getHeight() <= this.x+this.size  ){
            flag = true;
        }else if(player2.getX() >= this.x+this.size && player2.getX()+player2.getWidth() <= this.x && player2.getY() >= this.y+this.size && player2.getY()+player2.getHeight() <= this.x+this.size){
            flag = true;
        }else {
            for (Wall wall : walls) {
                if (wall.getX() >= this.x + this.size && wall.getX() + wall.getWidth() <= this.x && wall.getY() >= this.y + this.size && wall.getY() + wall.getHeight() <= this.x + this.size) {
                    flag = true;
                    break;
                }
            }
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
