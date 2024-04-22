import java.awt.*;
import java.awt.event.ActionEvent;

public class Platform {

    // Instance Variables
    PongViewer window;
    int x;
    final int y = 700;
    Image image;

    // Constructor
    public Platform(int x, PongViewer window){
        this.x = x;
        this.window = window;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isColliding(Ball ball){
        return false;
    }

    public void actionPerformed(ActionEvent e){

    }

    public void draw(Graphics g){

    }
}