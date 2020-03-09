import java.util.ArrayList;

class Snake {
    ArrayList<Cell> bodyList;
    Snake(){
        bodyList = new ArrayList<>();
    }
    Cell[] toArray(){
        return bodyList.toArray(new Cell[0]);
    }

    void addBody(Cell cell){
        cell.setBody(true);
        bodyList.add(cell);
    }


    void replaceBody(Cell newCell, int index){
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
