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

    int STEP_SIZE = 20;
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
        ball = new Ball(100, 100);
        platform = new Platform(window);
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
        ball.move();
        ball.bounce(0, PongViewer.WINDOW_WIDTH, PongViewer.TOP_OF_WINDOW, PongViewer.WINDOW_HEIGHT);
        window.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                platform.shiftX(-STEP_SIZE, 0, PongViewer.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                platform.shiftX(STEP_SIZE, 0, PongViewer.WINDOW_WIDTH);
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        // Change the color
//        clickNum++;
//        b.setColor(COLORS[clickNum % 3]);
//
//        window.repaint();
//
//        // For demo purposes only
//        System.out.println("mousePressed event handler executed.");

        // figure out how to get play button
        window.setStarted(true);
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
        game.run();
    }
}