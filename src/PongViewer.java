import java.awt.*;

public class PongViewer {

    // Instance Variables
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 800;
    Pong game;
    Image[] pieces;

    // Constructor
    public PongViewer(Pong game){
        this.game = game;
    }

    public Pong getGame(){
        return game;
    }

    public Image[] getPieces(){
        return pieces;
    }

    public void repaint(Graphics g){

    }
}
