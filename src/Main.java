public class Main {
    public  static EnterFrame enterFrame;
    private static int numScene;
    private static int numPlayed;
    private static int P1FinalScore;
    private static int P2FinalScore;
    public static void main(String[] args) {

        enterFrame = new EnterFrame();
        enterFrame.showFrame();

    }

    public static int getNumScene() {
        return numScene % 3;
    }

    public static void setNumScene() {
        Main.numScene ++;
    }
    public static int getNumPlayed() {
        return numPlayed % 2;
    }

    public static void setNumPlayed() {
        Main.numPlayed ++;
    }

    public static int getP1FinalScore() {
        return P1FinalScore;
    }

    public static void setP1FinalScore(int p1FinalScore) {
        P1FinalScore = p1FinalScore;
    }

    public static int getP2FinalScore() {
        return P2FinalScore;
    }

    public static void setP2FinalScore(int p2FinalScore) {
        P2FinalScore = p2FinalScore;
    }
}