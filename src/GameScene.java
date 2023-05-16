import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private Player player1;
    private Player player2;
    private Wall[] walls;
    private Coin[] coins;
    private final int speed = 5;
    private int DxPlayer1;
    private int DxPlayer2;
    private boolean P1Left;
    private boolean P1Right;
    private boolean P1Jump;
    private boolean P2Left;
    private boolean P2Right;
    private boolean P2Jump;
    private int score;
    private int timer;
    JLabel label;
    public GameScene(){

        this.setBackground(Color.GRAY);

        walls = Wall.maps(0);



        this.player1 = new Player(100, 500, false);
        this.player2 = new Player(900, 500, true);
        this.coins = new Coin[3];
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = new Coin(0,0);
        }

        score = 0;
        timer = 0;
        label = new JLabel("Time: " + timer/100 + ":" + timer%100 + "\t\t Score: " + score);
        label.setBounds(0,0,1000,50);
        label.setBackground(Color.GRAY);
        label.setVisible(true);
        label.setFont(new Font(null,0,50));
        this.add(label);

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);

        for (Coin coin : coins){
            coin.replace(player1,player2,walls,coins);
        }

        mainGameLoop();


    }
    public void mainGameLoop(){
        new Thread(()->{
            while (true){
                Utils.sleep(10);
                repaint();
                if(P1Right){
                    DxPlayer1 = speed;
                }else if(P1Left){
                    DxPlayer1 = -speed;
                }else {
                    DxPlayer1 = 0;
                }
                if(P2Right){
                    DxPlayer2 = speed;
                }else if(P2Left){
                    DxPlayer2 = -speed;
                }else {
                    DxPlayer2 = 0;
                }
                if(P1Jump){
                    player1.jump(walls);
                }
                if(P2Jump){
                    player2.jump(walls);
                }
                player1.move(DxPlayer1,walls);
                player2.move(DxPlayer2,walls);
//                if(player1){
//                    score++;
//                }
                timer += 1;
                label.setText("Time: " + timer/100 + ":" + timer%100 + "\t\t Score: " + score);
            }
        }).start();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        for(Wall wall : walls){
            wall.paint(graphics);
        }
        this.player1.paint(graphics);
        this.player2.paint(graphics);
        for(Coin coin : coins){
            coin.paint(graphics);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.P1Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.P1Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.P1Right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.P2Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            this.P2Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.P2Right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.P1Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.P1Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.P1Right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.P2Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            this.P2Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.P2Right = false;
        }
    }
}
