import javax.swing.*;

public class Frame extends JFrame{

    public static final int Width = 1000;
    public static final int Height = 600;
    GameScene gameScene;

    public Frame(){

        gameScene = new GameScene();

        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(gameScene);

    }
    public void showFrame(){
        this.setVisible(true);
    }
}
