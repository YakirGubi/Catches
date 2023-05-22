import java.awt.*;

public class Trail {
    private int x;
    private int y;
    private int size;
    private Color color = new Color(170,170,170);

    public Trail(int size){

        this.size = size;
    }
    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillOval(this.x, this.y, this.size, this.size);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
