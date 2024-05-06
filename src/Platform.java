import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platform{

    // Instance Variables
    PongViewer window;
    private int x;
    private final int Y = 700;
    public static final int PLATFORM_WIDTH = 90;
    public static final int PLATFORM_HEIGHT = 20;
    private final int STEP_SIZE = 20;

    // Constructor
    public Platform(PongViewer window){
        x = 205;
        this.window = window;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return Y;
    }

    public boolean isColliding(Ball ball){
        return false;
    }

    public void actionPerformed(ActionEvent e){

    }

    public void shiftX(int direction) {
        int shift = STEP_SIZE * direction;
        if (x + shift <= 0 && shift < 0) {
            x = 0;
        }
        else if (x + PLATFORM_WIDTH + shift >= PongViewer.WINDOW_WIDTH && shift > 0) {
            x = PongViewer.WINDOW_WIDTH - PLATFORM_WIDTH;
        }
        else {
            x += shift;
        }
    }

    public void draw(Graphics g){
        g.setColor(new Color(78, 182, 227, 255));
        g.fillRect(x, Y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }
}