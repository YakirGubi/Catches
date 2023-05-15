import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Player player1;
    private Player player2;
    private Wall wall1;
    private Coin coin1;
    public GameScene(){

        this.setBackground(Color.GRAY);

        this.player1 = new Player(100, 500, false);
        this.player2 = new Player(900, 500, true);
        this.wall1 = new Wall(400,450,100,20);
        this.coin1 = new Coin(450,430);


    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        this.player1.paint(graphics);
        this.player2.paint(graphics);
        this.wall1.paint(graphics);
        this.coin1.paint(graphics);
    }
}
