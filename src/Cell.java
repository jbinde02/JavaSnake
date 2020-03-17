/**
 * This class represents a single cell in the field. That cell can be nothing, food, or a part of the body.
 * Changing the WIDTH and HEIGHT variables will change how large the cells are.
 *
 * @author Jacob Binder
 */
class Cell {
    final int WIDTH = 20;
    final int HEIGHT = 20;
    int x;
    int y;
    boolean body;
    boolean food;
    Cell(int x, int y){
        setX(x);
        setY(y);
        setBody(false);
    }

    Cell(){

    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y){
        this.y = y;
    }

    void setBody(boolean state) {
        this.body = state;
    }

    void setFood(boolean state) {
        this.food = state;
    }

    /**
     * Divides the y by the HEIGHT because y represents a position on the panel and not a exact column.
     * Ex. 40 would be a position where the cell is drawn and 2 would be the column if each cell was 20 units tall.
     */
    int getCol(int y){
        return y/HEIGHT;
    }

    /**
     * Divides the x by the WIDTH because x represents a position on the panel and not a exact row.
     * Ex. 40 would be a position where the cell is drawn and 2 would be the row if each cell was 20 units wide.
     */
    int getRow(int x){
        return x/WIDTH;
    }

}
