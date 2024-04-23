import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong implements KeyListener {

    // Instance variables
    PongViewer window;
    boolean isWin;
    boolean isGameOver;
    Brick[] bricks;
    Ball ball;
    Platform platform;
    int STEP_SIZE = 10;

    // Constructor
    public Pong() {
        window = new PongViewer(this);
        // Temporary numbers
        bricks = new Brick[10];
        for (int i = 0; i < bricks.length; i++){
            bricks[i] = new Brick(0, 0, window);
        }
        ball = new Ball(0, 0, window);
        platform = new Platform(window);
        window.addKeyListener(this);
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
        window.repaint();
    }

    public void actionPerformed(ActionEvent e){

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                platform.shiftX(-STEP_SIZE, 0, window.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                platform.shiftX(STEP_SIZE, 0, window.WINDOW_WIDTH);
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Pong game = new Pong();
        game.run();
    }
}