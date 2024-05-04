import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball {

    // Instance Variables
    int x;
    int y;
    Image image;
    public static final int radius = 10;
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
        x = x - dx;
        y = y - dy;
    }

    public void bounce(int xLow, int xHigh, int yLow, int yHigh, Brick brick, Platform platform) {
        int diameter = radius * 2;
        if (x <= 0 || x + diameter >= PongViewer.WINDOW_WIDTH) {
            dx = -dx;
        }
        if (y <= PongViewer.TOP_OF_WINDOW || y + diameter >= PongViewer.WINDOW_HEIGHT) {
            dy = -dy;
        }
        if (((x + diameter == brick.getX()) || (x == brick.getX() + Brick.BRICK_WIDTH)) && ((y + radius < brick.getY() + Brick.BRICK_HEIGHT) && (y + radius > brick.getY()) && brick.isVisible())){
            dx = -dx;
            brick.setVisible(false);
        }
        if (((y + diameter == brick.getY()) || (y == brick.getY() + Brick.BRICK_HEIGHT)) && ((x + radius < brick.getX() + Brick.BRICK_WIDTH) && (x + radius > brick.getX()) && brick.isVisible())){
            dy = -dy;
            brick.setVisible(false);
        }
        if ((y + diameter == platform.getY()) && ((x + radius < platform.getX() + Platform.PLATFORM_WIDTH) && (x + radius > platform.getX()))){
            dy = -dy;
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 229, 95, 255));
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}