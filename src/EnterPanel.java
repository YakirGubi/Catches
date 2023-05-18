import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterPanel extends JPanel implements ActionListener {

    public static Frame frame;
    JButton enterButton;

    public EnterPanel() {

        enterButton = new JButton();
        enterButton.addActionListener(this);
        enterButton.setFocusable(false);

        this.setBounds(0,0,1000,600);
        this.setFocusable(true);
        this.requestFocus();
        this.add(enterButton);

    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null,5,40));
        graphics.drawString("Welcome to catches", 280, 60);
        graphics.drawString("In catches there are a chaser and fugitive", 100, 120);
        graphics.drawString("In catches there are a chaser and fugitive", 100, 120);
        enterButton.setBounds(440,400, 100, 50);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enterButton){

            frame = new Frame();
            frame.showFrame();

            Main.enterFrame.dispose();
        }
    }
}
