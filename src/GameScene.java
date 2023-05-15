import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Player player1;
    private Player player2;
    public GameScene(){

        this.setBackground(Color.GRAY);

        this.player1 = new Player(100, 500, false);
        this.player2 = new Player(900, 500, true);

    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        this.player1.paint(graphics);
        this.player2.paint(graphics);
    }
}
