import java.util.Random;

public class GameField {
    int[] xar;
    int[] yar;
    Cell[][] cellArray;
    Snake snake;
    String direction;
    Random random;

    GameField(){
        random = new Random();
        xar = new int[25];
        yar = new int[25];
        cellArray = new Cell[xar.length][yar.length];
        createGrid();
        snake = new Snake();
        snake.addBody(cellArray[2][5]);
        snake.addBody(cellArray[2][4]);
        snake.addBody(cellArray[2][3]);
        snake.addBody(cellArray[2][2]);
        snake.addBody(cellArray[2][1]);
        snake.addBody(cellArray[2][0]);
        addFood(cellArray[10][10]);
        direction = "none";
        System.out.println("Field running");
    }

    private void createGrid(){
        populateXY();
        populateCell();
    }

    private void populateXY(){
        int x = 0;
        int y = 0;
        for(int i = 0; i<xar.length; i++) {
            xar[i] = x;
            x+= 20;
        }
        for(int i = 0; i<yar.length; i++) {
            yar[i] = y;
            y+= 20;
        }

    }

    private void populateCell(){
        for(int i = 0; i<xar.length; i++){
            for(int j = 0; j<yar.length; j++){
                cellArray[i][j] = new Cell(xar[i],yar[j]);
            }
        }
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return this.direction;
    }

    public boolean moveBody (String direction){
        Cell[] snakeArray = snake.toArray();
        Cell newCell = new Cell();
        int index = 0;
        for(Cell cell : snakeArray){
           // System.out.println("Cell:" + index +" "+ cell.x +" "+ cell.y +" ");
            switch (direction) {
                case "up":
                    if(cell.getCol(cell.y) - 1 < 0){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y) - 1];
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "down":
                    if(cell.getCol(cell.y) + 1 == yar.length){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y) + 1];
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "left":
                    if(cell.getRow(cell.x) - 1 < 0){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x) - 1][cell.getCol(cell.y)];
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "right":
                    if(cell.getRow(cell.x) + 1 == xar.length){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x) + 1][cell.getCol(cell.y)];
                    }
                    snake.replaceBody(newCell, index);
                    break;
            }
            index++;
            newCell = cell;
        }
        return false;
    }

    public boolean isHeadCollision() {
        Cell[] snakeArray = snake.toArray();
        Cell head = snake.bodyList.get(0);
        int index = 0;
        for (Cell cell : snakeArray) {
            if(cell == head && index != 0){
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean foodExist(){
        for(int i = 0; i<xar.length; i++){
            for(int j = 0; j<yar.length; j++){
                if(cellArray[i][j].food){
                    return true;
                }
            }
        }
        return false;
    }

    public void addFood(Cell cell){
        cell.setFood(true);
    }

    public void addRandomFood(){
        int randomInt1 = random.nextInt(xar.length - 1);
        int randomInt2 = random.nextInt(yar.length - 1);
        cellArray[randomInt1][randomInt2].setFood(true);
    }

    public void eatFood(){

    }
}
