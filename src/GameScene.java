import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private Player player1;
    private Player player2;
    private Wall[] walls;
    private Coin[] coins;
    private boolean P1Left;
    private boolean P1Right;
    private boolean P1Jump;
    private boolean P2Left;
    private boolean P2Right;
    private boolean P2Jump;
    private int score;
    private int timer;
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
                if(P1Jump){
                    player1.jump(walls);
                }
                if(P2Jump){
                    player2.jump(walls);
                }
                if(P1Right){
                    player1.move(player1.getSpeed(),walls);
                }else if(P1Left){
                    player1.move(-player1.getSpeed(),walls);
                }else {
                    player1.move(0,walls);
                }
                if(P2Right){
                    player2.move(player2.getSpeed(),walls);
                }else if(P2Left){
                    player2.move(-player2.getSpeed(),walls);
                }else {
                    player2.move(0,walls);
                }

                if(player1.isTouchTheCoin(coins) != -1){
                    score++;
                    coins[player1.isTouchTheCoin(coins)].replace(player1,player2,walls,coins);
                }
                timer += 1;

                if(timer == 6000 || player2.isTouchTheHunted(player1)){
                    System.out.println("The game end: \nThe hunted get " + score + " points");
                }
            }
        }).start();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null,0,50));
        graphics.drawString("Time: " + timer / 100 + ":" + timer % 100 + "\t\t Score: " + score, 260, 60);

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
            this.P2Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.P2Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.P2Right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.P1Jump = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            this.P1Left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.P1Right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.P2Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.P2Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.P2Right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.P1Jump = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            this.P1Left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.P1Right = false;
        }
    }
}
