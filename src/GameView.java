

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    GameField field;

    GameView(GameField field){
        this.field = field;
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


}

