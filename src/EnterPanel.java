import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class EnterPanel extends JPanel implements ActionListener {

    private static Frame frame;
    private JButton enterButton;
    private ImageIcon image;

    public EnterPanel() {

        this.image = new ImageIcon("openW.png");

        this.enterButton = new JButton("Start");
        this.enterButton.addActionListener(this);
        this.enterButton.setFocusable(false);

        this.setBounds(0,0,1000,600);
        this.setFocusable(true);
        this.requestFocus();
        this.add(enterButton);

    }
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        this.image.paintIcon(this, graphics, 0, -10);

        graphics.setFont(new Font(null,5,18));

        this.enterButton.setBounds(440,460, 100, 50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the enterButton opening the frame again now with the GameScene
        if (e.getSource() == enterButton){

            frame = new Frame();
            frame.showFrame();

            Main.getFrame().dispose();
        }
    }

    public static Frame getFrame() {
        return frame;
    }

    public static void setFrame(Frame frame) {
        EnterPanel.frame = frame;
    }
}
