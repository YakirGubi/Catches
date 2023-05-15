import java.awt.*;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isCatch;
    private boolean isCanJump;
    private int velocity;
    private Color color;


    public Player(int x, int y, boolean isCatch) {

        if (isCatch){
            this.color = Color.RED;
        }else this.color = Color.BLUE;

        this.x = x;
        this.y = y;

        this.width = 10;
        this.height = 15;


    }

    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, this.width, this.height);

    }

    public void move(int dx, Wall[] walls) {
        this.x += dx;
        this.y -= velocity;
        if (!isToucheTheGround(walls)){
            velocity --;
        }else {
            velocity = 0;
        }
    }
    public void jump() {
        this.velocity = 32;
    }

    public boolean isToucheTheGround(Wall[] walls) {
        if (this.y - this.height == 600) {
            return true;
        }
        for (int i = 0; i < walls.length; i++) {

            for (int j = 0; j < walls[i].getX(); j++) {
                for (int k = 0; k < walls[i].getY(); k++) {
                    if (this.y - this.height == walls[i].getY() && this.x == walls[i].getX()){
                        return true;
                    }
                }
            }
        }
        return false;
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
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isCatch() {
        return isCatch;
    }
    public void setCatch(boolean aCatch) {
        isCatch = aCatch;
    }
    public boolean isCanJump() {
        return isCanJump;
    }
    public void setCanJump(boolean canJump) {
        isCanJump = canJump;
    }
    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
