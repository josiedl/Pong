import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball {

    // Instance Variables
    int x;
    int y;
    Image image;
    final int radius = 10;
    // Velocity - how much to move the ball in one time unit
    private int dx = 10;
    private int dy = 10;

    // Constructor
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x = x + dx;
        y = y + dy;
    }
    public void bounce(int xLow, int xHigh, int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((x - radius <= xLow && dx < 0) || (x + radius >= xHigh && dx > 0)) {
            dx = -dx;
        }
        // Now check for a y bounce.
        if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0)) {
            dy = -dy;
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 229, 95, 255));
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    public boolean isColliding(Brick brick, Platform platform) {
        return false;
    }
}