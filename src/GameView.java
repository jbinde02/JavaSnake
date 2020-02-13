

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
            g2d.fill3DRect(field.cellArray[i][j].x, field.cellArray[i][j].y, field.cellArray[i][j].WIDTH, field.cellArray[i][j].HEIGHT, field.cellArray[i][j].body);

        }
    }


    public void moveRight(){
        if(field.getDirection().equals("right")){
            return;
        }
        field.setDirection("right");
        field.moveBody(field.getDirection());
    }
    public void moveDown(){
        if(field.getDirection().equals("down")){
            return;
        }
        field.setDirection("down");
        field.moveBody(field.getDirection());
    }
    public void moveLeft(){
        if(field.getDirection().equals("left")){
            return;
        }
        field.setDirection("left");
        field.moveBody(field.getDirection());
    }
    public void moveUp(){
        if(field.getDirection().equals("up")){
            return;
        }
        field.setDirection("up");
        field.moveBody(field.getDirection());
    }
    public void moveStop(){
        if(field.getDirection().equals("none")){
            return;
        }
        field.setDirection("none");
        field.moveBody(field.getDirection());
    }
    public void checkDirection(){
        field.moveBody(field.getDirection());
    }

}

