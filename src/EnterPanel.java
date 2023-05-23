import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class EnterPanel extends JPanel implements ActionListener {

    public static Frame frame;
    JButton enterButton;
    ImageIcon image;

    public EnterPanel() {

        image = new ImageIcon("Untitled.png");

        enterButton = new JButton("Start");
        enterButton.addActionListener(this);
        enterButton.setFocusable(false);

        this.setBounds(0,0,1000,600);
        this.setFocusable(true);
        this.requestFocus();
        this.add(enterButton);

    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        this.image.paintIcon(this, graphics, 0, 0);

        graphics.setFont(new Font(null,5,18));

        enterButton.setBounds(440,440, 100, 50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enterButton){

            frame = new Frame();
            frame.showFrame();

            Main.frame.dispose();
        }
    }
}
