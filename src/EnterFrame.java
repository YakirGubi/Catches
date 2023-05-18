import javax.swing.*;

public class EnterFrame extends JFrame {

    public static final int Width = 1000;
    public static final int Height = 600;
    EnterPanel enterPanel;

    public EnterFrame(){

        enterPanel = new EnterPanel();

        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(enterPanel);


    }
    public void showFrame(){
        this.setVisible(true);
    }
}
