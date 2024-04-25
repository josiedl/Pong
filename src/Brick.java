import java.awt.*;

public class Brick {

    // Instance Variables
    PongViewer window;
    int x;
    int y;
    Image image;
    public static final int BRICK_WIDTH = 70;
    public static final int BRICK_HEIGHT = 15;

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
        g.setColor(new Color(210, 108, 86, 255));
        g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
    }
}
