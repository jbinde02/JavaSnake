public class Snake {
    Cell[] bodyarry;
    public Snake(int x, int y){
        bodyarry = new Cell[100];
        bodyarry[0] = new Cell(x,y,true);
    }
}
