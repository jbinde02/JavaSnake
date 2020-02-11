

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameField field = new GameField();

    GameView(GameField field){
        System.out.println("View running");
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        for(int i = 0; i<field.xar.length; i++) {
            for(int j = 0; j<field.yar.length; j++)
            g2d.fill3DRect(field.cellarry[i][j].x, field.cellarry[i][j].y, field.cellarry[i][j].WIDTH, field.cellarry[i][j].HEIGHT, field.cellarry[i][j].active);

        }
    }

    public void moveActive(){
        field.checkAll();
        repaint();
    }

    public void moveRight(){
        field.removeSnake();
        field.moveBody("right");
        field.addSnake();
        repaint();
    }
    public void moveDown(){
        field.removeSnake();
        field.moveBody("down");
        field.addSnake();
        repaint();
    }
    public void moveLeft(){
        field.removeSnake();
        field.moveBody("left");
        field.addSnake();
        repaint();
    }
    public void moveUp(){
        field.removeSnake();
        field.moveBody("up");
        field.addSnake();
        repaint();
    }
    public void addBody(){
        field.addBody();
        repaint();
    }

}

