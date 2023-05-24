import javax.swing.*;

public class Frame extends JFrame{

    private final int Width = 1000;
    private final int Height = 600;
    private EnterPanel enterPanel;
    private GameScene gameScene;
    private SecondHalf secondHalf;
    private EndGame endGame;
    public Frame(){

        this.setTitle("Catches");
        this.setResizable(false);
        this.setSize(Width,Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //checking what panel need to be open, by checking the % of the NumScene in Main.
        if(Main.getNumScene() == 0) {

            this.enterPanel = new EnterPanel();
            this.add(this.enterPanel);
            Main.setNumScene();

        }else if(Main.getNumScene() == 1) {

            this.gameScene = new GameScene();
            this.add(this.gameScene);
            Main.setNumScene();

        }else if(Main.getNumScene() == 2){

            this.secondHalf = new SecondHalf();
            this.add(this.secondHalf);
            Main.setNumScene();

        }else if(Main.getNumScene() == 3) {

            this.gameScene = new GameScene();
            this.add(this.gameScene);
            Main.setNumScene();

        }else {
            this.endGame = new EndGame();
            this.add(this.endGame);
            Main.setNumScene();
        }
    }
    public void showFrame(){
        this.setVisible(true);
    }
}