import javax.swing.*;
import java.awt.*;

public class EndGame extends JPanel {

    public EndGame(){

        this.setBackground(Color.GRAY);
        this.setFocusable(true);
        this.requestFocus();
    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null, Font.PLAIN,50));

        graphics.drawString("Player2 final score is : " + Main.getP2FinalScore() , 260, 160);
        if(Main.getP1FinalScore() > Main.getP2FinalScore()) {
            graphics.drawString("The Winner Is Player1",260,360);
        }else if(Main.getP1FinalScore() == Main.getP2FinalScore()){
            graphics.drawString("It Is Draw",260,360);
        }else {
            graphics.drawString("The Winner Is Player2",260,360);
        }
    }
}
