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
    private int speed = 5;


    public Player(int x, int y, boolean isCatch) {

        velocity = 0;

        this.isCatch = isCatch;
        //making the escaper blue and the catcher red.
        if (isCatch){
            this.color = Color.RED;
        }else this.color = Color.BLUE;

        this.x = x;
        this.y = y;

        this.width = 20;
        this.height = 30;
    }

    public void paint(Graphics graphics) {

        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, this.width, this.height);

    }

    public void move(int dx, Wall[] walls) {

        //the player move on the x-axis and not go through walls.
        if (isTouchTheRightWall(walls)) {
            if(dx >= 0){
                this.x += dx;
            }
        }else if (isTouchTheLeftWall(walls)) {
            if(dx <= 0){
                this.x += dx;
            }
        }else{
            this.x += dx;
        }
        //the player move on the y-axis and not go through walls.
        if (!isTouchTheLeftWall(walls) && !isTouchTheRightWall(walls)){
            this.y -= this.velocity;
        }
        if (!isToucheTheGround(walls)) {
            this.velocity--;
            isTouchTheCeiling(walls);
        }else {
            this.velocity = 0;
        }
    }
    public void jump(Wall[] walls) {
        //making the player jump only if he is on the ground or the walls.
        if(isTouchTheLeftWall(walls)) {
            this.velocity = 15;
            this.x -= this.speed;
        }else if(isTouchTheRightWall(walls)){
            this.velocity = 15;
            this.x += this.speed;
        }else if(isToucheTheGround(walls)) {
            this.velocity = 15;
        }
    }

    public boolean isToucheTheGround(Wall[] walls) {
        //checking that the player on the ground.
        for (Wall wall : walls) {
            if(this.x + this.width >= wall.getX() + this.speed && this.x < wall.getX() + wall.getWidth() - this.speed){
                if (this.y + this.height >= wall.getY() && this.y < wall.getY() + wall.getHeight() / 2){
                    this.y = wall.getY() - this.height;
                    return true;
                }
            }
        }
        return false;
    }

    public void isTouchTheCeiling(Wall[] walls){
        //checking that the player touching the ceiling.
        for (Wall wall : walls) {
            if(this.x + this.width >= wall.getX() + this.speed && this.x < wall.getX() + wall.getWidth() - this.speed){
                if (this.y >= wall.getY() && this.y <= wall.getY() + wall.getHeight()){

                    this.y = wall.getY() + wall.getHeight();
                    this.velocity = -1;
                    break;
                }
            }
        }
    }

    private boolean isTouchTheLeftWall(Wall[] walls) {
        //checking that the player touching the left side of the wall.
        for (Wall wall : walls) {
            if (this.x + this.width >= wall.getX() && this.x + this.width <= wall.getX() + this.speed) {
                if (this.y >= wall.getY() && this.y <= wall.getY() + wall.getHeight()) {

                    this.x = wall.getX() - this.width;
                    this.velocity = 0;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTouchTheRightWall(Wall[] walls){
        //checking that the player touching the right side of the wall.
        for (Wall wall : walls) {
            if (this.x <= wall.getX() + wall.getWidth() && this.x >= wall.getX() + wall.getWidth() - this.speed){
                if (this.y >= wall.getY() && this.y <= wall.getY() + wall.getHeight()){

                    this.x = wall.getX() + wall.getWidth();
                    this.velocity = 0;
                    return true;
                }
            }
        }
        return false;
    }


    public int isTouchTheCoin(Coin[] coins) {
        //checking if the escape one touch a coin and what the number of the coin.
        if (!this.isCatch){
            for (int i = 0; i < coins.length; i++) {
                if (this.x + this.width >= coins[i].getX() && this.x < coins[i].getX() + coins[i].getSize()){
                    if (this.y + this.height >= coins[i].getY() && this.y <= coins[i].getY() + coins[i].getSize()){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isTouchTheHunted(Player player) {
        //checking if the players touch each other.
        if (this.x + this.width >= player.getX() && this.x <= player.getX() + player.getWidth()) {
            if (this.y + this.height >= player.getY() && this.y <= player.getY() + player.getHeight()) {
                return true;
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
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
