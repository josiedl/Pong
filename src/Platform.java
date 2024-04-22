import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platform implements KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}