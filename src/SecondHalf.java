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
        new Thread(()->{
            while (true) {
                Utils.sleep(1000);
                timer--;
                if (timer < 0) {
                   frame = new Frame();
                   frame.showFrame();
                   GameScene.frame.dispose();
                   break;
                }
                repaint();
            }
        }).start();
    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null, Font.PLAIN,50));
        graphics.drawString("Player1 final score is : " + GameScene.getScoreP1(),200,160);
        graphics.drawString("Next round start in " + timer + " seconds",160,360);


    }
}
