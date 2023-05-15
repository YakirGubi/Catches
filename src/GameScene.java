import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private Player player1;
    private Player player2;
    private Wall[] walls;
    private Coin coin1;
    private int DxPlayer1;
    private int DxPlayer2;
    private boolean P1Left;
    private boolean P1Right;
    private boolean P1Jump;
    private boolean P2Left;
    private boolean P2Right;
    private boolean P2Jump;
    public GameScene(){

        this.setBackground(Color.GRAY);

        walls = new Wall[]{new Wall(0, 550, 1000, 50)};

        this.player1 = new Player(100, 500, false);
        this.player2 = new Player(900, 500, true);
        this.coin1 = new Coin(450,430);

        mainGameLoop();


    }
    public void mainGameLoop(){
        new Thread(()->{
            while (true){
                Utils.sleep(10);
                repaint();
                if(P1Right){
                    DxPlayer1 = 1;
                }else if(P1Left){
                    DxPlayer1 = -1;
                }else {
                    DxPlayer1 = 0;
                }
                if(P2Right){
                    DxPlayer2 = 1;
                }else if(P2Left){
                    DxPlayer2 = -1;
                }else {
                    DxPlayer2 = 0;
                }
                if(P1Jump){
                    player1.jump();
                }
                if(P2Jump){
                    player2.jump();
                }
                player1.move(DxPlayer1,walls);
                player2.move(DxPlayer2,walls);
            }
        }).start();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        this.walls[0].paint(graphics);
        this.player1.paint(graphics);
        this.player2.paint(graphics);
        this.coin1.paint(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            P1Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            P1Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            P1Right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            P2Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            P2Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            P2Right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            P1Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            P1Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            P1Right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            P2Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            P2Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            P2Right = false;
        }
    }
}
