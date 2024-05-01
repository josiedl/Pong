import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platform{

    // Instance Variables
    PongViewer window;
    int x;
    final int Y = 700;
    public static final int PLATFORM_WIDTH = 90;
    Image image;

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

    public void shiftX(int shift, int xLow, int xHigh) {
        if (x + shift <= xLow && shift < 0) {
            x = xLow;
        }
        else if (x + PLATFORM_WIDTH + shift >= xHigh && shift > 0) {
            x = xHigh - PLATFORM_WIDTH;
        }
        else {
            x += shift;
        }
    }

    public void draw(Graphics g){
        g.setColor(new Color(78, 182, 227, 255));
        g.fillRect(x, Y, PLATFORM_WIDTH, 20);
    }
}