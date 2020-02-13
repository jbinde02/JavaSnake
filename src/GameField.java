
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
        addBody(cellArray[2][2]);
        addBody(cellArray[1][2]);
        direction = "none";
        System.out.println("Field running");
    }
    public void addBody(Cell cell){
        snake.bodyList.add(cell);
        cell.body = true;
    }
    public void removeBody(Cell cell){
        cell.body = false;
        snake.bodyList.remove(snake.bodyList.size()-2);
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
        int i = 0;
        for(Cell cell : snakeArray){
            switch (direction) {
                case "up":
                    if(cell != snake.bodyList.get(0)){
                        cell = snake.bodyList.get(snake.bodyList.indexOf(cell)-1);
                        break;
                    }
                    addBody(cellArray[cell.getRow(cell.x)][cell.getCol(cell.y)-1]);
                    removeBody(cell);
                    System.out.println("up");
                    break;
                    case "down":
                        if(cell != snake.bodyList.get(0)){
                            cell = snake.bodyList.get(snake.bodyList.indexOf(cell)-1);
                            break;
                        }
                        addBody(cellArray[cell.getRow(cell.x)][cell.getCol(cell.y)+1]);
                        removeBody(cell);
                        System.out.println("down");
                        break;
                    case "left":
                        if(cell != snake.bodyList.get(0)){
                            cell = snake.bodyList.get(snake.bodyList.indexOf(cell)-1);
                            break;
                        }
                        addBody(cellArray[cell.getRow(cell.x)-1][cell.getCol(cell.y)]);
                        removeBody(cell);
                        System.out.println("left");
                        break;
                    case "right":
                        if(cell != snake.bodyList.get(0)){
                            cell = snake.bodyList.get(snake.bodyList.indexOf(cell)-1);
                            break;
                        }
                        addBody(cellArray[cell.getRow(cell.x)+1][cell.getCol(cell.y)]);
                        removeBody(cell);
                        System.out.println("right");
                        break;
                    case "none":
                        break;
            }
            i++;
        }
    }

}
