
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

    int getCol(int y){
        return y/20;
    }

    int getRow(int x){
        return x/20;
    }

}
