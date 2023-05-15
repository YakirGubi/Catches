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
}
