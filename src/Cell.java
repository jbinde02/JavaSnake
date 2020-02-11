import java.awt.*;

public class Cell {
    final int WIDTH = 20;
    final int HEIGHT = 20;
    int x;
    int y;
    boolean active;
    boolean body;
    boolean head;
    Rectangle rectangle;

    public Cell(int x, int y, boolean active){
        setX(x);
        setY(y);
        setActive(active);
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

    public void setActive(boolean active){
        this.active = active;
    }

    public void setBody(boolean body){this.body = false; }

    public void setHead(boolean head){this.head = false; }

}
