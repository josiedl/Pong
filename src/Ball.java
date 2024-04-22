import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball {

    // Instance Variables
    PongViewer window;
    int x;
    int y;
    Image image;

    // Constructor
    public Ball(int x, int y, PongViewer window){
        this.x = x;
        this.y = y;
        this.window = window;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {

    }

    public void actionPerformed(ActionEvent e){

    }

    public boolean isColliding(Brick brick, Platform platform) {
        return false;
    }
}
