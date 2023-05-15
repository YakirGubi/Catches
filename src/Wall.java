import java.awt.*;

public class Wall {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color = Color.black;

    public Wall(int x , int y , int width , int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, this.width, this.height);

    }

}
