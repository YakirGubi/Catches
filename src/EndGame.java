import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame extends JPanel implements ActionListener {

    JButton button;
    Frame frame;
    public EndGame(){
        button = new JButton("Play Again");
        button.addActionListener(this);
        button.setFocusable(false);

        this.setBackground(new Color(170,170,170));
        this.setFocusable(true);
        this.requestFocus();
        this.add(button);
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
        button.setBounds(440,400, 100, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){

            frame = new Frame();
            frame.showFrame();

            Main.frame.dispose();
        }
    }
}
