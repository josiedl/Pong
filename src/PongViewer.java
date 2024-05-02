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
        // Draw title
        g.setColor(new Color(191, 255, 170, 255));
        g.setFont(new Font("Serif", Font.PLAIN, 80));
        g.drawString("P•O•N•G", 75, 150);

        // Draw separators
        g.setColor(new Color(255, 153, 90, 255));
        g.drawString("* * * * * * * *", 5, 275);
        g.drawString("* * * * * * * *", 5, 550);

        // Write instructions
        g.setColor(new Color(192, 148, 236, 255));
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString("•Use the platform to bounce", 50, 300);
        g.drawString("  the ball and break the bricks!", 50, 330);
        g.drawString("•Break all the bricks to win!", 50, 380);
        g.drawString("•Don't let the ball fall!", 50, 430);

        // Draw mini versions of the objects
        g.setColor(new Color(78, 182, 227, 255));
        g.fillRect(380, 300, 70, 20);
        g.setColor(new Color(210, 108, 86, 255));
        g.fillRect(360, 365, 60, 15);
        g.setColor(new Color(255, 229, 95, 255));
        g.fillOval(330, 410, 20, 20);

        // Draw the play button
        g.setColor(new Color(255, 161, 211, 255));
        g.fillRect(100, 580, 300, 110);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 70));
        g.drawString("PLAY", 165, 660);
    }

    public void myPaint(Graphics g){
        drawInstructions(g);
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
        if (game.isWin()) {
            g.setColor(Color.WHITE);
            g.fillRect(0,  0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("YOU WIN", 75, 150);

        }
        if (game.isGameOver()) {
            g.setColor(Color.WHITE);
            g.fillRect(0,  0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("GAME OVER", 75, 150);
        }
    }
}
