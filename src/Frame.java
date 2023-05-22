import javax.swing.*;
import java.util.Scanner;

public class Frame extends JFrame{

    public static final int Width = 1000;
    public static final int Height = 600;
    GameScene gameScene;
    public static EnterPanel enterPanel;
    public static SecondHalf secondHalf;
    public static EndGame endGame;
    public Frame(){

        this.setTitle("Catches");
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        if(Main.getNumScene() == 0) {
            enterPanel = new EnterPanel();
            this.add(enterPanel);
            Main.setNumScene();
        }else if(Main.getNumScene() == 1) {
            gameScene = new GameScene();
            this.add(gameScene);
            Main.setNumScene();
        }else if(Main.getNumScene() == 2){
            secondHalf = new SecondHalf();
            this.add(secondHalf);
            Main.setNumScene();
        }else if(Main.getNumScene() == 3) {
            gameScene = new GameScene();
            this.add(gameScene);
            Main.setNumScene();
        }else {
            endGame = new EndGame();
            this.add(endGame);
            Main.setNumScene();
        }
    }
    public void showFrame(){
        this.setVisible(true);
    }
}
