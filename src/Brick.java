import java.awt.*;

public class Brick {

    // Instance Variables
    PongViewer window;
    int x;
    int y;
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

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    // Setters
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    // Draws itself
    public void draw(Graphics g){
        // If it's visible, draw a terracotta brick
        if (isVisible){
            g.setColor(new Color(210, 108, 86, 255));
            g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        }
        // Otherwise, draw a white brick (looks invisible)
        else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        }
    }
}
