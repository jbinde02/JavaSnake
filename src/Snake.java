import java.util.ArrayList;

public class Snake {
    ArrayList<Cell> bodyList;
    public Snake(){
        bodyList = new ArrayList<Cell>();
    }
    public Cell[] toArray(){
        return bodyList.toArray(new Cell[bodyList.size()]);
    }

    public void addBody(Cell cell){
        cell.setBody(true);
        bodyList.add(cell);
    }


    public void replaceBody(Cell newCell,int index){
        if(index != 0){
            bodyList.get(index).setBody(false);
            bodyList.set(index, newCell);
            newCell.setBody(true);
        }else {
            bodyList.get(index).setBody(false);
            bodyList.set(index, newCell);
            newCell.setBody(true);
        }
    }
}
