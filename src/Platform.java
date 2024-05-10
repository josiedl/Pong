import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platform{

    // Instance Variables
    private int x;
    private final int INITIAL_X = 205;
    private final int Y = 700;
    public static final int PLATFORM_WIDTH = 90;
    public static final int PLATFORM_HEIGHT = 20;
    private final int STEP_SIZE = 20;

    // Constructor
    public Platform(){
        x = INITIAL_X;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return Y;
    }

    // Shifts the platform left and right
    public void shiftX(int direction) {
        int shift = STEP_SIZE * direction;
        // If the shift goes past the left side of the window, set platform to leftmost edge
        if (x + shift <= 0 && shift < 0) {
            x = 0;
        }
        // If the shift goes past the right side of the window, set platform to rightmost edge
        else if (x + PLATFORM_WIDTH + shift >= PongViewer.WINDOW_WIDTH && shift > 0) {
            x = PongViewer.WINDOW_WIDTH - PLATFORM_WIDTH;
        }
        // Otherwise just add shift
        else {
            x += shift;
        }
    }

    // Draws itself
    public void draw(Graphics g){
        g.setColor(new Color(78, 182, 227, 255));
        g.fillRect(x, Y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }
}