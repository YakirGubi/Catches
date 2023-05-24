import javax.swing.*;
import java.awt.*;

public class SecondHalf extends JPanel {

    public static Frame frame;
    private int timer;

    public SecondHalf(){

        timer = 5;

        this.setBackground(new Color(170,170,170));
        this.setFocusable(true);
        this.requestFocus();

        mainLoop();
    }
    public void mainLoop(){
        //making timer for the next game.
        new Thread(()->{
            while (true) {
                Utils.sleep(1000);
                timer--;
                //if the timer go to 0 it closes the frame and open the next panel.
                if (timer < 0) {
                   frame = new Frame();
                   frame.showFrame();
                   GameScene.getFrame().dispose();
                   break;
                }
                repaint();
            }
        }).start();
    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null, Font.PLAIN,50));
        graphics.drawString("Player1 final score is : " + GameScene.getScore(),200,160);
        graphics.drawString("Next round start in " + timer + " seconds",160,360);
    }

    public static Frame getFrame() {
        return frame;
    }

    public static void setFrame(Frame frame) {
        SecondHalf.frame = frame;
    }
}
