import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScene extends JPanel implements KeyListener {

    private static Frame frame;
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
    private static int score;
    private int timer;
    public GameScene(){

        this.setBackground(Color.GRAY);
        //choosing the map from the maps that made in Wall.maps(now there are only one map).
        this.walls = Wall.maps(0);
        //choosing how is the player that need to be the catch and who is the escaper, by the NumPlayed in Main.
        if(Main.getNumPlayed() == 0) {
            this.player1 = new Player(100, 500, false);
            this.player2 = new Player(900, 500, true);
        }else {
            this.player1 = new Player(100, 500, true);
            this.player2 = new Player(900, 500, false);
        }
        Main.setNumPlayed();

        this.coins = new Coin[3];
        for(int i = 0 ; i < this.coins.length ; i++){
            coins[i] = new Coin(0,0);
        }
        this.P1Trail = new Trail[20];
        for(int i = 0 ; i < this.P1Trail.length ; i++){
            this.P1Trail[i] = new Trail(this.P1Trail.length - i);
        }
        this.P2Trail = new Trail[20];
        for(int i = 0 ; i < this.P2Trail.length ; i++){
            this.P2Trail[i] = new Trail(this.P2Trail.length - i);
        }

        this.score = 0;
        this.timer = 6000;

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        //replacing the coins for new location instead (0,0).
        for (Coin coin : coins){
            coin.replace(this.player1, this.player2, this.walls, this.coins);
        }

        mainGameLoop();
    }
    public void mainGameLoop(){
        new Thread(()->{
            while (true){
                Utils.sleep(10);
                repaint();
                if(this.P1Jump){
                    this.player1.jump(this.walls);
                }
                if(this.P2Jump){
                    this.player2.jump(this.walls);
                }
                if(this.P1Right){
                    this.player1.move(this.player1.getSpeed(),this.walls);
                }else if(P1Left){
                    this.player1.move(-this.player1.getSpeed(),this.walls);
                }else {
                    this.player1.move(0,this.walls);
                }
                if(this.P2Right){
                    this.player2.move(this.player2.getSpeed(),this.walls);
                }else if(this.P2Left){
                    this.player2.move(-this.player2.getSpeed(),this.walls);
                }else {
                    this.player2.move(0,this.walls);
                }
                moveTrail(this.player1,this.P1Trail);
                moveTrail(this.player2,this.P2Trail);
                //checking if the escape one touch a coin.
                if(!this.player1.isCatch()) {
                    if (this.player1.isTouchTheCoin(this.coins) != -1) {
                        this.score++;
                        this.coins[this.player1.isTouchTheCoin(this.coins)].replace(this.player1, this.player2, this.walls, this.coins);
                    }
                }else {
                    if (this.player2.isTouchTheCoin(this.coins) != -1) {
                        this.score++;
                        this.coins[this.player2.isTouchTheCoin(this.coins)].replace(this.player2, this.player1, this.walls, this.coins);
                    }
                }
                this.timer --;
                //checking if the game need to end by the timer or by the catcher.
                if(this.timer == 0 || this.player2.isTouchTheHunted(this.player1)){
                    //if the game end it updates the escaper FinalScore(in Main).
                    if(!this.player1.isCatch()) {
                        Main.setP1FinalScore(this.score);
                    }else {
                        Main.setP2FinalScore(this.score);
                    }
                    //the frame close and opening the next panel.
                    this.frame = new Frame();
                    this.frame.showFrame();
                    if (Main.getNumPlayed() == 1){
                        EnterPanel.getFrame().dispose();
                    }else SecondHalf.getFrame().dispose();

                    break;
                }
            }
        }).start();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        graphics.setFont(new Font(null, Font.PLAIN,50));
        if(!this.player1.isCatch()) {
            graphics.drawString("Time: " + this.timer / 100 + ":" + this.timer % 100 + "\t\t Score: " + this.score, 260, 60);
        }else {
            graphics.drawString("Time: " + this.timer / 100 + ":" + this.timer % 100 + "\t\t Score: " + this.score, 260, 60);
        }

        for(Wall wall : this.walls){
            wall.paint(graphics);
        }
        for(Trail trail : this.P1Trail){
            trail.paint(graphics);
        }
        for(Trail trail : this.P2Trail){
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
    public static int getScore() {
        return score;
    }
    public void moveTrail(Player player , Trail[] trails){
        //making the Trail go after the player in order from big to smale.
        for(int i = trails.length - 1 ; i > 0 ; i--){
            trails[i].setX(trails[i-1].getX());
            trails[i].setY(trails[i-1].getY());
        }
        trails[0].setX(player.getX() + player.getWidth() / 2 - trails[0].getSize() / 2);
        trails[0].setY(player.getY() + player.getHeight() / 2 - trails[0].getSize() / 2);
    }

    public static Frame getFrame() {
        return frame;
    }

    public static void setFrame(Frame frame) {
        GameScene.frame = frame;
    }
}
