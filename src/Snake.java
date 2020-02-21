import java.util.ArrayList;
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

    public void addBody(Cell cell){
        cell.setBody(true);
        bodyList.add(cell);
    }

    public void removeBody(Cell cell){
        cell.setBody(false);
        cell.setHead(false);
        if((Integer)bodyList.indexOf(cell) == null){
            throw new IndexOutOfBoundsException();
        }
        bodyList.remove(bodyList.indexOf(cell));
    }

    public void replaceBody(Cell newCell,Cell oldCell, int index){
        bodyList.set(index, newCell);
        newCell.setBody(true);
        if(bodyList.indexOf(newCell) == 0){
            newCell.setHead(true);
        }
        try {
            removeBody(oldCell);
        }catch (Exception e){
            System.out.println("Pass");
        }
    }
}
