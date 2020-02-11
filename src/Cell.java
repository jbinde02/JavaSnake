import java.awt.*;

public class Cell {
    final int WIDTH = 20;
    final int HEIGHT = 20;
    int x;
    int y;
    boolean active;
    boolean body;
    Rectangle rectangle;

    public Cell(int x, int y){
        setX(x);
        setY(y);
        setBody(false);
    }

    public void setRectangle(){
        this.rectangle = new Rectangle(x,y,WIDTH,HEIGHT);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setBody(boolean state) {
        this.body = state;
    }
}
