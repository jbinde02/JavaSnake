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
        if(bodyList.indexOf(cell) == 0){
            cell.setHead(true);
        }
    }

    public void removeBody(Cell cell){
        cell.setBody(false);
        cell.setHead(false);
        if((Integer)bodyList.indexOf(cell) == null){
            throw new IndexOutOfBoundsException();
        }
        bodyList.remove(bodyList.indexOf(cell));
    }

    public void replaceBody(Cell newCell, Cell previousCell, int index){
        if(!bodyList.get(index).isHead()){
            newCell = previousCell;
            newCell.setBody(true);
            bodyList.set(index, newCell);

        }else {
            bodyList.set(index, newCell);
            newCell.setBody(true);
            newCell.setHead(true);
        }
        try {
            removeBody(previousCell);
        }catch (Exception e){

        }
    }
}
