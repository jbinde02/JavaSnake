import java.awt.*;

public class Cell {
    final int WIDTH = 20;
    final int HEIGHT = 20;
    int x;
    int y;
    boolean body;
    boolean food;
    public Cell(int x, int y){
        setX(x);
        setY(y);
        setBody(false);
    }

    public Cell(){

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

    public void setFood(boolean state) {
        this.food = state;
    }

    public int getCol(int y){
        return y/20;
    }

    public int getRow(int x){
        return x/20;
    }

}
