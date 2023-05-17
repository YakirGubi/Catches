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
    public static Wall[] maps(int num){
        Wall[] map;

        if(num == 0){
            map = new Wall[19];
            map[5] = new Wall(100, 150, 100, 20);
            map[6] = new Wall(300, 150, 100, 20);
            map[7] = new Wall(600, 150, 100, 20);
            map[8] = new Wall(800, 150, 100, 20);
            map[9] = new Wall(100, 300, 100, 20);
            map[10] = new Wall(300, 300, 100, 20);
            map[11] = new Wall(600, 300, 100, 20);
            map[12] = new Wall(800, 300, 100, 20);
            map[13] = new Wall(100, 450, 100, 20);
            map[14] = new Wall(300, 450, 100, 20);
            map[15] = new Wall(600, 450, 100, 20);
            map[16] = new Wall(800, 450, 100, 20);
            map[17] = new Wall(490, 150, 20, 100);
            map[18] = new Wall(490, 350, 20, 100);

        }else{
            map = new Wall[5];
        }

        map[0] = new Wall(0, 555, 1000, 10);
        map[1] = new Wall(0, 0, 1000, 10);
        map[2] = new Wall(0, 0, 10, 600);
        map[3] = new Wall(977, 0, 10, 600);
        map[4] = new Wall(-10, 0, 1000, 10);

        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
