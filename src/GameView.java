

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameField field;

    GameView(){
        field = new GameField();
        System.out.println("View running");
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        for(int i = 0; i<field.xar.length; i++) {
            for(int j = 0; j<field.yar.length; j++)
            g2d.fill3DRect(field.cellarry[i][j].x, field.cellarry[i][j].y, field.cellarry[i][j].WIDTH, field.cellarry[i][j].HEIGHT, field.cellarry[i][j].body);

        }
    }


    public void moveRight(){
        field.setDirection("right");
        field.moveBody(field.getDirection());

    }
    public void moveDown(){
        field.setDirection("down");
        field.moveBody(field.getDirection());

    }
    public void moveLeft(){
        field.setDirection("left");
        field.moveBody(field.getDirection());

    }
    public void moveUp(){
        field.setDirection("up");
        field.moveBody(field.getDirection());

    }
    public void checkDirection(){
        field.moveBody(field.getDirection());
    }

}

