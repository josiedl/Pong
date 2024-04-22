import java.awt.event.ActionEvent;

public class Pong {

    // Instance variables
    PongViewer window;
    boolean isWin;
    boolean isGameOver;
    Brick[] bricks;
    Ball ball;
    Platform platform;

    // Constructor
    public Pong() {
        window = new PongViewer(this);
        // Temporary numbers
        bricks = new Brick[10];
        for (int i = 0; i < bricks.length; i++){
            bricks[i] = new Brick(0, 0, window);
        }
        ball = new Ball(0, 0, window);
        platform = new Platform(0, window);
    }

    public Brick[] getBricks(){
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public Platform getPlatform() {
        return platform;
    }

    public boolean checkWin(){
        return false;
    }

    public boolean checkGameOver(){
        return false;
    }

    public boolean checkCollision(){
        return false;
    }

    public void run(){

    }

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {

    }
}