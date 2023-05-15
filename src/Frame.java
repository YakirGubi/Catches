import javax.swing.*;

public class Frame extends JFrame{

    public static final int Width = 1000;
    public static final int Height = 600;

    public Frame(){
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    public void showFrame(){
        this.setVisible(true);
    }
}
