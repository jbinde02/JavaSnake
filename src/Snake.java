import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
    Iterator<Cell> iterator;
    ArrayList<Cell> bodyarry;
    Cell cell;
    public Snake(){
        bodyarry = new ArrayList<Cell>();
        iterator = bodyarry.iterator();
    }
}
