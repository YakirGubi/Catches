import javax.swing.*;

public class EnterFrame extends JFrame {

    public static final int Width = 1000;
    public static final int Height = 600;
    public static EnterPanel enterPanel;
    public static SecondHalf secondHalf;
    public static EndGame endGame;

    public EnterFrame(){

        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        if(Main.getNumScene() == 0) {
            enterPanel = new EnterPanel();
            this.add(enterPanel);
        }else if(Main.getNumScene() == 1){
            secondHalf = new SecondHalf();
            this.add(secondHalf);
        }else {
            endGame = new EndGame();
            this.add(endGame);
        }
        Main.setNumScene();
    }
    public void showFrame(){
        this.setVisible(true);
    }
}
