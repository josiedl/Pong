import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Back end
public class Pong implements KeyListener, ActionListener, MouseListener {

    // Instance variables
    PongViewer window;
    boolean isWin;
    boolean isGameOver;
    Brick[][] bricks;
    Ball ball;
    Platform platform;
    // Used to control the clock and thus how often actionPerformed occurs
    final static int DELAY_IN_MILLISEC = 30;
    private final int INITIAL_BRICK_Y = 80;
    private final int INITIAL_BRICK_X = 45;
    private final int SPACE_BETWEEN_BRICKS = 15;
    private final int INITAL_BALL_X = 240;
    private final int INITAL_BALL_Y = 600;
    private final int PLAY_X_MAX = 400;
    private final int PLAY_X_MIN = 100;
    private final int PLAY_Y_MAX = 690;
    private final int PLAY_Y_MIN = 580;

    // Constructor
    public Pong() {
        // Create a front end
        window = new PongViewer(this);
        // Bricks are a 2D array
        bricks = new Brick[5][5];
        int y = INITIAL_BRICK_Y;
        for (int i = 0; i < bricks.length; i++){
            int x = INITIAL_BRICK_X;
            for (int j = 0; j < bricks[0].length; j++){
                bricks[i][j] = new Brick(x, y, window);
                // Shift next brick right
                x += Brick.BRICK_WIDTH + SPACE_BETWEEN_BRICKS;
            }
            // Shift to next row
            y += Brick.BRICK_HEIGHT + SPACE_BETWEEN_BRICKS;
        }
        // Initialize platform and ball
        platform = new Platform();
        ball = new Ball(INITAL_BALL_X, INITAL_BALL_Y);
        // Implement KeyListener and MouseListener on the front end,
        // so it knows to be checking for keyboard and mouse input
        window.addKeyListener(this);
        window.addMouseListener(this);
    }

    // Getters
    public Brick[][] getBricks(){
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public Platform getPlatform() {
        return platform;
    }

    public boolean isWin() {
        return isWin;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    // Setters
    public void setWin(boolean win) {
        isWin = win;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    // Performs the animations
    public void actionPerformed(ActionEvent e){
        // Initialize a count that represents the number of bricks left
        int count = 0;
        // If the game has started, move the ball
        if (window.isStarted()) {
            ball.move();
        }
        // For each of the bricks
        for (int i = 0; i < bricks.length; i ++){
            for (int j = 0; j < bricks[0].length; j++){
                // Bounce the ball of each brick, platform, and borders of the window
                ball.bounce(bricks[i][j], platform);
                // If the brick is visible, add to count
                if (bricks[i][j].isVisible()){
                    count++;
                }
            }
        }
        // If there are no bricks left, set win to true
        if (count == 0) {
            setWin(true);
            window.setStarted(false);
        }
        // If the ball is below the platform, the game is over
        if (ball.getY() > platform.getY() + Platform.PLATFORM_HEIGHT) {
            setGameOver(true);
        }
        window.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            // When the left arrow key is pressed, shift the platform left
            case KeyEvent.VK_LEFT:
                platform.shiftX(-1);
                break;
            // When the right arrow key is pressed, shift the platform right
            case KeyEvent.VK_RIGHT:
                platform.shiftX(1);
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // If play button is clicked, start the game
        if (e.getX() < PLAY_X_MAX && e.getX() > PLAY_X_MIN && e.getY() < PLAY_Y_MAX && e.getY() > PLAY_Y_MIN){
            window.setStarted(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Main
    public static void main(String[] args) {
        // Create new game
        Pong game = new Pong();
        // Set timer (for animations)
        Timer clock = new Timer(DELAY_IN_MILLISEC, game);
        // Start timer
        clock.start();
    }
}