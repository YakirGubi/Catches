import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Coin {
    private int x;
    private int y;
    private int size = 15;
    private Color color = Color.YELLOW;
    File coinSound;
    AudioInputStream coinAudioSystem;
    Clip clip;

    public Coin(int x , int y){


        this.x = x;
        this.y = y;

        coinSound = new File("coinSound.wav");
        try {
            coinAudioSystem = AudioSystem.getAudioInputStream(coinSound);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(coinAudioSystem);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void replace(Player player1 , Player player2 , Wall[] walls , Coin[] coins){

        Random random = new Random();

        do{
           this.x = random.nextInt(977);
           this.y = random.nextInt(550);

        }while(isCollision(player1,player2,walls,coins));

        clip.setMicrosecondPosition(0);
        clip.start();
    }
    public boolean isCollision(Player player1 , Player player2 , Wall[] walls , Coin[] coins){

        if (this.x + this.size >= player1.getX() && this.x <= player1.getX() + player1.getWidth()) {
            if (this.y + this.size >= player1.getY() && this.y <= player1.getY() + player1.getHeight()) {

                return true;
            }
        }
        if (this.x + this.size >= player2.getX() && this.x <= player2.getX() + player2.getWidth()) {
            if (this.y + this.size >= player2.getY() && this.y <= player2.getY() + player2.getHeight()) {

                return true;
            }
        }
        for (Wall wall : walls) {
            if (this.x + this.size >= wall.getX() && this.x <= wall.getX() + wall.getWidth()) {
                if (this.y + this.size >= wall.getY() && this.y <= wall.getY() + wall.getHeight()) {

                    return true;
                }
            }
        }
        int count = 0;
        for (int i = 0 ; i < coins.length ; i++) {
            if (this.x + this.size >= coins[i].getX() && this.x <= coins[i].getX() + coins[i].getSize()) {
                if (this.y + this.size >= coins[i].getY() && this.y <= coins[i].getY() + coins[i].getSize()) {

                    count++;
                }
            }
        }
        if(count < 1){
            return true;
        }
        return false;
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
