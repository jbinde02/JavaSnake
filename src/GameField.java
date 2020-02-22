
public class GameField {
    int[] xar;
    int[] yar;
    Cell[][] cellArray;
    Snake snake;
    String direction;

    GameField(){
        xar = new int[25];
        yar = new int[25];
        cellArray = new Cell[xar.length][yar.length];
        createGrid();
        snake = new Snake();
        snake.addBody(cellArray[2][2]);
        snake.addBody(cellArray[2][1]);
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

    public void moveBody(String direction){
        Cell[] snakeArray = snake.toArray();
        Cell previousCell = new Cell();
        Cell newCell;
        int index = 0;
        for(Cell cell : snakeArray){
            System.out.println("Cell:" + index +" "+ cell.x +" "+ cell.y +" ");
            switch (direction) {
                case "up":
                    newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y)-1];
                    snake.replaceBody(newCell, previousCell, index);
                    break;

                case "down":
                    newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y)+1];
                    snake.replaceBody(newCell, previousCell, index);
                    break;

                case "left":
                    newCell = cellArray[cell.getRow(cell.x)-1][cell.getCol(cell.y)];
                    snake.replaceBody(newCell, previousCell, index);
                    break;

                case "right":
                    newCell = cellArray[cell.getRow(cell.x)+1][cell.getCol(cell.y)];
                    snake.replaceBody(newCell, previousCell, index);
                    break;
            }
            index++;
            previousCell = cell;
        }
    }
}
