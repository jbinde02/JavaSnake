

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
        if(field.getDirection().equals("right") || field.getDirection().equals("left") ){
            return;
        }
        field.setDirection("right");
    }
    public void moveDown(){
        if(field.getDirection().equals("down") || field.getDirection().equals("up")){
            return;
        }
        field.setDirection("down");
    }
    public void moveLeft(){
        if(field.getDirection().equals("left") || field.getDirection().equals("right")){
            return;
        }
        field.setDirection("left");
    }
    public void moveUp(){
        if(field.getDirection().equals("up") || field.getDirection().equals("down")){
            return;
        }
        field.setDirection("up");
    }
    public void moveStop(){
        if(field.getDirection().equals("none")){
            return;
        }
        field.setDirection("none");
    }
    public void checkDirection(){
        field.moveBody(field.getDirection());
    }
}

