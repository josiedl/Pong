import javax.swing.*;
import java.awt.*;

public class PongViewer extends JFrame{

    // Instance Variables
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 800;
    Pong game;
    Image[] pieces;

    // Constructor
    public PongViewer(Pong game){
        this.game = game;

        // Construct basic requirements for a frontend
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Pong by Josie Lee");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Pong getGame(){
        return game;
    }

    public Image[] getPieces(){
        return pieces;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,  0, WINDOW_WIDTH, WINDOW_HEIGHT);
        if (game.getPlatform() != null){
            game.getPlatform().draw(g);
        }
    }
}
