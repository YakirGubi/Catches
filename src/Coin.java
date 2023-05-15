import java.awt.*;

public class Coin {
    private int x;
    private int y;
    private int size = 7;
    private Color color = Color.YELLOW;

    public Coin(int x , int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillOval(this.x, this.y, this.size, this.size);

    }
}
