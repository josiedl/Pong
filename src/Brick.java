import java.awt.*;

public class Brick {

    // Instance Variables
    PongViewer window;
    int x;
    int y;
    Image image;
    public boolean isVisible;
    public static final int BRICK_WIDTH = 70;
    public static final int BRICK_HEIGHT = 15;

    // Constructor
    public Brick(int x, int y, PongViewer window){
        this.x = x;
        this.y = y;
        this.window = window;
        isVisible = true;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
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
        if (isVisible){
            g.setColor(new Color(210, 108, 86, 255));
            g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        }
    }
}
