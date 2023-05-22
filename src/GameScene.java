import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    public static Frame frame;
    private Player player1;
    private Player player2;
    private Wall[] walls;
    private Coin[] coins;
    private Trail[] P1Trail;
    private Trail[] P2Trail;
    private boolean P1Left;
    private boolean P1Right;
    private boolean P1Jump;
    private boolean P2Left;
    private boolean P2Right;
    private boolean P2Jump;
    private static int scoreP1;
    private static int scoreP2;
    private int timer;
    public GameScene(){

        this.setBackground(Color.GRAY);

        walls = Wall.maps(0);

        if(Main.getNumPlayed() == 0) {
            this.player1 = new Player(100, 500, false);
            this.player2 = new Player(900, 500, true);
        }else {
            this.player1 = new Player(100, 500, true);
            this.player2 = new Player(900, 500, false);
        }
        Main.setNumPlayed();

        this.coins = new Coin[3];
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = new Coin(0,0);
        }
        P1Trail = new Trail[20];
        for(int i = 0 ; i < P1Trail.length ; i++){
            P1Trail[i] = new Trail(P1Trail.length - i);
        }
        P2Trail = new Trail[20];
        for(int i = 0 ; i < P2Trail.length ; i++){
            P2Trail[i] = new Trail(P2Trail.length - i);
        }

        scoreP1 = 0;
        scoreP2 = 0;
        timer = 6000;

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
                moveTrail(player1,P1Trail);
                moveTrail(player2,P2Trail);

                if(!player1.isCatch()) {
                    if (player1.isTouchTheCoin(coins) != -1) {
                        scoreP1++;
                        coins[player1.isTouchTheCoin(coins)].replace(player1, player2, walls, coins);
                    }
                }else {
                    if (player2.isTouchTheCoin(coins) != -1) {
                        scoreP2++;
                        coins[player2.isTouchTheCoin(coins)].replace(player2, player1, walls, coins);
                    }
                }
                timer --;

                if(timer == 0 || player2.isTouchTheHunted(player1)){
                    if(!player1.isCatch()) {
                        Main.setP1FinalScore(scoreP1);
                    }else {
                        Main.setP2FinalScore(scoreP2);
                    }
                    frame = new Frame();
                    frame.showFrame();
                    EnterPanel.frame.dispose();
                    break;
                }
            }
        }).start();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null, Font.PLAIN,50));
        if(!player1.isCatch()) {
            graphics.drawString("Time: " + timer / 100 + ":" + timer % 100 + "\t\t Score: " + scoreP1, 260, 60);
        }else {
            graphics.drawString("Time: " + timer / 100 + ":" + timer % 100 + "\t\t Score: " + scoreP2, 260, 60);
        }

        for(Wall wall : walls){
            wall.paint(graphics);
        }
        for(Trail trail : P1Trail){
            trail.paint(graphics);
        }
        for(Trail trail : P2Trail){
            trail.paint(graphics);
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
    public static int getScoreP1() {
        return scoreP1;
    }
    public static int getScoreP2() {
        return scoreP2;
    }
    public void moveTrail(Player player , Trail[] trails){
        for(int i = trails.length - 1 ; i > 0 ; i--){
            trails[i].setX(trails[i-1].getX());
            trails[i].setY(trails[i-1].getY());
        }
        trails[0].setX(player.getX() + player.getWidth()/2 - trails[0].getSize()/2);
        trails[0].setY(player.getY() + player.getHeight()/2 - trails[0].getSize()/2);
    }
}
