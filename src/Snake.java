import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Snake {
    Iterator<Cell> iterator;
    ArrayList<Cell> bodyList;
    public Snake(){
        bodyList = new ArrayList<Cell>();
        iterator = bodyList.iterator();
    }
    public Cell[] toArray(){
        return bodyList.toArray(new Cell[bodyList.size()]);
    }
}
