

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameField field;

    GameView(GameField field){
        this.field = field;
        System.out.println("View running");
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i<field.xar.length; i++) {
            for(int j = 0; j<field.yar.length; j++)
                if(field.cellArray[i][j].body){
                    g2d.setColor(Color.red);
                    g2d.fill3DRect(field.cellArray[i][j].x, field.cellArray[i][j].y, field.cellArray[i][j].WIDTH, field.cellArray[i][j].HEIGHT, true);
                }else if (field.cellArray[i][j].food){
                    g2d.setColor(Color.green);
                    g2d.fill3DRect(field.cellArray[i][j].x, field.cellArray[i][j].y, field.cellArray[i][j].WIDTH, field.cellArray[i][j].HEIGHT, true);
                }else{
                    g2d.setColor(Color.cyan);
                    g2d.fill3DRect(field.cellArray[i][j].x, field.cellArray[i][j].y, field.cellArray[i][j].WIDTH, field.cellArray[i][j].HEIGHT, false);
                }


        }
    }


}

