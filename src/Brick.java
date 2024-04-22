import java.awt.*;

public class Brick {

    // Instance Variables
    PongViewer window;
    int x;
    int y;
    Image image;

    // Constructor
    public Brick(int x, int y, PongViewer window){
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

    public boolean isColliding(Ball ball){
        return false;
    }

    public void draw(Graphics g){

    }
}
