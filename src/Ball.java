import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball {

    // Instance Variables
    int x;
    int y;
    public static final int radius = 10;
    // Velocity - how much to move the ball in one time unit
    private int dx = 10;
    private int dy = 10;

    // Constructor
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Getter
    public int getY() {
        return y;
    }

    // Moves the ball by dx and dy
    public void move() {
        x = x - dx;
        y = y - dy;
    }

    // Bounces the ball off all surfaces
    public void bounce(Brick brick, Platform platform) {
        int diameter = radius * 2;
        // If the ball is touching the sides, change directions laterally
        if (x <= 0 || x + diameter >= PongViewer.WINDOW_WIDTH) {
            dx = -dx;
        }
        // If the ball is touching the top, change directions vertically
        if (y <= PongViewer.TOP_OF_WINDOW ) {
            dy = -dy;
        }
        // If the ball is touching either side of the brick, change directions laterally
        if (((x + diameter == brick.getX()) || (x == brick.getX() + Brick.BRICK_WIDTH)) && ((y + radius < brick.getY() + Brick.BRICK_HEIGHT) && (y + radius > brick.getY()) && brick.isVisible())){
            dx = -dx;
            // Make the brick not visible
            brick.setVisible(false);
        }
        // If the ball is touching the top or bottom of the brick, change directions vertically
        if (((y + diameter == brick.getY()) || (y == brick.getY() + Brick.BRICK_HEIGHT)) && ((x + radius < brick.getX() + Brick.BRICK_WIDTH) && (x + radius > brick.getX()) && brick.isVisible())){
            dy = -dy;
            // Make the brick not visible
            brick.setVisible(false);
        }
        // If the ball is touching the top of the platform, change directions vertically
        if ((y + diameter == platform.getY()) && ((x + radius < platform.getX() + Platform.PLATFORM_WIDTH) && (x + radius > platform.getX()))){
            dy = -dy;
        }
    }

    // Draws itself
    public void draw(Graphics g) {
        g.setColor(new Color(255, 229, 95, 255));
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}