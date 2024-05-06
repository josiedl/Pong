import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pong implements KeyListener, ActionListener, MouseListener {

    // Instance variables
    PongViewer window;
    boolean isWin;
    boolean isGameOver;
    Brick[][] bricks;
    Ball ball;
    Platform platform;
    final static int DELAY_IN_MILLISEC = 30;

    // Constructor
    public Pong() {
        window = new PongViewer(this);
        bricks = new Brick[5][5];
        // Create magic numbers later
        int y = 80;
        for (int i = 0; i < bricks.length; i++){
            int x = 45;
            for (int j = 0; j < bricks[0].length; j++){
                bricks[i][j] = new Brick(x, y, window);
                x += Brick.BRICK_WIDTH + 15;
            }
            y += Brick.BRICK_HEIGHT + 15;
        }
        platform = new Platform(window);
        ball = new Ball(240, 600);
        window.addKeyListener(this);
        window.addMouseListener(this);
    }

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

    public void setWin(boolean win) {
        isWin = win;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void actionPerformed(ActionEvent e){
        int count = 0;
        if (window.isStarted()) {
            ball.move();
        }
        for (int i = 0; i < bricks.length; i ++){
            for (int j = 0; j < bricks[0].length; j++){
                ball.bounce(0, PongViewer.WINDOW_WIDTH, PongViewer.TOP_OF_WINDOW, PongViewer.WINDOW_HEIGHT, bricks[i][j], platform);
                if (bricks[i][j].isVisible()){
                    count++;
                }
            }
        }
        if (count == 0) {
            setWin(true);
            window.setStarted(false);
        }
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
            case KeyEvent.VK_LEFT:
                platform.shiftX(-1);
                break;
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
        if (e.getX() < 400 && e.getX() > 100 && e.getY() < 690 && e.getY() > 580){
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

    public static void main(String[] args) {
        Pong game = new Pong();
        Timer clock = new Timer(DELAY_IN_MILLISEC, game);
        clock.start();
    }
}