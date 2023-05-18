import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterPanel extends JPanel implements ActionListener {

    JButton enterButton;

    public EnterPanel() {

        enterButton = new JButton();
        enterButton.addActionListener(this);
        enterButton.setFocusable(false);

        this.setBounds(0,0,1000,600);
//        this.setFocusable(true);
//        this.requestFocus();
        this.add(enterButton);

    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null,0,50));
        graphics.drawString("", 260, 60);
        enterButton.setBounds(100,100, 100, 100);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enterButton){

            Frame frame = new Frame();
            frame.showFrame();

            Main.enterFrame.dispose();
        }
    }
}
