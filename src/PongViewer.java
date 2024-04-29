import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class PongViewer extends JFrame{

    // Instance Variables
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 800;
    public static final int TOP_OF_WINDOW = 22;
    Pong game;
    Image[] pieces;
    private boolean isStarted;
    private boolean isGameOver;

    // Constructor
    public PongViewer(Pong game) {
        this.game = game;

        isStarted = false;
        isGameOver = false;

        // Construct basic requirements for a frontend
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Pong by Josie Lee");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

        createBufferStrategy(2);
    }

    public boolean isStarted() {
        return isStarted;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Pong getGame(){
        return game;
    }

    public Image[] getPieces(){
        return pieces;
    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;

        Graphics g2 = null;

        try {
            g2 = bf.getDrawGraphics();
            // myPaint does the actual drawing, as described in ManyBallsView
            myPaint(g2);
        }
        finally {
            // It is best to dispose() a Graphics object when done with it.
            g2.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();

        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        //Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawInstructions(Graphics g){
        // print instructions
    }

    public void myPaint(Graphics g){
        // print instructions
        if (isStarted) {
            g.setColor(Color.WHITE);
            g.fillRect(0,  0, WINDOW_WIDTH, WINDOW_HEIGHT);
            if (game.getPlatform() != null) {
                game.getPlatform().draw(g);
            }

            if (game.getBricks() != null) {
                for (Brick[] bricks : game.getBricks()){
                    for (Brick b : bricks) {
                        b.draw(g);
                    }
                }
            }

            if (game.getBall() != null) {
                game.getBall().draw(g);
            }
        }
        // if game is over
    }
}
